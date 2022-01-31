import android.os.RemoteException;
import cooperation.qzone.remote.IServiceHandler;
import cooperation.qzone.remote.RecvMsg;
import cooperation.qzone.remote.RemoteServiceProxy;
import cooperation.qzone.remote.SendMsg;

public class anfx
  implements Runnable
{
  public anfx(RemoteServiceProxy paramRemoteServiceProxy, SendMsg paramSendMsg) {}
  
  public void run()
  {
    try
    {
      if (this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.serviceHandler != null)
      {
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.serviceHandler.sendMsg(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg);
        return;
      }
      try
      {
        RecvMsg localRecvMsg = this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.createWaiteRespTimeout(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg, "main thread sendMsgToServiceFailed. serviceHandler is null.");
        this.jdField_a_of_type_CooperationQzoneRemoteRemoteServiceProxy.sendFailedRespToApp(this.jdField_a_of_type_CooperationQzoneRemoteSendMsg, localRecvMsg);
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
 * Qualified Name:     anfx
 * JD-Core Version:    0.7.0.1
 */