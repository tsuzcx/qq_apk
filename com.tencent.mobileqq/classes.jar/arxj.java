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

public class arxj
  implements baxz
{
  private ajxj jdField_a_of_type_Ajxj;
  private akil jdField_a_of_type_Akil;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private arum jdField_a_of_type_Arum;
  private arur jdField_a_of_type_Arur = new arxk(this);
  private arus jdField_a_of_type_Arus;
  private arvk jdField_a_of_type_Arvk;
  private arxt jdField_a_of_type_Arxt;
  private arxz jdField_a_of_type_Arxz;
  private baxy jdField_a_of_type_Baxy;
  private baxz jdField_a_of_type_Baxz;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, arxs> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  public arxj(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Arus = arus.a(paramQQAppInterface);
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    String str = bbcz.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, paramString, 0);
    if (this.jdField_a_of_type_Arum.a() == 0) {
      str = ((ajxl)this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app.getManager(51)).e(paramString).getFriendNickWithAlias();
    }
    for (;;)
    {
      return str;
      if (this.jdField_a_of_type_Arum.a() == 1) {
        str = bbcz.h(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.app, this.jdField_a_of_type_Arum.a(), paramString);
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new arxn(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new arxo(this, paramActivity));
    this.jdField_a_of_type_Baxy = new baxy(paramActivity, (AppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.jdField_a_of_type_Baxy.a(this);
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
    arum localarum = new arum(paramInt1, paramString);
    arus localarus = arus.a(paramQQAppInterface);
    localarus.a(localarum, false);
    localarus.a.b();
    ThreadManager.excute(new LocationShareController.4(paramQQAppInterface, paramInt1, paramString), 32, null, false);
    aryy.a(paramQQAppInterface, paramInt1, paramString, false);
    localarus.b(localarum, paramInt2);
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
      axqy.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
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
    if (!bbfj.a())
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694011, 0).a();
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
        axqy.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label185;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arxt.a(localInteger.intValue());
      this.jdField_a_of_type_Arxz.b();
      this.jdField_a_of_type_Arxt.a();
      return;
      i = paramInteger.intValue();
      break;
      label141:
      if (localInteger.intValue() == 1) {
        axqy.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label185:
    paramInteger = new aryp();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, aryp paramaryp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramaryp.a);
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
    if (paramaryp.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_Arxt.a(paramaryp, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_Arxz.b();
      this.jdField_a_of_type_Arxt.a();
      return;
      this.jdField_a_of_type_Arxt.a(paramaryp);
      continue;
      this.jdField_a_of_type_Arxt.a(paramaryp);
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_Arxz.a(paramVenue);
    this.jdField_a_of_type_Arxt.b();
    this.jdField_a_of_type_Arxz.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_Ajxj = new arxl(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Ajxj);
  }
  
  private void d()
  {
    this.jdField_a_of_type_Akil = new arxm(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_Akil);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_Arxz.b();
    this.jdField_a_of_type_Arxt.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new arxr(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Arum != null)
    {
      arvm.b(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_Arus.a(), this.jdField_a_of_type_Arum.a(), this.jdField_a_of_type_Arum.a());
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Arum.a(), this.jdField_a_of_type_Arum.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (arxs)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((arxs)localObject2).jdField_a_of_type_Long < 4000L) && (((arxs)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((arxs)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((arxs)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new arxs(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((arxs)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_Baxy.a(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_Baxy.a(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((arxs)localObject1).jdField_a_of_type_Long = l;
      ((arxs)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Akil);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_Ajxj);
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
  
  public void a(baxz parambaxz)
  {
    this.jdField_a_of_type_Baxz = parambaxz;
  }
  
  public void a(BaseActivity paramBaseActivity, arum paramarum, MapWidget paramMapWidget, arvk paramarvk, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_Arvk = paramarvk;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_Arum = paramarum;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_Arxz = new arxz(this, paramView3);
    this.jdField_a_of_type_Arxt = new arxt(this, paramView3);
    this.b.setVisibility(8);
    bkvi.a(paramBaseActivity);
    if (bkvi.jdField_a_of_type_Boolean) {}
    for (int i = baxn.a(paramBaseActivity, 112.0F) + bkvi.jdField_a_of_type_Int;; i = baxn.a(paramBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramBaseActivity, this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arum), null, i, paramView3);
      a(paramBaseActivity);
      this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arur);
      g();
      d();
      c();
      if (bfwr.a())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840246);
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
    if (!bbfj.a()) {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694011, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Arus.a(this.jdField_a_of_type_Arum, paramVenue, new arxp(this, paramVenue));
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
    if (!bbfj.a())
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2131694011, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      bcql.a(this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.b.setVisibility(0);
    this.jdField_a_of_type_Arus.b(this.jdField_a_of_type_Arum, localVenue, new arxq(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = bbef.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    arxs localarxs = (arxs)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localarxs;
    if (localarxs == null)
    {
      paramBitmap = new arxs(null);
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
 * Qualified Name:     arxj
 * JD-Core Version:    0.7.0.1
 */