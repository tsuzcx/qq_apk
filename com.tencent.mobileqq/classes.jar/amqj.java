import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy;
import cooperation.qqindividuality.ipc.QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper;
import java.util.concurrent.ConcurrentLinkedQueue;

class amqj
  extends Thread
{
  amqj(amqi paramamqi) {}
  
  public void run()
  {
    while (!this.a.a.a.isEmpty())
    {
      QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper localQQIndividualityRemoteProxyCallWrapper = (QQIndividualityRemoteProxy.QQIndividualityRemoteProxyCallWrapper)this.a.a.a.poll();
      if (localQQIndividualityRemoteProxyCallWrapper != null) {
        this.a.a.a(localQQIndividualityRemoteProxyCallWrapper);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amqj
 * JD-Core Version:    0.7.0.1
 */