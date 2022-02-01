package com.tencent.mobileqq.app.qqdaily;

import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.InOutQQ;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.ReqBody;
import tencent.im.oidb.cmd0xe27.oidb_cmd0xe27.RspBody;

public class QQDailyHandler
  extends BusinessHandler
{
  private List<QQDailyHandler.OnReceiveListener> a = new ArrayList();
  
  public QQDailyHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public void a(QQDailyHandler.OnReceiveListener paramOnReceiveListener)
  {
    if (paramOnReceiveListener != null) {
      try
      {
        if (!this.a.contains(paramOnReceiveListener))
        {
          this.a.add(paramOnReceiveListener);
          return;
        }
      }
      finally {}
    }
  }
  
  public void a(List<oidb_cmd0xe27.InOutQQ> paramList)
  {
    if (paramList != null)
    {
      if (paramList.size() == 0) {
        return;
      }
      int i = paramList.size();
      if (i > 20) {
        paramList.subList(i - 20, i);
      }
      oidb_cmd0xe27.ReqBody localReqBody = new oidb_cmd0xe27.ReqBody();
      localReqBody.rpt_msg_in_out_qq.set(paramList);
      sendPbReq(makeOIDBPkg("OidbSvc.0xe27", 3623, 1, localReqBody.toByteArray()));
    }
  }
  
  public void b(QQDailyHandler.OnReceiveListener paramOnReceiveListener)
  {
    if (paramOnReceiveListener != null)
    {
      if (!this.a.contains(paramOnReceiveListener)) {
        return;
      }
      this.a.remove(paramOnReceiveListener);
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive from front back report: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      QLog.d("QQDailyHandler", 0, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xe27.RspBody();
    if (parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject) == 0)
    {
      paramObject = this.a.iterator();
      while (paramObject.hasNext())
      {
        QQDailyHandler.OnReceiveListener localOnReceiveListener = (QQDailyHandler.OnReceiveListener)paramObject.next();
        if (localOnReceiveListener != null) {
          localOnReceiveListener.a(paramToServiceMsg, paramFromServiceMsg, (oidb_cmd0xe27.RspBody)localObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qqdaily.QQDailyHandler
 * JD-Core Version:    0.7.0.1
 */