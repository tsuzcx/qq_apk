package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$2
  implements QueryCallback<EmoticonPackage>
{
  MarketFaceItemBuilder$2(MarketFaceItemBuilder paramMarketFaceItemBuilder, int paramInt, ChatMessage paramChatMessage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    String str = "0";
    int i = -1;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 == paramEmoticonPackage.jobType) || (5 == paramEmoticonPackage.jobType)) {
        i = 2;
      }
    }
    else
    {
      if (this.jdField_a_of_type_Int != 2131365636) {
        break label98;
      }
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
    }
    label98:
    do
    {
      do
      {
        return;
        i = 1;
        break;
        if (this.jdField_a_of_type_Int == 2131362218)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a(paramEmoticonPackage, str, i);
          return;
        }
        if ((this.jdField_a_of_type_Int == 2131367415) || (this.jdField_a_of_type_Int == 2131367136))
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a(paramEmoticonPackage, str, i, this.jdField_a_of_type_Int);
          return;
        }
      } while (this.jdField_a_of_type_Int != 2131371953);
      if (QLog.isColorLevel()) {
        QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
      }
    } while ((MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null) || (MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage == null) || (MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon == null));
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B115", "0X800B115", EmoticonUtils.getRelatedEmotionReportFromType(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "1", "", MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.epId, MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.emoticon.eId);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b(MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */