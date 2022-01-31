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

public class atqj
  implements Manager
{
  atqe jdField_a_of_type_Atqe;
  private atqp jdField_a_of_type_Atqp;
  private final atqr jdField_a_of_type_Atqr;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  public boolean a;
  
  public atqj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atqp = new atqp(paramQQAppInterface);
    this.jdField_a_of_type_Atqr = new atqr(paramQQAppInterface);
    this.jdField_a_of_type_Atqe = new atqe(paramQQAppInterface);
  }
  
  public static atqj a(QQAppInterface paramQQAppInterface)
  {
    return (atqj)paramQQAppInterface.getManager(143);
  }
  
  private void a()
  {
    UiSettings localUiSettings = this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onResume();
  }
  
  private void a(atlh paramatlh)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplicationImpl.context).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = ((FloatMapWidget)LayoutInflater.from(BaseApplicationImpl.context).inflate(2131559215, null).findViewById(2131369805));
      this.jdField_a_of_type_Atqe.a(paramatlh, (CameraPosition)localObject, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, null);
      return;
    }
  }
  
  private void a(BaseActivity paramBaseActivity, atlh paramatlh)
  {
    atpy localatpy = new atpy();
    localatpy.a(paramBaseActivity.getString(2131720145));
    localatpy.b(paramBaseActivity.getString(2131690884));
    localatpy.c(paramBaseActivity.getString(2131691293));
    localatpy.a(new atqm(this, paramBaseActivity, paramatlh));
    localatpy.b(new atqn(this));
    localatpy.c(new atqo(this, localatpy));
    localatpy.a();
  }
  
  private boolean b(BaseActivity paramBaseActivity, atlh paramatlh)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setFloatingCenterX(300).setFloatingCenterY(-680).build();
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    int i = localFloatingScreenManager.enterLocationFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, localFloatingScreenParams);
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      atmi.a(paramBaseActivity);
      return false;
    }
    localFloatingScreenManager.setWindowClickListener(1, new atqk(this, paramBaseActivity, paramatlh));
    return true;
  }
  
  @NonNull
  public atqp a()
  {
    return this.jdField_a_of_type_Atqp;
  }
  
  @NonNull
  public atqr a()
  {
    return this.jdField_a_of_type_Atqr;
  }
  
  @UiThread
  public void a(int paramInt)
  {
    LocationFloatWindowManager.5 local5 = new LocationFloatWindowManager.5(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local5);
  }
  
  public boolean a(BaseActivity paramBaseActivity, atlh paramatlh)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      QQToast.a(BaseApplicationImpl.context, 2131694766, 0).a();
    }
    do
    {
      return false;
      a(paramatlh);
      a();
    } while (!b(paramBaseActivity, paramatlh));
    a().a(paramatlh);
    atln.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramatlh.a(), paramatlh.a());
    atpw.d();
    int i = atpw.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramatlh);
    if (i != 0) {
      azmj.b(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
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
    this.jdField_a_of_type_Atqe.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Atqp.b();
    this.jdField_a_of_type_Atqr.a();
    this.jdField_a_of_type_Atqe.a();
    a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqj
 * JD-Core Version:    0.7.0.1
 */