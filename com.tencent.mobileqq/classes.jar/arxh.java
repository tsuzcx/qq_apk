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
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class arxh
  implements baxl
{
  private ajxl jdField_a_of_type_Ajxl;
  private akim jdField_a_of_type_Akim;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aruk jdField_a_of_type_Aruk;
  private arup jdField_a_of_type_Arup = new arxi(this);
  private aruq jdField_a_of_type_Aruq;
  private arvi jdField_a_of_type_Arvi;
  private arxr jdField_a_of_type_Arxr;
  private arxx jdField_a_of_type_Arxx;
  private baxk jdField_a_of_type_Baxk;
  private baxl jdField_a_of_type_Baxl;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, arxq> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public arxh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aruq = aruq.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = bbcl.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Aruk.a() == 0) {
      str = ((ajxn)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_Aruk.a() == 1) {
        str = bbcl.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Aruk.a(), paramString);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new arxl(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new arxm(this, paramActivity));
    this.jdField_a_of_type_Baxk = new baxk(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Baxk.a(this);
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
    aruk localaruk = new aruk(paramInt1, paramString);
    aruq localaruq = aruq.a(paramQQAppInterface);
    localaruq.a(localaruk, false);
    localaruq.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    aryw.a(paramQQAppInterface, paramInt1, paramString, false);
    localaruq.b(localaruk, paramInt2);
    if ((BaseActivity.sTopActivity instanceof FragmentActivity))
    {
      paramQQAppInterface = (ChatFragment)((FragmentActivity)BaseActivity.sTopActivity).getSupportFragmentManager().findFragmentByTag(ChatFragment.class.getName());
      if (paramQQAppInterface != null)
      {
        paramQQAppInterface = paramQQAppInterface.a();
        if ((paramQQAppInterface == null) || (paramQQAppInterface.g() < 2)) {}
      }
    }
    try
    {
      paramQQAppInterface.e(131072);
      axqw.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
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
    if (!bbev.a())
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694010, 0).a();
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
        axqw.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label185;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arxr.a(localInteger.intValue());
      this.jdField_a_of_type_Arxx.b();
      this.jdField_a_of_type_Arxr.a();
      return;
      i = paramInteger.intValue();
      break;
      label141:
      if (localInteger.intValue() == 1) {
        axqw.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label185:
    paramInteger = new aryn();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, aryn paramaryn)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramaryn.a);
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
    if (paramaryn.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Arxr.a(paramaryn, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arxx.b();
      this.jdField_a_of_type_Arxr.a();
      return;
      this.jdField_a_of_type_Arxr.a(paramaryn);
      continue;
      this.jdField_a_of_type_Arxr.a(paramaryn);
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Arxx.a(paramVenue);
    this.jdField_a_of_type_Arxr.b();
    this.jdField_a_of_type_Arxx.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajxl = new arxj(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxl);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Akim = new arxk(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akim);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Arxx.b();
    this.jdField_a_of_type_Arxr.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new arxp(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Aruk != null)
    {
      arvk.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aruq.a(), this.jdField_a_of_type_Aruk.a(), this.jdField_a_of_type_Aruk.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aruk.a(), this.jdField_a_of_type_Aruk.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (arxq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((arxq)localObject2).jdField_a_of_type_Long < 4000L) && (((arxq)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((arxq)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((arxq)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new arxq(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((arxq)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Baxk.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Baxk.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((arxq)localObject1).jdField_a_of_type_Long = l;
      ((arxq)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akim);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxl);
      if (this.jdField_a_of_type_Baxk != null) {
        this.jdField_a_of_type_Baxk.d();
      }
      this.jdField_a_of_type_Aruq.b(this.jdField_a_of_type_Arup);
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
  
  public void a(baxl parambaxl)
  {
    this.jdField_a_of_type_Baxl = parambaxl;
  }
  
  public void a(BaseActivity paramBaseActivity, aruk paramaruk, MapWidget paramMapWidget, arvi paramarvi, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Arvi = paramarvi;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Aruk = paramaruk;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Arxx = new arxx(this, paramView3);
    this.jdField_a_of_type_Arxr = new arxr(this, paramView3);
    this.b.setVisibility(8);
    bkur.a(paramBaseActivity);
    if (bkur.jdField_a_of_type_Boolean) {}
    for (int i = bawz.a(paramBaseActivity, 112.0F) + bkur.jdField_a_of_type_Int;; i = bawz.a(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Aruq.a(this.jdField_a_of_type_Aruk), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Aruq.a(this.jdField_a_of_type_Arup);
      g();
      d();
      c();
      if (bfwa.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840249);
        paramView3.setBackgroundResource(2130838514);
      }
      return;
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!bbev.a()) {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694010, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Aruq.a(this.jdField_a_of_type_Aruk, paramVenue, new arxn(this, paramVenue));
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
    if (!bbev.a())
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694010, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      bcpw.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Aruq.b(this.jdField_a_of_type_Aruk, localVenue, new arxo(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bbdr.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    arxq localarxq = (arxq)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localarxq;
    if (localarxq == null)
    {
      paramBitmap = new arxq(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Baxl != null) {
      this.jdField_a_of_type_Baxl.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arxh
 * JD-Core Version:    0.7.0.1
 */