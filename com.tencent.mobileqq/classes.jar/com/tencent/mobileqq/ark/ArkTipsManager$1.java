package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.data.MessageRecord;
import java.util.Iterator;
import java.util.List;

class ArkTipsManager$1
  extends MessageObserver
{
  ArkTipsManager$1(ArkTipsManager paramArkTipsManager) {}
  
  public void onMsgRevokeNotice(boolean paramBoolean1, List<MessageRecord> paramList, boolean paramBoolean2)
  {
    if ((ArkTipsManager.a(this.a) != null) && (paramList != null))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        if ((localMessageRecord != null) && (localMessageRecord.uniseq == ArkTipsManager.a(this.a).b)) {
          this.a.a(localMessageRecord.uniseq);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkTipsManager.1
 * JD-Core Version:    0.7.0.1
 */