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

public class awbr
  implements aobv
{
  private aobu jdField_a_of_type_Aobu;
  private aobv jdField_a_of_type_Aobv;
  private avwp jdField_a_of_type_Avwp;
  private avwu jdField_a_of_type_Avwu = new awbs(this);
  private avwv jdField_a_of_type_Avwv;
  private awax jdField_a_of_type_Awax;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, awbv> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public awbr(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Avwv = avwv.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Aobu = new aobu((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aobu.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awbt(this);
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
      awbw localawbw = awbw.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Avwp != null) && (this.jdField_a_of_type_Avwp.equals(localawbw.a().a())))
      {
        avxq.b(localBaseActivity);
        localawbw.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Awax = new awbu(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Awax);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (awbv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awbv)localObject2).jdField_a_of_type_Long < 4000L) && (((awbv)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awbv)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awbv)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awbv(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awbv)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Aobu.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aobu.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awbv)localObject1).jdField_a_of_type_Long = l;
      ((awbv)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Aobu != null) {
        this.jdField_a_of_type_Aobu.d();
      }
      this.jdField_a_of_type_Awax = null;
      this.jdField_a_of_type_Avwv.b(this.jdField_a_of_type_Avwu);
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
  
  public void a(avwp paramavwp, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Avwp = paramavwp;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Avwv.a(this.jdField_a_of_type_Avwp), paramCameraPosition, bggq.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Avwv.a(this.jdField_a_of_type_Avwu);
    if (bkpg.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bgmo.c(paramBitmap, 16, 16);
    awbv localawbv = (awbv)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawbv;
    if (localawbv == null)
    {
      paramBitmap = new awbv(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Aobv != null) {
      this.jdField_a_of_type_Aobv.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awbr
 * JD-Core Version:    0.7.0.1
 */