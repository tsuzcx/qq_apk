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

public class avzn
  implements HttpResponseListener<BaseObject>
{
  avzn(avzm paramavzm) {}
  
  public void a(int paramInt, BaseObject paramBaseObject)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    avzm.a(this.a, false);
    Object localObject2;
    if ((paramBaseObject instanceof Geo2AddressResultObject))
    {
      paramBaseObject = (Geo2AddressResultObject)paramBaseObject;
      if ((paramBaseObject.result != null) && (paramBaseObject.result.pois != null))
      {
        avzm.a(this.a);
        localObject1 = paramBaseObject.result.pois.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (Poi)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(avzm.a(this.a).app.c(), (Poi)localObject2);
          avzm.a(this.a).add(localObject2);
        }
        localObject1 = this.a;
        if (paramBaseObject.result.poi_count < 20) {
          break label235;
        }
        bool1 = true;
        avzm.b((avzm)localObject1, bool1);
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
            QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onSuccess: mVenueList size = " + avzm.a(this.a).size() + ", mHashMore = " + avzm.a(this.a));
          }
          if (avzm.a(this.a) != null) {
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
        avzm.a(this.a);
        localObject1 = paramBaseObject.data.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (SuggestionResultObject.SuggestionData)((Iterator)localObject1).next();
          localObject2 = LocationRoom.Venue.a(avzm.a(this.a).app.c(), (SuggestionResultObject.SuggestionData)localObject2);
          avzm.a(this.a).add(localObject2);
        }
        localObject1 = this.a;
        if (paramBaseObject.count >= 20) {}
        for (;;)
        {
          avzm.b((avzm)localObject1, bool1);
          break;
          bool1 = false;
        }
      } while (!(paramBaseObject instanceof SearchResultObject));
      paramBaseObject = (SearchResultObject)paramBaseObject;
    } while (paramBaseObject.data == null);
    avzm.a(this.a);
    Object localObject1 = paramBaseObject.data.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (SearchResultObject.SearchResultData)((Iterator)localObject1).next();
      localObject2 = LocationRoom.Venue.a(avzm.a(this.a).app.c(), (SearchResultObject.SearchResultData)localObject2);
      avzm.a(this.a).add(localObject2);
    }
    localObject1 = this.a;
    if (paramBaseObject.count >= 20) {}
    for (bool1 = bool2;; bool1 = false)
    {
      avzm.b((avzm)localObject1, bool1);
      break;
    }
  }
  
  public void onFailure(int paramInt, String paramString, Throwable paramThrowable)
  {
    avzm.a(this.a, false);
    if (QLog.isDevelopLevel()) {
      QLog.i("LocationPoiDataFromMapHelper", 4, "[venue][poi-data] fetch onFailure: mVenueList size = " + avzm.a(this.a).size() + ", mHashMore = " + avzm.a(this.a));
    }
    if (avzm.a(this.a) != null) {
      ThreadManager.getUIHandler().post(new LocationPoiDataFromMapHelper.1.2(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avzn
 * JD-Core Version:    0.7.0.1
 */