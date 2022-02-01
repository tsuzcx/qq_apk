import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

class bkwe
  implements AdExposureChecker.ExposureCallback
{
  bkwe(bkwb parambkwb) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onExposure");
    if ((this.a.a != null) && (this.a.a.report_info != null) && (this.a.a.report_info.exposure_url != null)) {
      bkwb.a(this.a, this.a.a.report_info.exposure_url.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkwe
 * JD-Core Version:    0.7.0.1
 */