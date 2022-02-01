import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.mobileqq.data.MessageForArkBabyqReply;
import java.lang.ref.WeakReference;

public class arto
  implements agpb
{
  public arto(ArkBabyqCardInfo paramArkBabyqCardInfo) {}
  
  public void a()
  {
    if ((this.a.mBabyQReplyMsg != null) && (this.a.mBabyQReplyMsg.get() != null))
    {
      Object localObject = (MessageForArkBabyqReply)this.a.mBabyQReplyMsg.get();
      localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
      if (localObject != null) {
        localObject = (apys)((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.ARKAPP_HANDLER);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arto
 * JD-Core Version:    0.7.0.1
 */