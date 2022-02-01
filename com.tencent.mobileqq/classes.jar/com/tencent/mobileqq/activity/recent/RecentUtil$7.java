package com.tencent.mobileqq.activity.recent;

import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoDownloadItem;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;

final class RecentUtil$7
  implements Runnable
{
  RecentUtil$7(QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem) {}
  
  public void run()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade();
    if (localObject != null) {
      localObject = ((QQMessageFacade)localObject).getLastMessage(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int);
    } else {
      localObject = null;
    }
    if (localObject != null)
    {
      if ("false".equals(((Message)localObject).getExtInfoFromExtStr("recent_list_advertisement_message_first_click")))
      {
        ((Message)localObject).saveExtInfoToExtStr("recent_list_advertisement_message_first_click", "true");
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((Message)localObject).frienduin, ((Message)localObject).msgtype, ((Message)localObject).uniseq, "extStr", ((Message)localObject).extStr);
        if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null) {
          ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F5E", "0X8008F5E", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", PublicAccountAdUtil.a(), this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a != null) {
        ReportController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.jdField_a_of_type_JavaLangString, "0X8008F60", "0X8008F60", 0, 0, this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.c, "", "", this.jdField_a_of_type_ComTencentBizPubaccountAdvertisementDataAdvertisementItem.a.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil.7
 * JD-Core Version:    0.7.0.1
 */