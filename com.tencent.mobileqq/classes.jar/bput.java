import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import java.util.List;

public class bput
  implements View.OnClickListener
{
  public bput(AdvancedProviderView paramAdvancedProviderView) {}
  
  public void onClick(View paramView)
  {
    List localList = brhm.a().a();
    if (localList.size() > 0) {
      zqd.a(this.a.a, localList.get(0));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bput
 * JD-Core Version:    0.7.0.1
 */