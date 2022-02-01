import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.richstatus.EditActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class bbsp
  implements View.OnClickListener
{
  public bbsp(EditActivity paramEditActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.a();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbsp
 * JD-Core Version:    0.7.0.1
 */