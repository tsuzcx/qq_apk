package com.tencent.biz.qqcircle.list.bizblocks;

import com.tencent.biz.qqcircle.fragments.chat.QCircleChatGiftManager;
import com.tencent.mobileqq.qcircle.api.data.QCircleRecentDataInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class QCircleChatListBlock$1
  implements Runnable
{
  QCircleChatListBlock$1(QCircleChatListBlock paramQCircleChatListBlock) {}
  
  public void run()
  {
    QLog.d("QCircleChatListBlock", 1, "updateGiftInfo");
    Iterator localIterator = this.this$0.getDataList().iterator();
    while (localIterator.hasNext())
    {
      QCircleRecentDataInterface localQCircleRecentDataInterface = (QCircleRecentDataInterface)localIterator.next();
      if (localQCircleRecentDataInterface != null) {
        localQCircleRecentDataInterface.setGiftInfo(QCircleChatGiftManager.getInstance().getUserGiftInfo(localQCircleRecentDataInterface.getRecentUserUin()));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleChatListBlock.1
 * JD-Core Version:    0.7.0.1
 */