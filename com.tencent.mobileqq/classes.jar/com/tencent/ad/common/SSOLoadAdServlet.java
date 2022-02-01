package com.tencent.ad.common;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.gdtad.json.GdtJsonPbUtil;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGetRsp;

public class SSOLoadAdServlet
  extends MSFServlet
{
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    PkgTools.dWord2Byte(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "QqAd.getAd" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFromServiceMsg.isSuccess());
      ((StringBuilder)localObject).append(" onReceive with code: ");
      ((StringBuilder)localObject).append(paramFromServiceMsg.getResultCode());
      QLog.d("GdtSSOLoadAD", 2, ((StringBuilder)localObject).toString());
    }
    if (paramFromServiceMsg.isSuccess())
    {
      localObject = new qq_ad_get.QQAdGetRsp();
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        ((qq_ad_get.QQAdGetRsp)localObject).mergeFrom(arrayOfByte);
        paramFromServiceMsg = GdtJsonPbUtil.a((PBField)localObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg != JSONObject.NULL))
        {
          paramFromServiceMsg = paramFromServiceMsg.toString();
          localObject = new Bundle();
          ((Bundle)localObject).putString("sso_GdtLoadAd_rsp_json", paramFromServiceMsg);
          notifyObserver(paramIntent, 1, true, (Bundle)localObject, SSOLoadBusinessObserver.class);
          return;
        }
        notifyObserver(paramIntent, 1, false, null, SSOLoadBusinessObserver.class);
        return;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.i("GdtSSOLoadAD", 2, paramFromServiceMsg.getMessage());
        }
        notifyObserver(paramIntent, 1, false, null, SSOLoadBusinessObserver.class);
        return;
      }
    }
    notifyObserver(paramIntent, 1, false, null, SSOLoadBusinessObserver.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("GdtLoadAdServletCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend with cmd: ");
      localStringBuilder.append(str);
      QLog.d("GdtSSOLoadAD", 2, localStringBuilder.toString());
    }
    paramIntent = paramIntent.getByteArrayExtra("sso_GdtLoadAd_rquest_bytes");
    if (paramIntent != null)
    {
      paramPacket.putSendData(a(paramIntent));
      return;
    }
    paramIntent = new StringBuilder();
    paramIntent.append("no bytes to send");
    paramIntent.append(str);
    QLog.e("GdtSSOLoadAD", 1, paramIntent.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.common.SSOLoadAdServlet
 * JD-Core Version:    0.7.0.1
 */