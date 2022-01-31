package com.tencent.mobileqq.adapter;

import aiba;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;

class LebaListViewAdapter$2$1
  implements Runnable
{
  LebaListViewAdapter$2$1(LebaListViewAdapter.2 param2, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_Int <= 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.b();
      aiba.a(this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.this$0, this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch, this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.b);
      return;
    }
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.setMaxNum(99);
    localRedTypeInfo.red_content.set(String.valueOf(this.jdField_a_of_type_Int));
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    localRedTypeInfo.red_type.set(5);
    this.jdField_a_of_type_ComTencentMobileqqAdapterLebaListViewAdapter$2.jdField_a_of_type_ComTencentMobileqqRedtouchRedTouch.a(localRedTypeInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.LebaListViewAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */