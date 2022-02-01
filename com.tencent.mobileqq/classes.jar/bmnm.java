import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.vip.manager.FileBannerTianshuManger.4;

public class bmnm
  implements View.OnClickListener
{
  public bmnm(FileBannerTianshuManger.4 param4) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.setVisibility(8);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmnm
 * JD-Core Version:    0.7.0.1
 */