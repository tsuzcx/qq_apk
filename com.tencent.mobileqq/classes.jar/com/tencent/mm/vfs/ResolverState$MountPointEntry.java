package com.tencent.mm.vfs;

final class ResolverState$MountPointEntry
  implements Comparable<String>
{
  final String basePath;
  final int fallbackIndex;
  final FileSystem fileSystem;
  final String fileSystemName;
  
  ResolverState$MountPointEntry(String paramString1, String paramString2, FileSystem paramFileSystem, int paramInt)
  {
    this.basePath = paramString1;
    this.fileSystemName = paramString2;
    this.fileSystem = paramFileSystem;
    this.fallbackIndex = paramInt;
  }
  
  public int compareTo(String paramString)
  {
    return this.basePath.compareTo(paramString);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.basePath);
    localStringBuilder.append(" -> ");
    localStringBuilder.append(this.fileSystemName);
    localStringBuilder.append(" ");
    localStringBuilder.append(this.fileSystem.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.ResolverState.MountPointEntry
 * JD-Core Version:    0.7.0.1
 */