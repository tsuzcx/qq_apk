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

public class arzi
  implements baxz
{
  private arum jdField_a_of_type_Arum;
  private arur jdField_a_of_type_Arur = new arzj(this);
  private arus jdField_a_of_type_Arus;
  private aryo jdField_a_of_type_Aryo;
  private baxy jdField_a_of_type_Baxy;
  private baxz jdField_a_of_type_Baxz;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, arzm> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public arzi(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Arus = arus.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Baxy = new baxy((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Baxy.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new arzk(this);
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
      arzn localarzn = arzn.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Arum != null) && (this.jdField_a_of_type_Arum.equals(localarzn.a().a())))
      {
        arvm.b(localBaseActivity);
        localarzn.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Aryo = new arzl(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Aryo);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (arzm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((arzm)localObject2).jdField_a_of_type_Long < 4000L) && (((arzm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((arzm)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((arzm)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new arzm(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((arzm)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Baxy.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Baxy.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((arzm)localObject1).jdField_a_of_type_Long = l;
      ((arzm)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Baxy != null) {
        this.jdField_a_of_type_Baxy.d();
      }
      this.jdField_a_of_type_Aryo = null;
      this.jdField_a_of_type_Arus.b(this.jdField_a_of_type_Arur);
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
  
  public void a(arum paramarum, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Arum = paramarum;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arum), paramCameraPosition, baxn.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arur);
    if (bfwr.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bbef.c(paramBitmap, 16, 16);
    arzm localarzm = (arzm)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localarzm;
    if (localarzm == null)
    {
      paramBitmap = new arzm(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Baxz != null) {
      this.jdField_a_of_type_Baxz.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arzi
 * JD-Core Version:    0.7.0.1
 */