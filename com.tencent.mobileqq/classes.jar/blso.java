import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class blso
  implements View.OnClickListener
{
  public blso(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      xwa.a("clk_filter", xwa.b(babc.a), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.a) != 0)
      {
        AEProviderContainerView.a(this.a);
        continue;
        xwa.a("clk_beauty", xwa.b(babc.a), 0, false, new String[0]);
        if (AEProviderContainerView.a(this.a) != 1) {
          AEProviderContainerView.b(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blso
 * JD-Core Version:    0.7.0.1
 */