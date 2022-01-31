package com.tencent.biz.qrcode;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.utils.WupUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class QRCodeServlet
  extends MSFServlet
{
  private static String a = "QRCodeServlet";
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      QLog.d(a, 2, paramFromServiceMsg.toString());
    }
    Object localObject = null;
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool = true;
      if (!bool) {
        break label120;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      if (paramFromServiceMsg != null) {
        break label75;
      }
      bool = false;
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    for (;;)
    {
      notifyObserver(paramIntent, 0, bool, paramFromServiceMsg, BusinessObserver.class);
      return;
      bool = false;
      break;
      label75:
      localObject = WupUtil.b(paramFromServiceMsg);
      paramFromServiceMsg = new Bundle();
      localObject = new String((byte[])localObject);
      paramFromServiceMsg.putString("result", (String)localObject);
      QLog.d(a, 2, (String)localObject);
      continue;
      label120:
      QLog.e(a, 2, " MSF response is null");
      paramFromServiceMsg = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    Object localObject1 = new JSONObject();
    for (;;)
    {
      int i;
      try
      {
        paramIntent = paramIntent.getExtras();
        String[] arrayOfString = new String[5];
        arrayOfString[0] = "skey";
        arrayOfString[1] = "d";
        arrayOfString[2] = "appid";
        arrayOfString[3] = "ul";
        arrayOfString[4] = "bqq";
        int j = arrayOfString.length;
        i = 0;
        if (i < j)
        {
          String str = arrayOfString[i];
          if (!paramIntent.containsKey(str)) {
            break label183;
          }
          Object localObject2 = paramIntent.get(str);
          if ((localObject2 instanceof ArrayList)) {
            ((JSONObject)localObject1).put(str, new JSONArray((ArrayList)localObject2));
          } else {
            ((JSONObject)localObject1).put(str, localObject2);
          }
        }
      }
      catch (JSONException paramIntent)
      {
        QLog.d(a, 2, "json error");
        return;
      }
      localObject1 = ((JSONObject)localObject1).toString();
      paramPacket.setTimeout(30000L);
      paramPacket.setSSOCommand(paramIntent.getString("cmd"));
      paramPacket.putSendData(WupUtil.a(((String)localObject1).getBytes()));
      return;
      label183:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qrcode.QRCodeServlet
 * JD-Core Version:    0.7.0.1
 */