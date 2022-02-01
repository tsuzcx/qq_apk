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
      localObject = new StringBuilder().append("receive QzoneLoverCheckRequest, code: ");
      if (paramFromServiceMsg == null) {
        break label163;
      }
    }
    label163:
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      QLog.d("QzoneLoverCheckServlet", 2, i);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
        break label193;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      localObject = QzoneLoverCheckRequest.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramIntent.putInt("rsp_code", 0);
      paramFromServiceMsg = QzoneLoverCheckRequest.a(paramFromServiceMsg, (String)localObject);
      if (paramFromServiceMsg == null) {
        break label168;
      }
      paramIntent.putSerializable("rsp_data", paramFromServiceMsg);
      notifyObserver(null, 1, true, paramIntent, QzoneLoverService.class);
      return;
    }
    label168:
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverCheckServlet", 2, "inform QzoneLoverCheckServlet isSuccess false");
    }
    notifyObserver(null, 1, false, paramIntent, QzoneLoverService.class);
    return;
    label193:
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverCheckServlet", 2, "inform QzoneLoverCheckServlet resultcode fail.");
    }
    notifyObserver(null, 1, false, paramIntent, QzoneLoverService.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      return;
      l = paramIntent.getLongExtra("hostUin", 0L);
      byte[] arrayOfByte = new QzoneLoverCheckRequest(l).encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + QzoneLoverCheckRequest.a());
      paramPacket.putSendData(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneLoverCheckServlet", 2, "send req QzoneLoverCheckRequest: " + l);
  }
  
  public void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverCheckServlet
 * JD-Core Version:    0.7.0.1
 */