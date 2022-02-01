import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class asxv
  implements View.OnClickListener
{
  public asxv(FMActivity paramFMActivity) {}
  
  public void onClick(View paramView)
  {
    FMActivity.a(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asxv
 * JD-Core Version:    0.7.0.1
 */