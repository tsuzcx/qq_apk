package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.QQAppInterface;

public class BaseNewFriendView
  extends FrameLayout
{
  protected Intent a;
  protected BaseNewFriendView.INewFriendContext a;
  protected QQAppInterface a;
  private boolean a;
  private boolean b = false;
  
  public BaseNewFriendView(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final void a()
  {
    this.b = false;
    if (!a()) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.b();
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((20000 == paramInt1) && (paramInt2 != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.getActivity().setResult(paramInt2, paramIntent);
      g();
    }
  }
  
  protected void a(Intent paramIntent, BaseNewFriendView.INewFriendContext paramINewFriendContext)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext = paramINewFriendContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
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
      this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.b();
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
    this.jdField_a_of_type_ComTencentMobileqqActivityContactNewfriendBaseNewFriendView$INewFriendContext.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.BaseNewFriendView
 * JD-Core Version:    0.7.0.1
 */