import NS_MOBILE_QBOSS_PROTO.MobileQbossReportExceptionRsp;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class axcn
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    int i;
    if (paramFromServiceMsg != null)
    {
      i = paramFromServiceMsg.getResultCode();
      if (i != 1000) {
        break label83;
      }
      paramIntent = bhkc.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent == null) {
        break label68;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QbossErrorReportServlet", 2, "report qboss success state = " + paramIntent.iRet);
      }
    }
    label68:
    label83:
    while (!QLog.isColorLevel())
    {
      do
      {
        return;
        i = -1;
        break;
      } while (!QLog.isColorLevel());
      QLog.d("QbossErrorReportServlet", 2, "report qboss exception fail, decode result is null");
      return;
    }
    QLog.d("QbossErrorReportServlet", 2, "QZONE_GET_QBOSS_DATA fail, resultCode=" + i);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    long l = paramIntent.getLongExtra("uin", 0L);
    int i = paramIntent.getIntExtra("appId", 0);
    int j = paramIntent.getIntExtra("taskId", 0);
    Object localObject = paramIntent.getStringExtra("message");
    bhkc localbhkc = new bhkc(l, i, j, paramIntent.getIntExtra("code", 0), (String)localObject);
    localObject = localbhkc.encode();
    paramIntent = (Intent)localObject;
    if (localObject == null)
    {
      QLog.e("QbossErrorReportServlet", 1, "onSend request encode result is null.cmd=" + localbhkc.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + localbhkc.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axcn
 * JD-Core Version:    0.7.0.1
 */