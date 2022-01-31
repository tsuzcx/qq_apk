package com.tencent.mobileqq.armap;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.widget.ImageView;
import anod;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class SdCardImageAnimView
  extends ImageView
  implements anod
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  anod jdField_a_of_type_Anod = null;
  private FrameBmpCache jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache;
  private Runnable jdField_a_of_type_JavaLangRunnable = new SdCardImageAnimView.1(this);
  public boolean a;
  private Runnable jdField_b_of_type_JavaLangRunnable = new SdCardImageAnimView.2(this);
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  private boolean d;
  
  public SdCardImageAnimView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public SdCardImageAnimView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache = new FrameBmpCache(getResources());
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a(this);
    new HandlerThread("sub_thread").start();
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache != null) && (this.c))
    {
      Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a();
      if (QLog.isColorLevel()) {
        QLog.i("SdCardImageAnimView", 2, "bgUpdate cb=" + localBitmap + ", cbm=" + this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      if (this.jdField_a_of_type_AndroidGraphicsBitmap != localBitmap)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
        setImageBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap);
      }
      int i = 32;
      if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a > 0) {
        i = 1000 / this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a;
      }
      this.jdField_a_of_type_Boolean = true;
      postDelayed(this.jdField_a_of_type_JavaLangRunnable, i);
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.b();
    this.c = true;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.c();
    }
    this.c = false;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  public void a()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim has no data, return ");
      return;
    }
    if (this.c)
    {
      QLog.i("SdCardImageAnimView", 1, "startAnim isAnimStarted, return");
      return;
    }
    ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    d();
    post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void a(SdCardImageAnimView paramSdCardImageAnimView)
  {
    if (this.jdField_a_of_type_Anod != null) {
      this.jdField_a_of_type_Anod.a(this);
    }
  }
  
  public boolean a()
  {
    if (!this.jdField_b_of_type_Boolean) {
      return false;
    }
    ThreadManager.getSubThreadHandler().removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
    removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    e();
    return true;
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList)
  {
    setAnimationData(paramArrayList, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    setAnimationData(paramArrayList, paramBoolean, false);
  }
  
  public void setAnimationData(ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0)) {}
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a(paramBoolean1);
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.b(paramBoolean2);
      this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a(paramArrayList);
      return;
    }
  }
  
  public void setDefaultImg()
  {
    ThreadManager.getSubThreadHandler().post(this.jdField_b_of_type_JavaLangRunnable);
  }
  
  public void setEndListener(anod paramanod)
  {
    this.jdField_a_of_type_Anod = paramanod;
  }
  
  public void setFPS(int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapFrameBmpCache.a(paramInt);
  }
  
  public void setVisibility(int paramInt)
  {
    super.setVisibility(paramInt);
    if (paramInt != 0) {
      this.d = a();
    }
    while (!this.d) {
      return;
    }
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.armap.SdCardImageAnimView
 * JD-Core Version:    0.7.0.1
 */