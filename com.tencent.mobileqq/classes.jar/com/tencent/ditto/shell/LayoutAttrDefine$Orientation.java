package com.tencent.ditto.shell;

public class LayoutAttrDefine$Orientation
{
  public static final String DEF_Horizontal = "horizontal";
  public static final String DEF_Vertical = "vertical";
  public static final int Horizontal = 0;
  public static final String KEY = "orientation";
  public static final int Vertical = 1;
  
  public static int parse(String paramString)
  {
    if ("horizontal".equals(paramString)) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ditto.shell.LayoutAttrDefine.Orientation
 * JD-Core Version:    0.7.0.1
 */