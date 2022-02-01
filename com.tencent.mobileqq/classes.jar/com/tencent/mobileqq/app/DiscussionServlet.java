package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.biz.qrcode.activity.QRDisplayActivity.GetNicknameObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DiscussionServlet
  extends MSFServlet
{
  private byte[] a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    String[] arrayOfString = paramArrayOfString2;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1274);
    localOIDBSSOPkg.uint32_service_type.set(7);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfString1.length * 2 + 4 + arrayOfString.length * 4);
    int m = paramArrayOfString1.length;
    int i = (byte)(m >> 8 & 0xFF);
    int j = (byte)(m & 0xFF);
    byte[] arrayOfByte1 = new byte[paramArrayOfString1.length * 2];
    int i1 = paramArrayOfString1.length;
    m = 0;
    int n = 0;
    long l;
    while (m < i1)
    {
      l = Long.parseLong(paramArrayOfString1[m]);
      arrayOfByte1[n] = ((byte)(int)(l >> 8 & 0xFF));
      arrayOfByte1[(n + 1)] = ((byte)(int)(0xFF & l));
      n += 2;
      m += 1;
    }
    n = arrayOfString.length;
    paramArrayOfString1 = new byte[2];
    int k = (byte)(n >> 8 & 0xFF);
    m = 0;
    paramArrayOfString1[0] = k;
    paramArrayOfString1[1] = ((byte)(n & 0xFF));
    byte[] arrayOfByte2 = new byte[n * 4];
    i1 = arrayOfString.length;
    n = 0;
    arrayOfString = paramArrayOfString1;
    paramArrayOfString1 = localOIDBSSOPkg;
    while (m < i1)
    {
      l = Long.parseLong(paramArrayOfString2[m]);
      arrayOfByte2[(n + 3)] = ((byte)(int)(l & 0xFF));
      arrayOfByte2[(n + 2)] = ((byte)(int)(l >> 8 & 0xFF));
      arrayOfByte2[(n + 1)] = ((byte)(int)(l >> 16 & 0xFF));
      arrayOfByte2[n] = ((byte)(int)(l >> 24 & 0xFF));
      n += 4;
      m += 1;
    }
    localByteBuffer.put(new byte[] { i, j }).put(arrayOfByte1).put(arrayOfString).put(arrayOfByte2);
    paramArrayOfString1.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramArrayOfString1 = paramArrayOfString1.toByteArray();
    paramArrayOfString2 = ByteBuffer.allocate(paramArrayOfString1.length + 4);
    paramArrayOfString2.putInt(paramArrayOfString1.length + 4);
    paramArrayOfString2.put(paramArrayOfString1);
    return paramArrayOfString2.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int j = paramIntent.getIntExtra("key_cmd", -1);
    paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if (j != 0) {
      return;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        byte[] arrayOfByte = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get(arrayOfByte);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom(arrayOfByte);
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool = true;
          paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (bool)
          {
            arrayOfByte = new byte[2];
            paramFromServiceMsg.get(arrayOfByte);
            int k = Utils.b(arrayOfByte, 0);
            int i = 0;
            if (i < k)
            {
              arrayOfByte = new byte[4];
              paramFromServiceMsg.get(arrayOfByte);
              localArrayList2.add(String.valueOf(Utils.a(arrayOfByte, 0)));
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              Utils.b(arrayOfByte, 0);
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              Utils.b(arrayOfByte, 0);
              arrayOfByte = new byte[2];
              paramFromServiceMsg.get(arrayOfByte);
              arrayOfByte = new byte[Utils.b(arrayOfByte, 0)];
              paramFromServiceMsg.get(arrayOfByte);
              localArrayList1.add(new String(arrayOfByte, "utf-8"));
              i += 1;
              continue;
            }
          }
          localBundle.putStringArrayList("nickname_list", (ArrayList)localArrayList1);
          localBundle.putStringArrayList("uin_list", (ArrayList)localArrayList2);
          notifyObserver(paramIntent, j, bool, localBundle, QRDisplayActivity.GetNicknameObserver.class);
          return;
        }
      }
      catch (Exception paramIntent)
      {
        paramIntent.printStackTrace();
        return;
      }
      boolean bool = false;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent.getIntExtra("key_cmd", -1) != 0)
    {
      paramIntent = null;
    }
    else
    {
      paramPacket.putSendData(a(paramIntent.getStringArrayExtra("field_id"), paramIntent.getStringArrayExtra("uin_list")));
      paramIntent = "OidbSvc.0x4fa_7";
    }
    if (paramIntent != null) {
      paramPacket.setSSOCommand(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionServlet
 * JD-Core Version:    0.7.0.1
 */