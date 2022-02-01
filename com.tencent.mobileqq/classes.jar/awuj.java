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

public class awuj
  implements aoog
{
  private aoof jdField_a_of_type_Aoof;
  private aoog jdField_a_of_type_Aoog;
  private awpk jdField_a_of_type_Awpk;
  private awpp jdField_a_of_type_Awpp = new awuk(this);
  private awpq jdField_a_of_type_Awpq;
  private awtp jdField_a_of_type_Awtp;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, awun> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public awuj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awpq = awpq.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Aoof = new aoof((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aoof.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awul(this);
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
      awuo localawuo = awuo.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Awpk != null) && (this.jdField_a_of_type_Awpk.equals(localawuo.a().a())))
      {
        awql.b(localBaseActivity);
        localawuo.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Awtp = new awum(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Awtp);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (awun)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awun)localObject2).jdField_a_of_type_Long < 4000L) && (((awun)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awun)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awun)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awun(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awun)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Aoof.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aoof.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awun)localObject1).jdField_a_of_type_Long = l;
      ((awun)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Aoof != null) {
        this.jdField_a_of_type_Aoof.d();
      }
      this.jdField_a_of_type_Awtp = null;
      this.jdField_a_of_type_Awpq.b(this.jdField_a_of_type_Awpp);
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
  
  public void a(awpk paramawpk, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Awpk = paramawpk;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpk), paramCameraPosition, bhgr.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpp);
    if (blqj.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bhmq.c(paramBitmap, 16, 16);
    awun localawun = (awun)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawun;
    if (localawun == null)
    {
      paramBitmap = new awun(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Aoog != null) {
      this.jdField_a_of_type_Aoog.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awuj
 * JD-Core Version:    0.7.0.1
 */