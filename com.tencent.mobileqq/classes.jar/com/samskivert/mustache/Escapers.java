package com.samskivert.mustache;

public class Escapers
{
  public static final Mustache.Escaper HTML;
  public static final Mustache.Escaper NONE = new Escapers.1();
  
  static
  {
    String[] arrayOfString1 = { "&", "&amp;" };
    String[] arrayOfString2 = { "\"", "&quot;" };
    String[] arrayOfString3 = { "<", "&lt;" };
    String[] arrayOfString4 = { "`", "&#x60;" };
    HTML = simple(new String[][] { arrayOfString1, { "'", "&#39;" }, arrayOfString2, arrayOfString3, { ">", "&gt;" }, arrayOfString4, { "=", "&#x3D;" } });
  }
  
  public static Mustache.Escaper simple(String[]... paramVarArgs)
  {
    return new Escapers.2(paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.samskivert.mustache.Escapers
 * JD-Core Version:    0.7.0.1
 */