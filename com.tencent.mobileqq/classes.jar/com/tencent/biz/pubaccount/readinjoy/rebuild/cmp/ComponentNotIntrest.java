package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import actj;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import onh;
import pau;
import pqp;
import pqy;
import puy;

public class ComponentNotIntrest
  extends FrameLayout
  implements View.OnClickListener, pqp
{
  public View a;
  puy a;
  
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
    this.jdField_a_of_type_Puy = new puy();
    a(paramContext);
    a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(this);
  }
  
  public void a(Context paramContext)
  {
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(paramContext).inflate(2131559881, this, true).findViewById(2131378625);
  }
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof pau))
    {
      this.jdField_a_of_type_Puy.a((pau)paramObject);
      b();
    }
  }
  
  public void a(pqy parampqy)
  {
    this.jdField_a_of_type_Puy.a(parampqy);
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Puy.a())
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(actj.a(5.0F, getResources()), actj.a(5.0F, getResources()), actj.a(5.0F, getResources()), actj.a(5.0F, getResources()));
      return;
    }
    if (onh.l(this.jdField_a_of_type_Puy.jdField_a_of_type_Pau.a()))
    {
      this.jdField_a_of_type_AndroidViewView.setPadding(actj.a(5.0F, getResources()), actj.a(5.0F, getResources()), actj.a(9.0F, getResources()), actj.a(5.0F, getResources()));
      return;
    }
    this.jdField_a_of_type_AndroidViewView.setPadding(actj.a(12.0F, getResources()), actj.a(9.0F, getResources()), actj.a(12.0F, getResources()), actj.a(9.0F, getResources()));
  }
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Puy.jdField_a_of_type_Pqy != null) {
      this.jdField_a_of_type_Puy.jdField_a_of_type_Pqy.a(paramView, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentNotIntrest
 * JD-Core Version:    0.7.0.1
 */