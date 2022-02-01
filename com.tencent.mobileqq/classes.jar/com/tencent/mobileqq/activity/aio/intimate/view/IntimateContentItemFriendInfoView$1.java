package com.tencent.mobileqq.activity.aio.intimate.view;

import agll;
import auzd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class IntimateContentItemFriendInfoView$1
  implements Runnable
{
  IntimateContentItemFriendInfoView$1(IntimateContentItemFriendInfoView paramIntimateContentItemFriendInfoView) {}
  
  public void run()
  {
    if ((this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo != null) && (this.this$0.jdField_a_of_type_Agll.a() != null)) {
      ((auzd)this.this$0.jdField_a_of_type_Agll.a().getManager(QQManagerFactory.INTIMATE_INFO_MANAGER)).a(this.this$0.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.intimate.view.IntimateContentItemFriendInfoView.1
 * JD-Core Version:    0.7.0.1
 */