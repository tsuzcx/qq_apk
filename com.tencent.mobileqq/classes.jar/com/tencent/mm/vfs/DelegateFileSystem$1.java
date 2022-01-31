package com.tencent.mm.vfs;

import java.util.Iterator;

class DelegateFileSystem$1
  implements Iterable<FileSystem.FileEntry>
{
  DelegateFileSystem$1(DelegateFileSystem paramDelegateFileSystem, String paramString, boolean paramBoolean) {}
  
  public Iterator<FileSystem.FileEntry> iterator()
  {
    return new DelegateFileSystem.1.1(this, this.this$0.allFileSystems().iterator());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.DelegateFileSystem.1
 * JD-Core Version:    0.7.0.1
 */