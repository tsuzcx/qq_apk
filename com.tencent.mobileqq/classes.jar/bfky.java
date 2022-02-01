import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bfky
  implements View.OnClickListener
{
  bfky(bfkw parambfkw) {}
  
  public void onClick(View paramView)
  {
    if (bfkw.a(this.a) != null)
    {
      bfkw.a(this.a).a(paramView);
      if (bfkw.a(this.a) != null) {
        bfkw.a(this.a).b(paramView, 0);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfky
 * JD-Core Version:    0.7.0.1
 */