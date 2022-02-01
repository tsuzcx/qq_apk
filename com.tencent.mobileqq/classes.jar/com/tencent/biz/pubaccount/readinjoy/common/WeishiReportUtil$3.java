package com.tencent.biz.pubaccount.readinjoy.common;

import bnrf;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import ozs;
import pai;
import sbf;
import sbg;

public final class WeishiReportUtil$3
  implements Runnable
{
  public WeishiReportUtil$3(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, RecentBaseData paramRecentBaseData, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq, "extLong", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.extLong));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.parse();
    }
    String str = new sbg(null, null, null, null).a("folder_status", pai.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("algorithm_id", pai.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("reddot_style", pai.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("is_jump_to_video_content", Integer.valueOf(bnrf.I(ozs.a()))).a("EnterType", pai.c(this.jdField_a_of_type_Int)).a().a();
    pai.a(pai.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pai.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */