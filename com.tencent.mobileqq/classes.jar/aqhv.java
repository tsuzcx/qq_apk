import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class aqhv
{
  public ArrayList<aqhw> a;
  
  public static aqhv a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    aqhv localaqhv;
    do
    {
      return localObject;
      localaqhv = new aqhv();
      localObject = localaqhv;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localaqhv.a = aqhw.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localaqhv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqhv
 * JD-Core Version:    0.7.0.1
 */