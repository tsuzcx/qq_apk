import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class avzt
  implements avwu
{
  avzt(avzs paramavzs) {}
  
  public void a(avwp paramavwp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramavwp + " mRoomKey: " + avzs.a(this.a));
    }
    QQToast.a(avzs.a(this.a), "已在其他设备进行共享", 0).a();
    avzs.a(this.a).finish();
  }
  
  public void a(avwp paramavwp, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavwp, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavwp.equals(avzs.a(this.a))) {}
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
          if ((paramInt2 == 2) && (avzs.a(this.a).a() == 1))
          {
            if (avzs.a(this.a) != null)
            {
              avzs.a(this.a).a.a(1, avzs.a(this.a).a(), avzs.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((avzs.a(this.a) == null) || (avzs.a(this.a).isFinishing()));
        avxq.a(avzs.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((avzs.a(this.a) != null) && (!avzs.a(this.a).isFinishing()))
      {
        avxq.b(avzs.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramavwp });
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    if ((!paramavwp.equals(avzs.a(this.a))) || (avzs.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      avwn localavwn = (avwn)paramVenue.next();
      Bitmap localBitmap = this.a.a(localavwn.a());
      if (localBitmap != null)
      {
        localBitmap = bgmo.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        avzs.a(this.a).a(localavwn.a(), localBitmap);
      }
    }
    avzs.a(this.a).a(paramList);
    avzs.a(this.a).a(paramavwp);
  }
  
  public void b(avwp paramavwp, int paramInt)
  {
    if (!paramavwp.equals(avzs.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    avxq.a(avzs.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzt
 * JD-Core Version:    0.7.0.1
 */