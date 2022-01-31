package com.tencent.common.galleryactivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.ViewGroup;

public abstract class ImageScene
{
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler();
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  public GalleryManager a;
  
  public ViewGroup a()
  {
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(Configuration paramConfiguration) {}
  
  void a(GalleryManager paramGalleryManager)
  {
    this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager = paramGalleryManager;
  }
  
  public void a(Runnable paramRunnable, long paramLong)
  {
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(paramRunnable, paramLong);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent)
  {
    return false;
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public boolean e()
  {
    return false;
  }
  
  public void f() {}
  
  public void h() {}
  
  public void k() {}
  
  public void l() {}
  
  public void r()
  {
    if (this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager != null) {
      this.jdField_a_of_type_ComTencentCommonGalleryactivityGalleryManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.galleryactivity.ImageScene
 * JD-Core Version:    0.7.0.1
 */