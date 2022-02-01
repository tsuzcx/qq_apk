import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class asof
  implements View.OnClickListener
{
  asof(asnz paramasnz) {}
  
  public final void onClick(View paramView)
  {
    bcst.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 1, 0, "", "", "", "");
    this.a.dismiss();
    if (asnz.a(this.a) != null)
    {
      asob localasob = asnz.a(this.a);
      if (localasob == null) {
        Intrinsics.throwNpe();
      }
      localasob.a(asnz.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asof
 * JD-Core Version:    0.7.0.1
 */