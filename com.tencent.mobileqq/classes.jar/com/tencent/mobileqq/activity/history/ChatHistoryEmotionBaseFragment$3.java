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
    Object localObject1 = this.a;
    int i;
    if ((localObject1 != null) && (!((List)localObject1).isEmpty()))
    {
      ReportController.b(null, "dc00898", "", "", "0X800B724", "0X800B724", this.a.size(), 0, "", "", "", "");
      this.b.b(100);
      this.b.a(this.a.size());
      if (this.b.a() + this.a.size() > FavEmoConstant.a)
      {
        this.b.b(1);
        return;
      }
      i = 0;
    }
    while (i < this.a.size())
    {
      localObject1 = (EmotionPreviewData)this.a.get(i);
      Object localObject2 = (IEmoBatchAddedHandlerApi)QRoute.api(IEmoBatchAddedHandlerApi.class);
      QQAppInterface localQQAppInterface = this.c;
      IEmoBatchAddedHandler localIEmoBatchAddedHandler = this.b;
      localObject2 = ((IEmoBatchAddedHandlerApi)localObject2).createEmoBatchAddedCallback(localQQAppInterface, localIEmoBatchAddedHandler, localIEmoBatchAddedHandler.a(Integer.valueOf(i)));
      int j;
      if ((((EmotionPreviewData)localObject1).a instanceof MessageForMarketFace)) {
        j = 0;
      } else {
        j = 1;
      }
      if (j == 0) {
        ChatHistoryEmotionBaseFragment.a(this.c, this.b, (EmotionPreviewData)localObject1, i, (IEmoBatchAddedCallback)localObject2);
      } else {
        ChatHistoryEmotionBaseFragment.a(this.c, this.b, (EmotionPreviewData)localObject1, i, (IEmoBatchAddedCallback)localObject2, this.d);
      }
      i += 1;
      continue;
      FMToastUtil.c(2131889423);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionBaseFragment.3
 * JD-Core Version:    0.7.0.1
 */