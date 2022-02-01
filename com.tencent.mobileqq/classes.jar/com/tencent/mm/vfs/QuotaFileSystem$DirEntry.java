package com.tencent.mm.vfs;

final class QuotaFileSystem$DirEntry
{
  int childCount;
  FileSystem.FileEntry entry;
  
  QuotaFileSystem$DirEntry(FileSystem.FileEntry paramFileEntry)
  {
    this.entry = paramFileEntry;
    this.childCount = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("children: ");
    localStringBuilder.append(this.childCount);
    localStringBuilder.append(" [");
    localStringBuilder.append(this.entry);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.QuotaFileSystem.DirEntry
 * JD-Core Version:    0.7.0.1
 */