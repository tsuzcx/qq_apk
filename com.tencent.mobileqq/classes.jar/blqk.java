import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class blqk
  implements View.OnClickListener
{
  blqk(blqi paramblqi) {}
  
  public void onClick(View paramView)
  {
    if (blqi.a(this.a))
    {
      if (blqi.b(this.a)) {
        this.a.dismiss();
      }
      if (blqi.b(this.a) != null) {
        blqi.b(this.a).onClick(paramView);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blqk
 * JD-Core Version:    0.7.0.1
 */