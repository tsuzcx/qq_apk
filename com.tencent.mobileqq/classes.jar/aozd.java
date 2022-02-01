import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aozd
  extends MSFServlet
{
  private ToServiceMsg a;
  
  public static Intent a(Intent paramIntent, long paramLong)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("hostUin", paramLong);
    return localIntent;
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramIntent == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("QzoneLoverLightingServlet", 2, "onReceive, request is null");
      }
      return;
    }
    paramIntent = new Bundle();
    if (paramFromServiceMsg != null)
    {
      paramIntent.putInt("rsp_code", paramFromServiceMsg.getResultCode());
      paramIntent.putString("rsp_message", paramFromServiceMsg.getBusinessFailMsg());
    }
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("receive QzoneLoverLightingServlet, code: ");
      if (paramFromServiceMsg == null) {
        break label165;
      }
    }
    label165:
    for (int i = paramFromServiceMsg.getResultCode();; i = -1)
    {
      QLog.d("QzoneLoverLightingServlet", 2, i);
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
        break label197;
      }
      paramFromServiceMsg = paramFromServiceMsg.getWupBuffer();
      localObject = aozc.a();
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break;
      }
      paramIntent.putInt("rsp_code", 0);
      paramFromServiceMsg = aozc.a(paramFromServiceMsg, (String)localObject);
      if (paramFromServiceMsg == null) {
        break label170;
      }
      paramIntent.putSerializable("rsp_data", paramFromServiceMsg);
      notifyObserver(null, 291, true, paramIntent, aoze.class);
      return;
    }
    label170:
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverLightingServlet", 2, "inform QzoneLoverLightingServlet isSuccess false");
    }
    notifyObserver(null, 291, false, paramIntent, aoze.class);
    return;
    label197:
    if (QLog.isColorLevel()) {
      QLog.d("QzoneLoverLightingServlet", 2, "inform QzoneLoverLightingServlet resultcode fail.");
    }
    notifyObserver(null, 291, false, paramIntent, aoze.class);
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    if (paramIntent == null) {}
    long l;
    do
    {
      return;
      l = paramIntent.getLongExtra("hostUin", 0L);
      byte[] arrayOfByte = new aozc(l).encode();
      paramIntent = arrayOfByte;
      if (arrayOfByte == null) {
        paramIntent = new byte[4];
      }
      paramPacket.setTimeout(60000L);
      paramPacket.setSSOCommand("SQQzoneSvc." + aozc.a());
      paramPacket.putSendData(paramIntent);
    } while (!QLog.isColorLevel());
    QLog.d("QzoneLoverLightingServlet", 2, "send req QzoneLoverLightingRequest: " + l);
  }
  
  public void sendToMSF(Intent paramIntent, ToServiceMsg paramToServiceMsg)
  {
    this.a = paramToServiceMsg;
    super.sendToMSF(paramIntent, paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aozd
 * JD-Core Version:    0.7.0.1
 */