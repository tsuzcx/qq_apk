import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class avpo
  implements EIPCResultCallback
{
  avpo(avpm paramavpm, ayra paramayra) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 11;
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null))
    {
      avpm.a(this.jdField_a_of_type_Avpm, 11);
      QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, eipcResult is null or data is null");
      this.jdField_a_of_type_Ayra.onFailedResponse(null, -1, "eipcResult is null");
      return;
    }
    Object localObject;
    if (paramEIPCResult.code == 0)
    {
      boolean bool = paramEIPCResult.data.getBoolean("usable", false);
      localObject = this.jdField_a_of_type_Avpm;
      if (bool) {}
      for (;;)
      {
        avpm.a((avpm)localObject, i);
        paramEIPCResult = paramEIPCResult.data.getString("msg");
        this.jdField_a_of_type_Ayra.ipJudgeSuccess(bool, paramEIPCResult);
        return;
        i = 10;
      }
    }
    if (paramEIPCResult.code == -102)
    {
      avpm.a(this.jdField_a_of_type_Avpm, 11);
      i = paramEIPCResult.data.getInt("code");
      localObject = paramEIPCResult.data.getString("cmd");
      paramEIPCResult = paramEIPCResult.data.getString("msg");
      this.jdField_a_of_type_Ayra.onFailedResponse((String)localObject, i, paramEIPCResult);
      return;
    }
    avpm.a(this.jdField_a_of_type_Avpm, 11);
    QLog.e("FaceContext", 1, new Object[] { "refreshIpStateOnSubProcess error, unknown code : ", Integer.valueOf(paramEIPCResult.code) });
    this.jdField_a_of_type_Ayra.onFailedResponse(null, -1, "unknown code");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avpo
 * JD-Core Version:    0.7.0.1
 */