import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arzj
  implements arur
{
  arzj(arzi paramarzi) {}
  
  public void a(arum paramarum, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramarum + " mRoomKey: " + arzi.a(this.a));
    }
    bcql.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(arum paramarum, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramarum, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramarum.equals(arzi.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramarum = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramarum == null) || (paramarum.isFinishing()));
      arvm.a(paramarum);
      return;
    } while ((paramInt1 != 10101) || (paramarum == null) || (paramarum.isFinishing()));
    arvm.b(paramarum);
  }
  
  public void a(arum paramarum, LocationRoom.Venue paramVenue, List<aruk> paramList)
  {
    if (!paramarum.equals(arzi.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramarum, " mRoomKey: ", arzi.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aruk)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bbef.c(localBitmap, 16, 16);
        arzi.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    arzi.a(this.a).a(paramarum);
  }
  
  public void b(arum paramarum, int paramInt)
  {
    if (!paramarum.equals(arzi.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    arvm.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzj
 * JD-Core Version:    0.7.0.1
 */