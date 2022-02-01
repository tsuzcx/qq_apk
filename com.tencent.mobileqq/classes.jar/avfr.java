import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class avfr
  implements avcv
{
  avfr(avfq paramavfq) {}
  
  public void a(avcq paramavcq, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramavcq + " mRoomKey: " + avfq.a(this.a));
    }
    QQToast.a(avfq.a(this.a), "已在其他设备进行共享", 0).a();
    avfq.a(this.a).finish();
  }
  
  public void a(avcq paramavcq, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavcq, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavcq.equals(avfq.a(this.a))) {}
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
          if ((paramInt2 == 2) && (avfq.a(this.a).a() == 1))
          {
            if (avfq.a(this.a) != null)
            {
              avfq.a(this.a).a.a(1, avfq.a(this.a).a(), avfq.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((avfq.a(this.a) == null) || (avfq.a(this.a).isFinishing()));
        avdr.a(avfq.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((avfq.a(this.a) != null) && (!avfq.a(this.a).isFinishing()))
      {
        avdr.b(avfq.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramavcq });
  }
  
  public void a(avcq paramavcq, LocationRoom.Venue paramVenue, List<avco> paramList)
  {
    if ((!paramavcq.equals(avfq.a(this.a))) || (avfq.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      avco localavco = (avco)paramVenue.next();
      Bitmap localBitmap = this.a.a(localavco.a());
      if (localBitmap != null)
      {
        localBitmap = bfvo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        avfq.a(this.a).a(localavco.a(), localBitmap);
      }
    }
    avfq.a(this.a).a(paramList);
    avfq.a(this.a).a(paramavcq);
  }
  
  public void b(avcq paramavcq, int paramInt)
  {
    if (!paramavcq.equals(avfq.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    avdr.a(avfq.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfr
 * JD-Core Version:    0.7.0.1
 */