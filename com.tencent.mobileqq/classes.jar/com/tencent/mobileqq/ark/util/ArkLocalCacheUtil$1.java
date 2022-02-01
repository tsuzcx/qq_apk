package com.tencent.mobileqq.ark.util;

import java.io.File;
import java.io.FileFilter;

final class ArkLocalCacheUtil$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (paramFile.getName().startsWith("hc_")) || (paramFile.getName().startsWith(".hc_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.util.ArkLocalCacheUtil.1
 * JD-Core Version:    0.7.0.1
 */