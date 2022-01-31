package com.tencent.mobileqq.activity.aio.anim.goldmsg;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RelativeLayout;
import com.tencent.qphone.base.util.QLog;

public class BaseGoldMsgAnimator
{
  protected int a;
  Context jdField_a_of_type_AndroidContentContext;
  public Handler a;
  public RelativeLayout a;
  public GoldMsgAnimatorCtr a;
  public String a;
  boolean jdField_a_of_type_Boolean = false;
  boolean b = false;
  
  public BaseGoldMsgAnimator(int paramInt, GoldMsgAnimatorCtr paramGoldMsgAnimatorCtr, RelativeLayout paramRelativeLayout)
  {
    this.jdField_a_of_type_JavaLangString = BaseGoldMsgAnimator.class.getSimpleName();
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioAnimGoldmsgGoldMsgAnimatorCtr = paramGoldMsgAnimatorCtr;
    this.jdField_a_of_type_AndroidContentContext = paramRelativeLayout.getContext();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  }
  
  protected void a()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "end | animId:" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  protected void a(Bundle paramBundle)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "start | animId:" + this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
  }
  
  protected void b()
  {
    if (QLog.isDevelopLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 4, "stop | animId:" + this.jdField_a_of_type_Int);
    }
    this.b = true;
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.goldmsg.BaseGoldMsgAnimator
 * JD-Core Version:    0.7.0.1
 */