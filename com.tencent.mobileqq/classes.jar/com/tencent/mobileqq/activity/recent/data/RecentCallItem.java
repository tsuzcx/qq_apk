package com.tencent.mobileqq.activity.recent.data;

import android.content.Context;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QCallRecent;

public class RecentCallItem
  extends RecentBaseData
{
  protected QCallRecent a;
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.type;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallTime;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.uin;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    this.b = "123123123";
    this.jdField_c_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.lastCallMsg;
    this.jdField_a_of_type_Int = 0;
    this.h = 4;
    this.d = 1;
    this.jdField_c_of_type_JavaLangString = "0";
    this.jdField_c_of_type_Int = 0;
    this.f = 12288;
    this.e = "视频";
    this.jdField_a_of_type_ComTencentMobileqqDataQCallRecent.isVideo = 1;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public boolean b()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.data.RecentCallItem
 * JD-Core Version:    0.7.0.1
 */