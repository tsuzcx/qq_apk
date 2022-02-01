import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.gdtad.statistics.GdtDwellTimeStatisticsAfterClick;
import com.tencent.mobileqq.activity.qwallet.fragment.QwalletGdtCanvasFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class bcko
  implements View.OnClickListener
{
  bcko(bckm parambckm, GdtAd paramGdtAd, Context paramContext, ajvj paramajvj) {}
  
  public void onClick(View paramView)
  {
    new GdtDwellTimeStatisticsAfterClick(this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(paramView)).a();
    GdtHandler.Params localParams = new GdtHandler.Params();
    localParams.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference((Activity)this.jdField_a_of_type_AndroidContentContext);
    localParams.jdField_a_of_type_ComTencentGdtadAditemGdtAd = this.jdField_a_of_type_ComTencentGdtadAditemGdtAd;
    localParams.jdField_a_of_type_Boolean = true;
    localParams.jdField_b_of_type_Boolean = true;
    localParams.jdField_b_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_Ajvj.a(this.jdField_a_of_type_AndroidContentContext));
    localParams.jdField_b_of_type_JavaLangClass = QwalletGdtCanvasFragment.class;
    if (localParams.jdField_a_of_type_AndroidOsBundle == null) {
      localParams.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    localParams.jdField_a_of_type_AndroidOsBundle.putString("big_brother_ref_source_key", ugf.b(this.jdField_a_of_type_Bckm.ab));
    GdtHandler.a(localParams);
    AdExposureChecker.onClick(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentGdtadAditemGdtAd, new WeakReference(bckm.a));
    ajvj.a("public.tailplace.click", "", "", "1", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcko
 * JD-Core Version:    0.7.0.1
 */