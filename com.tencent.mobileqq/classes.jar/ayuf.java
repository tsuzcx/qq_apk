import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ayuf
  implements View.OnClickListener
{
  ayuf(ayue paramayue) {}
  
  public void onClick(View paramView)
  {
    if (((paramView.getTag() instanceof ayug)) && (this.a.a != null))
    {
      ayug localayug = (ayug)paramView.getTag();
      this.a.a.a(this.a, paramView, localayug);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayuf
 * JD-Core Version:    0.7.0.1
 */