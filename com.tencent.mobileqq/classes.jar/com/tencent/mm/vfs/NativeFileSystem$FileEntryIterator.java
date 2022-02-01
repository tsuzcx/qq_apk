package com.tencent.mm.vfs;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

class NativeFileSystem$FileEntryIterator
  extends VFSUtils.CascadeIterator<File, FileSystem.FileEntry>
{
  private final boolean mRecursive;
  
  NativeFileSystem$FileEntryIterator(NativeFileSystem paramNativeFileSystem, File paramFile, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramNativeFileSystem, Collections.singletonList(paramFile), paramBoolean1, paramBoolean2);
  }
  
  private NativeFileSystem$FileEntryIterator(List<File> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    super(paramBoolean1.iterator(), paramBoolean2);
    boolean bool;
    this.mRecursive = bool;
  }
  
  protected FileSystem.FileEntry convert(File paramFile)
  {
    return NativeFileSystem.access$000(this.this$0, paramFile);
  }
  
  protected Iterator<? extends FileSystem.FileEntry> traversal(File paramFile, FileSystem.FileEntry paramFileEntry)
  {
    if (!this.mRecursive) {
      return null;
    }
    if ((paramFileEntry != null) && (!paramFileEntry.isDirectory)) {
      return null;
    }
    paramFile = paramFile.listFiles();
    if (paramFile != null)
    {
      if (paramFile.length == 0) {
        return null;
      }
      return new FileEntryIterator(this.this$0, Arrays.asList(paramFile), this.mChildrenFirst, true);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.NativeFileSystem.FileEntryIterator
 * JD-Core Version:    0.7.0.1
 */