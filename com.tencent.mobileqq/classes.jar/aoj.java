import android.os.Bundle;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackObserver;
import com.qq.im.poi.LbsPackPoiListActivity;
import com.qq.im.poi.LbsPackPoiListAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class aoj
  extends LbsPackObserver
{
  public aoj(LbsPackPoiListActivity paramLbsPackPoiListActivity) {}
  
  public void onGetSendPOIList(boolean paramBoolean, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.i("LbsPack", 2, "isSuccess:" + paramBoolean);
    }
    if (paramBoolean)
    {
      paramBundle = LbsPackPoiListActivity.a(this.a).a();
      if (paramBundle != null)
      {
        LbsPackPoiListActivity.a(this.a).clear();
        LbsPackPoiListActivity.a(this.a).addAll(paramBundle);
      }
      if (LbsPackPoiListActivity.a(this.a) != null)
      {
        LbsPackPoiListActivity.a(this.a).a(LbsPackPoiListActivity.a(this.a));
        this.a.a.sendEmptyMessageDelayed(101, 200L);
      }
      return;
    }
    this.a.a.sendEmptyMessage(101);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     aoj
 * JD-Core Version:    0.7.0.1
 */