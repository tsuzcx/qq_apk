import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

class bjbu
  implements AdExposureChecker.ExposureCallback
{
  bjbu(bjbr parambjbr) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onExposure");
    if ((this.a.a != null) && (this.a.a.report_info != null) && (this.a.a.report_info.exposure_url != null)) {
      bjbr.a(this.a, this.a.a.report_info.exposure_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjbu
 * JD-Core Version:    0.7.0.1
 */