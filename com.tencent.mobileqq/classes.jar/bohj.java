import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.exporter.MovieExporter;

class bohj
  implements View.OnClickListener
{
  bohj(bohh parambohh) {}
  
  public void onClick(View paramView)
  {
    if (bohh.a(this.a) != null)
    {
      if (bohh.a(this.a) != null) {
        bohh.a(this.a).cancelCompress();
      }
      bohh.a(this.a).dismiss();
      bohh.a(this.a, null);
      bohh.a(this.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bohj
 * JD-Core Version:    0.7.0.1
 */