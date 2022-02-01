package com.tencent.mobileqq.ar.arengine;

import java.io.File;
import java.io.FileFilter;

final class ARDeviceInfo$1
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    if (paramFile.startsWith("cpu"))
    {
      int i = 3;
      while (i < paramFile.length())
      {
        if (!Character.isDigit(paramFile.charAt(i))) {
          return false;
        }
        i += 1;
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARDeviceInfo.1
 * JD-Core Version:    0.7.0.1
 */