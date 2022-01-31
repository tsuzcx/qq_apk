package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import java.util.List;

public abstract interface EditVideoPlayerExport
  extends EditVideoPart.EditExport
{
  public abstract long a(int paramInt);
  
  public abstract Bitmap a(int paramInt);
  
  public abstract List a();
  
  public abstract void a(int paramInt1, int paramInt2, float paramFloat);
  
  public abstract void a(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(Bitmap paramBitmap, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract void b(int paramInt);
  
  public abstract void i();
  
  public abstract void j();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditVideoPlayerExport
 * JD-Core Version:    0.7.0.1
 */