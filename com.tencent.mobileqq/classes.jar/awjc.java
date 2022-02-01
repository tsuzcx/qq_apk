import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.highway.utils.HwNetworkUtil;
import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.os.MqqHandler;

class awjc
  implements TencentLocationListener
{
  private Runnable jdField_b_of_type_JavaLangRunnable;
  private volatile boolean jdField_b_of_type_Boolean = true;
  private volatile boolean c;
  
  awjc(awiz paramawiz, boolean paramBoolean, Runnable paramRunnable, MqqHandler paramMqqHandler, LocationRoom paramLocationRoom)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (paramBoolean = bool;; paramBoolean = false)
    {
      this.c = paramBoolean;
      this.jdField_b_of_type_JavaLangRunnable = this.jdField_a_of_type_JavaLangRunnable;
      return;
    }
  }
  
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramInt == 0)
    {
      LatLng localLatLng = new LatLng(paramTencentLocation.getLatitude(), paramTencentLocation.getLongitude());
      paramTencentLocation = localLatLng;
      if (QLog.isColorLevel())
      {
        paramTencentLocation = localLatLng;
        if (awiz.a != null) {
          paramTencentLocation = awiz.a;
        }
      }
      if ((paramTencentLocation.getLatitude() == 0.0D) && (paramTencentLocation.getLongitude() == 0.0D))
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          QLog.e("LocationHandler", 1, "[LocationManager] onLocationChanged: invoked. (0,0) detected");
        }
        return;
      }
      awiz.a(this.jdField_a_of_type_Awiz, paramTencentLocation);
    }
    if ((this.c) && (this.jdField_b_of_type_JavaLangRunnable != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. remove over time runnable");
      }
      this.jdField_a_of_type_MqqOsMqqHandler.removeCallbacks(this.jdField_b_of_type_JavaLangRunnable);
      this.jdField_b_of_type_JavaLangRunnable = null;
    }
    if (paramInt != 0)
    {
      paramTencentLocation = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom.a();
      awlt.a(this.jdField_a_of_type_Awiz.app, paramTencentLocation.a(), paramTencentLocation.a(), 1);
    }
    for (;;)
    {
      if ((paramInt == 0) || (HwNetworkUtil.isNetworkAvailable(BaseApplicationImpl.getContext()))) {
        MagnifierSDK.a().a().a("requestSoso", new Object[] { Integer.valueOf(-1), Boolean.valueOf(false), "LocationHandler", Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) });
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("LocationHandler", 2, "[LocationManager] onLocationChanged: invoked. errorCode: " + paramInt + " errorMsg: " + paramString);
      return;
      if (this.c)
      {
        this.c = false;
        this.jdField_a_of_type_Awiz.a(awiz.a(this.jdField_a_of_type_Awiz).a(), awiz.a(this.jdField_a_of_type_Awiz).a());
      }
      awiz.a(this.jdField_a_of_type_Awiz, true);
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awjc
 * JD-Core Version:    0.7.0.1
 */