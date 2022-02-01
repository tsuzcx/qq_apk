package com.tencent.ark.open.appmanage;

import java.io.File;
import java.io.FileFilter;

final class LocalAppManager$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    if (!paramFile.isDirectory()) {
      return false;
    }
    return Utility.isValidAppName(paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.appmanage.LocalAppManager.1
 * JD-Core Version:    0.7.0.1
 */