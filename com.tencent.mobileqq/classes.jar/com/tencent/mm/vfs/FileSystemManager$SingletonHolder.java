package com.tencent.mm.vfs;

import android.annotation.SuppressLint;

final class FileSystemManager$SingletonHolder
{
  @SuppressLint({"StaticFieldLeak"})
  static final FileSystemManager INSTANCE = new FileSystemManager(null);
  
  static
  {
    FileSystemManager.access$300(INSTANCE);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.SingletonHolder
 * JD-Core Version:    0.7.0.1
 */