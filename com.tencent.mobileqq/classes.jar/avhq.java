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

class avhq
  implements avcv
{
  avhq(avhp paramavhp) {}
  
  public void a(avcq paramavcq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramavcq + " mRoomKey: " + avhp.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(avcq paramavcq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavcq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavcq.equals(avhp.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramavcq = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramavcq == null) || (paramavcq.isFinishing()));
      avdr.a(paramavcq);
      return;
    } while ((paramInt1 != 10101) || (paramavcq == null) || (paramavcq.isFinishing()));
    avdr.b(paramavcq);
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    if (!paramavcq.equals(avhp.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramavcq, " mRoomKey: ", avhp.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (avco)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bfvo.c(localBitmap, 16, 16);
        avhp.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    avhp.a(this.a).a(paramavcq);
  }
  
  public void b(avcq paramavcq, int paramInt)
  {
    if (!paramavcq.equals(avhp.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    avdr.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avhq
 * JD-Core Version:    0.7.0.1
 */