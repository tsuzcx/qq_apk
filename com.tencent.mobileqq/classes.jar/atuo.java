import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atuo
  implements atpv
{
  atuo(atun paramatun) {}
  
  public void a(atpq paramatpq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramatpq + " mRoomKey: " + atun.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(atpq paramatpq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatpq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatpq.equals(atun.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramatpq = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramatpq == null) || (paramatpq.isFinishing()));
      atqr.a(paramatpq);
      return;
    } while ((paramInt1 != 10101) || (paramatpq == null) || (paramatpq.isFinishing()));
    atqr.b(paramatpq);
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    if (!paramatpq.equals(atun.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramatpq, " mRoomKey: ", atun.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (atpo)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bdhj.c(localBitmap, 16, 16);
        atun.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    atun.a(this.a).a(paramatpq);
  }
  
  public void b(atpq paramatpq, int paramInt)
  {
    if (!paramatpq.equals(atun.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    atqr.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atuo
 * JD-Core Version:    0.7.0.1
 */