import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$bindTextView$2$1"}, k=3, mv={1, 1, 16})
final class aytn
  implements View.OnClickListener
{
  aytn(aytj paramaytj, String paramString) {}
  
  public final void onClick(View paramView)
  {
    aysf.a.a(this.jdField_a_of_type_Aytj.a(), "VAL_FROM_STATUS_MSG_TAB");
    aypy.a("0X800AF45", 0, null, 6, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytn
 * JD-Core Version:    0.7.0.1
 */