package com.tencent.mm.vfs;

final class FileSystemManager$Resolution
{
  final FileSystem fileSystem;
  final String path;
  final int revision;
  
  private FileSystemManager$Resolution(FileSystem paramFileSystem, String paramString, int paramInt)
  {
    this.fileSystem = paramFileSystem;
    this.path = paramString;
    this.revision = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.path);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(this.fileSystem.toString());
    return localStringBuilder.toString();
  }
  
  boolean valid()
  {
    return this.fileSystem != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.FileSystemManager.Resolution
 * JD-Core Version:    0.7.0.1
 */