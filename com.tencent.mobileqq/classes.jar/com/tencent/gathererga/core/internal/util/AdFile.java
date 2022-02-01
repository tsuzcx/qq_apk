package com.tencent.gathererga.core.internal.util;

import android.text.TextUtils;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class AdFile
{
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private FileLock jdField_a_of_type_JavaNioChannelsFileLock;
  private boolean jdField_a_of_type_Boolean = false;
  private String b;
  private String c;
  
  public AdFile(String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.c = paramString3;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  private boolean b()
  {
    return (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (!TextUtils.isEmpty(this.c));
  }
  
  public String a()
  {
    return a(-2147483648);
  }
  
  public String a(int paramInt)
  {
    if (!b()) {
      return null;
    }
    Object localObject = this.jdField_a_of_type_JavaIoRandomAccessFile;
    int i;
    if (localObject != null)
    {
      if (this.jdField_a_of_type_JavaNioChannelsFileLock == null) {
        return null;
      }
      if (paramInt != -2147483648) {
        i = paramInt;
      }
    }
    do
    {
      try
      {
        if (((RandomAccessFile)localObject).length() > paramInt) {
          continue;
        }
        i = Long.valueOf(this.jdField_a_of_type_JavaIoRandomAccessFile.length()).intValue();
      }
      catch (Throwable localThrowable)
      {
        GLog.b("AdFile read", localThrowable);
      }
      localObject = new byte[i];
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.read((byte[])localObject, 0, i) == i)
      {
        localObject = new String((byte[])localObject, 0, i, this.c);
        return localObject;
      }
      return null;
      return null;
    } while (i > 0);
    return null;
  }
  
  public void a()
  {
    try
    {
      if (this.jdField_a_of_type_JavaNioChannelsFileLock != null)
      {
        this.jdField_a_of_type_JavaNioChannelsFileLock.release();
        this.jdField_a_of_type_JavaNioChannelsFileLock = null;
      }
    }
    catch (Throwable localThrowable1)
    {
      GLog.b("AdFile close", localThrowable1);
    }
    try
    {
      if (this.jdField_a_of_type_JavaIoRandomAccessFile != null)
      {
        this.jdField_a_of_type_JavaIoRandomAccessFile.close();
        this.jdField_a_of_type_JavaIoRandomAccessFile = null;
        return;
      }
    }
    catch (Throwable localThrowable2)
    {
      GLog.b("AdFile close", localThrowable2);
    }
  }
  
  public boolean a()
  {
    if (!b()) {
      return false;
    }
    if (this.jdField_a_of_type_JavaIoRandomAccessFile == null) {
      if (this.jdField_a_of_type_JavaNioChannelsFileLock != null) {
        return false;
      }
    }
    for (;;)
    {
      try
      {
        Object localObject = new File(this.jdField_a_of_type_JavaLangString);
        File localFile = new File((File)localObject, this.b);
        if ((this.jdField_a_of_type_Boolean) && (!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
          return false;
        }
        if (!this.jdField_a_of_type_Boolean) {
          break label178;
        }
        localObject = "rwd";
        this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(localFile, (String)localObject);
        if (this.jdField_a_of_type_Boolean) {
          this.jdField_a_of_type_JavaNioChannelsFileLock = this.jdField_a_of_type_JavaIoRandomAccessFile.getChannel().lock();
        } else {
          this.jdField_a_of_type_JavaNioChannelsFileLock = this.jdField_a_of_type_JavaIoRandomAccessFile.getChannel().tryLock(0L, 9223372036854775807L, true);
        }
        if (localFile.exists()) {
          if (localFile.isFile()) {
            break;
          }
        }
        a();
        return false;
      }
      catch (Throwable localThrowable)
      {
        GLog.b("AdFile open", localThrowable);
        a();
      }
      return false;
      label178:
      String str = "r";
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (!b()) {
      return false;
    }
    if (!this.jdField_a_of_type_Boolean) {
      return false;
    }
    RandomAccessFile localRandomAccessFile = this.jdField_a_of_type_JavaIoRandomAccessFile;
    if (localRandomAccessFile != null)
    {
      if (this.jdField_a_of_type_JavaNioChannelsFileLock == null) {
        return false;
      }
      try
      {
        localRandomAccessFile.setLength(0L);
        if (!TextUtils.isEmpty(paramString))
        {
          paramString = paramString.getBytes(this.c);
          this.jdField_a_of_type_JavaIoRandomAccessFile.write(paramString);
        }
        return true;
      }
      catch (Throwable paramString)
      {
        GLog.b("AdFile write", paramString);
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.AdFile
 * JD-Core Version:    0.7.0.1
 */