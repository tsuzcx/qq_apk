package com.tencent.mm.vfs;

import java.io.InputStream;
import java.io.OutputStream;

public class FileSystem$FileEntry
{
  public final long diskSpace;
  final FileSystem fileSystem;
  public final boolean isDirectory;
  public final long modifiedTime;
  public final String name;
  public final String relPath;
  public final long size;
  
  public FileSystem$FileEntry(FileSystem paramFileSystem, String paramString1, String paramString2, long paramLong1, long paramLong2, long paramLong3, boolean paramBoolean)
  {
    this.fileSystem = paramFileSystem;
    this.relPath = paramString1;
    this.name = paramString2;
    this.size = paramLong1;
    this.diskSpace = paramLong2;
    this.modifiedTime = paramLong3;
    this.isDirectory = paramBoolean;
  }
  
  public boolean delete()
  {
    if (this.isDirectory) {
      return this.fileSystem.deleteDir(this.relPath, false);
    }
    return this.fileSystem.delete(this.relPath);
  }
  
  public InputStream openRead()
  {
    return this.fileSystem.openRead(this.relPath);
  }
  
  public OutputStream openWrite(boolean paramBoolean)
  {
    return this.fileSystem.openWrite(this.relPath, paramBoolean);
  }
  
  public String toString()
  {
    String str2 = this.relPath + " -> " + this.fileSystem.toString();
    String str1 = str2;
    if (this.isDirectory) {
      str1 = "[DIR] " + str2;
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystem.FileEntry
 * JD-Core Version:    0.7.0.1
 */