package com.tencent.kingkong;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Utils$InterProcessLock
{
  private String jdField_a_of_type_JavaLangString = "";
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel = null;
  private FileLock jdField_a_of_type_JavaNioChannelsFileLock = null;
  private boolean jdField_a_of_type_Boolean = false;
  private boolean b = false;
  
  Utils$InterProcessLock(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    try
    {
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Initial FileChannel exception : ");
      localStringBuilder.append(paramString);
      Common.Log.a("KingKongUtils", localStringBuilder.toString());
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    if (!this.b) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Release Inter-Process Lock ");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    Common.Log.a("KingKongUtils", ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_JavaNioChannelsFileLock;
    StringBuilder localStringBuilder;
    if (localObject != null) {
      try
      {
        ((FileLock)localObject).release();
      }
      catch (IOException localIOException1)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Release Inter-Process Lock ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" exception : ");
        localStringBuilder.append(localIOException1);
        Common.Log.a("KingKongUtils", localStringBuilder.toString());
        localIOException1.printStackTrace();
      }
    }
    FileChannel localFileChannel = this.jdField_a_of_type_JavaNioChannelsFileChannel;
    if (localFileChannel != null) {
      try
      {
        localFileChannel.close();
      }
      catch (IOException localIOException2)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Release Inter-Process Lock ");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(" exception : ");
        localStringBuilder.append(localIOException2);
        Common.Log.a("KingKongUtils", localStringBuilder.toString());
      }
    }
    this.b = false;
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (this.b) {
        return false;
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("Do Inter-Process Lock ");
      localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
      Common.Log.a("KingKongUtils", localStringBuilder1.toString());
      try
      {
        this.jdField_a_of_type_JavaNioChannelsFileChannel = new RandomAccessFile(new File(this.jdField_a_of_type_JavaLangString), "rw").getChannel();
        this.jdField_a_of_type_JavaNioChannelsFileLock = this.jdField_a_of_type_JavaNioChannelsFileChannel.lock();
        this.b = true;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("Do Inter-Process Lock OK ");
        localStringBuilder1.append(this.jdField_a_of_type_JavaLangString);
        Common.Log.a("KingKongUtils", localStringBuilder1.toString());
        return true;
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("Do Inter-Process Lock ");
        localStringBuilder2.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder2.append(" exception : ");
        localStringBuilder2.append(localException);
        Common.Log.a("KingKongUtils", localStringBuilder2.toString());
        localObject = this.jdField_a_of_type_JavaNioChannelsFileLock;
        if (localObject == null) {}
      }
    }
    try
    {
      ((FileLock)localObject).release();
    }
    catch (IOException localIOException1)
    {
      try
      {
        ((FileChannel)localObject).close();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Do Inter-Process Lock failed ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
        Common.Log.a("KingKongUtils", ((StringBuilder)localObject).toString());
        return false;
        localIOException1 = localIOException1;
      }
      catch (IOException localIOException2)
      {
        break label203;
      }
    }
    localObject = this.jdField_a_of_type_JavaNioChannelsFileChannel;
    if (localObject == null) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.kingkong.Utils.InterProcessLock
 * JD-Core Version:    0.7.0.1
 */