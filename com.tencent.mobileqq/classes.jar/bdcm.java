import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k=3, mv={1, 1, 16})
final class bdcm
  implements View.OnClickListener
{
  bdcm(bdcl parambdcl) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    bcst.b(bdcl.a(this.a).app, "dc00898", "", "", "0X800ADD6", "0X800ADD6", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdcm
 * JD-Core Version:    0.7.0.1
 */