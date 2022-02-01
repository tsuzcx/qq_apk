import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class amyg
  implements EIPCResultCallback
{
  amyg(long paramLong, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("resData");
    amwn.a().callbackFromRequest(this.jdField_a_of_type_Long, 0, this.jdField_a_of_type_JavaLangString, paramEIPCResult);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameToolCmdChannel", 2, " GET_DRESS_PATH onCallback resJson:" + paramEIPCResult);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyg
 * JD-Core Version:    0.7.0.1
 */