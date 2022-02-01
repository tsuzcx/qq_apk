import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class aver
  implements avcv
{
  aver(aveq paramaveq) {}
  
  public void a(avcq paramavcq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramavcq + " mRoomKey: " + aveq.a(this.a));
    }
    QQToast.a(aveq.a(this.a), "已在其他设备进行共享", 0).a();
    aveq.a(this.a).setResult(1);
    aveq.a(this.a).finish();
  }
  
  public void a(avcq paramavcq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavcq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavcq.equals(aveq.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((aveq.a(this.a) == null) || (aveq.a(this.a).isFinishing()));
      aveq.a(this.a).setResult(1);
      avdr.a(aveq.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (aveq.a(this.a) == null) || (aveq.a(this.a).isFinishing()));
    aveq.a(this.a).setResult(1);
    avdr.b(aveq.a(this.a));
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    if ((!paramavcq.equals(aveq.a(this.a))) || (aveq.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (avco)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bfvo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        aveq.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    aveq.a(this.a).a(paramavcq);
  }
  
  public void b(avcq paramavcq, int paramInt)
  {
    if (!paramavcq.equals(aveq.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    aveq.a(this.a).setResult(1);
    avdr.a(aveq.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aver
 * JD-Core Version:    0.7.0.1
 */