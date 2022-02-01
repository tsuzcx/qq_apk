package com.tencent.imcore.message.facade.add;

import android.text.TextUtils;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.facade.IOnMessageAddCompleteObserver;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.data.MessageForFoldMsg;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.List;

public abstract class OnMessageAddCompleteObserver
  implements IOnMessageAddCompleteObserver<QQMessageFacade>
{
  protected MessageRecord a(List<MessageRecord> paramList)
  {
    if (paramList != null)
    {
      if (paramList.isEmpty()) {
        return null;
      }
      int i = paramList.size() - 1;
      while (i >= 0)
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.get(i);
        if ((!TextUtils.equals(localMessageRecord.frienduin, AppConstants.KANDIAN_MERGE_UIN)) && ((localMessageRecord.msgtype != -2006) || ((localMessageRecord instanceof MessageForFoldMsg)))) {
          return localMessageRecord;
        }
        i -= 1;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.imcore.message.facade.add.OnMessageAddCompleteObserver
 * JD-Core Version:    0.7.0.1
 */