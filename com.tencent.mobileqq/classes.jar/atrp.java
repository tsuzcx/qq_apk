import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atrp
  implements atpv
{
  atrp(atro paramatro) {}
  
  public void a(atpq paramatpq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramatpq + " mRoomKey: " + atro.a(this.a));
    }
    QQToast.a(atro.a(this.a), "已在其他设备进行共享", 0).a();
    atro.a(this.a).setResult(1);
    atro.a(this.a).finish();
  }
  
  public void a(atpq paramatpq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatpq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatpq.equals(atro.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((atro.a(this.a) == null) || (atro.a(this.a).isFinishing()));
      atro.a(this.a).setResult(1);
      atqr.a(atro.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (atro.a(this.a) == null) || (atro.a(this.a).isFinishing()));
    atro.a(this.a).setResult(1);
    atqr.b(atro.a(this.a));
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    if ((!paramatpq.equals(atro.a(this.a))) || (atro.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (atpo)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bdhj.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        atro.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    atro.a(this.a).a(paramatpq);
  }
  
  public void b(atpq paramatpq, int paramInt)
  {
    if (!paramatpq.equals(atro.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    atro.a(this.a).setResult(1);
    atqr.a(atro.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atrp
 * JD-Core Version:    0.7.0.1
 */