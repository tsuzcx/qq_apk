import QMF_PROTOCAL.QmfDownstream;
import QzoneCombine.ClientOnlineNotfiyRsp;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.WNSStream;
import java.io.IOException;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class azca
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      QLog.e("NotifyQZoneServer", 1, "fromServiceMsg==null");
    }
    for (;;)
    {
      return;
      if (paramFromServiceMsg.getResultCode() != 1000) {
        break label192;
      }
      Object localObject = new WNSStream();
      paramFromServiceMsg = bdpd.b(paramFromServiceMsg.getWupBuffer());
      try
      {
        paramFromServiceMsg = ((WNSStream)localObject).unpack(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = (ClientOnlineNotfiyRsp)bilr.a(ClientOnlineNotfiyRsp.class, paramFromServiceMsg.BusiBuff);
          if (paramFromServiceMsg != null)
          {
            localObject = paramFromServiceMsg.AttachInfo;
            paramFromServiceMsg = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0).edit();
            localObject = bdhe.a((byte[])localObject);
            paramIntent = paramIntent.getStringExtra("key_uin");
            paramFromServiceMsg.putString("key_attach_info" + paramIntent, (String)localObject);
            if (QLog.isDevelopLevel()) {
              QLog.d("NotifyQZoneServer", 4, "onReceive attachinfo:" + (String)localObject);
            }
            if (Build.VERSION.SDK_INT >= 9)
            {
              paramFromServiceMsg.apply();
              return;
            }
          }
        }
      }
      catch (IOException paramIntent)
      {
        QLog.e("NotifyQZoneServer", 1, paramIntent, new Object[0]);
        return;
      }
    }
    paramFromServiceMsg.commit();
    return;
    label192:
    QLog.e("NotifyQZoneServer", 1, "onReceive fromServiceMsg.getResultCode():" + paramFromServiceMsg.getResultCode());
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("lastPushMsgTime", 0L);
    paramIntent = paramIntent.getStringExtra("key_uin");
    paramIntent = BaseApplication.getContext().getSharedPreferences("QZoneOnLineServlet", 0).getString("key_attach_info" + paramIntent, "");
    byte[] arrayOfByte = bdhe.a(paramIntent);
    if (QLog.isDevelopLevel()) {
      QLog.d("NotifyQZoneServer", 4, "onSend lastPushMsgTime:" + l + ",attachinfo:" + paramIntent);
    }
    bjcq localbjcq = new bjcq(l, arrayOfByte);
    arrayOfByte = localbjcq.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + localbjcq.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localbjcq.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azca
 * JD-Core Version:    0.7.0.1
 */