import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.weiyun.channel.pb.WeiyunPB.WeiyunTrialCouponUseMsgReq;
import cooperation.weiyun.sdk.api.WeiyunApi;
import cooperation.weiyun.utils.PreferenceUtils;
import mqq.app.AppRuntime;

public final class anhc
  implements Runnable
{
  public anhc(int paramInt) {}
  
  public void run()
  {
    WeiyunPB.WeiyunTrialCouponUseMsgReq localWeiyunTrialCouponUseMsgReq = new WeiyunPB.WeiyunTrialCouponUseMsgReq();
    localWeiyunTrialCouponUseMsgReq.business_id.set("upload_speed_up");
    WeiyunApi.a(localWeiyunTrialCouponUseMsgReq, null);
    if (this.a > 0)
    {
      int i = this.a;
      PreferenceUtils.a(BaseApplicationImpl.getApplication(), String.valueOf(BaseApplicationImpl.getApplication().getRuntime().getLongAccountUin()), "upload_coupon_count", String.valueOf(i - 1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anhc
 * JD-Core Version:    0.7.0.1
 */