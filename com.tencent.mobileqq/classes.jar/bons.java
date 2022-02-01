import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

public class bons
  implements View.OnClickListener
{
  public bons(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = bpqr.a().a();
    if (localList.size() > 1) {
      zfn.a(this.a.a, localList.get(1));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bons
 * JD-Core Version:    0.7.0.1
 */