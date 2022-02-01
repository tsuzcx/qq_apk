import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class bbmi
  implements bbls
{
  private abxq<Integer, bbls> a = new abxr();
  
  public bbmi()
  {
    a();
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(169), bbmk.class);
    this.a.a(Integer.valueOf(241), bbmk.class);
    this.a.a(Integer.valueOf(242), bbmk.class);
    this.a.a(Integer.valueOf(243), bbmk.class);
    this.a.a(Integer.valueOf(175), bbmj.class);
    this.a.a(Integer.valueOf(11), bbmj.class);
    this.a.a(Integer.valueOf(129), bbml.class);
    this.a.a(Integer.valueOf(131), bbml.class);
    this.a.a(Integer.valueOf(133), bbml.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbkm parambbkm)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    bbls localbbls;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localbbls = (bbls)this.a.a(Integer.valueOf(i));
    } while (localbbls == null);
    localbbls.a(paramMessageHandler, paramMsg, paramList, parambbkm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbmi
 * JD-Core Version:    0.7.0.1
 */