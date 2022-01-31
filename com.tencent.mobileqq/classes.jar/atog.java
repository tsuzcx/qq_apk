import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class atog
  implements atlm
{
  atog(atof paramatof) {}
  
  public void a(atlh paramatlh, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramatlh + " mRoomKey: " + atof.a(this.a));
    }
    QQToast.a(atof.a(this.a), "已在其他设备进行共享", 0).a();
    atof.a(this.a).finish();
  }
  
  public void a(atlh paramatlh, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramatlh, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramatlh.equals(atof.a(this.a))) {}
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
          if ((paramInt2 == 2) && (atof.a(this.a).a() == 1))
          {
            if (atof.a(this.a) != null)
            {
              atof.a(this.a).a.a(1, atof.a(this.a).a(), atof.a(this.a).a());
              QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
              return;
            }
            QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
            return;
          }
        } while ((atof.a(this.a) == null) || (atof.a(this.a).isFinishing()));
        atmi.a(atof.a(this.a));
        return;
      } while (paramInt1 != 10101);
      if ((atof.a(this.a) != null) && (!atof.a(this.a).isFinishing()))
      {
        atmi.b(atof.a(this.a));
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LocationShareController", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramatlh });
  }
  
  public void a(atlh paramatlh, LocationRoom.Venue paramVenue, List<atlf> paramList)
  {
    if ((!paramatlh.equals(atof.a(this.a))) || (atof.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      atlf localatlf = (atlf)paramVenue.next();
      Bitmap localBitmap = this.a.a(localatlf.a());
      if (localBitmap != null)
      {
        localBitmap = bdda.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        atof.a(this.a).a(localatlf.a(), localBitmap);
      }
    }
    atof.a(this.a).a(paramList);
    atof.a(this.a).a(paramatlh);
  }
  
  public void b(atlh paramatlh, int paramInt)
  {
    if (!paramatlh.equals(atof.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    atmi.a(atof.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atog
 * JD-Core Version:    0.7.0.1
 */