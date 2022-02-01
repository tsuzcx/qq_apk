import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class avyt
  implements avwu
{
  avyt(avys paramavys) {}
  
  public void a(avwp paramavwp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramavwp + " mRoomKey: " + avys.a(this.a));
    }
    QQToast.a(avys.a(this.a), "已在其他设备进行共享", 0).a();
    avys.a(this.a).setResult(1);
    avys.a(this.a).finish();
  }
  
  public void a(avwp paramavwp, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavwp, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavwp.equals(avys.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((avys.a(this.a) == null) || (avys.a(this.a).isFinishing()));
      avys.a(this.a).setResult(1);
      avxq.a(avys.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (avys.a(this.a) == null) || (avys.a(this.a).isFinishing()));
    avys.a(this.a).setResult(1);
    avxq.b(avys.a(this.a));
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    if ((!paramavwp.equals(avys.a(this.a))) || (avys.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (avwn)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bgmo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        avys.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    avys.a(this.a).a(paramavwp);
  }
  
  public void b(avwp paramavwp, int paramInt)
  {
    if (!paramavwp.equals(avys.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    avys.a(this.a).setResult(1);
    avxq.a(avys.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avyt
 * JD-Core Version:    0.7.0.1
 */