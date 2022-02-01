package com.tencent.ark.open;

import java.io.File;
import java.io.FileFilter;

final class ArkAppMgr$19
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    if (!paramFile.isDirectory()) {}
    while (!ArkAppMgr.isValidAppName(paramFile.getName())) {
      return false;
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppMgr.19
 * JD-Core Version:    0.7.0.1
 */