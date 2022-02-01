import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.manager.FileBannerTianshuManger.4;

public class bmun
  implements View.OnClickListener
{
  public bmun(FileBannerTianshuManger.4 param4) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a(this.a.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmun
 * JD-Core Version:    0.7.0.1
 */