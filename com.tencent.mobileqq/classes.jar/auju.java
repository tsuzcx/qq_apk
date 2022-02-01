import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class auju
  implements EIPCResultCallback
{
  auju(aujs paramaujs, axkv paramaxkv) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    int i = 11;
    if ((paramEIPCResult == null) || (paramEIPCResult.data == null))
    {
      aujs.a(this.jdField_a_of_type_Aujs, 11);
      QLog.e("FaceContext", 1, "refreshIpStateOnSubProcess error, eipcResult is null or data is null");
      this.jdField_a_of_type_Axkv.onFailedResponse(null, -1, "eipcResult is null");
      return;
    }
    Object localObject;
    if (paramEIPCResult.code == 0)
    {
      boolean bool = paramEIPCResult.data.getBoolean("usable", false);
      localObject = this.jdField_a_of_type_Aujs;
      if (bool) {}
      for (;;)
      {
        aujs.a((aujs)localObject, i);
        paramEIPCResult = paramEIPCResult.data.getString("msg");
        this.jdField_a_of_type_Axkv.ipJudgeSuccess(bool, paramEIPCResult);
        return;
        i = 10;
      }
    }
    if (paramEIPCResult.code == -102)
    {
      aujs.a(this.jdField_a_of_type_Aujs, 11);
      i = paramEIPCResult.data.getInt("code");
      localObject = paramEIPCResult.data.getString("cmd");
      paramEIPCResult = paramEIPCResult.data.getString("msg");
      this.jdField_a_of_type_Axkv.onFailedResponse((String)localObject, i, paramEIPCResult);
      return;
    }
    aujs.a(this.jdField_a_of_type_Aujs, 11);
    QLog.e("FaceContext", 1, new Object[] { "refreshIpStateOnSubProcess error, unknown code : ", Integer.valueOf(paramEIPCResult.code) });
    this.jdField_a_of_type_Axkv.onFailedResponse(null, -1, "unknown code");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auju
 * JD-Core Version:    0.7.0.1
 */