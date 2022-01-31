import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qqreader.ui.ReaderHomeTabFragment;
import cooperation.qqreader.view.ReaderTabBarView;

public class bgwb
  extends BroadcastReceiver
{
  public bgwb(ReaderHomeTabFragment paramReaderHomeTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bgwd.c(this.a.getActivity());
    ReaderHomeTabFragment.a(this.a).setUnReadMsg(1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwb
 * JD-Core Version:    0.7.0.1
 */