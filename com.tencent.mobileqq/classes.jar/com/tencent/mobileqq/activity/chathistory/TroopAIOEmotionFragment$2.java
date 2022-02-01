package com.tencent.mobileqq.activity.chathistory;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emotionintegrate.EmotionPreviewData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;

class TroopAIOEmotionFragment$2
  implements Runnable
{
  TroopAIOEmotionFragment$2(TroopAIOEmotionFragment paramTroopAIOEmotionFragment) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = TroopAIOEmotionFragment.a(this.this$0).iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((ChatMessage)((EmotionPreviewData)((Iterator)localObject).next()).a);
    }
    localObject = null;
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      localObject = (QQAppInterface)localAppRuntime;
    }
    if (localObject != null) {
      if (localArrayList.size() == 1) {
        ((QQAppInterface)localObject).getMessageFacade().a((MessageRecord)localArrayList.get(0), false);
      } else if (localArrayList.size() > 1) {
        ((QQAppInterface)localObject).getMessageFacade().a(localArrayList, false);
      }
    }
    ThreadManager.getUIHandler().post(new TroopAIOEmotionFragment.2.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.chathistory.TroopAIOEmotionFragment.2
 * JD-Core Version:    0.7.0.1
 */