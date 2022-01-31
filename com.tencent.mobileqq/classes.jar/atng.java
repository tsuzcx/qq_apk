import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atng
  implements atlm
{
  atng(atnf paramatnf) {}
  
  public void a(atlh paramatlh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramatlh + " mRoomKey: " + atnf.a(this.a));
    }
    QQToast.a(atnf.a(this.a), "已在其他设备进行共享", 0).a();
    atnf.a(this.a).setResult(1);
    atnf.a(this.a).finish();
  }
  
  public void a(atlh paramatlh, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatlh, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatlh.equals(atnf.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((atnf.a(this.a) == null) || (atnf.a(this.a).isFinishing()));
      atnf.a(this.a).setResult(1);
      atmi.a(atnf.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (atnf.a(this.a) == null) || (atnf.a(this.a).isFinishing()));
    atnf.a(this.a).setResult(1);
    atmi.b(atnf.a(this.a));
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    if ((!paramatlh.equals(atnf.a(this.a))) || (atnf.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (atlf)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bdda.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        atnf.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    atnf.a(this.a).a(paramatlh);
  }
  
  public void b(atlh paramatlh, int paramInt)
  {
    if (!paramatlh.equals(atnf.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    atnf.a(this.a).setResult(1);
    atmi.a(atnf.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atng
 * JD-Core Version:    0.7.0.1
 */