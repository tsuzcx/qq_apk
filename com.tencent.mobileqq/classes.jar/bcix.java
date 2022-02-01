import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcix
  implements View.OnClickListener
{
  bcix(bciw parambciw) {}
  
  public void onClick(View paramView)
  {
    bciw.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcix
 * JD-Core Version:    0.7.0.1
 */