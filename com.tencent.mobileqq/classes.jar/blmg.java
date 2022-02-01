import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tavcut.exporter.MovieExporter;

class blmg
  implements View.OnClickListener
{
  blmg(blmd paramblmd) {}
  
  public void onClick(View paramView)
  {
    if (blmd.a(this.a) != null)
    {
      if (blmd.a(this.a) != null) {
        blmd.a(this.a).cancelCompress();
      }
      blmd.a(this.a).dismiss();
      blmd.a(this.a, null);
      blmd.a(this.a, null);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blmg
 * JD-Core Version:    0.7.0.1
 */