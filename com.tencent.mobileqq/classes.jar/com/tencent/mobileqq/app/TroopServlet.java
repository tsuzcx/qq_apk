package com.tencent.mobileqq.app;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class TroopServlet
  extends MSFServlet
{
  private byte[] a(byte paramByte, String paramString1, String paramString2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1372);
    localOIDBSSOPkg.uint32_service_type.set(1);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(9);
    paramString1 = Long.valueOf(Long.parseLong(paramString1));
    int i = (byte)(int)(paramString1.longValue() & 0xFF);
    int j = (byte)(int)(paramString1.longValue() >> 8 & 0xFF);
    int k = (byte)(int)(paramString1.longValue() >> 16 & 0xFF);
    int m = (byte)(int)(paramString1.longValue() >> 24 & 0xFF);
    paramString1 = Long.valueOf(Long.parseLong(paramString2));
    int n = (byte)(int)(paramString1.longValue() & 0xFF);
    int i1 = (byte)(int)(paramString1.longValue() >> 8 & 0xFF);
    int i2 = (byte)(int)(paramString1.longValue() >> 16 & 0xFF);
    int i3 = (byte)(int)(paramString1.longValue() >> 24 & 0xFF);
    localByteBuffer.put(new byte[] { m, k, j, i }).put(new byte[] { i3, i2, i1, n }).put(paramByte);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString1 = localOIDBSSOPkg.toByteArray();
    paramString2 = ByteBuffer.allocate(paramString1.length + 4);
    paramString2.putInt(paramString1.length + 4);
    paramString2.put(paramString1);
    return paramString2.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramIntent.getIntExtra("command", -1);
    boolean bool1 = paramFromServiceMsg.isSuccess();
    Bundle localBundle = new Bundle();
    if (i == 0) {}
    for (;;)
    {
      byte b;
      try
      {
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        Object localObject1 = new byte[paramFromServiceMsg.getInt() - 4];
        paramFromServiceMsg.get((byte[])localObject1);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject1);
        int j = paramFromServiceMsg.uint32_result.get();
        if (j != 0) {
          break label381;
        }
        bool1 = true;
        boolean bool2 = QLog.isColorLevel();
        if (bool2)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("resultCode: ");
          ((StringBuilder)localObject1).append(j);
          QLog.d("set_troop_admin", 2, ((StringBuilder)localObject1).toString());
        }
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (bool1)
        {
          localObject1 = new byte[4];
          paramFromServiceMsg.get((byte[])localObject1);
          localObject1 = String.valueOf(Utils.a((byte[])localObject1, 0));
          Object localObject2 = new byte[4];
          paramFromServiceMsg.get((byte[])localObject2);
          localObject2 = String.valueOf(Utils.a((byte[])localObject2, 0));
          b = paramFromServiceMsg.get();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("set troop admin response. troopCode: ");
            localStringBuilder.append((String)localObject1);
            localStringBuilder.append(" memberUin: ");
            localStringBuilder.append((String)localObject2);
            localStringBuilder.append(" operation: ");
            if (b != 0) {
              break label387;
            }
            paramFromServiceMsg = "delete";
            localStringBuilder.append(paramFromServiceMsg);
            QLog.d("set_troop_admin", 2, localStringBuilder.toString());
          }
          if ((localObject1 != null) && (((String)localObject1).length() > 0) && (localObject2 != null) && (((String)localObject2).length() > 0))
          {
            localBundle.putString("troop_code", (String)localObject1);
            localBundle.putString("troop_member_uin", (String)localObject2);
            localBundle.putByte("operation", b);
            break label367;
          }
        }
        else
        {
          localBundle.putInt("error_code", j);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        bool1 = false;
      }
      label367:
      notifyObserver(paramIntent, i, bool1, localBundle, TroopObserver.class);
      return;
      label381:
      bool1 = false;
      continue;
      label387:
      if (b == 1) {
        paramFromServiceMsg = "add";
      } else {
        paramFromServiceMsg = "unkonwn";
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent.getIntExtra("command", -1) != 0)
    {
      paramIntent = null;
    }
    else
    {
      byte b = paramIntent.getByteExtra("operation", (byte)0);
      String str1 = paramIntent.getStringExtra("troop_code");
      String str2 = paramIntent.getStringExtra("troop_member_uin");
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("request set troop admin. troopCode: ");
        localStringBuilder.append(str1);
        localStringBuilder.append(" memberUin: ");
        localStringBuilder.append(str2);
        localStringBuilder.append(" operation: ");
        if (b == 0) {
          paramIntent = "delete";
        } else if (b == 1) {
          paramIntent = "add";
        } else {
          paramIntent = "unkonwn";
        }
        localStringBuilder.append(paramIntent);
        QLog.d("set_troop_admin", 2, localStringBuilder.toString());
      }
      paramPacket.putSendData(a(b, str1, str2));
      paramIntent = "OidbSvc.0x55c_1";
    }
    if (paramIntent != null) {
      paramPacket.setSSOCommand(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.TroopServlet
 * JD-Core Version:    0.7.0.1
 */