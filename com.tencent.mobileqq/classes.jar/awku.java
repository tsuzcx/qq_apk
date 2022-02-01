import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class awku
  implements awiy
{
  awku(awkt paramawkt) {}
  
  public void a(awit paramawit, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramawit + " mRoomKey: " + awkt.a(this.a));
    }
    QQToast.a(awkt.a(this.a), "已在其他设备进行共享", 0).a();
    awkt.a(this.a).setResult(1);
    awkt.a(this.a).finish();
  }
  
  public void a(awit paramawit, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawit, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawit.equals(awkt.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((awkt.a(this.a) == null) || (awkt.a(this.a).isFinishing()));
      awkt.a(this.a).setResult(1);
      awju.a(awkt.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (awkt.a(this.a) == null) || (awkt.a(this.a).isFinishing()));
    awkt.a(this.a).setResult(1);
    awju.b(awkt.a(this.a));
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    if ((!paramawit.equals(awkt.a(this.a))) || (awkt.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (awir)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bheg.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        awkt.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    awkt.a(this.a).a(paramawit);
  }
  
  public void b(awit paramawit, int paramInt)
  {
    if (!paramawit.equals(awkt.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    awkt.a(this.a).setResult(1);
    awju.a(awkt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awku
 * JD-Core Version:    0.7.0.1
 */