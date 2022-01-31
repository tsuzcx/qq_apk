import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.qq.im.poi.LbsPackListActivity;
import com.qq.im.poi.LbsPackListAdapter;
import com.qq.im.poi.LbsPackManager;
import com.qq.im.poi.LbsPackMapInfo;
import com.qq.im.poi.LbsPackPoiInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ann
  extends Handler
{
  public ann(LbsPackListActivity paramLbsPackListActivity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    long l;
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
              } while (LbsPackListActivity.a(this.a) == null);
              if ((LbsPackListActivity.a(this.a).a == null) || (LbsPackListActivity.a(this.a).a.a == null)) {
                break;
              }
              paramMessage = (LbsPackPoiInfo)LbsPackListActivity.a(this.a).a.a.get(Long.valueOf(LbsPackListActivity.a(this.a)));
            } while ((paramMessage == null) || (paramMessage.a == null) || (LbsPackListActivity.a(this.a) == null));
            LbsPackListActivity.a(this.a).addAll(paramMessage.a);
            LbsPackListActivity.a(this.a).a(LbsPackListActivity.a(this.a), LbsPackListActivity.a(this.a));
          } while (!QLog.isColorLevel());
          QLog.d("LbsPack", 2, "LbsPackListActivity handleMessage MSG_REQ_INIT_DATA size=" + paramMessage.a.size());
          return;
        } while (!QLog.isColorLevel());
        QLog.d("LbsPack", 2, "LbsPackListActivity MSG_REQ_INIT_DATA null");
        return;
        l = -1L;
        if ((paramMessage.obj instanceof Long)) {
          l = ((Long)paramMessage.obj).longValue();
        }
      } while (LbsPackListActivity.a(this.a) == null);
      if (QLog.isColorLevel()) {
        QLog.d("LbsPack", 2, "LbsPackListActivity handleMessage MSG_REQ_PAGINATION_DATA size=" + LbsPackListActivity.a(this.a).size() + " poiId=" + l + " mPoiId=" + LbsPackListActivity.a(this.a));
      }
    } while (l != LbsPackListActivity.a(this.a));
    LbsPackListActivity.a(this.a).a(LbsPackListActivity.a(this.a), LbsPackListActivity.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     ann
 * JD-Core Version:    0.7.0.1
 */