package com.tencent.mobileqq.app.qzonelover;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class QzoneLoverLightingServlet
  extends MSFServlet
{
  private ToServiceMsg a;
  
  public static Intent a(Intent paramIntent, long paramLong)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("hostUin", paramLong);
    return localIntent;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneLoverLightingServlet", 2, "onReceive, request is null");
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
      ((StringBuilder)localObject).append("receive QzoneLoverLightingServlet, code: ");
      int i;
      if (paramFromServiceMsg != null) {
        i = paramFromServiceMsg.getResultCode();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject).append(i);
      QLog.d("QzoneLoverLightingServlet", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      localObject = QzoneLoverLightingRequest.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        return;
      }
      paramIntent.putInt("rsp_code", 0);
      paramFromServiceMsg = QzoneLoverLightingRequest.a(paramFromServiceMsg, (String)localObject);
      if (paramFromServiceMsg != null)
      {
        paramIntent.putSerializable("rsp_data", paramFromServiceMsg);
        notifyObserver(null, 291, true, paramIntent, QzoneLoverService.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QzoneLoverLightingServlet", 2, "inform QzoneLoverLightingServlet isSuccess false");
      }
      notifyObserver(null, 291, false, paramIntent, QzoneLoverService.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverLightingServlet", 2, "inform QzoneLoverLightingServlet resultcode fail.");
    }
    notifyObserver(null, 291, false, paramIntent, QzoneLoverService.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("hostUin", 0L);
    Object localObject = new QzoneLoverLightingRequest(l).encode();
    paramIntent = (Intent)localObject;
    if (localObject == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("SQQzoneSvc.");
    ((StringBuilder)localObject).append(QzoneLoverLightingRequest.a());
    paramPacket.setSSOCommand(((StringBuilder)localObject).toString());
    paramPacket.putSendData(paramIntent);
    if (QLog.isColorLevel())
    {
      paramIntent = new StringBuilder();
      paramIntent.append("send req QzoneLoverLightingRequest: ");
      paramIntent.append(l);
      QLog.d("QzoneLoverLightingServlet", 2, paramIntent.toString());
    }
  }
  
  protected void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.qzonelover.QzoneLoverLightingServlet
 * JD-Core Version:    0.7.0.1
 */