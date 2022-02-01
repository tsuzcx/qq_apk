import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.multiaio.MultiAIOFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axdt
  implements View.OnClickListener
{
  public axdt(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "indicator onClick() called with: v = [" + paramView + "]");
    }
    MultiAIOFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axdt
 * JD-Core Version:    0.7.0.1
 */