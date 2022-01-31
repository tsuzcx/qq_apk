import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arwi
  implements arup
{
  arwi(arwh paramarwh) {}
  
  public void a(aruk paramaruk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramaruk + " mRoomKey: " + arwh.a(this.a));
    }
    bcpw.a(arwh.a(this.a), "已在其他设备进行共享", 0).a();
    arwh.a(this.a).setResult(1);
    arwh.a(this.a).finish();
  }
  
  public void a(aruk paramaruk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaruk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaruk.equals(arwh.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((arwh.a(this.a) == null) || (arwh.a(this.a).isFinishing()));
      arwh.a(this.a).setResult(1);
      arvk.a(arwh.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (arwh.a(this.a) == null) || (arwh.a(this.a).isFinishing()));
    arwh.a(this.a).setResult(1);
    arvk.b(arwh.a(this.a));
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, List<arui> paramList)
  {
    if ((!paramaruk.equals(arwh.a(this.a))) || (arwh.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (arui)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bbdr.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arwh.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    arwh.a(this.a).a(paramaruk);
  }
  
  public void b(aruk paramaruk, int paramInt)
  {
    if (!paramaruk.equals(arwh.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    arwh.a(this.a).setResult(1);
    arvk.a(arwh.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwi
 * JD-Core Version:    0.7.0.1
 */