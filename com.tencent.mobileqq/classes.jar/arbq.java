import android.graphics.Bitmap;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class arbq
  implements aqzb
{
  arbq(arbp paramarbp) {}
  
  public void a(aqyw paramaqyw, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[LocationShareController] onKickOff: invoked. roomKey: " + paramaqyw + " mRoomKey: " + arbp.a(this.a));
    }
    bbmy.a(arbp.a(this.a), "已在其他设备进行共享", 0).a();
    arbp.a(this.a).finish();
  }
  
  public void a(aqyw paramaqyw, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramaqyw, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramaqyw.equals(arbp.a(this.a))) {}
    do
    {
      do
      {
        return;
        if (paramInt1 != 10100) {
          break;
        }
        if ((paramInt2 == 2) && (arbp.a(this.a).a() == 1))
        {
          if (arbp.a(this.a) != null)
          {
            arbp.a(this.a).a.a(1, arbp.a(this.a).a(), arbp.a(this.a).a());
            QLog.d("LocationShareController", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
            return;
          }
          QLog.e("LocationShareController", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
          return;
        }
      } while ((arbp.a(this.a) == null) || (arbp.a(this.a).isFinishing()));
      aqzw.a(arbp.a(this.a));
      return;
    } while ((paramInt1 != 10101) || (arbp.a(this.a) == null) || (arbp.a(this.a).isFinishing()));
    aqzw.b(arbp.a(this.a));
  }
  
  public void a(aqyw paramaqyw, LocationRoom.Venue paramVenue, List<aqyu> paramList)
  {
    if ((!paramaqyw.equals(arbp.a(this.a))) || (arbp.a(this.a).isFinishing())) {
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      aqyu localaqyu = (aqyu)paramVenue.next();
      Bitmap localBitmap = this.a.a(localaqyu.a());
      if (localBitmap != null)
      {
        localBitmap = bacm.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        arbp.a(this.a).a(localaqyu.a(), localBitmap);
      }
    }
    arbp.a(this.a).a(paramList);
    arbp.a(this.a).a(paramaqyw);
  }
  
  public void b(aqyw paramaqyw, int paramInt)
  {
    if (!paramaqyw.equals(arbp.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1)) {
      return;
    }
    aqzw.a(arbp.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbq
 * JD-Core Version:    0.7.0.1
 */