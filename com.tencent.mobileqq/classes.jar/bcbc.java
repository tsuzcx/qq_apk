import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcbc
  implements View.OnClickListener
{
  public bcbc(UniteSearchActivity paramUniteSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.e();
    UniteSearchActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcbc
 * JD-Core Version:    0.7.0.1
 */