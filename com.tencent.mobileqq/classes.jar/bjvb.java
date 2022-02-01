import android.app.Activity;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.api.GdtAd;
import com.tencent.mobileqq.mini.util.AdUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.core.proxy.AdProxy.IBannerAdListener;
import java.lang.ref.WeakReference;

class bjvb
  implements acko
{
  bjvb(bjva parambjva, Activity paramActivity) {}
  
  public void onAdClicked(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClicked");
    if ((paramGdtAd != null) && (paramGdtAd.getAd() != null) && (AdUtils.isHitReport50ViewAndOneSecond(paramGdtAd.getAd()))) {
      AdExposureChecker.onClick(this.jdField_a_of_type_AndroidAppActivity, paramGdtAd.getAd(), new WeakReference(this.jdField_a_of_type_Bjva.jdField_a_of_type_ComTencentAdTangramUtilAdExposureChecker$ExposureCallback));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Bjva.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
        this.jdField_a_of_type_Bjva.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADClicked();
      }
      return;
      QLog.i("AdProxyImpl", 1, "ad null");
    }
  }
  
  public void onAdClosed(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdClosed");
    if (this.jdField_a_of_type_Bjva.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener != null) {
      this.jdField_a_of_type_Bjva.jdField_a_of_type_ComTencentQqminiSdkLauncherCoreProxyAdProxy$IBannerAdListener.onADClosed();
    }
  }
  
  public void onAdFailedToLoad(GdtAd paramGdtAd, ackn paramackn)
  {
    int i;
    if (paramackn != null)
    {
      i = paramackn.a();
      if (paramackn == null) {
        break label58;
      }
    }
    label58:
    for (paramGdtAd = paramackn.a();; paramGdtAd = "")
    {
      QLog.i("AdProxyImpl", 1, "bannerad onAdFailedToLoad code=" + i + ", msg=" + paramGdtAd);
      return;
      i = -1;
      break;
    }
  }
  
  public void onAdImpression(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdImpression");
  }
  
  public void onAdLoaded(GdtAd paramGdtAd)
  {
    QLog.i("AdProxyImpl", 1, "bannerad onAdLoaded");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bjvb
 * JD-Core Version:    0.7.0.1
 */