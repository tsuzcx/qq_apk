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
import java.util.HashMap;

public class atof
  implements bcwt
{
  private alox jdField_a_of_type_Alox;
  private amab jdField_a_of_type_Amab;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private atlh jdField_a_of_type_Atlh;
  private atlm jdField_a_of_type_Atlm = new atog(this);
  private atln jdField_a_of_type_Atln;
  private atmg jdField_a_of_type_Atmg;
  private atop jdField_a_of_type_Atop;
  private atov jdField_a_of_type_Atov;
  private bcws jdField_a_of_type_Bcws;
  private bcwt jdField_a_of_type_Bcwt;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, atoo> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public atof(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Atln = atln.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = bdbt.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Atlh.a() == 0) {
      str = ((aloz)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_Atlh.a() == 1) {
        str = bdbt.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Atlh.a(), paramString);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new atoj(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new atok(this, paramActivity));
    this.jdField_a_of_type_Bcws = new bcws(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Bcws.a(this);
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
    atlh localatlh = new atlh(paramInt1, paramString);
    atln localatln = atln.a(paramQQAppInterface);
    localatln.a(localatlh, false);
    localatln.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    atpu.a(paramQQAppInterface, paramInt1, paramString, false);
    localatln.b(localatlh, paramInt2);
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
      azmj.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
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
    if (!bdee.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694127, 0).a();
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
        azmj.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label185;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Atop.a(localInteger.intValue());
      this.jdField_a_of_type_Atov.b();
      this.jdField_a_of_type_Atop.a();
      return;
      i = paramInteger.intValue();
      break;
      label141:
      if (localInteger.intValue() == 1) {
        azmj.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label185:
    paramInteger = new atpl();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, atpl paramatpl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramatpl.a);
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
    if (paramatpl.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Atop.a(paramatpl, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Atov.b();
      this.jdField_a_of_type_Atop.a();
      return;
      this.jdField_a_of_type_Atop.a(paramatpl);
      continue;
      this.jdField_a_of_type_Atop.a(paramatpl);
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
    this.jdField_a_of_type_Atov.a(paramVenue);
    this.jdField_a_of_type_Atop.b();
    this.jdField_a_of_type_Atov.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Alox = new atoh(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Alox);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Amab = new atoi(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Amab);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Atov.b();
    this.jdField_a_of_type_Atop.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new aton(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Atlh != null)
    {
      atmi.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Atln.a(), this.jdField_a_of_type_Atlh.a(), this.jdField_a_of_type_Atlh.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Atlh.a(), this.jdField_a_of_type_Atlh.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (atoo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((atoo)localObject2).jdField_a_of_type_Long < 4000L) && (((atoo)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((atoo)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((atoo)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new atoo(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((atoo)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Bcws.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Bcws.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((atoo)localObject1).jdField_a_of_type_Long = l;
      ((atoo)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Amab);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Alox);
      if (this.jdField_a_of_type_Bcws != null) {
        this.jdField_a_of_type_Bcws.d();
      }
      this.jdField_a_of_type_Atln.b(this.jdField_a_of_type_Atlm);
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
  
  public void a(bcwt parambcwt)
  {
    this.jdField_a_of_type_Bcwt = parambcwt;
  }
  
  public void a(BaseActivity paramBaseActivity, atlh paramatlh, MapWidget paramMapWidget, atmg paramatmg, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Atmg = paramatmg;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Atlh = paramatlh;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Atov = new atov(this, paramView3);
    this.jdField_a_of_type_Atop = new atop(this, paramView3);
    this.b.setVisibility(8);
    bngs.a(paramBaseActivity);
    if (bngs.jdField_a_of_type_Boolean) {}
    for (int i = bcwh.a(paramBaseActivity, 112.0F) + bngs.jdField_a_of_type_Int;; i = bcwh.a(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Atln.a(this.jdField_a_of_type_Atlh), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Atln.a(this.jdField_a_of_type_Atlm);
      g();
      d();
      c();
      if (bhxo.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840349);
        paramView3.setBackgroundResource(2130838591);
      }
      return;
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!bdee.a()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694127, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Atln.a(this.jdField_a_of_type_Atlh, paramVenue, new atol(this, paramVenue));
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
    if (!bdee.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694127, 0).a();
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
    this.jdField_a_of_type_Atln.b(this.jdField_a_of_type_Atlh, localVenue, new atom(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bdda.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    atoo localatoo = (atoo)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localatoo;
    if (localatoo == null)
    {
      paramBitmap = new atoo(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Bcwt != null) {
      this.jdField_a_of_type_Bcwt.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atof
 * JD-Core Version:    0.7.0.1
 */