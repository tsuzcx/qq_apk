package com.tencent.biz.pubaccount.readinjoy.common;

import bhvy;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForStructing;
import onh;
import oob;
import qza;
import qzb;

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
    String str = new qzb(null, null, null, null).a("folder_status", oob.d(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("algorithm_id", oob.c(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing)).a("reddot_style", oob.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentRecentBaseData)).a("is_jump_to_video_content", Integer.valueOf(bhvy.L(onh.a()))).a("EnterType", oob.c(this.jdField_a_of_type_Int)).a().a();
    oob.a(oob.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), oob.b(this.jdField_a_of_type_ComTencentMobileqqDataMessageForStructing), "0X8009290", str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.3
 * JD-Core Version:    0.7.0.1
 */