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

public class atun
  implements bdbc
{
  private atpq jdField_a_of_type_Atpq;
  private atpv jdField_a_of_type_Atpv = new atuo(this);
  private atpw jdField_a_of_type_Atpw;
  private attt jdField_a_of_type_Attt;
  private bdbb jdField_a_of_type_Bdbb;
  private bdbc jdField_a_of_type_Bdbc;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, atur> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  public atun(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Atpw = atpw.a(paramQQAppInterface);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    e();
    this.jdField_a_of_type_Bdbb = new bdbb((AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Bdbb.a(this);
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new atup(this);
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
      atus localatus = atus.a(localBaseActivity.app);
      if ((this.jdField_a_of_type_Atpq != null) && (this.jdField_a_of_type_Atpq.equals(localatus.a().a())))
      {
        atqr.b(localBaseActivity);
        localatus.a = true;
      }
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_Attt = new atuq(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_Attt);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (atur)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((atur)localObject2).jdField_a_of_type_Long < 4000L) && (((atur)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((atur)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((atur)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new atur(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((atur)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Bdbb.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Bdbb.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((atur)localObject1).jdField_a_of_type_Long = l;
      ((atur)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_Bdbb != null) {
        this.jdField_a_of_type_Bdbb.d();
      }
      this.jdField_a_of_type_Attt = null;
      this.jdField_a_of_type_Atpw.b(this.jdField_a_of_type_Atpv);
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
  
  public void a(atpq paramatpq, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_Atpq = paramatpq;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_Atpw.a(this.jdField_a_of_type_Atpq), paramCameraPosition, bdaq.a(BaseApplicationImpl.context, 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    b();
    c();
    this.jdField_a_of_type_Atpw.a(this.jdField_a_of_type_Atpv);
    if (bibv.a()) {}
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bdhj.c(paramBitmap, 16, 16);
    atur localatur = (atur)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localatur;
    if (localatur == null)
    {
      paramBitmap = new atur(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Bdbc != null) {
      this.jdField_a_of_type_Bdbc.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atun
 * JD-Core Version:    0.7.0.1
 */