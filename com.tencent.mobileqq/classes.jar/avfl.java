import com.tencent.lbssearch.httpresponse.BaseObject;
import com.tencent.lbssearch.httpresponse.HttpResponseListener;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject;
import com.tencent.lbssearch.object.result.Geo2AddressResultObject.ReverseAddressResult;
import com.tencent.lbssearch.object.result.SearchResultObject;
import com.tencent.lbssearch.object.result.SearchResultObject.SearchResultData;
import com.tencent.lbssearch.object.result.SuggestionResultObject;
import com.tencent.lbssearch.object.result.SuggestionResultObject.SuggestionData;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.1;
import com.tencent.mobileqq.location.ui.LocationPoiDataFromMapHelper.1.2;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class avfl
  implements HttpResponseListener<BaseObject>
{
  avfl(avfk paramavfk) {}
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    avfk.a(this.a, false);
    Object localObject2;
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null))
      {
        avfk.a(this.a);
        localObject1 = paramBaseObject.result.pois.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Poi)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(avfk.a(this.a).app.getCurrentUin(), (Poi)localObject2);
          avfk.a(this.a).add(localObject2);
        }
        localObject1 = this.a;
        if (paramBaseObject.result.poi_count < 20) {
          break label235;
        }
        bool1 = true;
        avfk.b((avfk)localObject1, bool1);
      }
    }
    label235:
    label368:
    do
    {
      do
      {
        do
        {
          if (QLog.isDevelopLevel()) {
            QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onSuccess: mVenueList size = " + avfk.a(this.a).size() + ", mHashMore = " + avfk.a(this.a));
          }
          if (avfk.a(this.a) != null) {
            ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.1(this));
          }
          return;
          bool1 = false;
          break;
          if (!(paramBaseObject instanceof SuggestionResultObject)) {
            break label368;
          }
          paramBaseObject = (SuggestionResultObject)paramBaseObject;
        } while (paramBaseObject.data == null);
        avfk.a(this.a);
        localObject1 = paramBaseObject.data.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SuggestionResultObject.SuggestionData)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(avfk.a(this.a).app.getCurrentUin(), (SuggestionResultObject.SuggestionData)localObject2);
          avfk.a(this.a).add(localObject2);
        }
        localObject1 = this.a;
        if (paramBaseObject.count >= 20) {}
        for (;;)
        {
          avfk.b((avfk)localObject1, bool1);
          break;
          bool1 = false;
        }
      } while (!(paramBaseObject instanceof SearchResultObject));
      paramBaseObject = (SearchResultObject)paramBaseObject;
    } while (paramBaseObject.data == null);
    avfk.a(this.a);
    Object localObject1 = paramBaseObject.data.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SearchResultObject.SearchResultData)((Iterator)localObject1).next();
      localObject2 = LocationRoom.Venue.a(avfk.a(this.a).app.getCurrentUin(), (SearchResultObject.SearchResultData)localObject2);
      avfk.a(this.a).add(localObject2);
    }
    localObject1 = this.a;
    if (paramBaseObject.count >= 20) {}
    for (bool1 = bool2;; bool1 = false)
    {
      avfk.b((avfk)localObject1, bool1);
      break;
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    avfk.a(this.a, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + avfk.a(this.a).size() + ", mHashMore = " + avfk.a(this.a));
    }
    if (avfk.a(this.a) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avfl
 * JD-Core Version:    0.7.0.1
 */