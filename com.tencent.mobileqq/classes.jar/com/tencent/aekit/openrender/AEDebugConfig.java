package com.tencent.aekit.openrender;

public class AEDebugConfig
{
  public static boolean ENABLE_BODY_BEAUTY;
  public static boolean ENABLE_CAT = false;
  public static boolean ENABLE_FACEKIT_3D_LINE;
  public static boolean ENABLE_FACELINE = false;
  public static boolean ENABLE_GENDER_DETECT;
  public static boolean ENABLE_HAIRSEG;
  public static boolean ENABLE_HAND_LINE;
  public static boolean ENABLE_RGBDEPTH;
  public static boolean ENABLE_SEGMENT;
  public static boolean ENABLE_SKYSEG;
  public static boolean ENABLE_SMART_FILTER;
  
  static
  {
    ENABLE_FACEKIT_3D_LINE = false;
    ENABLE_HAND_LINE = false;
    ENABLE_GENDER_DETECT = true;
    ENABLE_BODY_BEAUTY = false;
    ENABLE_HAIRSEG = false;
    ENABLE_SKYSEG = false;
    ENABLE_RGBDEPTH = false;
    ENABLE_SEGMENT = false;
    ENABLE_SMART_FILTER = false;
  }
  
  public static void reset()
  {
    ENABLE_FACELINE = false;
    ENABLE_FACEKIT_3D_LINE = false;
    ENABLE_HAND_LINE = false;
    ENABLE_BODY_BEAUTY = false;
    ENABLE_HAIRSEG = false;
    ENABLE_SKYSEG = false;
    ENABLE_RGBDEPTH = false;
    ENABLE_SEGMENT = false;
    ENABLE_SMART_FILTER = false;
    ENABLE_CAT = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.AEDebugConfig
 * JD-Core Version:    0.7.0.1
 */