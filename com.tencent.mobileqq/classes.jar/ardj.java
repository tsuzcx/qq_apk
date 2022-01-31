import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ardj
  implements aqzb
{
  ardj(ardi paramardi) {}
  
  public void a(aqyw paramaqyw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramaqyw + " mRoomKey: " + ardi.a(this.a));
    }
    bbmy.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(aqyw paramaqyw, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaqyw, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaqyw.equals(ardi.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramaqyw = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramaqyw == null) || (paramaqyw.isFinishing()));
      aqzw.a(paramaqyw);
      return;
    } while ((paramInt1 != 10101) || (paramaqyw == null) || (paramaqyw.isFinishing()));
    aqzw.b(paramaqyw);
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    if (!paramaqyw.equals(ardi.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramaqyw, " mRoomKey: ", ardi.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aqyu)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bacm.c(localBitmap, 16, 16);
        ardi.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    ardi.a(this.a).a(paramaqyw);
  }
  
  public void b(aqyw paramaqyw, int paramInt)
  {
    if (!paramaqyw.equals(ardi.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    aqzw.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ardj
 * JD-Core Version:    0.7.0.1
 */