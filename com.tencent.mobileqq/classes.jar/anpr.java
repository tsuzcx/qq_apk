import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class anpr
{
  public ArrayList<anps> a;
  
  public static anpr a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    anpr localanpr;
    do
    {
      return localObject;
      localanpr = new anpr();
      localObject = localanpr;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localanpr.a = anps.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localanpr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anpr
 * JD-Core Version:    0.7.0.1
 */