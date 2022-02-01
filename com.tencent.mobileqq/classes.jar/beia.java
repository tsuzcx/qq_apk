import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

class beia
  implements View.OnClickListener
{
  beia(behz parambehz) {}
  
  public void onClick(View paramView)
  {
    behz.a(this.a).b();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beia
 * JD-Core Version:    0.7.0.1
 */