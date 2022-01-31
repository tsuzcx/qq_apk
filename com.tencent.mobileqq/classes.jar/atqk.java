import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class atqk
  implements atqn
{
  atqk(atqj paramatqj, atpv paramatpv, atqd paramatqd) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, atpw paramatpw) {}
  
  public void a(int paramInt, ArrayList<atpw> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, atpw paramatpw) {}
  
  public void c(int paramInt, atpw arg2)
  {
    atqr localatqr = (atqr)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Atpv.jdField_a_of_type_Atqd.g).append(",uuid:").append(this.jdField_a_of_type_Atpv.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      atpg.a("PresendPicMgrService", "onSend ", ???);
      atpg.a("PresendPicMgrService", "onSend", " SendResult = " + localatqr);
    }
    for (;;)
    {
      synchronized (atqj.a(this.jdField_a_of_type_Atqj))
      {
        if (!this.jdField_a_of_type_Atqd.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Atpv.jdField_a_of_type_Atqd.c = 1;
            atpg.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Atpv);
            atqj.a(this.jdField_a_of_type_Atqj).add(this.jdField_a_of_type_Atpv);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Atpv.jdField_a_of_type_Atqd.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(atqj.a(this.jdField_a_of_type_Atqj));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Atpv.jdField_a_of_type_Atqd.a;
          ((avau)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          atpg.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Atpv);
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
  
  public void d(int paramInt, atpw paramatpw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     atqk
 * JD-Core Version:    0.7.0.1
 */