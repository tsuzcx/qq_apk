import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arxi
  implements arup
{
  arxi(arxh paramarxh) {}
  
  public void a(aruk paramaruk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramaruk + " mRoomKey: " + arxh.a(this.a));
    }
    bcpw.a(arxh.a(this.a), "已在其他设备进行共享", 0).a();
    arxh.a(this.a).finish();
  }
  
  public void a(aruk paramaruk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaruk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaruk.equals(arxh.a(this.a))) {}
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
          if ((paramInt2 == 2) && (arxh.a(this.a).a() == 1))
          {
            if (arxh.a(this.a) != null)
            {
              arxh.a(this.a).a.a(1, arxh.a(this.a).a(), arxh.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((arxh.a(this.a) == null) || (arxh.a(this.a).isFinishing()));
        arvk.a(arxh.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((arxh.a(this.a) != null) && (!arxh.a(this.a).isFinishing()))
      {
        arvk.b(arxh.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramaruk });
  }
  
  public void a(aruk paramaruk, LocationRoom.Venue paramVenue, List<arui> paramList)
  {
    if ((!paramaruk.equals(arxh.a(this.a))) || (arxh.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      arui localarui = (arui)paramVenue.next();
      Bitmap localBitmap = this.a.a(localarui.a());
      if (localBitmap != null)
      {
        localBitmap = bbdr.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arxh.a(this.a).a(localarui.a(), localBitmap);
      }
    }
    arxh.a(this.a).a(paramList);
    arxh.a(this.a).a(paramaruk);
  }
  
  public void b(aruk paramaruk, int paramInt)
  {
    if (!paramaruk.equals(arxh.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    arvk.a(arxh.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxi
 * JD-Core Version:    0.7.0.1
 */