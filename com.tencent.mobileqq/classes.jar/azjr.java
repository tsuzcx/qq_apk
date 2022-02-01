import android.content.Intent;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.util.WeakReference;

public class azjr
  extends apcq
{
  private static azkn jdField_a_of_type_Azkn = new azkn("weather", 1000, 3, 1);
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private WeakReference<azjt> jdField_a_of_type_MqqUtilWeakReference;
  
  public azjr(int paramInt, Intent paramIntent, azjt paramazjt)
  {
    super(0, true, true, 60000L, false, false, "official_location");
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramazjt);
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (this.jdField_a_of_type_MqqUtilWeakReference.get() == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. mCallback is null ");
      }
      return;
    }
    if ((paramSosoLbsInfo == null) || (paramInt != 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish error. errCode : " + paramInt);
      }
      ((azjt)this.jdField_a_of_type_MqqUtilWeakReference.get()).a(paramInt, 0.0D, 0.0D, "", "", this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidContentIntent);
      return;
    }
    paramSosoLbsInfo = new LatLng(paramSosoLbsInfo.a.a, paramSosoLbsInfo.a.b);
    if (QLog.isColorLevel()) {
      QLog.e("OnlineStatusWeatherLocationListener", 2, "[MovementDetector] onLocationFinish invoked. latLng : " + paramSosoLbsInfo + " errCode : " + paramInt);
    }
    try
    {
      jdField_a_of_type_Azkn.a(paramSosoLbsInfo, new azjs(this, paramSosoLbsInfo, paramInt));
      return;
    }
    catch (Throwable paramSosoLbsInfo)
    {
      QLog.e("OnlineStatusWeatherLocationListener", 1, "getPoiWithLatLngError", paramSosoLbsInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjr
 * JD-Core Version:    0.7.0.1
 */