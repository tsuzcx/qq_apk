import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class azra
  implements azrd
{
  azra(azqz paramazqz, azqk paramazqk, azqt paramazqt) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, azql paramazql) {}
  
  public void a(int paramInt, ArrayList<azql> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, azql paramazql) {}
  
  public void c(int paramInt, azql arg2)
  {
    azrh localazrh = (azrh)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqt.g).append(",uuid:").append(this.jdField_a_of_type_Azqk.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      azpw.a("PresendPicMgrService", "onSend ", ???);
      azpw.a("PresendPicMgrService", "onSend", " SendResult = " + localazrh);
    }
    for (;;)
    {
      synchronized (azqz.a(this.jdField_a_of_type_Azqz))
      {
        if (!this.jdField_a_of_type_Azqt.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqt.c = 1;
            azpw.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Azqk);
            azqz.a(this.jdField_a_of_type_Azqz).add(this.jdField_a_of_type_Azqk);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqt.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(azqz.a(this.jdField_a_of_type_Azqz));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Azqk.jdField_a_of_type_Azqt.a;
          ((bbnr)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          azpw.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Azqk);
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
  
  public void d(int paramInt, azql paramazql) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azra
 * JD-Core Version:    0.7.0.1
 */