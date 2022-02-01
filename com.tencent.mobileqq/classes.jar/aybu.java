import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aybu
  implements View.OnClickListener
{
  aybu(ayat paramayat) {}
  
  public void onClick(View paramView)
  {
    this.a.j(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aybu
 * JD-Core Version:    0.7.0.1
 */