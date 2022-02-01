package com.tencent.mm.vfs;

import java.util.regex.Pattern;

final class CombinedFileSystem$PatternEntry
{
  final FileSystem fs;
  final int fsIdx;
  final Pattern pattern;
  
  CombinedFileSystem$PatternEntry(Pattern paramPattern, int paramInt, FileSystem paramFileSystem)
  {
    this.pattern = paramPattern;
    this.fsIdx = paramInt;
    this.fs = paramFileSystem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.vfs.CombinedFileSystem.PatternEntry
 * JD-Core Version:    0.7.0.1
 */