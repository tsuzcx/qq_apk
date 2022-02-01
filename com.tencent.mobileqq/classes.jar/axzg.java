import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class axzg
  implements View.OnClickListener
{
  axzg(axzc paramaxzc, String paramString) {}
  
  public final void onClick(View paramView)
  {
    axyg.a.a(this.jdField_a_of_type_Axzc.a(), "VAL_FROM_STATUS_MSG_TAB");
    axvz.a("0X800AF45", 0, null, null, 14, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzg
 * JD-Core Version:    0.7.0.1
 */