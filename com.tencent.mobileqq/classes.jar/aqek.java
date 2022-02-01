import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class aqek
{
  public ArrayList<aqel> a;
  
  public static aqek a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    aqek localaqek;
    do
    {
      return localObject;
      localaqek = new aqek();
      localObject = localaqek;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localaqek.a = aqel.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localaqek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqek
 * JD-Core Version:    0.7.0.1
 */