import android.os.RemoteException;
import cooperation.qappcenter.remote.IServiceHandler;
import cooperation.qappcenter.remote.RecvMsg;
import cooperation.qappcenter.remote.RemoteServiceProxy;
import cooperation.qappcenter.remote.SendMsg;

public class amuj
  implements Runnable
{
  public amuj(RemoteServiceProxy paramRemoteServiceProxy, SendMsg paramSendMsg) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy.a != null)
      {
        this.jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy.a.a(this.jdField_a_of_type_CooperationQappcenterRemoteSendMsg);
        return;
      }
      try
      {
        RecvMsg localRecvMsg = this.jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy.a(this.jdField_a_of_type_CooperationQappcenterRemoteSendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null.");
        this.jdField_a_of_type_CooperationQappcenterRemoteRemoteServiceProxy.a(this.jdField_a_of_type_CooperationQappcenterRemoteSendMsg, localRecvMsg);
        return;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      return;
    }
    catch (RemoteException localRemoteException)
    {
      localRemoteException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuj
 * JD-Core Version:    0.7.0.1
 */