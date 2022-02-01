import com.tencent.mobileqq.pb.PBRepeatMessageField;
import java.util.ArrayList;
import tencent.im.oidb.cmd0x74b.oidb_0x74b.RspBody;

public class apuf
{
  public ArrayList<apug> a;
  
  public static apuf a(oidb_0x74b.RspBody paramRspBody)
  {
    Object localObject;
    if (paramRspBody == null) {
      localObject = null;
    }
    apuf localapuf;
    do
    {
      return localObject;
      localapuf = new apuf();
      localObject = localapuf;
    } while (!paramRspBody.rpt_msg_uin_head_list.has());
    localapuf.a = apug.a(paramRspBody.rpt_msg_uin_head_list.get());
    return localapuf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apuf
 * JD-Core Version:    0.7.0.1
 */