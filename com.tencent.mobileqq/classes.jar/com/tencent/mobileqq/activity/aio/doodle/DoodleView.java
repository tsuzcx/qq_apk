package com.tencent.mobileqq.activity.aio.doodle;

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
  private DoodleView.DoodleViewListener jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$DoodleViewListener;
  private LineLayer jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(new DoodleView.1(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(LineLayer.a);
    super.requestLayout();
  }
  
  public int a(boolean paramBoolean)
  {
    LineLayer localLineLayer;
    if (!paramBoolean)
    {
      localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
      if (localLineLayer != null) {
        return localLineLayer.b();
      }
    }
    else
    {
      localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
      if (localLineLayer != null) {
        return localLineLayer.c();
      }
    }
    return 0;
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
    catch (OutOfMemoryError|Exception localOutOfMemoryError) {}
    return null;
  }
  
  public DoodleItem a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer == null) {
      return null;
    }
    DoodleItem localDoodleItem = new DoodleItem();
    localDoodleItem.a(a(), paramBoolean, true);
    localDoodleItem.a().a(a());
    return localDoodleItem;
  }
  
  public DoodleParam a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer == null) {
      return null;
    }
    return localLineLayer.a();
  }
  
  public List<PathData> a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      return localLineLayer.a();
    }
    return null;
  }
  
  public void a()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$DoodleViewListener = null;
  }
  
  public void a(DoodleView.DoodleViewListener paramDoodleViewListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleDoodleView$DoodleViewListener = paramDoodleViewListener;
    c();
  }
  
  public void a(boolean paramBoolean)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramBoolean);
    }
    super.invalidate();
  }
  
  public void b()
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.d();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
      if (localLineLayer != null) {
        localLineLayer.a(paramInt1, paramInt2);
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      return localLineLayer.a(paramMotionEvent);
    }
    return false;
  }
  
  protected void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (isShown()) {
      super.invalidate();
    }
    if (paramInt != 0)
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
      if ((paramView != null) && (paramView.b() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer.a(true);
      }
    }
    else
    {
      paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
      if (paramView != null) {
        paramView.d();
      }
    }
  }
  
  public void setLineColor(int paramInt)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.a(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    LineLayer localLineLayer = this.jdField_a_of_type_ComTencentMobileqqActivityAioDoodleLineLayer;
    if (localLineLayer != null) {
      localLineLayer.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.doodle.DoodleView
 * JD-Core Version:    0.7.0.1
 */