package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actn;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import onk;
import pax;
import pqs;
import prb;
import pvb;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, pqs
{
  public View a;
  pvb a;
  
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
    this.jdField_a_of_type_Pvb = new pvb();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559881, this, true).findViewById(2131378620);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pax))
    {
      this.jdField_a_of_type_Pvb.a((pax)paramObject);
      b();
    }
  }
  
  public void a(prb paramprb)
  {
    this.jdField_a_of_type_Pvb.a(paramprb);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Pvb.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(actn.a(5.0F, getResources()), actn.a(5.0F, getResources()), actn.a(5.0F, getResources()), actn.a(5.0F, getResources()));
      return;
    }
    if (onk.l(this.jdField_a_of_type_Pvb.jdField_a_of_type_Pax.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(actn.a(5.0F, getResources()), actn.a(5.0F, getResources()), actn.a(9.0F, getResources()), actn.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(actn.a(12.0F, getResources()), actn.a(9.0F, getResources()), actn.a(12.0F, getResources()), actn.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Pvb.jdField_a_of_type_Prb != null) {
      this.jdField_a_of_type_Pvb.jdField_a_of_type_Prb.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */