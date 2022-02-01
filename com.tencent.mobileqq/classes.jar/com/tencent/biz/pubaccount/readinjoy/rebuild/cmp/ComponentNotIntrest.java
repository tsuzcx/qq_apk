package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import afur;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import pha;
import pxk;
import qqs;
import qrb;
import qva;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, qqs
{
  public View a;
  qva a;
  
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
    this.jdField_a_of_type_Qva = new qva();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560122, this, true).findViewById(2131380227);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pxk))
    {
      this.jdField_a_of_type_Qva.a((pxk)paramObject);
      b();
    }
  }
  
  public void a(qrb paramqrb)
  {
    this.jdField_a_of_type_Qva.a(paramqrb);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qva.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(afur.a(5.0F, getResources()), afur.a(5.0F, getResources()), afur.a(5.0F, getResources()), afur.a(5.0F, getResources()));
      return;
    }
    if (pha.l(this.jdField_a_of_type_Qva.jdField_a_of_type_Pxk.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(afur.a(5.0F, getResources()), afur.a(5.0F, getResources()), afur.a(9.0F, getResources()), afur.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(afur.a(12.0F, getResources()), afur.a(9.0F, getResources()), afur.a(12.0F, getResources()), afur.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qva.jdField_a_of_type_Qrb != null) {
      this.jdField_a_of_type_Qva.jdField_a_of_type_Qrb.a(paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */