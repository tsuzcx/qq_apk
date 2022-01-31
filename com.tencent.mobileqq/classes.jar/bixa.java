import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qqreader.ui.ReaderHomeTabFragment;
import cooperation.qqreader.view.ReaderTabBarView;

public class bixa
  extends BroadcastReceiver
{
  public bixa(ReaderHomeTabFragment paramReaderHomeTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bixc.c(this.a.getActivity());
    ReaderHomeTabFragment.a(this.a).setUnReadMsg(1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bixa
 * JD-Core Version:    0.7.0.1
 */