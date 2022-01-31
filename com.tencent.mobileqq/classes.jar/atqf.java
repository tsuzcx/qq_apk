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

class atqf
  implements atlm
{
  atqf(atqe paramatqe) {}
  
  public void a(atlh paramatlh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramatlh + " mRoomKey: " + atqe.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(atlh paramatlh, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatlh, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatlh.equals(atqe.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramatlh = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramatlh == null) || (paramatlh.isFinishing()));
      atmi.a(paramatlh);
      return;
    } while ((paramInt1 != 10101) || (paramatlh == null) || (paramatlh.isFinishing()));
    atmi.b(paramatlh);
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    if (!paramatlh.equals(atqe.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramatlh, " mRoomKey: ", atqe.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (atlf)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bdda.c(localBitmap, 16, 16);
        atqe.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    atqe.a(this.a).a(paramatlh);
  }
  
  public void b(atlh paramatlh, int paramInt)
  {
    if (!paramatlh.equals(atqe.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    atmi.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqf
 * JD-Core Version:    0.7.0.1
 */