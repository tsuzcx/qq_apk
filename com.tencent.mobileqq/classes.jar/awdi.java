import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class awdi
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      try
      {
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          paramIntent = bfov.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
          if (paramIntent != null)
          {
            paramFromServiceMsg = new Bundle();
            paramFromServiceMsg.putSerializable("data", paramIntent);
            notifyObserver(null, 1004, true, paramFromServiceMsg, atdk.class);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet isSuccess false");
          }
          notifyObserver(null, 1004, false, new Bundle(), atdk.class);
          return;
        }
      }
      catch (Throwable paramIntent)
      {
        QLog.e("QzonePublicMsgServlet", 1, paramIntent + "onReceive error");
        notifyObserver(null, 1004, false, new Bundle(), atdk.class);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("QzonePublicMsgServlet", 2, "inform QzonePublicMsgServlet resultcode fail.");
    }
    notifyObserver(null, 1004, false, new Bundle(), atdk.class);
    if (paramFromServiceMsg != null) {}
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("key_uin", 0L);
    paramIntent = paramIntent.getStringExtra("has_photo");
    Object localObject = new HashMap();
    ((Map)localObject).put("has_photo", paramIntent);
    bfov localbfov = new bfov(l, (Map)localObject);
    localObject = localbfov.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      QLog.e("NotifyQZoneServer", 1, "onSend request encode result is null.cmd=" + localbfov.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(30000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localbfov.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awdi
 * JD-Core Version:    0.7.0.1
 */