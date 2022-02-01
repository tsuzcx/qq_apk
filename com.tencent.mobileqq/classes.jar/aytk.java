import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mobileqq/onlinestatus/view/ConstellationView$1$1"}, k=3, mv={1, 1, 16})
final class aytk
  implements View.OnClickListener
{
  aytk(aytj paramaytj) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    this.a.a().a(1040);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aytk
 * JD-Core Version:    0.7.0.1
 */