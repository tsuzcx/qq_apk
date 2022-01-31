import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.HashMap;

public class ardi
  implements azwh
{
  private aqyw jdField_a_of_type_Aqyw;
  private aqzb jdField_a_of_type_Aqzb = new ardj(this);
  private aqzc jdField_a_of_type_Aqzc;
  private arcu jdField_a_of_type_Arcu;
  private azwg jdField_a_of_type_Azwg;
  private azwh jdField_a_of_type_Azwh;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, ardm> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public ardi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Aqzc = aqzc.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Azwg = new azwg((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Azwg.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ardk(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onBadNetSituation: invoked. ", " TAG: ", "LocationShareController" });
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (localBaseActivity != null)
    {
      ardn localardn = ardn.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Aqyw != null) && (this.jdField_a_of_type_Aqyw.equals(localardn.a().a())))
      {
        aqzw.b(localBaseActivity);
        localardn.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Arcu = new ardl(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Arcu);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (ardm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((ardm)localObject2).jdField_a_of_type_Long < 4000L) && (((ardm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((ardm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((ardm)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new ardm(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((ardm)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Azwg.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Azwg.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((ardm)localObject1).jdField_a_of_type_Long = l;
      ((ardm)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Azwg != null) {
        this.jdField_a_of_type_Azwg.d();
      }
      this.jdField_a_of_type_Arcu = null;
      this.jdField_a_of_type_Aqzc.b(this.jdField_a_of_type_Aqzb);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
      }
    }
  }
  
  public void a(aqyw paramaqyw, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Aqyw = paramaqyw;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Aqzc.a(this.jdField_a_of_type_Aqyw), paramCameraPosition, azvv.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Aqzc.a(this.jdField_a_of_type_Aqzb);
    if (beog.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bacm.c(paramBitmap, 16, 16);
    ardm localardm = (ardm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localardm;
    if (localardm == null)
    {
      paramBitmap = new ardm(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Azwh != null) {
      this.jdField_a_of_type_Azwh.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     ardi
 * JD-Core Version:    0.7.0.1
 */