import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.HashMap;

public class awns
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private awit jdField_a_of_type_Awit;
  private awiy jdField_a_of_type_Awiy = new awnt(this);
  private awiz jdField_a_of_type_Awiz;
  private awmy jdField_a_of_type_Awmy;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, awnw> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public awns(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awiz = awiz.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awnu(this);
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
      awnx localawnx = awnx.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Awit != null) && (this.jdField_a_of_type_Awit.equals(localawnx.a().a())))
      {
        awju.b(localBaseActivity);
        localawnx.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Awmy = new awnv(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Awmy);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (awnw)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awnw)localObject2).jdField_a_of_type_Long < 4000L) && (((awnw)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awnw)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awnw)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awnw(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awnw)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awnw)localObject1).jdField_a_of_type_Long = l;
      ((awnw)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.destory();
      }
      this.jdField_a_of_type_Awmy = null;
      this.jdField_a_of_type_Awiz.b(this.jdField_a_of_type_Awiy);
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
  
  public void a(awit paramawit, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Awit = paramawit;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awit), paramCameraPosition, DisplayUtil.dip2px(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awiy);
    if (blfw.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bheg.c(paramBitmap, 16, 16);
    awnw localawnw = (awnw)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawnw;
    if (localawnw == null)
    {
      paramBitmap = new awnw(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awns
 * JD-Core Version:    0.7.0.1
 */