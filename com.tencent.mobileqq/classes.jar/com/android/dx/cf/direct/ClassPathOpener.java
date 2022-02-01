package com.android.dx.cf.direct;

import com.android.dex.util.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ClassPathOpener
{
  public static final ClassPathOpener.FileNameFilter acceptAll = new ClassPathOpener.1();
  private final ClassPathOpener.Consumer consumer;
  private ClassPathOpener.FileNameFilter filter;
  private final String pathname;
  private final boolean sort;
  
  public ClassPathOpener(String paramString, boolean paramBoolean, ClassPathOpener.Consumer paramConsumer)
  {
    this(paramString, paramBoolean, acceptAll, paramConsumer);
  }
  
  public ClassPathOpener(String paramString, boolean paramBoolean, ClassPathOpener.FileNameFilter paramFileNameFilter, ClassPathOpener.Consumer paramConsumer)
  {
    this.pathname = paramString;
    this.sort = paramBoolean;
    this.consumer = paramConsumer;
    this.filter = paramFileNameFilter;
  }
  
  private static int compareClassNames(String paramString1, String paramString2)
  {
    paramString1 = paramString1.replace('$', '0');
    paramString2 = paramString2.replace('$', '0');
    return paramString1.replace("package-info", "").compareTo(paramString2.replace("package-info", ""));
  }
  
  private boolean processArchive(File paramFile)
  {
    ZipFile localZipFile = new ZipFile(paramFile);
    Object localObject = Collections.list(localZipFile.entries());
    if (this.sort) {
      Collections.sort((List)localObject, new ClassPathOpener.3(this));
    }
    this.consumer.onProcessArchiveStart(paramFile);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(40000);
    byte[] arrayOfByte = new byte[20000];
    localObject = ((ArrayList)localObject).iterator();
    boolean bool1 = false;
    if (((Iterator)localObject).hasNext())
    {
      ZipEntry localZipEntry = (ZipEntry)((Iterator)localObject).next();
      boolean bool2 = localZipEntry.isDirectory();
      String str = localZipEntry.getName();
      if (!this.filter.accept(str)) {
        break label216;
      }
      if (!bool2)
      {
        paramFile = localZipFile.getInputStream(localZipEntry);
        localByteArrayOutputStream.reset();
        for (;;)
        {
          int i = paramFile.read(arrayOfByte);
          if (i == -1) {
            break;
          }
          localByteArrayOutputStream.write(arrayOfByte, 0, i);
        }
        paramFile.close();
        paramFile = localByteArrayOutputStream.toByteArray();
        label179:
        bool1 = this.consumer.processFileBytes(str, localZipEntry.getTime(), paramFile) | bool1;
      }
    }
    label216:
    for (;;)
    {
      break;
      paramFile = new byte[0];
      break label179;
      localZipFile.close();
      return bool1;
    }
  }
  
  private boolean processDirectory(File paramFile, boolean paramBoolean)
  {
    File localFile = paramFile;
    if (paramBoolean) {
      localFile = new File(paramFile, ".");
    }
    paramFile = localFile.listFiles();
    int j = paramFile.length;
    if (this.sort) {
      Arrays.sort(paramFile, new ClassPathOpener.2(this));
    }
    int i = 0;
    paramBoolean = false;
    while (i < j)
    {
      paramBoolean |= processOne(paramFile[i], false);
      i += 1;
    }
    return paramBoolean;
  }
  
  private boolean processOne(File paramFile, boolean paramBoolean)
  {
    try
    {
      if (paramFile.isDirectory()) {
        return processDirectory(paramFile, paramBoolean);
      }
      String str = paramFile.getPath();
      if ((str.endsWith(".zip")) || (str.endsWith(".jar")) || (str.endsWith(".apk"))) {
        return processArchive(paramFile);
      }
      if (this.filter.accept(str))
      {
        byte[] arrayOfByte = FileUtils.readFile(paramFile);
        paramBoolean = this.consumer.processFileBytes(str, paramFile.lastModified(), arrayOfByte);
        return paramBoolean;
      }
    }
    catch (Exception paramFile)
    {
      this.consumer.onException(paramFile);
    }
    return false;
  }
  
  public boolean process()
  {
    return processOne(new File(this.pathname), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.android.dx.cf.direct.ClassPathOpener
 * JD-Core Version:    0.7.0.1
 */