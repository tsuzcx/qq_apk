import NS_MOBILE_PHOTO.operation_red_touch_req;
import android.content.Intent;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class avfe
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg != null) {
      if (QLog.isColorLevel()) {
        QLog.d("QzoneAlbumRedDotServlet", 2, "resultcode:" + paramFromServiceMsg.getResultCode() + ",failMsg:" + paramFromServiceMsg.getBusinessFailMsg());
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("QzoneAlbumRedDotServlet", 2, "fromServiceMsg==msg");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramIntent = paramIntent.getSerializableExtra("req");
    if ((paramIntent != null) && ((paramIntent instanceof operation_red_touch_req)))
    {
      avfd localavfd = new avfd(getAppRuntime().getLongAccountUin(), (operation_red_touch_req)paramIntent);
      byte[] arrayOfByte = localavfd.encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + localavfd.uniKey());
      paramPacket.putSendData(paramIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avfe
 * JD-Core Version:    0.7.0.1
 */