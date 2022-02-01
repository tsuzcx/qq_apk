import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import cooperation.qqreader.ui.ReaderHomeTabFragment;
import cooperation.qqreader.view.ReaderTabBarView;

public class bmqs
  extends BroadcastReceiver
{
  public bmqs(ReaderHomeTabFragment paramReaderHomeTabFragment) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    bmqu.c(this.a.getActivity());
    ReaderHomeTabFragment.a(this.a).setUnReadMsg(1, 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmqs
 * JD-Core Version:    0.7.0.1
 */