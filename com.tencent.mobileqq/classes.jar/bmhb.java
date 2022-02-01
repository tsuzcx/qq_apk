import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmhb
  implements View.OnClickListener
{
  bmhb(bmha parambmha) {}
  
  public void onClick(View paramView)
  {
    if (bmha.a(this.a))
    {
      if (bmha.b(this.a)) {
        this.a.dismiss();
      }
      if (bmha.a(this.a) != null) {
        bmha.a(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhb
 * JD-Core Version:    0.7.0.1
 */