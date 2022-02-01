package com.samskivert.mustache;

public class Escapers
{
  public static final Mustache.Escaper HTML;
  public static final Mustache.Escaper NONE = new Escapers.1();
  
  static
  {
    String[] arrayOfString1 = { "&", "&amp;" };
    String[] arrayOfString2 = { "'", "&#39;" };
    String[] arrayOfString3 = { "\"", "&quot;" };
    String[] arrayOfString4 = { ">", "&gt;" };
    String[] arrayOfString5 = { "`", "&#x60;" };
    String[] arrayOfString6 = { "=", "&#x3D;" };
    HTML = simple(new String[][] { arrayOfString1, arrayOfString2, arrayOfString3, { "<", "&lt;" }, arrayOfString4, arrayOfString5, arrayOfString6 });
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