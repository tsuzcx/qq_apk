import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class awsl
  implements awpp
{
  awsl(awsk paramawsk) {}
  
  public void a(awpk paramawpk, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramawpk + " mRoomKey: " + awsk.a(this.a));
    }
    QQToast.a(awsk.a(this.a), "已在其他设备进行共享", 0).a();
    awsk.a(this.a).finish();
  }
  
  public void a(awpk paramawpk, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramawpk, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramawpk.equals(awsk.a(this.a))) {}
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
          if ((paramInt2 == 2) && (awsk.a(this.a).a() == 1))
          {
            if (awsk.a(this.a) != null)
            {
              awsk.a(this.a).a.a(1, awsk.a(this.a).a(), awsk.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((awsk.a(this.a) == null) || (awsk.a(this.a).isFinishing()));
        awql.a(awsk.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((awsk.a(this.a) != null) && (!awsk.a(this.a).isFinishing()))
      {
        awql.b(awsk.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramawpk });
  }
  
  public void a(awpk paramawpk, LocationRoom.Venue paramVenue, List<awpi> paramList)
  {
    if ((!paramawpk.equals(awsk.a(this.a))) || (awsk.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      awpi localawpi = (awpi)paramVenue.next();
      Bitmap localBitmap = this.a.a(localawpi.a());
      if (localBitmap != null)
      {
        localBitmap = bhmq.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        awsk.a(this.a).a(localawpi.a(), localBitmap);
      }
    }
    awsk.a(this.a).a(paramList);
    awsk.a(this.a).a(paramawpk);
  }
  
  public void b(awpk paramawpk, int paramInt)
  {
    if (!paramawpk.equals(awsk.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    awql.a(awsk.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsl
 * JD-Core Version:    0.7.0.1
 */