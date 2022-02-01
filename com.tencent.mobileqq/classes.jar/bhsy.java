import android.os.Bundle;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness;
import com.tencent.mobileqq.vas.updatesystem.business.TroopNickNameBusiness.Config;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

class bhsy
  implements EIPCResultCallback
{
  bhsy(bhsx parambhsx) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null) && (paramEIPCResult.data.getBoolean("status")))
    {
      bhsx.a(this.a, paramEIPCResult.data.getString("filepath"));
      paramEIPCResult = TroopNickNameBusiness.a(bhsx.a(this.a));
      if (paramEIPCResult != null)
      {
        this.a.a = paramEIPCResult.fontId;
        this.a.b = paramEIPCResult.fontType;
        this.a.a(bhsx.a(this.a), paramEIPCResult.delay, paramEIPCResult.repeatCount);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhsy
 * JD-Core Version:    0.7.0.1
 */