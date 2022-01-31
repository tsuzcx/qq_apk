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

public class atqe
  implements bcwt
{
  private atlh jdField_a_of_type_Atlh;
  private atlm jdField_a_of_type_Atlm = new atqf(this);
  private atln jdField_a_of_type_Atln;
  private atpk jdField_a_of_type_Atpk;
  private bcws jdField_a_of_type_Bcws;
  private bcwt jdField_a_of_type_Bcwt;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, atqi> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public atqe(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atln = atln.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Bcws = new bcws((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Bcws.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new atqg(this);
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
      atqj localatqj = atqj.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Atlh != null) && (this.jdField_a_of_type_Atlh.equals(localatqj.a().a())))
      {
        atmi.b(localBaseActivity);
        localatqj.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Atpk = new atqh(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Atpk);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (atqi)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((atqi)localObject2).jdField_a_of_type_Long < 4000L) && (((atqi)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((atqi)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((atqi)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new atqi(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((atqi)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Bcws.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Bcws.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((atqi)localObject1).jdField_a_of_type_Long = l;
      ((atqi)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Bcws != null) {
        this.jdField_a_of_type_Bcws.d();
      }
      this.jdField_a_of_type_Atpk = null;
      this.jdField_a_of_type_Atln.b(this.jdField_a_of_type_Atlm);
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
  
  public void a(atlh paramatlh, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Atlh = paramatlh;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Atln.a(this.jdField_a_of_type_Atlh), paramCameraPosition, bcwh.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Atln.a(this.jdField_a_of_type_Atlm);
    if (bhxo.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bdda.c(paramBitmap, 16, 16);
    atqi localatqi = (atqi)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localatqi;
    if (localatqi == null)
    {
      paramBitmap = new atqi(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Bcwt != null) {
      this.jdField_a_of_type_Bcwt.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atqe
 * JD-Core Version:    0.7.0.1
 */