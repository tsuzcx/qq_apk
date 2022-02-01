import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.PlusMenuContainer;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class bmyb
  implements View.OnClickListener
{
  public bmyb(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onClick(View paramView)
  {
    String str;
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      str = (String)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", str);
      bmtd.a((Activity)this.a.a, bmtk.a(), localIntent);
      if (!str.equals(PlusMenuContainer.b[0])) {
        break label101;
      }
      LpReportInfo_pf00064.report(133, 2);
    }
    for (;;)
    {
      this.a.b();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label101:
      if (str.equals(PlusMenuContainer.b[1])) {
        LpReportInfo_pf00064.report(133, 3);
      } else if (str.equals(PlusMenuContainer.b[2])) {
        LpReportInfo_pf00064.report(133, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmyb
 * JD-Core Version:    0.7.0.1
 */