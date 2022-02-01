import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class avuw
  implements View.OnClickListener
{
  public avuw(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      avwr.a("0X800A237");
    }
    for (;;)
    {
      this.a.a();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (avtq.c) {
        avwr.a("0X800A25C");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avuw
 * JD-Core Version:    0.7.0.1
 */