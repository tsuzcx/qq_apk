import android.content.Context;
import android.view.View;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class bdsc
  implements AdExposureChecker.ExposureCallback
{
  bdsc(bdsb parambdsb, akxs paramakxs, Context paramContext, GdtAd paramGdtAd) {}
  
  public void onExposure(WeakReference<View> paramWeakReference)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletGdtAdManager_StructMsgItemLayout31", 2, "reportImpression...");
    }
    this.jdField_a_of_type_Akxs.a(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_Akxs.a(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd.getUrlForImpression());
    akxs.a("public.tailplace.show", "", "", "1", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsc
 * JD-Core Version:    0.7.0.1
 */