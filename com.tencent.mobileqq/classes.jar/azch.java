import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class azch
  extends MSFServlet
{
  private byte[] a()
  {
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1231);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(1);
    localObject = ((oidb_sso.OIDBSSOPkg)localObject).toByteArray();
    ByteBuffer localByteBuffer = ByteBuffer.allocate(localObject.length + 4);
    localByteBuffer.putInt(localObject.length + 4);
    localByteBuffer.put((byte[])localObject);
    return localByteBuffer.array();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive() is called, isSuccess is:" + bool1);
    }
    Bundle localBundle = new Bundle();
    Object localObject1;
    if (bool1) {
      localObject1 = new ArrayList();
    }
    label539:
    label689:
    label694:
    for (;;)
    {
      int j;
      Object localObject2;
      int k;
      try
      {
        i = paramFromServiceMsg.getResultCode();
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.getWupBuffer());
        j = paramFromServiceMsg.getInt();
        localObject2 = new byte[j - 4];
        paramFromServiceMsg.get((byte[])localObject2);
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])localObject2);
        k = paramFromServiceMsg.uint32_result.get();
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        int m = paramFromServiceMsg.get();
        if (QLog.isColorLevel()) {
          QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,result is:" + k + ",response.lenth is:" + j + ",sso.RespResult is:" + i + ",cCount is:" + m);
        }
        if (k == 0) {
          continue;
        }
        bool1 = false;
      }
      catch (Exception paramFromServiceMsg)
      {
        boolean bool2 = false;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive occurs exception,error msg is:" + paramFromServiceMsg.getMessage(), paramFromServiceMsg);
        bool1 = bool2;
        continue;
        localBundle.putStringArrayList("redu_list", (ArrayList)localObject1);
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,reduList is:" + localObject1);
        if (paramIntent == null) {
          break label539;
        }
      }
      int i = 0;
      if (paramIntent != null) {
        i = paramIntent.getIntExtra("action", 0);
      }
      notifyObserver(paramIntent, i, bool1, localBundle, azcg.class);
      return;
      long l;
      if (paramFromServiceMsg.position() < paramFromServiceMsg.capacity())
      {
        localObject2 = new byte[4];
        paramFromServiceMsg.get((byte[])localObject2, 0, localObject2.length);
        l = bdqa.a((byte[])localObject2, 0);
        i = paramFromServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,uin is:" + l + ",redu is:" + i);
        }
        ((ArrayList)localObject1).add(String.valueOf(l));
      }
      else
      {
        for (paramFromServiceMsg = paramIntent.getStringExtra("k_uin");; paramFromServiceMsg = null)
        {
          if (paramFromServiceMsg != null)
          {
            l = ayzl.a();
            SharedPreferences.Editor localEditor = BaseApplication.getContext().getSharedPreferences("free_call", 0).edit();
            localEditor.putString(agzo.b(paramFromServiceMsg), String.valueOf(l));
            j = ((ArrayList)localObject1).size();
            localObject2 = new StringBuilder();
            k = Math.min(j, 100);
            i = 0;
            while (i < k)
            {
              ((StringBuilder)localObject2).append((String)((ArrayList)localObject1).get(i));
              ((StringBuilder)localObject2).append("|");
              i += 1;
              continue;
              if (!QLog.isColorLevel()) {
                break label689;
              }
              QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,qq has exception,request is null");
              break label689;
            }
            localObject2 = ((StringBuilder)localObject2).toString();
            localObject1 = localObject2;
            if (j > 0) {
              localObject1 = ((String)localObject2).substring(0, ((String)localObject2).length() - 1);
            }
            localEditor.putString(agzo.c(paramFromServiceMsg), (String)localObject1);
            localEditor.commit();
            if (!QLog.isColorLevel()) {
              break label694;
            }
            QLog.d("ReduFriendServlet", 2, "reduSize is:" + j + ",curTime is:" + l + ",allReduFriend is:" + (String)localObject1);
            break label694;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onReceive,please pass uin,uin is empty");
          }
          break;
          break;
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReduFriendServlet", 2, "ReduFriendServlet onSend() is called");
    }
    paramPacket.putSendData(a());
    paramPacket.setSSOCommand("OidbSvc.0x4cf_1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azch
 * JD-Core Version:    0.7.0.1
 */