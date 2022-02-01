import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class azku
  implements azkx
{
  azku(azkt paramazkt, azke paramazke, azkn paramazkn) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azkf paramazkf) {}
  
  public void a(int paramInt, ArrayList<azkf> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, azkf paramazkf) {}
  
  public void c(int paramInt, azkf arg2)
  {
    azlb localazlb = (azlb)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Azke.jdField_a_of_type_Azkn.g).append(",uuid:").append(this.jdField_a_of_type_Azke.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      azjq.a("PresendPicMgrService", "onSend ", ???);
      azjq.a("PresendPicMgrService", "onSend", " SendResult = " + localazlb);
    }
    for (;;)
    {
      synchronized (azkt.a(this.jdField_a_of_type_Azkt))
      {
        if (!this.jdField_a_of_type_Azkn.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Azke.jdField_a_of_type_Azkn.c = 1;
            azjq.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Azke);
            azkt.a(this.jdField_a_of_type_Azkt).add(this.jdField_a_of_type_Azke);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Azke.jdField_a_of_type_Azkn.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(azkt.a(this.jdField_a_of_type_Azkt));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Azke.jdField_a_of_type_Azkn.a;
          ((bbob)localQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a((MessageRecord)localObject2, null);
          azjq.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Azke);
        }
        catch (AccountNotMatchException localAccountNotMatchException) {}
        if (QLog.isColorLevel()) {
          QLog.d("PresendPicMgrService", 2, "no appRuntime");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("PresendPicMgrService", 2, "onSend SendResult = " + localAccountNotMatchException + ", upload failed");
      }
    }
  }
  
  public void d(int paramInt, azkf paramazkf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azku
 * JD-Core Version:    0.7.0.1
 */