import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aqwq
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = bhuf.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      aoip localaoip = (aoip)((QQAppInterface)getAppRuntime()).a(20);
      if (localaoip != null) {
        localaoip.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(bhuf.a(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwq
 * JD-Core Version:    0.7.0.1
 */