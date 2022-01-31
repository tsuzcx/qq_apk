import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ayxs
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg) {}
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    long l = paramIntent.getLongExtra("timestamp", 0L);
    byte[] arrayOfByte = new bjae(paramIntent.getLongExtra("hostuin", 0L), l, paramIntent.getStringExtra("refer"), paramIntent.getLongExtra("flag", 0L), paramIntent.getStringExtra("mark")).encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "wns.pushrsp");
    paramPacket.putSendData(paramIntent);
    QLog.d("MessageSvc.WNSQzone.Push", 2, "发送push ack 时间:" + l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxs
 * JD-Core Version:    0.7.0.1
 */