import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayns
  implements View.OnClickListener
{
  ayns(aynr paramaynr) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof aynt)) && (this.a.a != null))
    {
      aynt localaynt = (aynt)paramView.getTag();
      this.a.a.a(this.a, paramView, localaynt);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayns
 * JD-Core Version:    0.7.0.1
 */