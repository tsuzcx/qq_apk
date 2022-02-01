import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class annw
  implements anny
{
  public void a(amwl paramamwl, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, amwm paramamwm)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4003: 
      paramamwl.getTroopMsgFin(paramBoolean, paramArrayOfObject);
      return;
    case 4005: 
      paramamwl.getSystemMsgFin(paramBoolean, false, (List)paramObject);
      return;
    case 4006: 
      paramamwl.getSystemMsgFin(false, true, null);
      return;
    case 4011: 
      paramamwl.sendSystemMsgActionFin(paramBoolean, (ToServiceMsg)paramObject);
      return;
    case 4012: 
      paramamwl.sendSystemMsgActionError((ToServiceMsg)paramObject);
      return;
    case 4001: 
      paramamwl.getMsgFin(paramBoolean);
      return;
    case 4004: 
      paramamwl.registerProxyFin(paramBoolean, paramObject);
      return;
    case 4002: 
      paramamwl.getDiscussionMsgFin(paramBoolean);
      return;
    case 4013: 
      paramamwl.getAllProxyTroopMsg(paramBoolean, paramArrayOfObject);
      return;
    }
    paramamwl.receiptErrorRsp((Long[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     annw
 * JD-Core Version:    0.7.0.1
 */