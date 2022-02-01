import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class aqtd
  extends MSFServlet
{
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.isSuccess()) {}
    for (byte[] arrayOfByte = bhjl.b(paramFromServiceMsg.getWupBuffer());; arrayOfByte = null)
    {
      new Bundle().putByteArray("data", arrayOfByte);
      aoep localaoep = (aoep)((QQAppInterface)getAppRuntime()).getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER);
      if (localaoep != null) {
        localaoep.a(paramIntent, paramFromServiceMsg, arrayOfByte);
      }
      return;
    }
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    byte[] arrayOfByte = paramIntent.getByteArrayExtra("data");
    paramPacket.setSSOCommand(paramIntent.getStringExtra("cmd"));
    paramPacket.putSendData(bhjl.a(arrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqtd
 * JD-Core Version:    0.7.0.1
 */