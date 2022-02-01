package com.tencent.biz.pubaccount.readinjoy.common;

import bmhv;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForStructing;
import pkh;
import pkp;
import sut;
import suu;

public final class WeishiReportUtil$3
  implements Runnable
{
  public WeishiReportUtil$3(QQAppInterface paramQQAppInterface, MessageForStructing paramMessageForStructing, RecentBaseData paramRecentBaseData, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().updateMsgFieldByUniseq(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.frienduin, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.istroop, this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.uniseq, "extLong", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.extLong));
    if (this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.structingMsg == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing.parse();
    }
    String str = new suu(null, null, null, null).a("folder_status", pkp.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("algorithm_id", pkp.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("reddot_style", pkp.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("is_jump_to_video_content", Integer.valueOf(bmhv.F(pkh.a()))).a("EnterType", pkp.c(this.jdField_a_of_type_Int)).a().a();
    pkp.a(pkp.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), pkp.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */