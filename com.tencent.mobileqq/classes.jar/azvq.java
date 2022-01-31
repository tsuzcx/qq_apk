import android.os.Bundle;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class azvq
  extends QIPCModule
{
  azvq(azvp paramazvp, String paramString)
  {
    super(paramString);
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if ("receipt_set_read".equals(paramString)) {
      azvp.a(this.a, paramBundle);
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d(StructMsgForGeneralShare.access$000(), 2, "unknown action");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azvq
 * JD-Core Version:    0.7.0.1
 */