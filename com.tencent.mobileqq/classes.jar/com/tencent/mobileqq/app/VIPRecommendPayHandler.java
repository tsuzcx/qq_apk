package com.tencent.mobileqq.app;

import android.text.TextUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class VIPRecommendPayHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  protected VIPRecommendPayHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return VIPRecommendPayObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null) && (paramObject != null))
    {
      String str = paramToServiceMsg.getServiceCmd();
      if (TextUtils.isEmpty(str))
      {
        notifyUI(1, false, null);
        return;
      }
      if ((str.compareTo("VipPayLogicServer.getCommPayInfo ") == 0) && (QLog.isColorLevel()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("req---");
        localStringBuilder.append(paramToServiceMsg);
        localStringBuilder.append(",res----");
        localStringBuilder.append(paramFromServiceMsg);
        localStringBuilder.append(",data-----");
        localStringBuilder.append(paramObject);
        QLog.i("VIPRecommendPayHandler", 2, localStringBuilder.toString());
      }
      if (str.compareTo("VipPayLogicServer.getCommPayInfo ") == 0)
      {
        notifyUI(1, true, paramObject);
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append(this.a.getCurrentAccountUin());
        paramToServiceMsg.append("_");
        paramToServiceMsg.append("VIPRecommendPayFile.txt");
        FileUtils.writeObject(paramToServiceMsg.toString(), paramObject);
      }
      return;
    }
    notifyUI(1, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.VIPRecommendPayHandler
 * JD-Core Version:    0.7.0.1
 */