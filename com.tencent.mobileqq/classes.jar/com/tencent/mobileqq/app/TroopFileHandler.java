package com.tencent.mobileqq.app;

import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;

public class TroopFileHandler
  extends BusinessHandler
{
  private QQAppInterface a;
  
  TroopFileHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.a = paramQQAppInterface;
  }
  
  public static long a(String paramString)
  {
    try
    {
      long l = Long.valueOf(paramString).longValue();
      return l;
    }
    catch (Exception paramString)
    {
      label10:
      break label10;
    }
    return 0L;
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"GroupFileAppSvr.GetFileInfo".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    notifyUI(39, true, paramObject);
  }
  
  public void a(Object paramObject)
  {
    notifyUI(9, true, paramObject);
  }
  
  public void a(String paramString, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    paramString = new ToServiceMsg("mobileqq.service", this.a.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(paramArrayOfByte);
    if (paramBundle != null) {
      paramString.extraData = paramBundle;
    }
    sendPbReq(paramString);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (!"GroupFileAppSvr.GetFileSearch".equals(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    notifyUI(40, true, paramObject);
  }
  
  public void b(Object paramObject)
  {
    notifyUI(13, true, paramObject);
  }
  
  public void c(Object paramObject)
  {
    notifyUI(20, true, paramObject);
  }
  
  public void d(Object paramObject)
  {
    notifyUI(41, true, paramObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("GroupFileAppSvr.DelFile");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileList");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileListV2");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileInfo");
      this.allowCmdSet.add("GroupFileAppSvr.GetFileSearch");
    }
    return this.allowCmdSet;
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return BizTroopObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TroopFileHandler", 4, "onReceive");
    }
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("res.getServiceCmd():");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getServiceCmd());
      QLog.d("TroopFileHandler", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter((String)localObject))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append((String)localObject);
        QLog.d("TroopFileHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopFileHandler
 * JD-Core Version:    0.7.0.1
 */