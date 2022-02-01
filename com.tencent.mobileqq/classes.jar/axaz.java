import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.msgbackup.fragment.MsgBackupDateFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class axaz
  implements View.OnClickListener
{
  public axaz(MsgBackupDateFragment paramMsgBackupDateFragment) {}
  
  public void onClick(View paramView)
  {
    if (MsgBackupDateFragment.a(this.a) == 0) {
      axct.a("0X800A236");
    }
    for (;;)
    {
      this.a.onBackEvent();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (awzs.c) {
        axct.a("0X800A25B");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     axaz
 * JD-Core Version:    0.7.0.1
 */