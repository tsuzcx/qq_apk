import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arwk
  implements arur
{
  arwk(arwj paramarwj) {}
  
  public void a(arum paramarum, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramarum + " mRoomKey: " + arwj.a(this.a));
    }
    bcql.a(arwj.a(this.a), "已在其他设备进行共享", 0).a();
    arwj.a(this.a).setResult(1);
    arwj.a(this.a).finish();
  }
  
  public void a(arum paramarum, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramarum, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramarum.equals(arwj.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((arwj.a(this.a) == null) || (arwj.a(this.a).isFinishing()));
      arwj.a(this.a).setResult(1);
      arvm.a(arwj.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (arwj.a(this.a) == null) || (arwj.a(this.a).isFinishing()));
    arwj.a(this.a).setResult(1);
    arvm.b(arwj.a(this.a));
  }
  
  public void a(arum paramarum, LocationRoom.Venue paramVenue, List<aruk> paramList)
  {
    if ((!paramarum.equals(arwj.a(this.a))) || (arwj.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (aruk)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bbef.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arwj.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    arwj.a(this.a).a(paramarum);
  }
  
  public void b(arum paramarum, int paramInt)
  {
    if (!paramarum.equals(arwj.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    arwj.a(this.a).setResult(1);
    arvm.a(arwj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwk
 * JD-Core Version:    0.7.0.1
 */