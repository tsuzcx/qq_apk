package com.tencent.aekit.openrender;

public class AEOpenRenderConfig
{
  public static boolean DEBUG = false;
  public static final float[] EMPTY_POSITIONS = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static final float[] EMPTY_POSITIONS_TRIANGLES = { 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F };
  public static boolean GL_DEBUG = false;
  public static final float[] ORIGIN_POSITION_COORDS = { -1.0F, -1.0F, -1.0F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F };
  public static final float[] ORIGIN_TEX_COORDS = { 0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F, 1.0F, 0.0F };
  public static final float[] ORIGIN_TEX_COORDS_REVERSE = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final float[] ORIGIN_TEX_COORDS_TRIANGLES = { 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F };
  public static final int RENDER_MODE_GLFINISH = 0;
  public static final int RENDER_MODE_GLFLUSH = 1;
  public static final int RENDER_MODE_GLNONE = 2;
  private static boolean enableLog = false;
  public static int glMode = 1;
  private static boolean strictMode = false;
  
  public static void checkStrictMode(boolean paramBoolean, String paramString)
  {
    if (!strictMode) {
      return;
    }
    if (paramBoolean) {
      return;
    }
    throw new AEOpenRenderConfig.StrictModeCheckFailedException(paramString);
  }
  
  public static boolean isEnableLog()
  {
    return enableLog;
  }
  
  public static boolean isStrictMode()
  {
    return strictMode;
  }
  
  public static void setEnableLog(boolean paramBoolean)
  {
    enableLog = paramBoolean;
  }
  
  public static void setEnableStrictMode(boolean paramBoolean)
  {
    strictMode = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.AEOpenRenderConfig
 * JD-Core Version:    0.7.0.1
 */