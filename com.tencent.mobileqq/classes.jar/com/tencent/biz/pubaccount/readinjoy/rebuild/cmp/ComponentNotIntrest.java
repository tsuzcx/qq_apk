package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import agej;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import ozs;
import ppu;
import qjg;
import qjp;
import qno;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, qjg
{
  public View a;
  qno a;
  
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
    this.jdField_a_of_type_Qno = new qno();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131560134, this, true).findViewById(2131380413);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof ppu))
    {
      this.jdField_a_of_type_Qno.a((ppu)paramObject);
      b();
    }
  }
  
  public void a(qjp paramqjp)
  {
    this.jdField_a_of_type_Qno.a(paramqjp);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Qno.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(agej.a(5.0F, getResources()), agej.a(5.0F, getResources()), agej.a(5.0F, getResources()), agej.a(5.0F, getResources()));
      return;
    }
    if (ozs.l(this.jdField_a_of_type_Qno.jdField_a_of_type_Ppu.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(agej.a(5.0F, getResources()), agej.a(5.0F, getResources()), agej.a(9.0F, getResources()), agej.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(agej.a(12.0F, getResources()), agej.a(9.0F, getResources()), agej.a(12.0F, getResources()), agej.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Qno.jdField_a_of_type_Qjp != null) {
      this.jdField_a_of_type_Qno.jdField_a_of_type_Qjp.a(paramView, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */