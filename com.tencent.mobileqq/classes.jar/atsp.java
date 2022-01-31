import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atsp
  implements atpv
{
  atsp(atso paramatso) {}
  
  public void a(atpq paramatpq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramatpq + " mRoomKey: " + atso.a(this.a));
    }
    QQToast.a(atso.a(this.a), "已在其他设备进行共享", 0).a();
    atso.a(this.a).finish();
  }
  
  public void a(atpq paramatpq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatpq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatpq.equals(atso.a(this.a))) {}
    do
    {
      do
      {
        do
        {
          return;
          if (paramInt1 != 10100) {
            break;
          }
          if ((paramInt2 == 2) && (atso.a(this.a).a() == 1))
          {
            if (atso.a(this.a) != null)
            {
              atso.a(this.a).a.a(1, atso.a(this.a).a(), atso.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((atso.a(this.a) == null) || (atso.a(this.a).isFinishing()));
        atqr.a(atso.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((atso.a(this.a) != null) && (!atso.a(this.a).isFinishing()))
      {
        atqr.b(atso.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramatpq });
  }
  
  public void a(atpq paramatpq, LocationRoom.Venue paramVenue, List<atpo> paramList)
  {
    if ((!paramatpq.equals(atso.a(this.a))) || (atso.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      atpo localatpo = (atpo)paramVenue.next();
      Bitmap localBitmap = this.a.a(localatpo.a());
      if (localBitmap != null)
      {
        localBitmap = bdhj.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        atso.a(this.a).a(localatpo.a(), localBitmap);
      }
    }
    atso.a(this.a).a(paramList);
    atso.a(this.a).a(paramatpq);
  }
  
  public void b(atpq paramatpq, int paramInt)
  {
    if (!paramatpq.equals(atso.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    atqr.a(atso.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsp
 * JD-Core Version:    0.7.0.1
 */