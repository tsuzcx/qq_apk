import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender;
import com.tencent.mobileqq.together.writetogether.websocket.WriteTogetherWebSocketSender.MyNetInfoHandler.1;

public class beqr
  extends beqm
{
  private beqr(WriteTogetherWebSocketSender paramWriteTogetherWebSocketSender) {}
  
  protected void a()
  {
    ThreadManagerV2.excute(new WriteTogetherWebSocketSender.MyNetInfoHandler.1(this), 128, null, true);
  }
  
  protected void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beqr
 * JD-Core Version:    0.7.0.1
 */