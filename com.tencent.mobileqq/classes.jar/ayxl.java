import android.content.Intent;
import android.os.Bundle;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class ayxl
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramIntent = bizk.a(paramFromServiceMsg.getWupBuffer());
      if (paramIntent != null)
      {
        paramFromServiceMsg = new Bundle();
        paramFromServiceMsg.putSerializable("data", paramIntent);
        notifyObserver(null, 1002, true, paramFromServiceMsg, avqu.class);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet isSuccess false");
      }
      notifyObserver(null, 1002, false, new Bundle(), avqu.class);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("QZoneAlbumListNumServlet", 2, "inform QZoneAlbumListNumServlet resultcode fail.");
    }
    notifyObserver(null, 1002, false, new Bundle(), avqu.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {
      return;
    }
    byte[] arrayOfByte = new bizk(paramIntent.getLongExtra("selfuin", 0L), paramIntent.getStringExtra("refer")).encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null) {
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(60000L);
    paramPacket.setSSOCommand("SQQzoneSvc." + "getAlbumListNum");
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayxl
 * JD-Core Version:    0.7.0.1
 */