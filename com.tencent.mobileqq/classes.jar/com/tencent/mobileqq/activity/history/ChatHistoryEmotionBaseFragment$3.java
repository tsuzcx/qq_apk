package com.tencent.mobileqq.activity.history;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.emosm.api.IEmoBatchAddedHandlerApi;
import com.tencent.mobileqq.emosm.favroaming.FavEmoConstant;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedCallback;
import com.tencent.mobileqq.emosm.favroaming.IEmoBatchAddedHandler;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import com.tencent.mobileqq.filemanager.util.FMToastUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

final class ChatHistoryEmotionBaseFragment$3
  implements Runnable
{
  ChatHistoryEmotionBaseFragment$3(List paramList1, IEmoBatchAddedHandler paramIEmoBatchAddedHandler, QQAppInterface paramQQAppInterface, List paramList2) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoBatchAdded", 1, "addEmotions execute");
    }
    Object localObject1 = this.jdField_a_of_type_JavaUtilList;
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B724", "0X800B724", this.jdField_a_of_type_JavaUtilList.size(), 0, "", "", "", "");
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler.b(100);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler.a(this.jdField_a_of_type_JavaUtilList.size());
      if (this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler.a() + this.jdField_a_of_type_JavaUtilList.size() > FavEmoConstant.a)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler.b(1);
        return;
      }
      i = 0;
    }
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      localObject1 = (EmotionPreviewData)this.jdField_a_of_type_JavaUtilList.get(i);
      Object localObject2 = (IEmoBatchAddedHandlerApi)QRoute.api(IEmoBatchAddedHandlerApi.class);
      QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      IEmoBatchAddedHandler localIEmoBatchAddedHandler = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler;
      localObject2 = ((IEmoBatchAddedHandlerApi)localObject2).createEmoBatchAddedCallback(localQQAppInterface, localIEmoBatchAddedHandler, localIEmoBatchAddedHandler.a(Integer.valueOf(i)));
      int j;
      if ((((EmotionPreviewData)localObject1).a instanceof MessageForMarketFace)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0) {
        ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler, (EmotionPreviewData)localObject1, i, (IEmoBatchAddedCallback)localObject2);
      } else {
        ChatHistoryEmotionBaseFragment.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingIEmoBatchAddedHandler, (EmotionPreviewData)localObject1, i, (IEmoBatchAddedCallback)localObject2, this.b);
      }
      i += 1;
      continue;
      FMToastUtil.c(2131692435);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */