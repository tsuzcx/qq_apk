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

class awuk
  implements awpp
{
  awuk(awuj paramawuj) {}
  
  public void a(awpk paramawpk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramawpk + " mRoomKey: " + awuj.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(awpk paramawpk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawpk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawpk.equals(awuj.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramawpk = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramawpk == null) || (paramawpk.isFinishing()));
      awql.a(paramawpk);
      return;
    } while ((paramInt1 != 10101) || (paramawpk == null) || (paramawpk.isFinishing()));
    awql.b(paramawpk);
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    if (!paramawpk.equals(awuj.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramawpk, " mRoomKey: ", awuj.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (awpi)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bhmq.c(localBitmap, 16, 16);
        awuj.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    awuj.a(this.a).a(paramawpk);
  }
  
  public void b(awpk paramawpk, int paramInt)
  {
    if (!paramawpk.equals(awuj.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    awql.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuk
 * JD-Core Version:    0.7.0.1
 */