import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class awfs
  implements awfv
{
  awfs(awfr paramawfr, awfc paramawfc, awfl paramawfl) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, awfd paramawfd) {}
  
  public void a(int paramInt, ArrayList<awfd> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, awfd paramawfd) {}
  
  public void c(int paramInt, awfd arg2)
  {
    awfz localawfz = (awfz)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Awfc.jdField_a_of_type_Awfl.g).append(",uuid:").append(this.jdField_a_of_type_Awfc.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      awen.a("PresendPicMgrService", "onSend ", ???);
      awen.a("PresendPicMgrService", "onSend", " SendResult = " + localawfz);
    }
    for (;;)
    {
      synchronized (awfr.a(this.jdField_a_of_type_Awfr))
      {
        if (!this.jdField_a_of_type_Awfl.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Awfc.jdField_a_of_type_Awfl.c = 1;
            awen.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Awfc);
            awfr.a(this.jdField_a_of_type_Awfr).add(this.jdField_a_of_type_Awfc);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Awfc.jdField_a_of_type_Awfl.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(awfr.a(this.jdField_a_of_type_Awfr));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Awfc.jdField_a_of_type_Awfl.a;
          ((axso)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          awen.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Awfc);
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
  
  public void d(int paramInt, awfd paramawfd) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awfs
 * JD-Core Version:    0.7.0.1
 */