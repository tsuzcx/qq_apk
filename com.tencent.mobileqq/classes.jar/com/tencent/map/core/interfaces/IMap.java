package com.tencent.map.core.interfaces;

import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;

public abstract interface IMap
{
  public abstract void moveCamera(CameraUpdate paramCameraUpdate);
  
  public abstract void setIndoorEnabled(boolean paramBoolean);
  
  public abstract void setIndoorFloor(int paramInt);
  
  public abstract void setIndoorFloor(String paramString1, String paramString2);
  
  public abstract void setMapStyle(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.core.interfaces.IMap
 * JD-Core Version:    0.7.0.1
 */