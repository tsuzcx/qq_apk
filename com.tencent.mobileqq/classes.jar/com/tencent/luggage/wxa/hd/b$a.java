package com.tencent.luggage.wxa.hd;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class b$a
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.hd.b.a
 * JD-Core Version:    0.7.0.1
 */