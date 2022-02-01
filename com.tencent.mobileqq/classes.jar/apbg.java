import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class apbg
{
  public ArrayList<apbh> a;
  
  public static apbg a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    apbg localapbg;
    do
    {
      return localObject;
      localapbg = new apbg();
      localObject = localapbg;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localapbg.a = apbh.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localapbg;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apbg
 * JD-Core Version:    0.7.0.1
 */