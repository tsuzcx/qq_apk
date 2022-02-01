package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emosm.api.IEmoticonManagerService;
import com.tencent.mobileqq.emoticon.api.IEmojiManagerService;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

final class ChatActivityFacade$19
  implements Runnable
{
  ChatActivityFacade$19(Emoticon paramEmoticon, IEmoticonManagerService paramIEmoticonManagerService, IEmojiManagerService paramIEmojiManagerService) {}
  
  public void run()
  {
    Object localObject;
    if (this.a.jobType == 0)
    {
      localObject = (ArrayList)this.b.syncGetSubEmoticonsByPackageId(this.a.epId, true);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        this.c.fetchEmoticonEncryptKeys(this.a.epId, (ArrayList)localObject);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("func tryFetchEmosmKey, try fetch normal emotion keys. epId:");
          ((StringBuilder)localObject).append(this.a.epId);
          ((StringBuilder)localObject).append(",cur emo id:");
          ((StringBuilder)localObject).append(this.a.eId);
          QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
        }
      }
    }
    else if ((this.a.jobType == 2) || (this.a.jobType == 4))
    {
      localObject = new ArrayList();
      ((ArrayList)localObject).add(this.a);
      this.c.fetchEmoticonEncryptKeys(this.a.epId, (ArrayList)localObject);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("func tryFetchEmosmKey, try fetch magic emotion key. epId:");
        ((StringBuilder)localObject).append(this.a.epId);
        ((StringBuilder)localObject).append(",cur emo id:");
        ((StringBuilder)localObject).append(this.a.eId);
        QLog.d("ChatActivityFacade", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatActivityFacade.19
 * JD-Core Version:    0.7.0.1
 */