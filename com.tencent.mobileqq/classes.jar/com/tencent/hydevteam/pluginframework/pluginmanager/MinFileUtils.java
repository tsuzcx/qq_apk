package com.tencent.hydevteam.pluginframework.pluginmanager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class MinFileUtils
{
  static void a(File paramFile)
  {
    File localFile = paramFile.getParentFile();
    if (!localFile.isDirectory())
    {
      if (localFile.mkdirs()) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder("创建父目录失败,文件目录:");
      localStringBuilder.append(paramFile.getAbsolutePath());
      localStringBuilder.append(" parent dir exists=");
      localStringBuilder.append(localFile.exists());
      throw new IOException(localStringBuilder.toString());
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
      Collections.sort(localLinkedList, new MinFileUtils.1());
    }
    return localLinkedList;
  }
  
  static void c(File paramFile)
  {
    if (paramFile.exists())
    {
      if (paramFile.isDirectory())
      {
        File[] arrayOfFile = paramFile.listFiles();
        if (arrayOfFile != null)
        {
          paramFile = null;
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            File localFile2 = arrayOfFile[i];
            try
            {
              File localFile1;
              if (localFile2.isDirectory())
              {
                localFile1 = paramFile;
                if (localFile2.exists())
                {
                  c(localFile2);
                  if (localFile2.delete())
                  {
                    localFile1 = paramFile;
                  }
                  else
                  {
                    paramFile = new StringBuilder("Unable to delete directory ");
                    paramFile.append(localFile2);
                    paramFile.append(".");
                    throw new IOException(paramFile.toString());
                  }
                }
              }
              else
              {
                boolean bool = localFile2.exists();
                localFile1 = paramFile;
                if (!localFile2.delete())
                {
                  if (!bool)
                  {
                    paramFile = new StringBuilder("File does not exist: ");
                    paramFile.append(localFile2);
                    throw new FileNotFoundException(paramFile.toString());
                  }
                  paramFile = new StringBuilder("Unable to delete file: ");
                  paramFile.append(localFile2);
                  throw new IOException(paramFile.toString());
                }
              }
            }
            catch (IOException localIOException)
            {
              i += 1;
              paramFile = localIOException;
            }
          }
          if (paramFile == null) {
            return;
          }
          throw paramFile;
        }
        localStringBuilder = new StringBuilder("Failed to list contents of ");
        localStringBuilder.append(paramFile);
        throw new IOException(localStringBuilder.toString());
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramFile);
      localStringBuilder.append(" is not a directory");
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(" does not exist");
    paramFile = new IllegalArgumentException(localStringBuilder.toString());
    for (;;)
    {
      throw paramFile;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hydevteam.pluginframework.pluginmanager.MinFileUtils
 * JD-Core Version:    0.7.0.1
 */