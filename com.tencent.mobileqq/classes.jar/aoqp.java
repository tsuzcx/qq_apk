import com.tencent.qphone.base.remote.ToServiceMsg;
import java.util.List;

public class aoqp
  implements aoqr
{
  public void a(anyz paramanyz, int paramInt, boolean paramBoolean, Object paramObject, Object[] paramArrayOfObject, anza paramanza)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 4003: 
      paramanyz.getTroopMsgFin(paramBoolean, paramArrayOfObject);
      return;
    case 4005: 
      paramanyz.getSystemMsgFin(paramBoolean, false, (List)paramObject);
      return;
    case 4006: 
      paramanyz.getSystemMsgFin(false, true, null);
      return;
    case 4011: 
      paramanyz.sendSystemMsgActionFin(paramBoolean, (ToServiceMsg)paramObject);
      return;
    case 4012: 
      paramanyz.sendSystemMsgActionError((ToServiceMsg)paramObject);
      return;
    case 4001: 
      paramanyz.getMsgFin(paramBoolean);
      return;
    case 4004: 
      paramanyz.registerProxyFin(paramBoolean, paramObject);
      return;
    case 4002: 
      paramanyz.getDiscussionMsgFin(paramBoolean);
      return;
    case 4013: 
      paramanyz.getAllProxyTroopMsg(paramBoolean, paramArrayOfObject);
      return;
    }
    paramanyz.receiptErrorRsp((Long[])paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoqp
 * JD-Core Version:    0.7.0.1
 */