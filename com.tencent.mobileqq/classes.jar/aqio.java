import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.YTAGReflectLiveCheckInterface.LightLiveCheckResult;
import com.tencent.youtu.ytagreflectlivecheck.requester.LightDiffResponse;

class aqio
  implements YTAGReflectLiveCheckInterface.LightLiveCheckResult
{
  aqio(aqil paramaqil) {}
  
  public void onFailed(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "YTAGReflectLiveCheckInterface onFailed= " + paramInt);
    }
    if (paramInt == 303) {
      this.a.a.a(2, aqip.a(211, ajjy.a(2131639914), true));
    }
  }
  
  public void onSuccess(boolean paramBoolean, LightDiffResponse paramLightDiffResponse, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("qq_Identification.Model", 2, "YTAGReflectLiveCheckInterface onSuccess= " + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqio
 * JD-Core Version:    0.7.0.1
 */