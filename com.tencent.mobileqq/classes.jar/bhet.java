import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class bhet
  implements View.OnClickListener
{
  bhet(bheh parambheh) {}
  
  public void onClick(View paramView)
  {
    if ((bheh.a(this.a) != null) && (bheh.a(this.a).isShowing())) {
      bheh.a(this.a).dismiss();
    }
    ((BaseActivity)this.a.a).finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhet
 * JD-Core Version:    0.7.0.1
 */