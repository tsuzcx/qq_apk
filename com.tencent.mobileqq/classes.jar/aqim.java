import com.tencent.qphone.base.util.QLog;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBack;
import com.tencent.youtu.ytagreflectlivecheck.requester.RGBConfigRequester.RGBConfigRequestCallBackType;

class aqim
  implements RGBConfigRequester
{
  aqim(aqil paramaqil) {}
  
  public void request(RGBConfigRequester.RGBConfigRequestCallBack paramRGBConfigRequestCallBack)
  {
    if (this.a.a != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("qq_Identification.Model", 2, "YTAGReflectLiveCheckInterface setRGBConfigRequest:" + aqil.a(this.a));
      }
      paramRGBConfigRequestCallBack.onSuccess("{\"business_name\":\"livecheck\",\"person_id\":\"2936662\",\"error_code\":0,\"error_msg\":\"OK\",\"color_data\":\"1 120 6 3 4 5 0 1 \"}", RGBConfigRequester.RGBConfigRequestCallBackType.RGB_FullResponse);
      this.a.a.a(6);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqim
 * JD-Core Version:    0.7.0.1
 */