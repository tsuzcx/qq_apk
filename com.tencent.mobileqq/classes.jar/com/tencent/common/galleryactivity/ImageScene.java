package com.tencent.common.galleryactivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;

public abstract class ImageScene
{
  ViewGroup B;
  protected GalleryManager C;
  private Handler a = new Handler();
  
  public ViewGroup C()
  {
    return this.B;
  }
  
  public void D()
  {
    GalleryManager localGalleryManager = this.C;
    if (localGalleryManager != null) {
      localGalleryManager.f();
    }
  }
  
  public void L_() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  void a(GalleryManager paramGalleryManager)
  {
    this.C = paramGalleryManager;
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    this.B = paramViewGroup;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void d() {}
  
  public void k() {}
  
  public void l() {}
  
  public void t() {}
  
  public void u() {}
  
  public boolean x()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.galleryactivity.ImageScene
 * JD-Core Version:    0.7.0.1
 */