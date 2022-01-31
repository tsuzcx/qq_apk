import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPoiDataHelper.1.1;
import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.proto.lbsshare.LBSShare.LocationResp;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class atsm
  extends CommonObserver
{
  public void onGetPoiList(boolean paramBoolean, LBSShare.LocationResp paramLocationResp)
  {
    atsl.a(this.a, false);
    Object localObject1;
    if (paramBoolean)
    {
      atsl.a(this.a);
      localObject1 = paramLocationResp.poilist.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (LBSShare.POI)((Iterator)localObject1).next();
        localObject2 = LocationRoom.Venue.a(atsl.a(this.a).app.c(), (LBSShare.POI)localObject2);
        atsl.a(this.a).add(localObject2);
      }
      localObject1 = this.a;
      if (paramLocationResp.next.get() <= 0) {
        break label198;
      }
    }
    label198:
    for (paramBoolean = true;; paramBoolean = false)
    {
      atsl.b((atsl)localObject1, paramBoolean);
      if (QLog.isDevelopLevel()) {
        QLog.i("LocationPoiDataHelper", 4, "[venue][poi-data] onGetPoiList next: mVenueList size = " + atsl.a(this.a).size() + ", mHashMore = " + atsl.a(this.a));
      }
      if (atsl.a(this.a) != null) {
        ThreadManager.getUIHandler().post(new LocationPoiDataHelper.1.1(this));
      }
      return;
    }
  }
  
  public void onGetStreetUrl(boolean paramBoolean, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atsm
 * JD-Core Version:    0.7.0.1
 */