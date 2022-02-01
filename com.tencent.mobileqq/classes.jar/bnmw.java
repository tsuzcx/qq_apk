import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class bnmw
  implements View.OnClickListener
{
  public bnmw(AEProviderContainerView paramAEProviderContainerView) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      yqu.a("clk_filter", yqu.b(banm.a), 0, false, new String[0]);
      if (AEProviderContainerView.a(this.a) != 0)
      {
        AEProviderContainerView.a(this.a);
        continue;
        yqu.a("clk_beauty", yqu.b(banm.a), 0, false, new String[0]);
        if (AEProviderContainerView.a(this.a) != 1) {
          AEProviderContainerView.b(this.a);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnmw
 * JD-Core Version:    0.7.0.1
 */