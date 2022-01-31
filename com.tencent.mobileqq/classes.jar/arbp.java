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

public class arbp
  implements azwh
{
  private ajjh jdField_a_of_type_Ajjh;
  private ajuc jdField_a_of_type_Ajuc;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private aqyw jdField_a_of_type_Aqyw;
  private aqzb jdField_a_of_type_Aqzb = new arbq(this);
  private aqzc jdField_a_of_type_Aqzc;
  private aqzu jdField_a_of_type_Aqzu;
  private arbz jdField_a_of_type_Arbz;
  private arcf jdField_a_of_type_Arcf;
  private azwg jdField_a_of_type_Azwg;
  private azwh jdField_a_of_type_Azwh;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, arby> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public arbp(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Aqzc = aqzc.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = babh.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Aqyw.a() == 0) {
      str = ((ajjj)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_Aqyw.a() == 1) {
        str = babh.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Aqyw.a(), paramString);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new arbt(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new arbu(this, paramActivity));
    this.jdField_a_of_type_Azwg = new azwg(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Azwg.a(this);
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
    aqyw localaqyw = new aqyw(paramInt1, paramString);
    aqzc localaqzc = aqzc.a(paramQQAppInterface);
    localaqzc.a(localaqyw, false);
    localaqzc.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    arde.a(paramQQAppInterface, paramInt1, paramString, false);
    localaqzc.b(localaqyw, paramInt2);
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
      awqx.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
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
    if (!badq.a())
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628369, 0).a();
      return;
    }
    int i;
    Integer localInteger;
    if (paramInteger == null)
    {
      i = 0;
      localInteger = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(i);
      if (paramInteger == null)
      {
        if (localInteger.intValue() != 3) {
          break label137;
        }
        awqx.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label181;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arbz.a(localInteger.intValue());
      this.jdField_a_of_type_Arcf.b();
      this.jdField_a_of_type_Arbz.a();
      return;
      i = paramInteger.intValue();
      break;
      label137:
      if (localInteger.intValue() == 1) {
        awqx.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label181:
    paramInteger = new arcv();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, arcv paramarcv)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramarcv.a);
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
    if (paramarcv.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Arbz.a(paramarcv, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arcf.b();
      this.jdField_a_of_type_Arbz.a();
      return;
      this.jdField_a_of_type_Arbz.a(paramarcv);
      continue;
      this.jdField_a_of_type_Arbz.a(paramarcv);
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Arcf.a(paramVenue);
    this.jdField_a_of_type_Arbz.b();
    this.jdField_a_of_type_Arcf.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajjh = new arbr(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajjh);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Ajuc = new arbs(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajuc);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Arcf.b();
    this.jdField_a_of_type_Arbz.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new arbx(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Aqyw != null)
    {
      aqzw.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Aqzc.a(), this.jdField_a_of_type_Aqyw.a(), this.jdField_a_of_type_Aqyw.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Aqyw.a(), this.jdField_a_of_type_Aqyw.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (arby)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((arby)localObject2).jdField_a_of_type_Long < 4000L) && (((arby)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((arby)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((arby)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new arby(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((arby)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Azwg.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Azwg.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((arby)localObject1).jdField_a_of_type_Long = l;
      ((arby)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajuc);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajjh);
      if (this.jdField_a_of_type_Azwg != null) {
        this.jdField_a_of_type_Azwg.d();
      }
      this.jdField_a_of_type_Aqzc.b(this.jdField_a_of_type_Aqzb);
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
  
  public void a(azwh paramazwh)
  {
    this.jdField_a_of_type_Azwh = paramazwh;
  }
  
  public void a(BaseActivity paramBaseActivity, aqyw paramaqyw, MapWidget paramMapWidget, aqzu paramaqzu, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Aqzu = paramaqzu;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Aqyw = paramaqyw;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Arcf = new arcf(this, paramView3);
    this.jdField_a_of_type_Arbz = new arbz(this, paramView3);
    this.b.setVisibility(8);
    bjeh.a(paramBaseActivity);
    if (bjeh.jdField_a_of_type_Boolean) {}
    for (int i = azvv.a(paramBaseActivity, 112.0F) + bjeh.jdField_a_of_type_Int;; i = azvv.a(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Aqzc.a(this.jdField_a_of_type_Aqyw), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Aqzc.a(this.jdField_a_of_type_Aqzb);
      g();
      d();
      c();
      if (beog.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840202);
        paramView3.setBackgroundResource(2130838503);
      }
      return;
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!badq.a()) {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628369, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Aqzc.a(this.jdField_a_of_type_Aqyw, paramVenue, new arbv(this, paramVenue));
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
    if (!badq.a())
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131628369, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      bbmy.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Aqzc.b(this.jdField_a_of_type_Aqyw, localVenue, new arbw(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bacm.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    arby localarby = (arby)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localarby;
    if (localarby == null)
    {
      paramBitmap = new arby(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_Azwh != null) {
      this.jdField_a_of_type_Azwh.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     arbp
 * JD-Core Version:    0.7.0.1
 */