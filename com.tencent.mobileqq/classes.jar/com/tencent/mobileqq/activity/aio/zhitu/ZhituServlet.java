package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;

public class ZhituServlet
  extends MSFServlet
{
  private void a(Intent paramIntent, int paramInt, FromServiceMsg paramFromServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("ErrorCode", paramInt);
    localBundle.putParcelable("FromServerMsg", paramFromServiceMsg);
    localBundle.putString("UniqueKey", paramIntent.getStringExtra("ZhituReqKey"));
    notifyObserver(paramIntent, 0, false, localBundle, ZhituObserver.class);
  }
  
  private byte[] a(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte.length + 4];
    PkgTools.a(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "AIMessage.Text2Image", "MQInference.ZhituReport" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ZhituServlet", 2, "onReceive with code: " + paramFromServiceMsg.getResultCode());
    }
    if (paramIntent.getStringExtra("ZhituCMD").equals("MQInference.ZhituReport")) {
      return;
    }
    if (!paramFromServiceMsg.isSuccess())
    {
      a(paramIntent, 1, paramFromServiceMsg);
      return;
    }
    Object localObject = paramFromServiceMsg.getWupBuffer();
    if (localObject != null)
    {
      localObject = new String(Arrays.copyOfRange((byte[])localObject, 4, localObject.length));
      try
      {
        ZhituResponse localZhituResponse = (ZhituResponse)JSONUtils.b(new JSONObject((String)localObject), ZhituResponse.class);
        Bundle localBundle = new Bundle();
        localBundle.putInt("ErrorCode", 0);
        localBundle.putParcelable("Response", localZhituResponse);
        localBundle.putString("UniqueKey", paramIntent.getStringExtra("ZhituReqKey"));
        localBundle.putInt("StartIdx", paramIntent.getIntExtra("StartIdx", 0));
        localBundle.putString("QueryText", paramIntent.getStringExtra("QueryText"));
        notifyObserver(paramIntent, 0, true, localBundle, ZhituObserver.class);
        return;
      }
      catch (JSONException localJSONException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ZhituServlet", 2, "parse json error with str:\n" + (String)localObject + "\n" + localJSONException);
        }
        a(paramIntent, 3, paramFromServiceMsg);
        return;
      }
    }
    a(paramIntent, 2, paramFromServiceMsg);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("ZhituCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel()) {
      QLog.d("ZhituServlet", 2, "onSend with cmd: " + str);
    }
    paramIntent = paramIntent.getByteArrayExtra("ZhituRequestBytes");
    if (paramIntent != null)
    {
      paramPacket.putSendData(a(paramIntent));
      return;
    }
    throw new IllegalArgumentException("no bytes to send");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituServlet
 * JD-Core Version:    0.7.0.1
 */