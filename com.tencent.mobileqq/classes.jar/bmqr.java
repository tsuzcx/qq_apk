import android.content.Intent;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bmqr
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    Object localObject;
    long l;
    boolean bool;
    label93:
    int i;
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
        break label189;
      }
      bool = true;
      if (QLog.isColorLevel())
      {
        l = System.currentTimeMillis();
        QLog.d("WadlBusinessServlet", 2, "onReceive success=" + bool);
      }
      localObject = null;
      if (bool)
      {
        i = paramFromServiceMsg.getWupBuffer().length - 4;
        localObject = new byte[i];
        PkgTools.copyData((byte[])localObject, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
      }
      if (paramIntent != null) {
        break label195;
      }
      if (QLog.isColorLevel()) {
        QLog.e("WadlBusinessServlet", 2, "onReceive fail, request is null");
      }
    }
    for (;;)
    {
      return;
      localObject = "";
      break;
      label189:
      bool = false;
      break label93;
      label195:
      i = paramIntent.getIntExtra("wadl_sso_type", 0);
      if (i == 1) {
        bmqw.a().a(paramIntent, bool, (byte[])localObject);
      }
      while (QLog.isColorLevel())
      {
        QLog.d("WadlBusinessServlet", 2, "onReceive exit|cost: " + (System.currentTimeMillis() - l));
        return;
        if (i == 0) {
          bmqt.a().a(paramIntent, bool, (byte[])localObject);
        }
      }
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WadlBusinessServlet", 2, "onSend...");
    }
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("webssoReq");
    if (paramIntent.getIntExtra("wadl_sso_type", 0) == 1) {
      paramPacket.setSSOCommand("GDCTrpcProxy.service");
    }
    while (arrayOfByte != null)
    {
      paramIntent = new byte[arrayOfByte.length + 4];
      PkgTools.DWord2Byte(paramIntent, 0, arrayOfByte.length + 4);
      PkgTools.copyData(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
      return;
      paramPacket.setSSOCommand("QQVacCommSvc.web_sso");
    }
    paramIntent = new byte[4];
    PkgTools.DWord2Byte(paramIntent, 0, 4L);
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqr
 * JD-Core Version:    0.7.0.1
 */