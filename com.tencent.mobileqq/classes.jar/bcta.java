import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.List;
import msf.msgcomm.msg_comm.Msg;
import msf.msgcomm.msg_comm.MsgHead;

public class bcta
  implements bcsk
{
  private acny<Integer, bcsk> a = new acnz();
  
  public bcta()
  {
    a();
  }
  
  protected void a()
  {
    this.a.a(Integer.valueOf(169), bctc.class);
    this.a.a(Integer.valueOf(241), bctc.class);
    this.a.a(Integer.valueOf(242), bctc.class);
    this.a.a(Integer.valueOf(243), bctc.class);
    this.a.a(Integer.valueOf(175), bctb.class);
    this.a.a(Integer.valueOf(11), bctb.class);
    this.a.a(Integer.valueOf(129), bctd.class);
    this.a.a(Integer.valueOf(131), bctd.class);
    this.a.a(Integer.valueOf(133), bctd.class);
  }
  
  public void a(MessageHandler paramMessageHandler, msg_comm.Msg paramMsg, List<MessageRecord> paramList, bcre parambcre)
  {
    if (!((msg_comm.MsgHead)paramMsg.msg_head.get()).c2c_cmd.has()) {}
    bcsk localbcsk;
    do
    {
      return;
      int i = paramMsg.msg_head.c2c_cmd.get();
      localbcsk = (bcsk)this.a.a(Integer.valueOf(i));
    } while (localbcsk == null);
    localbcsk.a(paramMessageHandler, paramMsg, paramList, parambcre);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcta
 * JD-Core Version:    0.7.0.1
 */