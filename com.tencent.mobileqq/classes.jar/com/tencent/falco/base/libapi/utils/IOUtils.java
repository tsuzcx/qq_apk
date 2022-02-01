package com.tencent.falco.base.libapi.utils;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

class IOUtils
{
  public static final char a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_Char = File.separatorChar;
    StringWriter localStringWriter = new StringWriter(4);
    new PrintWriter(localStringWriter).println();
    jdField_a_of_type_JavaLangString = localStringWriter.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.utils.IOUtils
 * JD-Core Version:    0.7.0.1
 */