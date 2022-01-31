import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SignatureHandler;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class amcu
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SignatureServlet", 2, "onReceive cmd=" + paramIntent.getStringExtra("cmd"));
    }
    byte[] arrayOfByte;
    if (paramFromServiceMsg.isSuccess())
    {
      int i = paramFromServiceMsg.getWupBuffer().length - 4;
      arrayOfByte = new byte[i];
      bdqa.a(arrayOfByte, 0, paramFromServiceMsg.getWupBuffer(), 4, i);
    }
    for (;;)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      SignatureHandler localSignatureHandler = (SignatureHandler)((QQAppInterface)super.getAppRuntime()).a(41);
      if (localSignatureHandler != null) {
        localSignatureHandler.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      if (QLog.isColorLevel()) {
        QLog.d("SignatureServlet", 2, "onReceive exit");
      }
      return;
      arrayOfByte = null;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    String str = paramIntent.getStringExtra("cmd");
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    long l = paramIntent.getLongExtra("timeout", 30000L);
    if ((!TextUtils.isEmpty(str)) && (arrayOfByte != null))
    {
      paramPacket.setSSOCommand(str);
      paramPacket.setTimeout(l);
      paramIntent = new byte[arrayOfByte.length + 4];
      bdqa.a(paramIntent, 0, arrayOfByte.length + 4);
      bdqa.a(paramIntent, 4, arrayOfByte, arrayOfByte.length);
      paramPacket.putSendData(paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("SignatureServlet", 2, "onSend exit cmd=" + str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amcu
 * JD-Core Version:    0.7.0.1
 */