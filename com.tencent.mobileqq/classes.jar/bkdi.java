import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.MsfMsgUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import mqq.app.AppRuntime;
import mqq.app.MSFServlet;
import mqq.app.Packet;

public class bkdi
  extends MSFServlet
{
  protected AppRuntime a;
  
  private void a(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "SharpSvr.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void a(String paramString, int paramInt)
  {
    bkdg.a().a(paramString, paramInt);
  }
  
  private void a(byte[] paramArrayOfByte)
  {
    bkdg.a().b(paramArrayOfByte);
  }
  
  private void b(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "SharpSvr.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void b(byte[] paramArrayOfByte)
  {
    bkdg.a().c(paramArrayOfByte);
  }
  
  private void c(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "MultiVideo.c2s");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void c(byte[] paramArrayOfByte)
  {
    bkdg.a().d(paramArrayOfByte);
  }
  
  private void d(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "MultiVideo.s2cack");
    localToServiceMsg.setNeedCallback(false);
    localToServiceMsg.putWupBuffer(paramBundle);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void d(byte[] paramArrayOfByte)
  {
    bkdg.a().e(paramArrayOfByte);
  }
  
  private void e(Intent paramIntent, Bundle paramBundle)
  {
    int i = paramBundle.getInt("app_id");
    paramBundle = MsfMsgUtil.getGatewayIpMsg(null);
    paramBundle.setTimeout(30000L);
    paramBundle.setNeedCallback(true);
    paramBundle.setNeedRemindSlowNetwork(false);
    paramBundle.setAppId(i);
    sendToMSF(paramIntent, paramBundle);
  }
  
  private void e(byte[] paramArrayOfByte)
  {
    bkdg.a().f(paramArrayOfByte);
  }
  
  private void f(Intent paramIntent, Bundle paramBundle)
  {
    paramBundle = paramBundle.getByteArray("wup_buffer");
    ToServiceMsg localToServiceMsg = new ToServiceMsg(null, this.a.getAccount(), "VideoCCSvc.Adaptation");
    localToServiceMsg.putWupBuffer(paramBundle);
    localToServiceMsg.setTimeout(10000L);
    sendToMSF(paramIntent, localToServiceMsg);
  }
  
  private void g(Intent paramIntent, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramBundle.getByteArray("wup_buffer");
    paramBundle = new ToServiceMsg(null, String.valueOf(paramBundle.getLong("uin")), "CliLogSvc.UploadReq");
    paramBundle.putWupBuffer(arrayOfByte);
    paramBundle.setNeedCallback(false);
    sendToMSF(paramIntent, paramBundle);
  }
  
  public String[] getPreferSSOCommands()
  {
    return new String[] { "SharpSvr.c2sack", "SharpSvr.s2c", "MultiVideo.c2sack", "MultiVideo.s2c" };
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.a = getAppRuntime();
  }
  
  public void onReceive(Intent paramIntent, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {}
    do
    {
      return;
      paramIntent = paramFromServiceMsg.getServiceCmd();
      bkdp.c("VideoChannelServlet", String.format("onReceive cmd=%s", new Object[] { paramIntent }));
      if ("SharpSvr.s2c".equalsIgnoreCase(paramIntent))
      {
        a(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("SharpSvr.c2sack".equalsIgnoreCase(paramIntent))
      {
        b(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.s2c".equalsIgnoreCase(paramIntent))
      {
        c(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if ("MultiVideo.c2sack".equalsIgnoreCase(paramIntent))
      {
        d(paramFromServiceMsg.getWupBuffer());
        return;
      }
      if (!"cmd_getGatewayIp".equalsIgnoreCase(paramIntent)) {
        break;
      }
      paramIntent = (String)paramFromServiceMsg.getAttribute("cmd_getGatewayIp");
    } while (paramIntent == null);
    bkdp.c("VideoChannelServlet", String.format(">>> ip=%s", new Object[] { paramIntent }));
    a(paramIntent, 0);
    return;
    if ("VideoCCSvc.Adaptation".equalsIgnoreCase(paramIntent))
    {
      if (paramFromServiceMsg.isSuccess())
      {
        e(paramFromServiceMsg.getWupBuffer());
        return;
      }
      bkdp.a("VideoChannelServlet", String.format("onReceive get config fail, resultCode=%s", new Object[] { Integer.valueOf(paramFromServiceMsg.getResultCode()) }));
      return;
    }
    bkdp.b("VideoChannelServlet", "onReceive handle not process cmd.");
  }
  
  public void onSend(Intent paramIntent, Packet paramPacket)
  {
    paramPacket = paramIntent.getExtras();
    if (paramPacket == null) {
      return;
    }
    int i = paramPacket.getInt("req_type", -1);
    bkdp.c("VideoChannelServlet", String.format("onSend reqType=%s", new Object[] { Integer.valueOf(i) }));
    switch (i)
    {
    default: 
      bkdp.b("VideoChannelServlet", "onSend handle not define reqType.");
      return;
    case 1: 
      a(paramIntent, paramPacket);
      return;
    case 2: 
      b(paramIntent, paramPacket);
      return;
    case 3: 
      c(paramIntent, paramPacket);
      return;
    case 4: 
      d(paramIntent, paramPacket);
      return;
    case 5: 
      e(paramIntent, paramPacket);
      return;
    case 6: 
      f(paramIntent, paramPacket);
      return;
    }
    g(paramIntent, paramPacket);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkdi
 * JD-Core Version:    0.7.0.1
 */