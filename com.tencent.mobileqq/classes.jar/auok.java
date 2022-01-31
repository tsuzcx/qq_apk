import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class auok
  implements auon
{
  auok(auoj paramauoj, aunv paramaunv, auod paramauod) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, aunw paramaunw) {}
  
  public void a(int paramInt, ArrayList<aunw> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, aunw paramaunw) {}
  
  public void c(int paramInt, aunw arg2)
  {
    auor localauor = (auor)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Aunv.jdField_a_of_type_Auod.g).append(",uuid:").append(this.jdField_a_of_type_Aunv.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      aung.a("PresendPicMgrService", "onSend ", ???);
      aung.a("PresendPicMgrService", "onSend", " SendResult = " + localauor);
    }
    for (;;)
    {
      synchronized (auoj.a(this.jdField_a_of_type_Auoj))
      {
        if (!this.jdField_a_of_type_Auod.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Aunv.jdField_a_of_type_Auod.c = 1;
            aung.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Aunv);
            auoj.a(this.jdField_a_of_type_Auoj).add(this.jdField_a_of_type_Aunv);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Aunv.jdField_a_of_type_Auod.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(auoj.a(this.jdField_a_of_type_Auoj));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Aunv.jdField_a_of_type_Auod.a;
          ((awap)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          aung.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Aunv);
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
  
  public void d(int paramInt, aunw paramaunw) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auok
 * JD-Core Version:    0.7.0.1
 */