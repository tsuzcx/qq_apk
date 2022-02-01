import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.onlinestatus.StatusVisibleFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref.ObjectRef;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/WeatherView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class ayty
  implements View.OnClickListener
{
  ayty(aytv paramaytv, Ref.ObjectRef paramObjectRef, boolean paramBoolean) {}
  
  public final void onClick(View paramView)
  {
    if (this.jdField_a_of_type_Boolean) {
      aypy.a("0X800AF49", 2, null, 4, null);
    }
    for (;;)
    {
      StatusVisibleFragment.a(this.jdField_a_of_type_Aytv.a(), aytv.a(this.jdField_a_of_type_Aytv), 2, 998);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aypy.a("0X800AF49", 1, null, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayty
 * JD-Core Version:    0.7.0.1
 */