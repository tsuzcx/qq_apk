import android.content.Intent;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QzoneExternalRequest;
import cooperation.vip.manager.CommonRequestManager.1;
import mqq.app.MSFServlet;
import mqq.app.Packet;
import mqq.os.MqqHandler;

public abstract class bgqc
  extends MSFServlet
{
  protected long a()
  {
    return 10000L;
  }
  
  public abstract QzoneExternalRequest a(Intent paramIntent);
  
  public void a(Intent paramIntent)
  {
    ThreadManager.getSubThreadHandler().post(new CommonRequestManager.1(this, paramIntent));
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    QzoneExternalRequest localQzoneExternalRequest = a(paramIntent);
    if (localQzoneExternalRequest == null)
    {
      QLog.i("CommonRequestManager", 1, " onSend request = null");
      return;
    }
    byte[] arrayOfByte = localQzoneExternalRequest.encode();
    paramIntent = arrayOfByte;
    if (arrayOfByte == null)
    {
      QLog.e("CommonRequestManager", 1, "onSend request encode result is null.cmd=" + localQzoneExternalRequest.uniKey());
      paramIntent = new byte[4];
    }
    paramPacket.setTimeout(a());
    paramPacket.setSSOCommand("SQQzoneSvc." + localQzoneExternalRequest.uniKey());
    paramPacket.putSendData(paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgqc
 * JD-Core Version:    0.7.0.1
 */