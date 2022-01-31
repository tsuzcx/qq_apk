import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class anua
{
  public ArrayList<anub> a;
  
  public static anua a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    anua localanua;
    do
    {
      return localObject;
      localanua = new anua();
      localObject = localanua;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localanua.a = anub.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localanua;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anua
 * JD-Core Version:    0.7.0.1
 */