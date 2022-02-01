import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.location.window.LocationFloatWindowManager.5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.manager.Manager;

public class awnx
  implements Manager
{
  awns jdField_a_of_type_Awns;
  private awod jdField_a_of_type_Awod;
  private final awof jdField_a_of_type_Awof;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  public boolean a;
  
  public awnx(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awod = new awod(paramQQAppInterface);
    this.jdField_a_of_type_Awof = new awof(paramQQAppInterface);
    this.jdField_a_of_type_Awns = new awns(paramQQAppInterface);
  }
  
  public static awnx a(QQAppInterface paramQQAppInterface)
  {
    return (awnx)paramQQAppInterface.getManager(QQManagerFactory.LOCATION_FLOAT_WINDOW_MANAGER);
  }
  
  private void a()
  {
    UiSettings localUiSettings = this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onResume();
  }
  
  private void a(awit paramawit)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplicationImpl.context).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = ((FloatMapWidget)LayoutInflater.from(BaseApplicationImpl.context).inflate(2131559350, null).findViewById(2131370512));
      this.jdField_a_of_type_Awns.a(paramawit, (CameraPosition)localObject, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, null);
      return;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, awit paramawit)
  {
    BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
    awnm localawnm = new awnm();
    localawnm.a(localBaseApplication.getString(2131718879));
    localawnm.b(localBaseApplication.getString(2131690845));
    localawnm.c(localBaseApplication.getString(2131691220));
    localawnm.a(new awoa(this, paramawit, paramQQAppInterface));
    localawnm.b(new awob(this));
    localawnm.c(new awoc(this, localawnm));
    localawnm.a();
  }
  
  private boolean b(BaseActivity paramBaseActivity, awit paramawit)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setCanZoom(false).setFloatingCenterX(300).setFloatingCenterY(-680).build();
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    int i = localFloatingScreenManager.enterLocationFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, localFloatingScreenParams);
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      awju.a(paramBaseActivity);
      return false;
    }
    localFloatingScreenManager.setWindowClickListener(1, new awny(this, paramawit));
    return true;
  }
  
  @NonNull
  public awod a()
  {
    return this.jdField_a_of_type_Awod;
  }
  
  @NonNull
  public awof a()
  {
    return this.jdField_a_of_type_Awof;
  }
  
  @UiThread
  public void a(int paramInt)
  {
    LocationFloatWindowManager.5 local5 = new LocationFloatWindowManager.5(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local5);
  }
  
  public boolean a(BaseActivity paramBaseActivity, awit paramawit)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(BaseApplicationImpl.context, 2131694255, 0).a();
    }
    do
    {
      return false;
      a(paramawit);
      a();
    } while (!b(paramBaseActivity, paramawit));
    a().a(paramawit);
    awiz.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramawit.a(), paramawit.a());
    awnk.c();
    int i = awnk.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawit);
    if (i != 0) {
      bdla.b(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
    }
    return true;
  }
  
  public void b(int paramInt)
  {
    try
    {
      FloatingScreenManager.getInstance().quitFloatingScreen(1);
      a().a();
      if (this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onPause();
        this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onStop();
        if ((this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap() != null) && (!this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap().isDestroyed())) {
          this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onDestroy();
        }
        this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = null;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationFloatWindowManager", 1, "quitFloat: failed. ", localException);
      }
    }
    this.jdField_a_of_type_Awns.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Awod.b();
    this.jdField_a_of_type_Awof.a();
    this.jdField_a_of_type_Awns.a();
    a(2);
    FloatingScreenManager.getInstance().setWindowClickListener(1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awnx
 * JD-Core Version:    0.7.0.1
 */