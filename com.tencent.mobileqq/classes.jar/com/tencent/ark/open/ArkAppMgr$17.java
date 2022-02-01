package com.tencent.ark.open;

import java.io.File;
import java.io.FileFilter;

final class ArkAppMgr$17
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return (paramFile.isFile()) && (paramFile.exists());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.17
 * JD-Core Version:    0.7.0.1
 */