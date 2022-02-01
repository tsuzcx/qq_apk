import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bcis
  implements View.OnClickListener
{
  bcis(bcir parambcir) {}
  
  public void onClick(View paramView)
  {
    bcir.a(this.a).a(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcis
 * JD-Core Version:    0.7.0.1
 */