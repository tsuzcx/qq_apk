import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class atej
  implements View.OnClickListener
{
  atej(ated paramated) {}
  
  public final void onClick(View paramView)
  {
    bdll.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 1, 0, "", "", "", "");
    this.a.dismiss();
    if (ated.a(this.a) != null)
    {
      atef localatef = ated.a(this.a);
      if (localatef == null) {
        Intrinsics.throwNpe();
      }
      localatef.a(ated.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atej
 * JD-Core Version:    0.7.0.1
 */