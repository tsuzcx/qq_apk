package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push;

import com.tencent.biz.pubaccount.readinjoy.struct.KandianRedDotInfo.RedPntInfoForReport;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;

final class RIJKanDianFolderStatus$1
  implements Runnable
{
  RIJKanDianFolderStatus$1(QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = this.a.getMessageFacade();
    if (localObject == null) {
      return;
    }
    MessageRecord localMessageRecord = ((QQMessageFacade)localObject).b(AppConstants.KANDIAN_MERGE_UIN, 7220);
    localObject = localMessageRecord;
    if (RIJKanDianFolderStatus.a.a != null) {
      if (localMessageRecord != null)
      {
        localObject = localMessageRecord;
        if (localMessageRecord.time > RIJKanDianFolderStatus.a.a.time) {}
      }
      else
      {
        localObject = RIJKanDianFolderStatus.a.a;
      }
    }
    RIJKanDianFolderStatus.a(this.a, (MessageRecord)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus.1
 * JD-Core Version:    0.7.0.1
 */