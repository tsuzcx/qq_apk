import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.QZoneLiveVideoBaseDownLoadActivty;
import cooperation.qzone.report.lp.LpReportInfo_dc00321;

public class amzg
  implements View.OnClickListener
{
  public amzg(QZoneLiveVideoBaseDownLoadActivty paramQZoneLiveVideoBaseDownLoadActivty) {}
  
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
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amzg
 * JD-Core Version:    0.7.0.1
 */