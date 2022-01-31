import GIFT_MALL_PROTOCOL.DouFuInfo;
import GIFT_MALL_PROTOCOL.doufu_piece_rsp;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

class bjhv
  extends avvd
{
  public WeakReference<QQAppInterface> a;
  
  protected void j(boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a == null) {
      if (QLog.isColorLevel()) {
        QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData appRef==null");
      }
    }
    QQAppInterface localQQAppInterface;
    do
    {
      return;
      localQQAppInterface = (QQAppInterface)this.a.get();
      if (localQQAppInterface != null) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("UndealCount.QZoneObserver", 2, "onGetBirthDayNoticeData app == null ");
    return;
    paramBundle = paramBundle.getSerializable("data");
    if ((paramBoolean) && (paramBundle != null) && ((paramBundle instanceof doufu_piece_rsp)))
    {
      paramBundle = ((doufu_piece_rsp)paramBundle).doufu.iterator();
      while (paramBundle.hasNext()) {
        bjhu.a(localQQAppInterface, (DouFuInfo)paramBundle.next());
      }
    }
    localQQAppInterface.unRegistObserver(bjhu.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjhv
 * JD-Core Version:    0.7.0.1
 */