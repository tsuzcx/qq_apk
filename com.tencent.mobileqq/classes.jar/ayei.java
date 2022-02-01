import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class ayei
  implements ayel
{
  ayei(ayeh paramayeh, ayds paramayds, ayeb paramayeb) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, aydt paramaydt) {}
  
  public void a(int paramInt, ArrayList<aydt> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, aydt paramaydt) {}
  
  public void c(int paramInt, aydt arg2)
  {
    ayep localayep = (ayep)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Ayds.jdField_a_of_type_Ayeb.g).append(",uuid:").append(this.jdField_a_of_type_Ayds.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      ayde.a("PresendPicMgrService", "onSend ", ???);
      ayde.a("PresendPicMgrService", "onSend", " SendResult = " + localayep);
    }
    for (;;)
    {
      synchronized (ayeh.a(this.jdField_a_of_type_Ayeh))
      {
        if (!this.jdField_a_of_type_Ayeb.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Ayds.jdField_a_of_type_Ayeb.c = 1;
            ayde.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Ayds);
            ayeh.a(this.jdField_a_of_type_Ayeh).add(this.jdField_a_of_type_Ayds);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Ayds.jdField_a_of_type_Ayeb.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(ayeh.a(this.jdField_a_of_type_Ayeh));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Ayds.jdField_a_of_type_Ayeb.a;
          ((bahm)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          ayde.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Ayds);
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
  
  public void d(int paramInt, aydt paramaydt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayei
 * JD-Core Version:    0.7.0.1
 */