import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import cooperation.qzone.contentbox.PlusMenuContainer;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class bjek
  implements View.OnClickListener
{
  public bjek(PlusMenuContainer paramPlusMenuContainer) {}
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      Intent localIntent = new Intent();
      localIntent.putExtra("cmd", "Schema");
      localIntent.putExtra("schema", paramView);
      bizm.a((Activity)this.a.a, bizt.a(), localIntent);
      if (!paramView.equals(PlusMenuContainer.b[0])) {
        break label94;
      }
      LpReportInfo_pf00064.report(133, 2);
    }
    for (;;)
    {
      this.a.b();
      return;
      label94:
      if (paramView.equals(PlusMenuContainer.b[1])) {
        LpReportInfo_pf00064.report(133, 3);
      } else if (paramView.equals(PlusMenuContainer.b[2])) {
        LpReportInfo_pf00064.report(133, 4);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjek
 * JD-Core Version:    0.7.0.1
 */