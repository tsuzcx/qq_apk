package com.tencent.mapsdk.rastercore.e;

import android.graphics.Canvas;

public abstract interface b
{
  public abstract boolean checkInBounds();
  
  public abstract void destroy();
  
  public abstract void draw(Canvas paramCanvas);
  
  public abstract boolean equalsRemote(b paramb);
  
  public abstract String getId();
  
  public abstract float getZIndex();
  
  public abstract int hashCodeRemote();
  
  public abstract boolean isVisible();
  
  public abstract void remove();
  
  public abstract void setVisible(boolean paramBoolean);
  
  public abstract void setZIndex(float paramFloat);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.e.b
 * JD-Core Version:    0.7.0.1
 */