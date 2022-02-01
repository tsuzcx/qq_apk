package com.tencent.mobileqq.activity.aio.zhitu;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.JSONUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.zhitu.gate.ZhituSafeGate.GateInfo;
import tencent.im.zhitu.gate.ZhituSafeGate.RspBody;

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
    PkgTools.dWord2Byte(arrayOfByte, 0, paramArrayOfByte.length + 4);
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 4, paramArrayOfByte.length);
    return arrayOfByte;
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "AIMessage.Text2Image", "MQInference.ZhituReport" };
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onReceive with code: ");
      ((StringBuilder)localObject1).append(paramFromServiceMsg.getResultCode());
      QLog.d("ZhituServlet", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = paramIntent.getStringExtra("ZhituCMD");
    if (((String)localObject1).equals("MQInference.ZhituReport")) {
      return;
    }
    boolean bool2 = ((String)localObject1).equals("ZhituGate.Check");
    boolean bool1 = true;
    int i;
    if (bool2) {
      if (paramFromServiceMsg.isSuccess())
      {
        paramIntent = getAppRuntime();
        if ((paramIntent == null) || (!(paramIntent instanceof AppInterface))) {
          break label554;
        }
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject1 = new byte[i];
        PkgTools.copyData((byte[])localObject1, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
        paramFromServiceMsg.putWupBuffer((byte[])localObject1);
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
        localObject1 = new ZhituSafeGate.RspBody();
        ((ZhituSafeGate.RspBody)localObject1).mergeFrom(paramFromServiceMsg);
        i = ((ZhituSafeGate.RspBody)localObject1).int32_result.get();
        if (i == 0)
        {
          i = ((ZhituSafeGate.GateInfo)((ZhituSafeGate.RspBody)localObject1).gate_info.get()).uint32_state.get();
          paramFromServiceMsg = ZhituManager.a((QQAppInterface)paramIntent);
          if (i != 1) {
            break label555;
          }
          paramFromServiceMsg.c(bool1);
          long l = System.currentTimeMillis();
          ZhituManager.a((QQAppInterface)paramIntent).a(l);
          return;
        }
        if (!QLog.isColorLevel()) {
          break label554;
        }
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive CMD_SAFE_GATE failed result: ");
        paramIntent.append(i);
        QLog.d("ZhituServlet", 2, paramIntent.toString());
        return;
      }
      catch (Exception paramIntent)
      {
        QLog.e("ZhituServlet", 2, "onReceive CMD_SAFE_GATE has exception: ", paramIntent);
        return;
      }
      i = paramFromServiceMsg.getResultCode();
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("onReceive CMD_SAFE_GATE not Success code is : ");
        paramIntent.append(i);
        QLog.d("ZhituServlet", 2, paramIntent.toString());
        return;
        if (!paramFromServiceMsg.isSuccess())
        {
          a(paramIntent, 1, paramFromServiceMsg);
          return;
        }
        localObject1 = paramFromServiceMsg.getWupBuffer();
        if (localObject1 != null)
        {
          String str = new String(Arrays.copyOfRange((byte[])localObject1, 4, localObject1.length));
          try
          {
            if (!TextUtils.isEmpty(str)) {
              localObject1 = (ZhituResponse)JSONUtils.b(new JSONObject(str), ZhituResponse.class);
            } else {
              localObject1 = new ZhituResponse();
            }
            localObject2 = new Bundle();
            ((Bundle)localObject2).putInt("ErrorCode", 0);
            ((Bundle)localObject2).putParcelable("Response", (Parcelable)localObject1);
            ((Bundle)localObject2).putString("UniqueKey", paramIntent.getStringExtra("ZhituReqKey"));
            ((Bundle)localObject2).putInt("StartIdx", paramIntent.getIntExtra("StartIdx", 0));
            ((Bundle)localObject2).putString("QueryText", paramIntent.getStringExtra("QueryText"));
            notifyObserver(paramIntent, 0, true, (Bundle)localObject2, ZhituObserver.class);
            return;
          }
          catch (JSONException localJSONException)
          {
            Object localObject2;
            if (QLog.isColorLevel())
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("parse json error with str:\n");
              ((StringBuilder)localObject2).append(str);
              ((StringBuilder)localObject2).append("\n");
              ((StringBuilder)localObject2).append(localJSONException);
              QLog.d("ZhituServlet", 2, ((StringBuilder)localObject2).toString());
            }
            a(paramIntent, 3, paramFromServiceMsg);
            return;
          }
        }
        a(paramIntent, 2, paramFromServiceMsg);
      }
      label554:
      return;
      label555:
      bool1 = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    String str = paramIntent.getStringExtra("ZhituCMD");
    paramPacket.setSSOCommand(str);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSend with cmd: ");
      localStringBuilder.append(str);
      QLog.d("ZhituServlet", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.zhitu.ZhituServlet
 * JD-Core Version:    0.7.0.1
 */