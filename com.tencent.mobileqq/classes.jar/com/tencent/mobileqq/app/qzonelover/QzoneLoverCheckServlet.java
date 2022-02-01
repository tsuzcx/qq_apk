package com.tencent.mobileqq.app.qzonelover;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneLoverCheckServlet
  extends MSFServlet
{
  private ToServiceMsg a;
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneLoverCheckServlet", 2, "onReceive, request is null");
      }
      return;
    }
    paramIntent = new Bundle();
    if (paramFromServiceMsg != null)
    {
      paramIntent.putInt("rsp_code", paramFromServiceMsg.getResultCode());
      paramIntent.putString("rsp_message", paramFromServiceMsg.getBusinessFailMsg());
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive QzoneLoverCheckRequest, code: ");
      int i;
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.getResultCode();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("QzoneLoverCheckServlet", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      localObject = QzoneLoverCheckRequest.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent.putInt("rsp_code", 0);
      paramFromServiceMsg = QzoneLoverCheckRequest.a(paramFromServiceMsg, (String)localObject);
      if (paramFromServiceMsg != null)
      {
        paramIntent.putSerializable("rsp_data", paramFromServiceMsg);
        notifyObserver(null, 1, true, paramIntent, QzoneLoverService.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneLoverCheckServlet", 2, "inform QzoneLoverCheckServlet isSuccess false");
      }
      notifyObserver(null, 1, false, paramIntent, QzoneLoverService.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverCheckServlet", 2, "inform QzoneLoverCheckServlet resultcode fail.");
    }
    notifyObserver(null, 1, false, paramIntent, QzoneLoverService.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("hostUin", 0L);
    Object localObject = new QzoneLoverCheckRequest(l).encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(QzoneLoverCheckRequest.a());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("send req QzoneLoverCheckRequest: ");
      paramIntent.append(l);
      QLog.d("QzoneLoverCheckServlet", 2, paramIntent.toString());
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverCheckServlet
 * JD-Core Version:    0.7.0.1
 */