package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.EmoBatchAddedHandler;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class ChatHistoryEmotionBaseFragment$3
  implements Runnable
{
  ChatHistoryEmotionBaseFragment$3(List paramList1, EmoBatchAddedHandler paramEmoBatchAddedHandler, QQAppInterface paramQQAppInterface, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "addEmotions execute");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (!this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B724", "0X800B724", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(100);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.a(this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.g + this.jdField_a_of_type_JavaUtilList.size() > FavEmoConstant.a)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.b(1);
        return;
      }
      int i = 0;
      label124:
      EmotionPreviewData localEmotionPreviewData;
      EmoBatchAddedCallback localEmoBatchAddedCallback;
      int j;
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        localEmotionPreviewData = (EmotionPreviewData)this.jdField_a_of_type_JavaUtilList.get(i);
        localEmoBatchAddedCallback = new EmoBatchAddedCallback(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler.a(Integer.valueOf(i)));
        if (!(localEmotionPreviewData.a instanceof MessageForMarketFace)) {
          break label217;
        }
        j = 0;
        label191:
        if (j != 0) {
          break label222;
        }
        ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler, localEmotionPreviewData, i, localEmoBatchAddedCallback);
      }
      for (;;)
      {
        i += 1;
        break label124;
        break;
        label217:
        j = 1;
        break label191;
        label222:
        ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingEmoBatchAddedHandler, localEmotionPreviewData, i, localEmoBatchAddedCallback, this.b);
      }
    }
    FMToastUtil.c(2131692499);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */