import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

public class bonr
  implements View.OnClickListener
{
  public bonr(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = bpqr.a().a();
    if (localList.size() > 0) {
      zfn.a(this.a.a, localList.get(0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonr
 * JD-Core Version:    0.7.0.1
 */