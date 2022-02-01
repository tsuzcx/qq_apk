import android.app.Activity;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.ui.LocationShareController.4;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.util.LiuHaiUtils;
import java.util.HashMap;

public class awsk
  implements aoog
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private anyu jdField_a_of_type_Anyu;
  private aojs jdField_a_of_type_Aojs;
  private aoof jdField_a_of_type_Aoof;
  private aoog jdField_a_of_type_Aoog;
  private awpk jdField_a_of_type_Awpk;
  private awpp jdField_a_of_type_Awpp = new awsl(this);
  private awpq jdField_a_of_type_Awpq;
  private awqj jdField_a_of_type_Awqj;
  private awsu jdField_a_of_type_Awsu;
  private awta jdField_a_of_type_Awta;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, awst> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public awsk(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Awpq = awpq.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = bhlg.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Awpk.a() == 0) {
      str = ((anyw)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_Awpk.a() == 1) {
        str = bhlg.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Awpk.a(), paramString);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new awso(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new awsp(this, paramActivity));
    this.jdField_a_of_type_Aoof = new aoof(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Aoof.a(this);
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
    awpk localawpk = new awpk(paramInt1, paramString);
    awpq localawpq = awpq.a(paramQQAppInterface);
    localawpq.a(localawpk, false);
    localawpq.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    awtz.a(paramQQAppInterface, paramInt1, paramString, false);
    localawpq.b(localawpk, paramInt2);
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramQQAppInterface = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if ((paramQQAppInterface == null) || (paramQQAppInterface.h() < 2)) {}
      }
    }
    try
    {
      paramQQAppInterface.f(131072);
      bdll.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
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
    if (!bhnv.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693429, 0).a();
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
        bdll.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label185;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Awsu.a(localInteger.intValue());
      this.jdField_a_of_type_Awta.b();
      this.jdField_a_of_type_Awsu.a();
      return;
      i = paramInteger.intValue();
      break;
      label141:
      if (localInteger.intValue() == 1) {
        bdll.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label185:
    paramInteger = new awtq();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, awtq paramawtq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramawtq.a);
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
    if (paramawtq.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Awsu.a(paramawtq, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Awta.b();
      this.jdField_a_of_type_Awsu.a();
      return;
      this.jdField_a_of_type_Awsu.a(paramawtq);
      continue;
      this.jdField_a_of_type_Awsu.a(paramawtq);
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
    this.jdField_a_of_type_Awta.a(paramVenue);
    this.jdField_a_of_type_Awsu.b();
    this.jdField_a_of_type_Awta.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Anyu = new awsm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Anyu);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Aojs = new awsn(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Aojs);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Awta.b();
    this.jdField_a_of_type_Awsu.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new awss(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Awpk != null)
    {
      awql.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Awpq.a(), this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awpk.a(), this.jdField_a_of_type_Awpk.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (awst)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((awst)localObject2).jdField_a_of_type_Long < 4000L) && (((awst)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((awst)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((awst)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new awst(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((awst)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Aoof.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Aoof.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((awst)localObject1).jdField_a_of_type_Long = l;
      ((awst)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Aojs);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Anyu);
      if (this.jdField_a_of_type_Aoof != null) {
        this.jdField_a_of_type_Aoof.d();
      }
      this.jdField_a_of_type_Awpq.b(this.jdField_a_of_type_Awpp);
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
  
  public void a(aoog paramaoog)
  {
    this.jdField_a_of_type_Aoog = paramaoog;
  }
  
  public void a(BaseActivity paramBaseActivity, awpk paramawpk, MapWidget paramMapWidget, awqj paramawqj, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Awqj = paramawqj;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Awpk = paramawpk;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Awta = new awta(this, paramView3);
    this.jdField_a_of_type_Awsu = new awsu(this, paramView3);
    this.b.setVisibility(8);
    LiuHaiUtils.a(paramBaseActivity);
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {}
    for (int i = bhgr.a(paramBaseActivity, 112.0F) + LiuHaiUtils.jdField_a_of_type_Int;; i = bhgr.a(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpk), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpp);
      g();
      d();
      c();
      if (blqj.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840546);
        paramView3.setBackgroundResource(2130838778);
      }
      return;
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!bhnv.a()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693429, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Awpq.a(this.jdField_a_of_type_Awpk, paramVenue, new awsq(this, paramVenue));
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
    if (!bhnv.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131693429, 0).a();
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
    this.jdField_a_of_type_Awpq.b(this.jdField_a_of_type_Awpk, localVenue, new awsr(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bhmq.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    awst localawst = (awst)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localawst;
    if (localawst == null)
    {
      paramBitmap = new awst(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Aoog != null) {
      this.jdField_a_of_type_Aoog.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awsk
 * JD-Core Version:    0.7.0.1
 */