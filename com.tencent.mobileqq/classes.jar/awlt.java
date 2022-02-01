import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.FaceDecoder;
import com.tencent.mobileqq.app.face.FaceDecoder.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationShareController.4;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.HashMap;

public class awlt
  implements FaceDecoder.DecodeTaskCompletionListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private anvi jdField_a_of_type_Anvi;
  private aofu jdField_a_of_type_Aofu;
  private awit jdField_a_of_type_Awit;
  private awiy jdField_a_of_type_Awiy = new awlu(this);
  private awiz jdField_a_of_type_Awiz;
  private awjs jdField_a_of_type_Awjs;
  private awmd jdField_a_of_type_Awmd;
  private awmj jdField_a_of_type_Awmj;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FaceDecoder.DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener;
  private FaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, awmc> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public awlt(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awiz = awiz.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = ContactUtils.getNick(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Awit.a() == 0)
    {
      paramString = ((anvk)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).e(paramString);
      if (paramString == null) {
        break label99;
      }
      paramString = paramString.getFriendNickWithAlias();
    }
    for (;;)
    {
      return paramString;
      if (this.jdField_a_of_type_Awit.a() == 1) {
        paramString = ContactUtils.getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Awit.a(), paramString);
      } else {
        label99:
        paramString = str;
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awlx(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new awly(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder = new FaceDecoder(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    a(paramQQAppInterface, paramInt, paramString, -1);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "stopOnErrorSituationByReason: invoked. ", " uin: ", paramString, " reason: ", Integer.valueOf(paramInt2) });
    }
    awit localawit = new awit(paramInt1, paramString);
    awiz localawiz = awiz.a(paramQQAppInterface);
    localawiz.a(localawit, false);
    localawiz.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    awni.a(paramQQAppInterface, paramInt1, paramString, false);
    localawiz.b(localawit, paramInt2);
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramQQAppInterface = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if ((paramQQAppInterface == null) || (paramQQAppInterface.getCurrentAIOState() < 2)) {}
      }
    }
    try
    {
      paramQQAppInterface.refresh(131072);
      bdla.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
      return;
    }
    catch (Throwable paramQQAppInterface)
    {
      for (;;)
      {
        paramQQAppInterface.printStackTrace();
      }
    }
  }
  
  private void a(Integer paramInteger)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693705, 0).a();
      return;
    }
    int i;
    Integer localInteger;
    if (paramInteger == null)
    {
      i = 0;
      localInteger = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(i);
      if ((paramInteger == null) && (localInteger != null))
      {
        if (localInteger.intValue() != 3) {
          break label141;
        }
        bdla.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label185;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Awmd.a(localInteger.intValue());
      this.jdField_a_of_type_Awmj.b();
      this.jdField_a_of_type_Awmd.a();
      return;
      i = paramInteger.intValue();
      break;
      label141:
      if (localInteger.intValue() == 1) {
        bdla.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label185:
    paramInteger = new awmz();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, awmz paramawmz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramawmz.a);
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
      }
      e();
      return;
    }
    if (paramawmz.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Awmd.a(paramawmz, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Awmj.b();
      this.jdField_a_of_type_Awmd.a();
      return;
      this.jdField_a_of_type_Awmd.a(paramawmz);
      continue;
      this.jdField_a_of_type_Awmd.a(paramawmz);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Awmj.a(paramVenue);
    this.jdField_a_of_type_Awmd.b();
    this.jdField_a_of_type_Awmj.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anvi = new awlv(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anvi);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aofu = new awlw(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aofu);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Awmj.b();
    this.jdField_a_of_type_Awmd.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awmb(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Awit != null)
    {
      awju.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awiz.a(), this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awit.a(), this.jdField_a_of_type_Awit.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (awmc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awmc)localObject2).jdField_a_of_type_Long < 4000L) && (((awmc)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awmc)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awmc)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awmc(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awmc)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awmc)localObject1).jdField_a_of_type_Long = l;
      ((awmc)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aofu);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anvi);
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
  
  public void a(BaseActivity paramBaseActivity, awit paramawit, MapWidget paramMapWidget, awjs paramawjs, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Awjs = paramawjs;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Awit = paramawit;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Awmj = new awmj(this, paramView3);
    this.jdField_a_of_type_Awmd = new awmd(this, paramView3);
    this.b.setVisibility(8);
    LiuHaiUtils.a(paramBaseActivity);
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {}
    for (int i = DisplayUtil.dip2px(paramBaseActivity, 112.0F) + LiuHaiUtils.jdField_a_of_type_Int;; i = DisplayUtil.dip2px(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awit), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awiy);
      g();
      d();
      c();
      if (blfw.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840620);
        paramView3.setBackgroundResource(2130838911);
      }
      return;
    }
  }
  
  public void a(FaceDecoder.DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceFaceDecoder$DecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!NetworkUtil.isNetworkAvailable()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693705, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Awiz.a(this.jdField_a_of_type_Awit, paramVenue, new awlz(this, paramVenue));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, true);
  }
  
  boolean a()
  {
    return this.b.getVisibility() == 0;
  }
  
  void b()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693705, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Awiz.b(this.jdField_a_of_type_Awit, localVenue, new awma(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bheg.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    awmc localawmc = (awmc)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawmc;
    if (localawmc == null)
    {
      paramBitmap = new awmc(null);
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
 * Qualified Name:     awlt
 * JD-Core Version:    0.7.0.1
 */