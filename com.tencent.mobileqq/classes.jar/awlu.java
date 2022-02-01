import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class awlu
  implements awiy
{
  awlu(awlt paramawlt) {}
  
  public void a(awit paramawit, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramawit + " mRoomKey: " + awlt.a(this.a));
    }
    QQToast.a(awlt.a(this.a), "已在其他设备进行共享", 0).a();
    awlt.a(this.a).finish();
  }
  
  public void a(awit paramawit, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawit, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawit.equals(awlt.a(this.a))) {}
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
          if ((paramInt2 == 2) && (awlt.a(this.a).a() == 1))
          {
            if (awlt.a(this.a) != null)
            {
              awlt.a(this.a).a.a(1, awlt.a(this.a).a(), awlt.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((awlt.a(this.a) == null) || (awlt.a(this.a).isFinishing()));
        awju.a(awlt.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((awlt.a(this.a) != null) && (!awlt.a(this.a).isFinishing()))
      {
        awju.b(awlt.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramawit });
  }
  
  public void a(awit paramawit, LocationRoom.Venue paramVenue, List<awir> paramList)
  {
    if ((!paramawit.equals(awlt.a(this.a))) || (awlt.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      awir localawir = (awir)paramVenue.next();
      Bitmap localBitmap = this.a.a(localawir.a());
      if (localBitmap != null)
      {
        localBitmap = bheg.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        awlt.a(this.a).a(localawir.a(), localBitmap);
      }
    }
    awlt.a(this.a).a(paramList);
    awlt.a(this.a).a(paramawit);
  }
  
  public void b(awit paramawit, int paramInt)
  {
    if (!paramawit.equals(awlt.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    awju.a(awlt.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awlu
 * JD-Core Version:    0.7.0.1
 */