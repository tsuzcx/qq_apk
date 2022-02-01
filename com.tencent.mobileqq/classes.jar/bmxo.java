import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bmxo
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    long l;
    boolean bool;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("onReceive... ");
      if (paramFromServiceMsg != null)
      {
        localObject = ",failCode=" + paramFromServiceMsg.getBusinessFailCode() + "  errMsg:" + paramFromServiceMsg.getBusinessFailMsg();
        QLog.d("WadlBusinessServlet", 2, (String)localObject);
      }
    }
    else
    {
      l = 0L;
      if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.isSuccess())) {
        break label217;
      }
      bool = true;
      label93:
      if (QLog.isColorLevel())
      {
        l = System.currentTimeMillis();
        QLog.d("WadlBusinessServlet", 2, "onReceive success=" + bool);
      }
      if (!bool) {
        break label223;
      }
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      localObject = new byte[i];
      bgva.a((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    label217:
    label223:
    for (paramFromServiceMsg = (FromServiceMsg)localObject;; paramFromServiceMsg = null)
    {
      bmxq.a().a(paramIntent, bool, paramFromServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("WadlBusinessServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - l));
      }
      return;
      localObject = "";
      break;
      bool = false;
      break label93;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlBusinessServlet", 2, "onSend...");
    }
    paramIntent = paramIntent.getByteArrayExtra("webssoReq");
    paramPacket.setSSOCommand("QQVacCommSvc.web_sso");
    if (paramIntent != null)
    {
      byte[] arrayOfByte = new byte[paramIntent.length + 4];
      bgva.a(arrayOfByte, 0, paramIntent.length + 4);
      bgva.a(arrayOfByte, 4, paramIntent, paramIntent.length);
      paramPacket.putSendData(arrayOfByte);
      return;
    }
    paramIntent = new byte[4];
    bgva.a(paramIntent, 0, 4L);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxo
 * JD-Core Version:    0.7.0.1
 */