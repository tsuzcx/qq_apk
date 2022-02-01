package com.tencent.TMG.sdk;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class AVClientInfo$1CpuFilter
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.sdk.AVClientInfo.1CpuFilter
 * JD-Core Version:    0.7.0.1
 */