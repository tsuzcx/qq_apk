import android.os.Bundle;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class amyf
  implements EIPCResultCallback
{
  amyf(long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data.getString("respData");
    amwn.a().callbackFromRequest(this.a, 0, "cs.on_get_open_key.local", paramEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amyf
 * JD-Core Version:    0.7.0.1
 */