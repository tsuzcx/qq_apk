import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;

public class bmtp
  implements View.OnClickListener
{
  public bmtp(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
  public void onClick(View paramView)
  {
    if (!this.a.b)
    {
      if (1 == this.a.c) {
        LpReportInfo_dc00321.report(8, 129, 0, false, false, null);
      }
      this.a.a(false, false);
      this.a.b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmtp
 * JD-Core Version:    0.7.0.1
 */