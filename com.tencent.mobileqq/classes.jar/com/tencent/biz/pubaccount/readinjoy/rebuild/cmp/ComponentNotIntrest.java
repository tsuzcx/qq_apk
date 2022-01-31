package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aepi;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import ors;
import pgd;
import pxk;
import pxt;
import qbs;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, pxk
{
  public View a;
  qbs a;
  
  public ComponentNotIntrest(Context paramContext)
  {
    super(paramContext);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b(paramContext);
  }
  
  public ComponentNotIntrest(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b(paramContext);
  }
  
  private void b(Context paramContext)
  {
    this.jdField_a_of_type_Qbs = new qbs();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559975, this, true).findViewById(2131379300);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pgd))
    {
      this.jdField_a_of_type_Qbs.a((pgd)paramObject);
      b();
    }
  }
  
  public void a(pxt parampxt)
  {
    this.jdField_a_of_type_Qbs.a(parampxt);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qbs.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(aepi.a(5.0F, getResources()), aepi.a(5.0F, getResources()), aepi.a(5.0F, getResources()), aepi.a(5.0F, getResources()));
      return;
    }
    if (ors.l(this.jdField_a_of_type_Qbs.jdField_a_of_type_Pgd.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(aepi.a(5.0F, getResources()), aepi.a(5.0F, getResources()), aepi.a(9.0F, getResources()), aepi.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(aepi.a(12.0F, getResources()), aepi.a(9.0F, getResources()), aepi.a(12.0F, getResources()), aepi.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qbs.jdField_a_of_type_Pxt != null) {
      this.jdField_a_of_type_Qbs.jdField_a_of_type_Pxt.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */