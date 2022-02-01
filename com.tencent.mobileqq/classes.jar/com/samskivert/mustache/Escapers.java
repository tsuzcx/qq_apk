package com.samskivert.mustache;

public class Escapers
{
  public static final Mustache.Escaper HTML = simple(new String[][] { { "&", "&amp;" }, { "'", "&#39;" }, { "\"", "&quot;" }, { "<", "&lt;" }, { ">", "&gt;" }, { "`", "&#x60;" }, { "=", "&#x3D;" } });
  public static final Mustache.Escaper NONE = new Escapers.1();
  
  public static Mustache.Escaper simple(String[]... paramVarArgs)
  {
    return new Escapers.2(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Escapers
 * JD-Core Version:    0.7.0.1
 */