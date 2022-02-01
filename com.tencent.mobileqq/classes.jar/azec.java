import com.tencent.lbssearch.httpresponse.AdInfo;
import com.tencent.lbssearch.httpresponse.Poi;
import com.tencent.mobileqq.onlinestatus.auto.location.cache.PoiBean;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.Arrays;

abstract class azec
{
  protected static String a = "Loader";
  protected final String b;
  
  azec(String paramString)
  {
    this.b = paramString;
  }
  
  protected void a(String paramString, PoiBean paramPoiBean)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null) && (paramPoiBean.poiArray.length > 0)) {
        break label99;
      }
      localObject = a;
      localStringBuilder = new StringBuilder().append("[status][poiLoader][").append(this.b).append("] from: ").append(paramString).append(" result: ");
      if ((paramPoiBean != null) && (paramPoiBean.poiArray != null)) {
        break label93;
      }
    }
    label93:
    for (paramString = "null";; paramString = "0")
    {
      QLog.d((String)localObject, 2, paramString);
      return;
    }
    label99:
    QLog.d(a, 2, "[status][poiLoader][" + this.b + "] from: " + paramString + " result: " + Arrays.toString(paramPoiBean.poiArray) + " size: " + paramPoiBean.poiArray.length);
    Object localObject = paramPoiBean.poiArray[0];
    QLog.d(a, 2, "[status][poiLoader][" + this.b + "] from: " + paramString + " first poi: " + ((Poi)localObject).title + "-" + ((Poi)localObject).category + "-" + ((Poi)localObject)._distance);
    if (paramPoiBean.poiArray.length >= 2)
    {
      localObject = paramPoiBean.poiArray[1];
      QLog.d(a, 2, "[status][poiLoader][" + this.b + "] from: " + paramString + " second poi: " + ((Poi)localObject).title + "-" + ((Poi)localObject).category + "-" + ((Poi)localObject)._distance);
    }
    QLog.d(a, 2, "[status][poiLoader][" + this.b + "] from: " + paramString + " result: " + Arrays.toString(paramPoiBean.poiArray) + " adInfoCity: " + paramPoiBean.adInfo.city + " adInfoDistrict: " + paramPoiBean.adInfo.district);
  }
  
  protected boolean a(LatLng paramLatLng1, LatLng paramLatLng2, int paramInt)
  {
    if ((paramLatLng1 == null) || (paramLatLng2 == null)) {
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[status][poiLoader][" + this.b + "] accept? fail this.latLng: " + paramLatLng1 + " that.latLng: " + paramLatLng2);
      }
    }
    double d;
    do
    {
      return false;
      d = azdk.a(paramLatLng1, paramLatLng2);
      if (QLog.isColorLevel()) {
        QLog.d(a, 2, "[status][poiLoader][" + this.b + "] accept? this.latLng: " + paramLatLng1 + " that.latLng: " + paramLatLng2 + " distance: " + d + " acceptAccuracy: " + paramInt);
      }
    } while (d >= paramInt);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azec
 * JD-Core Version:    0.7.0.1
 */