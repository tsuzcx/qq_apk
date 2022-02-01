import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.BaseSearchActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bcar
  implements View.OnClickListener
{
  public bcar(BaseSearchActivity paramBaseSearchActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcar
 * JD-Core Version:    0.7.0.1
 */