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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.location.window.LocationFloatWindowManager.5;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.manager.Manager;

public class awuo
  implements Manager
{
  awuj jdField_a_of_type_Awuj;
  private awuu jdField_a_of_type_Awuu;
  private final awuw jdField_a_of_type_Awuw;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  public boolean a;
  
  public awuo(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awuu = new awuu(paramQQAppInterface);
    this.jdField_a_of_type_Awuw = new awuw(paramQQAppInterface);
    this.jdField_a_of_type_Awuj = new awuj(paramQQAppInterface);
  }
  
  public static awuo a(QQAppInterface paramQQAppInterface)
  {
    return (awuo)paramQQAppInterface.getManager(143);
  }
  
  private void a()
  {
    UiSettings localUiSettings = this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onResume();
  }
  
  private void a(awpk paramawpk)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplicationImpl.context).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = ((FloatMapWidget)LayoutInflater.from(BaseApplicationImpl.context).inflate(2131559294, null).findViewById(2131370362));
      this.jdField_a_of_type_Awuj.a(paramawpk, (CameraPosition)localObject, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, null);
      return;
    }
  }
  
  private void a(BaseActivity paramBaseActivity, awpk paramawpk)
  {
    awud localawud = new awud();
    localawud.a(paramBaseActivity.getString(2131718252));
    localawud.b(paramBaseActivity.getString(2131690728));
    localawud.c(paramBaseActivity.getString(2131691095));
    localawud.a(new awur(this, paramBaseActivity, paramawpk));
    localawud.b(new awus(this));
    localawud.c(new awut(this, localawud));
    localawud.a();
  }
  
  private boolean b(BaseActivity paramBaseActivity, awpk paramawpk)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setFloatingCenterX(300).setFloatingCenterY(-680).build();
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    int i = localFloatingScreenManager.enterLocationFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, localFloatingScreenParams);
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      awql.a(paramBaseActivity);
      return false;
    }
    localFloatingScreenManager.setWindowClickListener(1, new awup(this, paramBaseActivity, paramawpk));
    return true;
  }
  
  @NonNull
  public awuu a()
  {
    return this.jdField_a_of_type_Awuu;
  }
  
  @NonNull
  public awuw a()
  {
    return this.jdField_a_of_type_Awuw;
  }
  
  @UiThread
  public void a(int paramInt)
  {
    LocationFloatWindowManager.5 local5 = new LocationFloatWindowManager.5(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local5);
  }
  
  public boolean a(BaseActivity paramBaseActivity, awpk paramawpk)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(BaseApplicationImpl.context, 2131693965, 0).a();
    }
    do
    {
      return false;
      a(paramawpk);
      a();
    } while (!b(paramBaseActivity, paramawpk));
    a().a(paramawpk);
    awpq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramawpk.a(), paramawpk.a());
    awub.c();
    int i = awub.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramawpk);
    if (i != 0) {
      bdll.b(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
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
    this.jdField_a_of_type_Awuj.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Awuu.b();
    this.jdField_a_of_type_Awuw.a();
    this.jdField_a_of_type_Awuj.a();
    a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuo
 * JD-Core Version:    0.7.0.1
 */