package com.tencent.mobileqq.activity.bless;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import msg.uin_list.UinList.C2C;
import msg.uin_list.UinList.UinListUploadReq;
import msg.uin_list.UinList.UinListUploadRsp;

public class BlessUploadUinListServlet
  extends MSFServlet
{
  public static String a(byte[] paramArrayOfByte)
  {
    String str1 = "";
    int i = 0;
    if (i < paramArrayOfByte.length)
    {
      String str2 = Integer.toHexString(paramArrayOfByte[i] & 0xFF);
      if (str2.length() == 1) {}
      for (str1 = str1 + "0" + str2;; str1 = str1 + str2)
      {
        i += 1;
        break;
      }
    }
    return str1.toUpperCase();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int k = 0;
    int j = 0;
    boolean bool = paramFromServiceMsg.isSuccess();
    Object localObject = "";
    if (bool) {}
    for (;;)
    {
      try
      {
        localObject = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        paramFromServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
        ((ByteBuffer)localObject).get(paramFromServiceMsg);
        localObject = new UinList.UinListUploadRsp();
        ((UinList.UinListUploadRsp)localObject).mergeFrom(paramFromServiceMsg);
        i = ((UinList.UinListUploadRsp)localObject).int32_result.get();
      }
      catch (Exception localException1)
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("BlessManager", 2, "onReceive result=" + false + " waitTime=" + j);
          }
          paramFromServiceMsg = "";
          bool = false;
        }
        catch (Exception localException4)
        {
          paramFromServiceMsg = "";
          k = i;
          i = j;
          j = k;
          continue;
        }
        localException1 = localException1;
        paramFromServiceMsg = "";
        j = 0;
        i = 0;
        localException1.printStackTrace();
        k = j;
        bool = false;
        j = i;
        i = k;
        continue;
      }
      try
      {
        paramFromServiceMsg = ((UinList.UinListUploadRsp)localObject).bytes_store_key.get().toByteArray();
        if (i < 0) {
          continue;
        }
        if (paramFromServiceMsg != null)
        {
          k = paramFromServiceMsg.length;
          if (k != 0) {
            continue;
          }
        }
        paramFromServiceMsg = "";
        bool = false;
      }
      catch (Exception localException2)
      {
        paramFromServiceMsg = "";
        j = i;
        i = 0;
        continue;
        continue;
      }
      localObject = new Bundle();
      ((Bundle)localObject).putString("store.key", paramFromServiceMsg);
      ((Bundle)localObject).putInt("k_result_code", i);
      ((Bundle)localObject).putInt("k_wait_time", j);
      notifyObserver(paramIntent, 1, bool, (Bundle)localObject, BlessBaseActivity.class);
      return;
      paramFromServiceMsg = a(paramFromServiceMsg);
      try
      {
        if (!QLog.isColorLevel()) {
          break label351;
        }
        QLog.d("BlessManager", 2, "onReceive result=" + bool + " key=" + paramFromServiceMsg);
      }
      catch (Exception localException3)
      {
        k = 0;
        j = i;
        i = k;
        continue;
        j = 0;
        continue;
      }
      if (i == -8) {
        j = ((UinList.UinListUploadRsp)localObject).silence_period.get();
      }
      label351:
      int i = 0;
      j = k;
      paramFromServiceMsg = localException4;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    Object localObject1 = (ArrayList)paramIntent.getSerializableExtra("k_uin_list");
    paramIntent = new UinList.UinListUploadReq();
    paramIntent.uint32_cmd.set(1);
    localObject1 = ((ArrayList)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (String)((Iterator)localObject1).next();
      UinList.C2C localC2C = new UinList.C2C();
      long l = Long.parseLong((String)localObject2);
      localC2C.to_uin.set(l);
      paramIntent.friend_list.add(localC2C);
    }
    localObject1 = paramIntent.toByteArray();
    Object localObject2 = ByteBuffer.allocate(localObject1.length + 4);
    ((ByteBuffer)localObject2).putInt(localObject1.length + 4).put((byte[])localObject1);
    localObject1 = ((ByteBuffer)localObject2).array();
    paramPacket.setSSOCommand("redbag_assistant.client_request");
    paramPacket.putSendData((byte[])localObject1);
    if (QLog.isColorLevel()) {
      QLog.d("BlessManager", 2, "onSend req=" + paramIntent.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessUploadUinListServlet
 * JD-Core Version:    0.7.0.1
 */