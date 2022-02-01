package com.tencent.mobileqq.activity.contact.newfriend;

import ajjg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseNewFriendView
  extends FrameLayout
{
  public ajjg a;
  protected Intent a;
  public QQAppInterface a;
  private boolean a;
  private boolean b;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a()
  {
    this.b = false;
    if (!a()) {
      this.jdField_a_of_type_Ajjg.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((20000 == paramInt1) && (paramInt2 != 0))
    {
      this.jdField_a_of_type_Ajjg.getActivity().setResult(paramInt2, paramIntent);
      g();
    }
  }
  
  protected void a(Intent paramIntent, ajjg paramajjg)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_Ajjg = paramajjg;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_Ajjg.a();
  }
  
  protected final boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Boolean = false;
    if (this.b)
    {
      this.jdField_a_of_type_Ajjg.a();
      return;
    }
    this.jdField_a_of_type_Ajjg.b();
  }
  
  protected void c() {}
  
  protected void d() {}
  
  protected final void d(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  protected void e()
  {
    a();
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void f() {}
  
  protected void g()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Ajjg.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */