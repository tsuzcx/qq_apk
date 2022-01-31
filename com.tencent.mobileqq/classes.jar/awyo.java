import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;

class awyo
  extends amlv
{
  awyo(awyn paramawyn) {}
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramFromServiceMsg != null) && ("VideoSvc.Send".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd())))
    {
      localObject = this.a.a("VideoSvc.Send");
      if (localObject != null)
      {
        localObject = ((xom)localObject).a(paramToServiceMsg, paramFromServiceMsg);
        localMessageHandler = awyn.a(this.a).a();
        if ((localMessageHandler != null) && (localObject != null)) {
          localMessageHandler.onReceive(paramToServiceMsg, paramFromServiceMsg, localObject);
        }
      }
    }
    while (paramFromServiceMsg == null)
    {
      Object localObject;
      MessageHandler localMessageHandler;
      return;
    }
    this.a.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awyo
 * JD-Core Version:    0.7.0.1
 */