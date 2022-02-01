package com.tencent.mobileqq.activity.selectmember;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class TroopDiscussionBaseV
  extends FrameLayout
{
  protected Context a;
  protected LayoutInflater a;
  protected InnerFrameManager a;
  protected SelectMemberActivity a;
  protected QQAppInterface a;
  
  public TroopDiscussionBaseV(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramSelectMemberActivity.app;
    this.jdField_a_of_type_ComTencentMobileqqActivitySelectmemberSelectMemberActivity = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidContentContext = paramSelectMemberActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramSelectMemberActivity.getLayoutInflater();
    this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager = paramSelectMemberActivity.jdField_a_of_type_ComTencentCommonAppInnerFrameManager;
  }
  
  protected void a() {}
  
  protected final void a(int paramInt)
  {
    ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(paramInt, this, true);
  }
  
  public void a(Bundle paramBundle) {}
  
  protected void b() {}
  
  public void b(Bundle paramBundle) {}
  
  protected void e() {}
  
  protected void f() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopDiscussionBaseV
 * JD-Core Version:    0.7.0.1
 */