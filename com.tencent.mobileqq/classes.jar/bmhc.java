import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bmhc
  implements View.OnClickListener
{
  bmhc(bmha parambmha) {}
  
  public void onClick(View paramView)
  {
    if (bmha.a(this.a))
    {
      if (bmha.b(this.a)) {
        this.a.dismiss();
      }
      if (bmha.b(this.a) != null) {
        bmha.b(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmhc
 * JD-Core Version:    0.7.0.1
 */