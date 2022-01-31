import android.os.Handler.Callback;
import android.os.Message;
import com.qq.im.poi.LbsPackPoiListActivity;
import com.tencent.widget.XListView;

public class anp
  implements Handler.Callback
{
  public anp(LbsPackPoiListActivity paramLbsPackPoiListActivity) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    default: 
      return true;
    case 100: 
      this.a.a = false;
      LbsPackPoiListActivity.a(this.a).springBackOverScrollHeaderView();
      return true;
    }
    this.a.runOnUiThread(new anq(this));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     anp
 * JD-Core Version:    0.7.0.1
 */