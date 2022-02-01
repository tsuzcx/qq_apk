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
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationPickController.3;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.location.ui.PoiSlideBottomPanel;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class awkt
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private awit jdField_a_of_type_Awit;
  private awiy jdField_a_of_type_Awiy = new awku(this);
  private awiz jdField_a_of_type_Awiz;
  private awkp jdField_a_of_type_Awkp;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new awkv(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LocationPickController.3(this);
  private HashMap<String, awla> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean = true;
  private View b;
  private View c;
  
  public awkt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Awiz = awiz.a(paramQQAppInterface);
  }
  
  private void a(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131366280);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awky(this, paramActivity, localEditText));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new awkz(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
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
    LocationRoom.Venue localVenue = this.jdField_a_of_type_Awkp.a();
    if (localVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, true);
    int i = this.jdField_a_of_type_Awkp.a();
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
    Object localObject2 = (awla)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awla)localObject2).jdField_a_of_type_Long < 4000L) && (((awla)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awla)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awla)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awla(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awla)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awla)localObject1).jdField_a_of_type_Long = l;
      ((awla)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_Awkp.a();
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
      this.jdField_a_of_type_Awiz.b(this.jdField_a_of_type_Awiy);
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
  
  public void a(Activity paramActivity, awit paramawit, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = ((BaseActivity)paramActivity);
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = paramPoiSlideBottomPanel;
    this.c = paramView3;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Awit = paramawit;
    this.jdField_a_of_type_Awkp = new awkp(paramActivity);
    this.jdField_a_of_type_Awkp.a(new awkw(this));
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.jdField_a_of_type_Awkp);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    paramXListView.setOnItemClickListener(new awkx(this, paramPoiSlideBottomPanel));
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {}
    for (int i = DisplayUtil.dip2px(paramActivity, 54.0F) + LiuHaiUtils.jdField_a_of_type_Int;; i = DisplayUtil.dip2px(paramActivity, 54.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramActivity, this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awit), paramCameraPosition, i, paramPoiSlideBottomPanel);
      a(paramActivity);
      this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awiy);
      if (blfw.a()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840620);
      }
      return;
    }
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Awkp.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getMap(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramString);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_Awkp.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bheg.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    awla localawla = (awla)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawla;
    if (localawla == null)
    {
      paramBitmap = new awla(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awkt
 * JD-Core Version:    0.7.0.1
 */