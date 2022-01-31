import cooperation.qappcenter.remote.RecvMsg;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ammx
  extends Thread
{
  public ammx(RemoteServiceProxy paramRemoteServiceProxy) {}
  
  public void run()
  {
    while (!this.a.a.isEmpty())
    {
      SendMsg localSendMsg = (SendMsg)this.a.a.poll();
      if (localSendMsg != null) {
        try
        {
          this.a.a(localSendMsg);
        }
        catch (Exception localException)
        {
          RecvMsg localRecvMsg = this.a.a(localSendMsg, "sendMsgToServiceFailed，" + localException.toString());
          this.a.a(localSendMsg, localRecvMsg);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     ammx
 * JD-Core Version:    0.7.0.1
 */