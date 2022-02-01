package com.tencent.falco.base.libapi.utils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

class IOUtils
{
  public static final char a = File.separatorChar;
  public static final String b;
  
  static
  {
    StringWriter localStringWriter = new StringWriter(4);
    new PrintWriter(localStringWriter).println();
    b = localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.libapi.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */