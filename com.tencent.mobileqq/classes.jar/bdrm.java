import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.activity.qwallet.fragment.QwalletGdtCanvasFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bdrm
  implements View.OnClickListener
{
  bdrm(bdrk parambdrk, Context paramContext, GdtAd paramGdtAd, akrc paramakrc) {}
  
  public void onClick(View paramView)
  {
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.jdField_a_of_type_AndroidContentContext);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_Akrc.a(this.jdField_a_of_type_AndroidContentContext));
    localParams.jdField_b_of_type_JavaLangClass = QwalletGdtCanvasFragment.class;
    if (localParams.jdField_a_of_type_AndroidOsBundle == null) {
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", uuc.b(this.jdField_a_of_type_Bdrk.ab));
    GdtHandler.a(localParams);
    AdExposureChecker.onClick(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(bdrk.a));
    akrc.a("public.tailplace.click", "", "", "1", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdrm
 * JD-Core Version:    0.7.0.1
 */