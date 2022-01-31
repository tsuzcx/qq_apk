package com.tencent.aekit.openrender;

public class PTDebugConfig
{
  public static boolean ENABLE_BODY_BEAUTY;
  public static boolean ENABLE_FACEKIT_3D_LINE;
  public static boolean ENABLE_FACELINE = false;
  public static boolean ENABLE_HAIRSEG;
  public static boolean ENABLE_HAND_LINE;
  public static boolean ENABLE_SEGMENT = false;
  public static boolean ENABLE_SKYSEG;
  public static boolean ENABLE_SMART_FILTER = false;
  
  static
  {
    ENABLE_FACEKIT_3D_LINE = true;
    ENABLE_HAND_LINE = false;
    ENABLE_BODY_BEAUTY = false;
    ENABLE_HAIRSEG = false;
    ENABLE_SKYSEG = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.openrender.PTDebugConfig
 * JD-Core Version:    0.7.0.1
 */