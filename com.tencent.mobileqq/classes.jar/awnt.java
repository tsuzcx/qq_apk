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

class awnt
  implements awiy
{
  awnt(awns paramawns) {}
  
  public void a(awit paramawit, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramawit + " mRoomKey: " + awns.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(awit paramawit, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawit, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawit.equals(awns.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramawit = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramawit == null) || (paramawit.isFinishing()));
      awju.a(paramawit);
      return;
    } while ((paramInt1 != 10101) || (paramawit == null) || (paramawit.isFinishing()));
    awju.b(paramawit);
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    if (!paramawit.equals(awns.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramawit, " mRoomKey: ", awns.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (awir)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bheg.c(localBitmap, 16, 16);
        awns.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    awns.a(this.a).a(paramawit);
  }
  
  public void b(awit paramawit, int paramInt)
  {
    if (!paramawit.equals(awns.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    awju.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnt
 * JD-Core Version:    0.7.0.1
 */