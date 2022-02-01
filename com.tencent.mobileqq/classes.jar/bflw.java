import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bflw
  implements View.OnClickListener
{
  bflw(bflv parambflv) {}
  
  public void onClick(View paramView)
  {
    if (bflv.a(this.a) != null) {
      bflv.a(this.a).onClick(paramView);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bflw
 * JD-Core Version:    0.7.0.1
 */