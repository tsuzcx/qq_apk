package com.tencent.biz.qqcircle.list.bizblocks;

import anii;
import anil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;

public class QCircleHandler
  extends anii
{
  private static final String TAG = "QCircleHandler";
  public static final int TYPE_UPDATE_RED_POINT_DISPLAY = 1;
  
  public QCircleHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void clearPedPoint()
  {
    QLog.d("QCircleHandler", 1, "clearRedPoint");
    QCircleChatBoxHelper.getInstance().clearUnReadInfo();
    notifyUI(1, true, Integer.valueOf(0));
  }
  
  public Class<? extends anil> observerClass()
  {
    return QCircleObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
  
  public void updateRedPoint()
  {
    Pair localPair = QCircleChatBoxHelper.getInstance().getUnReadInfo();
    if (localPair != null)
    {
      QLog.d("QCircleHandler", 1, "updateRedPoint:" + localPair.first);
      notifyUI(1, true, localPair.first);
      return;
    }
    QLog.e("QCircleHandler", 1, "updateRedPoint null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqcircle.list.bizblocks.QCircleHandler
 * JD-Core Version:    0.7.0.1
 */