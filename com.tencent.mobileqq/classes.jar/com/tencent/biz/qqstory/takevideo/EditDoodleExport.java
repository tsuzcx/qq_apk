package com.tencent.biz.qqstory.takevideo;

import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;

public abstract interface EditDoodleExport
  extends EditVideoPart.EditExport
{
  public abstract void J_();
  
  public abstract int a();
  
  public abstract Bitmap a();
  
  public abstract Bitmap a(int paramInt);
  
  @NonNull
  public abstract DoodleLayout a();
  
  public abstract void a(int paramInt1, int paramInt2);
  
  public abstract void a(Bitmap paramBitmap);
  
  public abstract void a(MotionEvent paramMotionEvent);
  
  public abstract boolean a(int paramInt);
  
  public abstract boolean a(MotionEvent paramMotionEvent);
  
  public abstract byte[] a(int paramInt);
  
  public abstract void b();
  
  public abstract boolean b();
  
  public abstract boolean c_();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.EditDoodleExport
 * JD-Core Version:    0.7.0.1
 */