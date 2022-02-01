import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class bcsy
  implements bcsi
{
  private adbd<Integer, bcsi> a = new adbe();
  
  public bcsy()
  {
    a();
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(169), bcta.class);
    this.a.a(Integer.valueOf(241), bcta.class);
    this.a.a(Integer.valueOf(242), bcta.class);
    this.a.a(Integer.valueOf(243), bcta.class);
    this.a.a(Integer.valueOf(175), bcsz.class);
    this.a.a(Integer.valueOf(11), bcsz.class);
    this.a.a(Integer.valueOf(129), bctb.class);
    this.a.a(Integer.valueOf(131), bctb.class);
    this.a.a(Integer.valueOf(133), bctb.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    bcsi localbcsi;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localbcsi = (bcsi)this.a.a(Integer.valueOf(i));
    } while (localbcsi == null);
    localbcsi.a(paramMessageHandler, paramMsg, paramList, parambcre);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcsy
 * JD-Core Version:    0.7.0.1
 */