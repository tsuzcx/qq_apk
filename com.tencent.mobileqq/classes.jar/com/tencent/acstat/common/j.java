package com.tencent.acstat.common;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class j
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.acstat.common.j
 * JD-Core Version:    0.7.0.1
 */