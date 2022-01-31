package com.tencent.TMG.camera;

public class CameraCaptureSettings
{
  private static final int DEFAULT_FORMAT = 17;
  private static final int DEFAULT_HEIGHT = 480;
  private static final int DEFAULT_WIDTH = 640;
  public int format;
  public int height;
  public int width;
  
  public CameraCaptureSettings()
  {
    initSettings();
  }
  
  public void initSettings()
  {
    this.width = 640;
    this.height = 480;
    this.format = 17;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.TMG.camera.CameraCaptureSettings
 * JD-Core Version:    0.7.0.1
 */