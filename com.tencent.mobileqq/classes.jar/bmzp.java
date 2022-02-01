import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.exporter.MovieExporter;

class bmzp
  implements View.OnClickListener
{
  bmzp(bmzm parambmzm) {}
  
  public void onClick(View paramView)
  {
    if (bmzm.a(this.a) != null)
    {
      if (bmzm.a(this.a) != null) {
        bmzm.a(this.a).cancelCompress();
      }
      bmzm.a(this.a).dismiss();
      bmzm.a(this.a, null);
      bmzm.a(this.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzp
 * JD-Core Version:    0.7.0.1
 */