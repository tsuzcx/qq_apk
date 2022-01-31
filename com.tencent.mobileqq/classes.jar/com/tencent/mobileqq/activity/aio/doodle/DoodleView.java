package com.tencent.mobileqq.activity.aio.doodle;

import aezq;
import afaj;
import afan;
import afao;
import afba;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

public class DoodleView
  extends View
{
  private afao jdField_a_of_type_Afao;
  private LineLayer jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(new afan(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(LineLayer.a);
    super.requestLayout();
  }
  
  public int a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.b();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.c();
    }
    return 0;
  }
  
  public aezq a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return null;
    }
    aezq localaezq = new aezq();
    localaezq.a(a(), paramBoolean, true);
    localaezq.a().a(a());
    return localaezq;
  }
  
  public afaj a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
  }
  
  public Bitmap a(int paramInt)
  {
    int i = getWidth();
    i = (int)(getHeight() * 1.0F / i * paramInt);
    try
    {
      Bitmap localBitmap = Bitmap.createBitmap(paramInt, i, Bitmap.Config.ARGB_8888);
      if (localBitmap == null) {
        return null;
      }
      Canvas localCanvas = new Canvas(localBitmap);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(localCanvas);
      }
      return localBitmap;
    }
    catch (Exception localException)
    {
      return null;
    }
    catch (OutOfMemoryError localOutOfMemoryError) {}
    return null;
  }
  
  public List<afba> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
    }
    this.jdField_a_of_type_Afao = null;
  }
  
  public void a(afao paramafao)
  {
    this.jdField_a_of_type_Afao = paramafao;
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(paramBoolean);
    }
    super.invalidate();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.d();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
    if (paramInt != 0) {
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.b() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.d();
  }
  
  public void setLineColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */