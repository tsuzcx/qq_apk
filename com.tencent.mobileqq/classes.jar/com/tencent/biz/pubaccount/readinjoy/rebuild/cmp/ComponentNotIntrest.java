package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import aciy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import obz;
import opw;
import pey;
import pfh;
import pjg;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, pey
{
  public View a;
  pjg a;
  
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
    this.jdField_a_of_type_Pjg = new pjg();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131494310, this, true).findViewById(2131312796);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof opw))
    {
      this.jdField_a_of_type_Pjg.a((opw)paramObject);
      b();
    }
  }
  
  public void a(pfh parampfh)
  {
    this.jdField_a_of_type_Pjg.a(parampfh);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pjg.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(aciy.a(5.0F, getResources()), aciy.a(5.0F, getResources()), aciy.a(5.0F, getResources()), aciy.a(5.0F, getResources()));
      return;
    }
    if (obz.l(this.jdField_a_of_type_Pjg.jdField_a_of_type_Opw.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(aciy.a(5.0F, getResources()), aciy.a(5.0F, getResources()), aciy.a(9.0F, getResources()), aciy.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(aciy.a(12.0F, getResources()), aciy.a(9.0F, getResources()), aciy.a(12.0F, getResources()), aciy.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Pjg.jdField_a_of_type_Pfh != null) {
      this.jdField_a_of_type_Pjg.jdField_a_of_type_Pfh.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */