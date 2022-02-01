import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aysp
  implements View.OnClickListener
{
  aysp(aysl paramaysl) {}
  
  public void onClick(View paramView)
  {
    aysl.c(this.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aysp
 * JD-Core Version:    0.7.0.1
 */