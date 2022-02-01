import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class asua
  implements View.OnClickListener
{
  asua(astu paramastu) {}
  
  public final void onClick(View paramView)
  {
    if (this.a.isShowing())
    {
      this.a.dismiss();
      bdla.b(null, "dc00898", "", "", "0X800B08A", "0X800B08A", 6, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asua
 * JD-Core Version:    0.7.0.1
 */