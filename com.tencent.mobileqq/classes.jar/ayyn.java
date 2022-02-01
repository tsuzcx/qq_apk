import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AccountNotMatchException;

class ayyn
  implements ayyq
{
  ayyn(ayym paramayym, ayxx paramayxx, ayyg paramayyg) {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, ayxy paramayxy) {}
  
  public void a(int paramInt, ArrayList<ayxy> paramArrayList) {}
  
  public void a_(int paramInt, boolean paramBoolean) {}
  
  public void b(int paramInt, ayxy paramayxy) {}
  
  public void c(int paramInt, ayxy arg2)
  {
    ayyu localayyu = (ayyu)???.a;
    Object localObject2 = new StringBuilder().append("PresendStatus: destPath:").append(this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayyg.g).append(",uuid:").append(this.jdField_a_of_type_Ayxx.jdField_a_of_type_JavaLangString).append(",canceled:false, peakCompress:true, peakUpload:true, saveMR:true, transferAsync:true, mainUploadFinish:true, uploadResult:");
    if (paramInt == 0)
    {
      ??? = "ResultOk";
      ayxi.a("PresendPicMgrService", "onSend ", ???);
      ayxi.a("PresendPicMgrService", "onSend", " SendResult = " + localayyu);
    }
    for (;;)
    {
      synchronized (ayym.a(this.jdField_a_of_type_Ayym))
      {
        if (!this.jdField_a_of_type_Ayyg.f)
        {
          if (paramInt == 0)
          {
            this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayyg.c = 1;
            ayxi.a("PresendPicMgrService", "onSend", " SendButton not clicked, add senReq to mUploadFinishList,senReq = " + this.jdField_a_of_type_Ayxx);
            ayym.a(this.jdField_a_of_type_Ayym).add(this.jdField_a_of_type_Ayxx);
            return;
            ??? = "ResultFail";
            break;
          }
          this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayyg.c = 2;
        }
      }
      if (paramInt == 0)
      {
        try
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.sApplication.getAppRuntime(ayym.a(this.jdField_a_of_type_Ayym));
          localObject2 = (MessageRecord)this.jdField_a_of_type_Ayxx.jdField_a_of_type_Ayyg.a;
          ((bauy)localQQAppInterface.getManager(326)).a((MessageRecord)localObject2, null);
          ayxi.a("PresendPicMgrService", "onSend", " SendButton has been clicked, sendMessage directly! ,senReq = " + this.jdField_a_of_type_Ayxx);
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
  
  public void d(int paramInt, ayxy paramayxy) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayyn
 * JD-Core Version:    0.7.0.1
 */