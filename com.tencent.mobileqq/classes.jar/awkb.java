import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class awkb
  implements awke
{
  awkb(awka paramawka, awjl paramawjl, awju paramawju) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, awjm paramawjm) {}
  
  public void a(int paramInt, ArrayList<awjm> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, awjm paramawjm) {}
  
  public void c(int paramInt, awjm arg2)
  {
    awki localawki = (awki)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Awjl.jdField_a_of_type_Awju.g).append(",uuid:").append(this.jdField_a_of_type_Awjl.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      awiw.a("PresendPicMgrService", "onSend ", ???);
      awiw.a("PresendPicMgrService", "onSend", " SendResult = " + localawki);
    }
    for (;;)
    {
      synchronized (awka.a(this.jdField_a_of_type_Awka))
      {
        if (!this.jdField_a_of_type_Awju.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Awjl.jdField_a_of_type_Awju.c = 1;
            awiw.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Awjl);
            awka.a(this.jdField_a_of_type_Awka).add(this.jdField_a_of_type_Awjl);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Awjl.jdField_a_of_type_Awju.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(awka.a(this.jdField_a_of_type_Awka));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Awjl.jdField_a_of_type_Awju.a;
          ((axwx)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          awiw.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Awjl);
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
  
  public void d(int paramInt, awjm paramawjm) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awkb
 * JD-Core Version:    0.7.0.1
 */