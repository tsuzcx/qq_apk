package com.tencent.mobileqq.activity.contact.addcontact;

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
  public Activity a;
  public ContactBaseView.IAddContactContext a;
  public QQAppInterface a;
  
  public ContactBaseView(ContactBaseView.IAddContactContext paramIAddContactContext)
  {
    super(paramIAddContactContext.a());
    this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext = paramIAddContactContext;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_ComTencentMobileqqActivityContactAddcontactContactBaseView$IAddContactContext.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramIAddContactContext.a();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131298174);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */