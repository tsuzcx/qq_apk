import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class awyl
  implements View.OnClickListener
{
  awyl(awyf paramawyf) {}
  
  public void onClick(View paramView)
  {
    bjnw localbjnw = bjnw.a(this.a.a);
    localbjnw.a(2131716953, 1);
    localbjnw.c(2131690620);
    localbjnw.a(new awym(this, localbjnw));
    localbjnw.show();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awyl
 * JD-Core Version:    0.7.0.1
 */