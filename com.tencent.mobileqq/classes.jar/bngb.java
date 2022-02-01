import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.exporter.MovieExporter;

class bngb
  implements View.OnClickListener
{
  bngb(bnfz parambnfz) {}
  
  public void onClick(View paramView)
  {
    if (bnfz.a(this.a) != null)
    {
      if (bnfz.a(this.a) != null) {
        bnfz.a(this.a).cancelCompress();
      }
      bnfz.a(this.a).dismiss();
      bnfz.a(this.a, null);
      bnfz.a(this.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bngb
 * JD-Core Version:    0.7.0.1
 */