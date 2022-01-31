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
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import mqq.manager.Manager;

public class arzl
  implements Manager
{
  arzg jdField_a_of_type_Arzg;
  private arzr jdField_a_of_type_Arzr;
  private final arzt jdField_a_of_type_Arzt;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  public boolean a;
  
  public arzl(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arzr = new arzr(paramQQAppInterface);
    this.jdField_a_of_type_Arzt = new arzt(paramQQAppInterface);
    this.jdField_a_of_type_Arzg = new arzg(paramQQAppInterface);
  }
  
  public static arzl a(QQAppInterface paramQQAppInterface)
  {
    return (arzl)paramQQAppInterface.getManager(143);
  }
  
  private void a()
  {
    UiSettings localUiSettings = this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.onResume();
  }
  
  private void a(aruk paramaruk)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplicationImpl.context).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = ((FloatMapWidget)LayoutInflater.from(BaseApplicationImpl.context).inflate(2131559172, null).findViewById(2131369544));
      this.jdField_a_of_type_Arzg.a(paramaruk, (CameraPosition)localObject, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, null);
      return;
    }
  }
  
  private void a(BaseActivity paramBaseActivity, aruk paramaruk)
  {
    arza localarza = new arza();
    localarza.a(paramBaseActivity.getString(2131719602));
    localarza.b(paramBaseActivity.getString(2131690832));
    localarza.c(paramBaseActivity.getString(2131691240));
    localarza.a(new arzo(this, paramBaseActivity, paramaruk));
    localarza.b(new arzp(this));
    localarza.c(new arzq(this, localarza));
    localarza.a();
  }
  
  private boolean b(BaseActivity paramBaseActivity, aruk paramaruk)
  {
    FloatingScreenParams localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setShapeType(3).setCanMove(true).setFloatingCenterX(300).setFloatingCenterY(-680).build();
    FloatingScreenManager localFloatingScreenManager = FloatingScreenManager.getInstance();
    int i = localFloatingScreenManager.enterLocationFloatingScreen(BaseApplicationImpl.context, this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget, localFloatingScreenParams);
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "createFloatWindow: invoked. ", " result: ", Integer.valueOf(i) });
    }
    if (i == 1)
    {
      arvk.a(paramBaseActivity);
      return false;
    }
    localFloatingScreenManager.setWindowClickListener(1, new arzm(this, paramBaseActivity, paramaruk));
    return true;
  }
  
  @NonNull
  public arzr a()
  {
    return this.jdField_a_of_type_Arzr;
  }
  
  @NonNull
  public arzt a()
  {
    return this.jdField_a_of_type_Arzt;
  }
  
  @UiThread
  public void a(int paramInt)
  {
    LocationFloatWindowManager.5 local5 = new LocationFloatWindowManager.5(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local5);
  }
  
  public boolean a(BaseActivity paramBaseActivity, aruk paramaruk)
  {
    if (!AppNetConnInfo.isNetSupport()) {
      bcpw.a(BaseApplicationImpl.context, 2131694609, 0).a();
    }
    do
    {
      return false;
      a(paramaruk);
      a();
    } while (!b(paramBaseActivity, paramaruk));
    a().a(paramaruk);
    aruq.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c(paramaruk.a(), paramaruk.a());
    aryy.d();
    int i = aryy.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramaruk);
    if (i != 0) {
      axqw.b(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
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
    this.jdField_a_of_type_Arzg.a();
    if (QLog.isColorLevel()) {
      QLog.d("LocationFloatWindowManager", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_Arzr.b();
    this.jdField_a_of_type_Arzt.a();
    this.jdField_a_of_type_Arzg.a();
    a(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzl
 * JD-Core Version:    0.7.0.1
 */