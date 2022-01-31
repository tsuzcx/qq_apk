package com.tencent.mapsdk.raster.model;

public class TencentMapOptions
{
  public static final int LOGO_POSITION_BOTTOM_LEFT = 0;
  public static final int LOGO_POSITION_BOTTOM_RIGHT = 1;
  public static final int LOGO_POSITION_TOP_LEFT = 3;
  public static final int LOGO_POSITION_TOP_RIGHT = 2;
  private boolean enableHandDrawMap = false;
  
  public TencentMapOptions enableHandDrawMap(boolean paramBoolean)
  {
    this.enableHandDrawMap = paramBoolean;
    return this;
  }
  
  public boolean isHandDrawMapEnable()
  {
    return this.enableHandDrawMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.raster.model.TencentMapOptions
 * JD-Core Version:    0.7.0.1
 */