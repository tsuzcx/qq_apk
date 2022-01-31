import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arau
  implements aqzb
{
  arau(arat paramarat) {}
  
  public void a(aqyw paramaqyw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramaqyw + " mRoomKey: " + arat.a(this.a));
    }
    bbmy.a(arat.a(this.a), "已在其他设备进行共享", 0).a();
    arat.a(this.a).setResult(1);
    arat.a(this.a).finish();
  }
  
  public void a(aqyw paramaqyw, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaqyw, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaqyw.equals(arat.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((arat.a(this.a) == null) || (arat.a(this.a).isFinishing()));
      arat.a(this.a).setResult(1);
      aqzw.a(arat.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (arat.a(this.a) == null) || (arat.a(this.a).isFinishing()));
    arat.a(this.a).setResult(1);
    aqzw.b(arat.a(this.a));
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    if ((!paramaqyw.equals(arat.a(this.a))) || (arat.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aqyu)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bacm.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arat.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    arat.a(this.a).a(paramaqyw);
  }
  
  public void b(aqyw paramaqyw, int paramInt)
  {
    if (!paramaqyw.equals(arat.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    arat.a(this.a).setResult(1);
    aqzw.a(arat.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arau
 * JD-Core Version:    0.7.0.1
 */