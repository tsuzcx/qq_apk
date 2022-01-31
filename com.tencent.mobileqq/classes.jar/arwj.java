import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPickController.3;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class arwj
  implements baxz
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private arum jdField_a_of_type_Arum;
  private arur jdField_a_of_type_Arur = new arwk(this);
  private arus jdField_a_of_type_Arus;
  private arwf jdField_a_of_type_Arwf;
  private baxy jdField_a_of_type_Baxy;
  private baxz jdField_a_of_type_Baxz;
  private bfos jdField_a_of_type_Bfos = new arwl(this);
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LocationPickController.3(this);
  private HashMap<String, arwq> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean = true;
  private View b;
  private View c;
  
  public arwj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Arus = arus.a(paramQQAppInterface);
  }
  
  private void a(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131365763);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new arwo(this, paramActivity, localEditText));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new arwp(this, paramActivity));
    this.jdField_a_of_type_Baxy = new baxy(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Baxy.a(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.b.setEnabled(false);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    LocationRoom.Venue localVenue = this.jdField_a_of_type_Arwf.a();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, true);
    int i = this.jdField_a_of_type_Arwf.a();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.b())) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.b.setEnabled(true);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (arwq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((arwq)localObject2).jdField_a_of_type_Long < 4000L) && (((arwq)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((arwq)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((arwq)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new arwq(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((arwq)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Baxy.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Baxy.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((arwq)localObject1).jdField_a_of_type_Long = l;
      ((arwq)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_Arwf.a();
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
      this.jdField_a_of_type_Arus.b(this.jdField_a_of_type_Arur);
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
  
  public void a(Activity paramActivity, arum paramarum, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = paramPoiSlideBottomPanel;
    this.c = paramView3;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Arum = paramarum;
    this.jdField_a_of_type_Arwf = new arwf(paramActivity);
    this.jdField_a_of_type_Arwf.a(new arwm(this));
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.jdField_a_of_type_Arwf);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.jdField_a_of_type_Bfos);
    paramXListView.setOnItemClickListener(new arwn(this, paramPoiSlideBottomPanel));
    bkvi.a(paramActivity);
    if (bkvi.jdField_a_of_type_Boolean) {}
    for (int i = baxn.a(paramActivity, 54.0F) + bkvi.jdField_a_of_type_Int;; i = baxn.a(paramActivity, 54.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramActivity, this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arum), paramCameraPosition, i, paramPoiSlideBottomPanel);
      a(paramActivity);
      this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arur);
      if (bfwr.a()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840246);
      }
      return;
    }
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Arwf.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getMap(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramString);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Arwf.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bbef.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    arwq localarwq = (arwq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localarwq;
    if (localarwq == null)
    {
      paramBitmap = new arwq(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Baxz != null) {
      this.jdField_a_of_type_Baxz.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arwj
 * JD-Core Version:    0.7.0.1
 */