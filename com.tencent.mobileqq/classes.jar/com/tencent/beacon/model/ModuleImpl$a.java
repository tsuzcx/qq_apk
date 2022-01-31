package com.tencent.beacon.model;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

final class ModuleImpl$a
  implements FileFilter
{
  public final boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.model.ModuleImpl.a
 * JD-Core Version:    0.7.0.1
 */