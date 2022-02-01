import VIP.AIOKeyWordReq;
import VIP.AIOSendReq;
import VIP.AIOSendRes;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bbjm
  extends aafe
{
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((andu.a.equals(paramToServiceMsg.getServiceCmd())) || (andu.b.equals(paramToServiceMsg.getServiceCmd())))
    {
      if (paramFromServiceMsg == null) {
        return null;
      }
      paramToServiceMsg = new UniPacket(true);
      try
      {
        paramToServiceMsg.setEncodeName("utf-8");
        paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = (AIOSendRes)paramToServiceMsg.getByClass("response", new AIOSendRes());
        return paramToServiceMsg;
      }
      catch (RuntimeException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
        return null;
      }
      catch (Exception paramToServiceMsg)
      {
        return null;
      }
    }
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("VIP.AIOSendTipsServer.AIOSendTipsObj");
    if (andu.a.equals(paramToServiceMsg.getServiceCmd()))
    {
      paramUniPacket.setFuncName("CheckPopGrayStips");
      paramUniPacket.put("request", (AIOSendReq)paramToServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
    }
    for (;;)
    {
      return true;
      if (andu.b.equals(paramToServiceMsg.getServiceCmd()))
      {
        paramUniPacket.setFuncName("getUserKeyWordStips");
        paramUniPacket.put("request", (AIOKeyWordReq)paramToServiceMsg.extraData.getSerializable("VIPAioSendRequest"));
      }
    }
  }
  
  public String[] a()
  {
    return new String[] { "AIOSendSvc" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbjm
 * JD-Core Version:    0.7.0.1
 */