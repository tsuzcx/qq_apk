package com.tencent.mobileqq.activity.contact.addcontact;

import aitf;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class ContactBaseView
  extends FrameLayout
{
  public aitf a;
  public Activity a;
  public QQAppInterface a;
  
  public ContactBaseView(aitf paramaitf)
  {
    super(paramaitf.a());
    this.jdField_a_of_type_Aitf = paramaitf;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Aitf.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaitf.a();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298099);
  }
  
  public void a() {}
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void b() {}
  
  public void c() {}
  
  public void d() {}
  
  public void g() {}
  
  public void h() {}
  
  public final void setContentView(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */