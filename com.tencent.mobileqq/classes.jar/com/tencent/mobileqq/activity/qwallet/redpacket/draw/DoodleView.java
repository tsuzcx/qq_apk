package com.tencent.mobileqq.activity.qwallet.redpacket.draw;

import aezq;
import afaj;
import afba;
import ajcr;
import ajcs;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import java.util.List;

public class DoodleView
  extends View
{
  private ajcs jdField_a_of_type_Ajcs;
  private LineLayer jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer;
  
  public DoodleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer = new LineLayer(this);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a();
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(new ajcr(this));
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(LineLayer.a);
    super.requestLayout();
  }
  
  public int a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
        return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.b();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.c();
    }
    return 0;
  }
  
  public aezq a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return null;
    }
    aezq localaezq = new aezq();
    localaezq.a(a(), paramBoolean, true);
    localaezq.a().a(a());
    return localaezq;
  }
  
  public afaj a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return null;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a();
  }
  
  public List<afba> a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a();
    }
    return null;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.b();
    }
  }
  
  public void a(ajcs paramajcs)
  {
    this.jdField_a_of_type_Ajcs = paramajcs;
    b();
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(paramBoolean);
    }
    super.invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(paramCanvas);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {}
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(paramInt1, paramInt2);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      return this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(paramMotionEvent);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) && (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.b() == 0)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(true);
      }
    }
    while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.d();
  }
  
  public void setLineColor(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.a(paramInt);
    }
  }
  
  public void setLineTexture(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer != null) {
      this.jdField_a_of_type_ComTencentMobileqqActivityQwalletRedpacketDrawLineLayer.b(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.draw.DoodleView
 * JD-Core Version:    0.7.0.1
 */