import NS_NEW_MOBILE_REPORT.AccessRspHead;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bgsf
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("YYBAdvServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd") + ",success=" + paramFromServiceMsg.isSuccess());
    }
    if ((paramIntent == null) || (paramFromServiceMsg == null)) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramFromServiceMsg.getResultCode();
        if (i != 1000) {
          break;
        }
        paramIntent = bgse.a(paramFromServiceMsg.getWupBuffer(), new int[1]);
      } while (paramIntent == null);
      QLog.d("YYBAdvServlet", 2, "handler MobileReport result , resultCode=" + i + " error code " + paramIntent.err_code + " error msg " + paramIntent.err_msg);
      return;
    } while (!QLog.isColorLevel());
    QLog.d("YYBAdvServlet", 2, "MobileReport fail, resultCode=" + i);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    bgse localbgse = new bgse(Long.valueOf(paramIntent.getLongExtra("selfuin", 0L)).longValue());
    byte[] arrayOfByte = localbgse.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("YYBAdvServlet", 1, "onSend request encode result is null.cmd=" + localbgse.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand(localbgse.getCmdString());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgsf
 * JD-Core Version:    0.7.0.1
 */