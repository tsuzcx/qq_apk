import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arxk
  implements arur
{
  arxk(arxj paramarxj) {}
  
  public void a(arum paramarum, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramarum + " mRoomKey: " + arxj.a(this.a));
    }
    bcql.a(arxj.a(this.a), "已在其他设备进行共享", 0).a();
    arxj.a(this.a).finish();
  }
  
  public void a(arum paramarum, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramarum, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramarum.equals(arxj.a(this.a))) {}
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
          if ((paramInt2 == 2) && (arxj.a(this.a).a() == 1))
          {
            if (arxj.a(this.a) != null)
            {
              arxj.a(this.a).a.a(1, arxj.a(this.a).a(), arxj.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((arxj.a(this.a) == null) || (arxj.a(this.a).isFinishing()));
        arvm.a(arxj.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((arxj.a(this.a) != null) && (!arxj.a(this.a).isFinishing()))
      {
        arvm.b(arxj.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramarum });
  }
  
  public void a(arum paramarum, LocationRoom.Venue paramVenue, List<aruk> paramList)
  {
    if ((!paramarum.equals(arxj.a(this.a))) || (arxj.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      aruk localaruk = (aruk)paramVenue.next();
      Bitmap localBitmap = this.a.a(localaruk.a());
      if (localBitmap != null)
      {
        localBitmap = bbef.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arxj.a(this.a).a(localaruk.a(), localBitmap);
      }
    }
    arxj.a(this.a).a(paramList);
    arxj.a(this.a).a(paramarum);
  }
  
  public void b(arum paramarum, int paramInt)
  {
    if (!paramarum.equals(arxj.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    arvm.a(arxj.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxk
 * JD-Core Version:    0.7.0.1
 */