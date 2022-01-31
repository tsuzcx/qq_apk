package com.tencent.hydevteam.pluginframework.pluginmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class MinFileUtils
{
  static void a(File paramFile)
    throws IOException
  {
    File localFile = paramFile.getParentFile();
    if ((!localFile.isDirectory()) && (!localFile.mkdirs())) {
      throw new IOException("创建父目录失败,文件目录:" + paramFile.getAbsolutePath() + " parent dir exists=" + localFile.exists());
    }
  }
  
  static List<File> b(File paramFile)
  {
    paramFile = paramFile.listFiles();
    LinkedList localLinkedList = new LinkedList();
    if (paramFile != null)
    {
      int j = paramFile.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramFile[i];
        if (!localObject.isDirectory()) {
          localLinkedList.add(localObject);
        }
        i += 1;
      }
      Collections.sort(localLinkedList, new Comparator() {});
    }
    return localLinkedList;
  }
  
  static void c(File paramFile)
    throws IOException
  {
    if (!paramFile.exists()) {
      throw new IllegalArgumentException(paramFile + " does not exist");
    }
    if (!paramFile.isDirectory()) {
      throw new IllegalArgumentException(paramFile + " is not a directory");
    }
    File[] arrayOfFile = paramFile.listFiles();
    if (arrayOfFile == null) {
      throw new IOException("Failed to list contents of " + paramFile);
    }
    Object localObject = null;
    int j = arrayOfFile.length;
    int i = 0;
    label310:
    for (;;)
    {
      File localFile;
      if (i < j)
      {
        localFile = arrayOfFile[i];
        paramFile = (File)localObject;
      }
      try
      {
        if (localFile.isDirectory())
        {
          paramFile = (File)localObject;
          paramFile = (File)localObject;
          if (!localFile.exists()) {
            break label310;
          }
          paramFile = (File)localObject;
          c(localFile);
          paramFile = (File)localObject;
          paramFile = (File)localObject;
          if (localFile.delete()) {
            break label310;
          }
          paramFile = (File)localObject;
          localObject = "Unable to delete directory " + localFile + ".";
          paramFile = (File)localObject;
          throw new IOException((String)localObject);
        }
        paramFile = (File)localObject;
        boolean bool = localFile.exists();
        paramFile = (File)localObject;
        paramFile = (File)localObject;
        if (localFile.delete()) {
          break label310;
        }
        if (!bool)
        {
          paramFile = (File)localObject;
          throw new FileNotFoundException("File does not exist: " + localFile);
        }
        paramFile = (File)localObject;
        localObject = "Unable to delete file: " + localFile;
        paramFile = (File)localObject;
        throw new IOException((String)localObject);
      }
      catch (IOException paramFile)
      {
        i += 1;
        localObject = paramFile;
      }
      if (localObject != null) {
        throw ((Throwable)localObject);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.MinFileUtils
 * JD-Core Version:    0.7.0.1
 */