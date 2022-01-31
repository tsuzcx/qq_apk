package com.tencent.mobileqq.armap;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.view.View;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.portal.BaseAnimHolder;
import com.tencent.qphone.base.util.QLog;

public class ARMapPendantHolder
  extends ConversationActivePendantHolderBase
{
  public ARMapSaQianView a;
  BaseAnimHolder a;
  BaseAnimHolder jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  private boolean jdField_b_of_type_Boolean;
  BaseAnimHolder c;
  private int k;
  private int l;
  private int m;
  
  public ARMapPendantHolder(View paramView)
  {
    super(paramView);
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView = new ARMapSaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
  }
  
  private void f()
  {
    int i = 2130842274;
    try
    {
      if (this.jdField_b_of_type_Boolean) {
        i = 2130842275;
      }
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(i);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPendantHolder", 2, "initPendantParams ");
    }
    f();
    int i = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131559568);
    int j = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131559575);
    int n = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131559566);
    int i1 = AIOUtils.a(46.0F, this.jdField_a_of_type_AndroidViewView.getResources());
    a(this.jdField_a_of_type_AndroidViewView.getWidth() - j - n, i1, j, i, this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ARMapPendantHolder", 2, "setPendantType type:" + paramInt);
    }
    if (paramInt == 0) {}
    for (boolean bool = true; bool == this.jdField_b_of_type_Boolean; bool = false) {
      return;
    }
    this.jdField_b_of_type_Boolean = bool;
    f();
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    int i;
    int j;
    int n;
    int i1;
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
      i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559583);
      this.m = AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      j = this.g;
      n = this.m;
      i1 = this.h / 2;
      int i2 = i / 2;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842276);
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(i1 + paramInt1 - i2, 0, i, j + n + this.m, paramView);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder == null)
    {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
      this.k = AIOUtils.a(-8.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      i = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559579);
      j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131559580);
      paramInt3 /= 2;
      n = i / 2;
      i1 = this.k;
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842273);
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt3 + paramInt1 - n, i1 + (paramInt2 + paramInt4), i, j, this.jdField_a_of_type_AndroidViewView);
    }
    if (this.c == null)
    {
      this.c = new BaseAnimHolder();
      this.c.jdField_b_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130842290);
      this.l = AIOUtils.a(7.5F, this.jdField_a_of_type_AndroidContentContext.getResources());
      this.c.a(paramInt1 - AIOUtils.a(3.5F, this.jdField_a_of_type_AndroidContentContext.getResources()), paramInt2 - this.l, AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), AIOUtils.a(90.0F, this.jdField_a_of_type_AndroidContentContext.getResources()), this.jdField_a_of_type_AndroidViewView);
    }
  }
  
  protected void a(Canvas paramCanvas)
  {
    super.a(paramCanvas);
    if ((!this.jdField_b_of_type_Boolean) && (this.c != null) && (this.j != 0))
    {
      this.c.j = this.j;
      this.c.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
      this.c.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
      this.c.a(paramCanvas);
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.j != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.j = this.j;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
  }
  
  public void b()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      super.b();
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView.b();
    }
  }
  
  public void b(int paramInt)
  {
    super.b(paramInt);
    if (this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.i = (this.g + this.m);
    }
    if (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.g = (this.g + this.i + this.k);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView.a(this.f + this.h / 2, this.g);
    }
    if (this.c != null) {
      this.c.g = (this.g - this.l);
    }
  }
  
  protected void b(Canvas paramCanvas)
  {
    super.b(paramCanvas);
    if ((!this.jdField_b_of_type_Boolean) && (this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.j != 0))
    {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.j = this.j;
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    if (!this.jdField_b_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView.a(paramCanvas);
    }
  }
  
  public void c()
  {
    if (!this.jdField_b_of_type_Boolean)
    {
      super.c();
      this.jdField_a_of_type_ComTencentMobileqqArmapARMapSaQianView.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapPendantHolder
 * JD-Core Version:    0.7.0.1
 */