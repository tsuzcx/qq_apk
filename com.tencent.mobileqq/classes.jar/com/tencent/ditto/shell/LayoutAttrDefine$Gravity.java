package com.tencent.ditto.shell;

public class LayoutAttrDefine$Gravity
{
  public static final int BOTTOM = 80;
  public static final int CENTER = 17;
  public static final int CENTER_HORIZONTAL = 1;
  public static final int CENTER_VERTICAL = 16;
  public static final String DEF_BOTTOM = "bottom";
  public static final String DEF_CENTER = "center";
  public static final String DEF_CENTER_HORIZONTAL = "center_horizontal";
  public static final String DEF_CENTER_VERTICAL = "center_vertical";
  public static final String DEF_LEFT = "left";
  public static final String DEF_RIGHT = "right";
  public static final String DEF_TOP = "top";
  public static final String Gravity = "gravity";
  public static final int LEFT = 3;
  public static final String Layout_Gravity = "layout_gravity";
  public static final int NONE = 0;
  public static final int RIGHT = 5;
  public static final int TOP = 48;
  
  public static int parse(String paramString)
  {
    if ("top".equals(paramString)) {
      return 48;
    }
    if ("bottom".equals(paramString)) {
      return 80;
    }
    if ("left".equals(paramString)) {
      return 3;
    }
    if ("right".equals(paramString)) {
      return 5;
    }
    if ("center_vertical".equals(paramString)) {
      return 16;
    }
    if ("center_horizontal".equals(paramString)) {
      return 1;
    }
    if ("center".equals(paramString)) {
      return 17;
    }
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.ditto.shell.LayoutAttrDefine.Gravity
 * JD-Core Version:    0.7.0.1
 */