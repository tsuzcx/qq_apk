import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class arqr
  implements View.OnClickListener
{
  arqr(arql paramarql) {}
  
  public final void onClick(View paramView)
  {
    bcef.b(null, "dc00898", "", "", "0X800B08B", "0X800B08B", 1, 0, "", "", "", "");
    this.a.dismiss();
    if (arql.a(this.a) != null)
    {
      arqn localarqn = arql.a(this.a);
      if (localarqn == null) {
        Intrinsics.throwNpe();
      }
      localarqn.a(arql.a(this.a));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arqr
 * JD-Core Version:    0.7.0.1
 */