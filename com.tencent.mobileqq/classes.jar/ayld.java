import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ayld
  implements View.OnClickListener
{
  ayld(aykx paramaykx) {}
  
  public void onClick(View paramView)
  {
    blir localblir = blir.a(this.a.a);
    localblir.a(2131716719, 1);
    localblir.c(2131690580);
    localblir.a(new ayle(this, localblir));
    localblir.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayld
 * JD-Core Version:    0.7.0.1
 */