package com.tencent.mobileqq.activity.contact.addcontact;

import aeuo;
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
  public aeuo a;
  public Activity a;
  public QQAppInterface a;
  
  public ContactBaseView(aeuo paramaeuo)
  {
    super(paramaeuo.a());
    this.jdField_a_of_type_Aeuo = paramaeuo;
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Aeuo.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramaeuo.a();
  }
  
  public int a()
  {
    return getResources().getDimensionPixelSize(2131166837);
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  protected void b() {}
  
  protected void c() {}
  
  protected void d() {}
  
  protected void g() {}
  
  protected void h() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.ContactBaseView
 * JD-Core Version:    0.7.0.1
 */