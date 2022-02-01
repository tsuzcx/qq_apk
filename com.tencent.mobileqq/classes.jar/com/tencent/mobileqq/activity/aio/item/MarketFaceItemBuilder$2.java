package com.tencent.mobileqq.activity.aio.item;

import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.IPicEmoticonInfo;
import com.tencent.mobileqq.emoticonview.QueryCallback;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class MarketFaceItemBuilder$2
  implements QueryCallback<EmoticonPackage>
{
  MarketFaceItemBuilder$2(MarketFaceItemBuilder paramMarketFaceItemBuilder, int paramInt, ChatMessage paramChatMessage) {}
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    String str;
    int i;
    if (paramEmoticonPackage != null)
    {
      str = paramEmoticonPackage.epId;
      if ((3 != paramEmoticonPackage.jobType) && (5 != paramEmoticonPackage.jobType)) {
        i = 1;
      } else {
        i = 2;
      }
    }
    else
    {
      str = "0";
      i = -1;
    }
    int j = this.jdField_a_of_type_Int;
    if (j == 2131365480)
    {
      ChatActivityFacade.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006447", "0X8006447", 0, 0, "4", "", "", "");
      return;
    }
    if (j == 2131362241)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a(paramEmoticonPackage, str, i);
      return;
    }
    if ((j != 2131367197) && (j != 2131366973))
    {
      if (j == 2131371561)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MarketFaceItemBuilder", 4, "marketface related click");
        }
        if ((MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo != null) && (MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage != null))
        {
          if (MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon() == null) {
            return;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0X800B115", "0X800B115", EmoticonPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_Int), 0, "1", "", MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().epId, MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewIPicEmoticonInfo.getEmoticon().eId);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.b(MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
          return;
        }
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioItemMarketFaceItemBuilder.a(paramEmoticonPackage, str, i, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.2
 * JD-Core Version:    0.7.0.1
 */