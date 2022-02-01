import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class awrl
  implements awpp
{
  awrl(awrk paramawrk) {}
  
  public void a(awpk paramawpk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramawpk + " mRoomKey: " + awrk.a(this.a));
    }
    QQToast.a(awrk.a(this.a), "已在其他设备进行共享", 0).a();
    awrk.a(this.a).setResult(1);
    awrk.a(this.a).finish();
  }
  
  public void a(awpk paramawpk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawpk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawpk.equals(awrk.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((awrk.a(this.a) == null) || (awrk.a(this.a).isFinishing()));
      awrk.a(this.a).setResult(1);
      awql.a(awrk.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (awrk.a(this.a) == null) || (awrk.a(this.a).isFinishing()));
    awrk.a(this.a).setResult(1);
    awql.b(awrk.a(this.a));
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    if ((!paramawpk.equals(awrk.a(this.a))) || (awrk.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (awpi)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bhmq.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        awrk.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    awrk.a(this.a).a(paramawpk);
  }
  
  public void b(awpk paramawpk, int paramInt)
  {
    if (!paramawpk.equals(awrk.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    awrk.a(this.a).setResult(1);
    awql.a(awrk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awrl
 * JD-Core Version:    0.7.0.1
 */