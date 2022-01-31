import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class auoi
  implements auol
{
  auoi(auoh paramauoh, aunt paramaunt, auob paramauob) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, aunu paramaunu) {}
  
  public void a(int paramInt, ArrayList<aunu> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, aunu paramaunu) {}
  
  public void c(int paramInt, aunu arg2)
  {
    auop localauop = (auop)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Aunt.jdField_a_of_type_Auob.g).append(",uuid:").append(this.jdField_a_of_type_Aunt.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      aune.a("PresendPicMgrService", "onSend ", ???);
      aune.a("PresendPicMgrService", "onSend", " SendResult = " + localauop);
    }
    for (;;)
    {
      synchronized (auoh.a(this.jdField_a_of_type_Auoh))
      {
        if (!this.jdField_a_of_type_Auob.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Aunt.jdField_a_of_type_Auob.c = 1;
            aune.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Aunt);
            auoh.a(this.jdField_a_of_type_Auoh).add(this.jdField_a_of_type_Aunt);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Aunt.jdField_a_of_type_Auob.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(auoh.a(this.jdField_a_of_type_Auoh));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Aunt.jdField_a_of_type_Auob.a;
          ((awan)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          aune.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Aunt);
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
  
  public void d(int paramInt, aunu paramaunu) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoi
 * JD-Core Version:    0.7.0.1
 */