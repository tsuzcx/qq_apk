package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import pay;
import pvc;
import qpj;
import qps;
import qtr;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, qpj
{
  public View a;
  qtr a;
  
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
    this.jdField_a_of_type_Qtr = new qtr();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560141, this, true).findViewById(2131380137);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pvc))
    {
      this.jdField_a_of_type_Qtr.a((pvc)paramObject);
      b();
    }
  }
  
  public void a(qps paramqps)
  {
    this.jdField_a_of_type_Qtr.a(paramqps);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qtr.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.dp2px(5.0F, getResources()), AIOUtils.dp2px(5.0F, getResources()), AIOUtils.dp2px(5.0F, getResources()), AIOUtils.dp2px(5.0F, getResources()));
      return;
    }
    if (pay.l(this.jdField_a_of_type_Qtr.jdField_a_of_type_Pvc.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.dp2px(5.0F, getResources()), AIOUtils.dp2px(5.0F, getResources()), AIOUtils.dp2px(9.0F, getResources()), AIOUtils.dp2px(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(AIOUtils.dp2px(12.0F, getResources()), AIOUtils.dp2px(9.0F, getResources()), AIOUtils.dp2px(12.0F, getResources()), AIOUtils.dp2px(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qtr.jdField_a_of_type_Qps != null) {
      this.jdField_a_of_type_Qtr.jdField_a_of_type_Qps.a(paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */