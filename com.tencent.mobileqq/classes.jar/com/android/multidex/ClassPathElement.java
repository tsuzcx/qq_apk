package com.android.multidex;

import java.io.InputStream;

abstract interface ClassPathElement
{
  public static final char SEPARATOR_CHAR = '/';
  
  public abstract void close();
  
  public abstract Iterable<String> list();
  
  public abstract InputStream open(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.android.multidex.ClassPathElement
 * JD-Core Version:    0.7.0.1
 */