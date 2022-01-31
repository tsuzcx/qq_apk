import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arzh
  implements arup
{
  arzh(arzg paramarzg) {}
  
  public void a(aruk paramaruk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramaruk + " mRoomKey: " + arzg.a(this.a));
    }
    bcpw.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(aruk paramaruk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaruk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaruk.equals(arzg.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramaruk = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramaruk == null) || (paramaruk.isFinishing()));
      arvk.a(paramaruk);
      return;
    } while ((paramInt1 != 10101) || (paramaruk == null) || (paramaruk.isFinishing()));
    arvk.b(paramaruk);
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, List<arui> paramList)
  {
    if (!paramaruk.equals(arzg.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramaruk, " mRoomKey: ", arzg.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (arui)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bbdr.c(localBitmap, 16, 16);
        arzg.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    arzg.a(this.a).a(paramaruk);
  }
  
  public void b(aruk paramaruk, int paramInt)
  {
    if (!paramaruk.equals(arzg.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    arvk.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzh
 * JD-Core Version:    0.7.0.1
 */