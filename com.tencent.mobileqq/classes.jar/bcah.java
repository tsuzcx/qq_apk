import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class bcah
  implements bbzr
{
  private acww<Integer, bbzr> a = new acwx();
  
  public bcah()
  {
    a();
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(169), bcaj.class);
    this.a.a(Integer.valueOf(241), bcaj.class);
    this.a.a(Integer.valueOf(242), bcaj.class);
    this.a.a(Integer.valueOf(243), bcaj.class);
    this.a.a(Integer.valueOf(175), bcai.class);
    this.a.a(Integer.valueOf(11), bcai.class);
    this.a.a(Integer.valueOf(129), bcak.class);
    this.a.a(Integer.valueOf(131), bcak.class);
    this.a.a(Integer.valueOf(133), bcak.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bbyn parambbyn)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    bbzr localbbzr;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localbbzr = (bbzr)this.a.a(Integer.valueOf(i));
    } while (localbbzr == null);
    localbbzr.a(paramMessageHandler, paramMsg, paramList, parambbyn);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcah
 * JD-Core Version:    0.7.0.1
 */