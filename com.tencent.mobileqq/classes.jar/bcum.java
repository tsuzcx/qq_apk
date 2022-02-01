import PayMQQ.UniPayRequest;
import PayMQQ.UniPayResponse;
import android.os.Bundle;
import com.qq.jce.wup.UniPacket;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

public class bcum
  extends aauq
{
  public Object a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg == null) {
      return null;
    }
    paramToServiceMsg = new UniPacket(true);
    try
    {
      paramToServiceMsg.setEncodeName("utf-8");
      paramToServiceMsg.decode(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = (UniPayResponse)paramToServiceMsg.getByClass("stResponse", new UniPayResponse());
      return paramToServiceMsg;
    }
    catch (RuntimeException paramToServiceMsg)
    {
      return null;
    }
    catch (Exception paramToServiceMsg) {}
    return null;
  }
  
  public boolean a(ToServiceMsg paramToServiceMsg, UniPacket paramUniPacket)
  {
    paramUniPacket.setServantName("MQQ.VipSTCheckServer.VipSTCheckObj");
    paramUniPacket.setFuncName("mobileUniPayCheck");
    paramUniPacket.put("stRequest", (UniPayRequest)paramToServiceMsg.extraData.getSerializable("UniPayRequest"));
    return true;
  }
  
  public String[] a()
  {
    return new String[] { "VipSTCheckServer" };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcum
 * JD-Core Version:    0.7.0.1
 */