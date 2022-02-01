import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.fragment.CustomHeightFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class auvw
  implements View.OnClickListener
{
  auvw(auvv paramauvv) {}
  
  public void onClick(View paramView)
  {
    this.a.a.getHostActivity().finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auvw
 * JD-Core Version:    0.7.0.1
 */