import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/WeatherView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class axzr
  implements View.OnClickListener
{
  axzr(axzo paramaxzo, Ref.ObjectRef paramObjectRef, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      axvz.a("0X800AF49", 2, null, null, 12, null);
    }
    for (;;)
    {
      StatusVisibleFragment.a(this.jdField_a_of_type_Axzo.a(), axzo.a(this.jdField_a_of_type_Axzo), 2, 998);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      axvz.a("0X800AF49", 1, null, null, 12, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axzr
 * JD-Core Version:    0.7.0.1
 */