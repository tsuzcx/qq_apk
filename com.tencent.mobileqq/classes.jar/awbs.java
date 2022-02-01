import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class awbs
  implements avwu
{
  awbs(awbr paramawbr) {}
  
  public void a(avwp paramavwp, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "onKickOff: invoked. roomKey: " + paramavwp + " mRoomKey: " + awbr.a(this.a));
    }
    QQToast.a(BaseApplicationImpl.context, "已在其他设备进行共享", 0).a();
  }
  
  public void a(avwp paramavwp, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramavwp, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramavwp.equals(awbr.a(this.a))) {}
    do
    {
      do
      {
        return;
        paramavwp = BaseActivity.sTopActivity;
        if (paramInt1 != 10100) {
          break;
        }
      } while ((paramavwp == null) || (paramavwp.isFinishing()));
      avxq.a(paramavwp);
      return;
    } while ((paramInt1 != 10101) || (paramavwp == null) || (paramavwp.isFinishing()));
    avxq.b(paramavwp);
  }
  
  public void a(avwp paramavwp, LocationRoom.Venue paramVenue, List<avwn> paramList)
  {
    if (!paramavwp.equals(awbr.a(this.a)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationShareController", 2, new Object[] { "onUpdateUserLocations: invoked. ", " roomKey: ", paramavwp, " mRoomKey: ", awbr.a(this.a) });
      }
      return;
    }
    paramVenue = paramList.iterator();
    while (paramVenue.hasNext())
    {
      paramList = (avwn)paramVenue.next();
      Bitmap localBitmap = this.a.a(paramList.a());
      if (localBitmap != null)
      {
        localBitmap = bgmo.c(localBitmap, 16, 16);
        awbr.a(this.a).a(paramList.a(), localBitmap);
      }
    }
    awbr.a(this.a).a(paramavwp);
  }
  
  public void b(avwp paramavwp, int paramInt)
  {
    if (!paramavwp.equals(awbr.a(this.a))) {}
    while ((paramInt == 2) || (paramInt == 1) || (BaseActivity.sTopActivity == null)) {
      return;
    }
    avxq.a(BaseActivity.sTopActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbs
 * JD-Core Version:    0.7.0.1
 */