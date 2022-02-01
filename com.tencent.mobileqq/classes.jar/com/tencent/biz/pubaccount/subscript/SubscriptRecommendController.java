package com.tencent.biz.pubaccount.subscript;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.Display;
import android.view.View;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver;
import com.tencent.biz.pubaccount.api.IPublicAccountObserver.OnCallback;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.HorizontalListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.List;
import mqq.os.MqqHandler;

public class SubscriptRecommendController
{
  public int a;
  public View a;
  ViewStub jdField_a_of_type_AndroidViewViewStub = null;
  ImageButton jdField_a_of_type_AndroidWidgetImageButton = null;
  private IPublicAccountObserver.OnCallback jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback = new SubscriptRecommendController.2(this);
  private IPublicAccountObserver jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  private SubscriptObserver jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver = new SubscriptRecommendController.1(this);
  SubscriptPicManager jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager;
  SubscriptRecommendAdapter jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  HorizontalListView jdField_a_of_type_ComTencentWidgetHorizontalListView;
  public WeakReference<Activity> a;
  public boolean a;
  int b = 0;
  int c = 0;
  private int d = 0;
  
  public SubscriptRecommendController(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.jdField_a_of_type_AndroidViewView = null;
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager = paramSubscriptPicManager;
    this.d = ((int)paramActivity.getResources().getDimension(2131298061));
    i();
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.3(this));
    this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.setOnCallback(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver$OnCallback);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscribe_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("subscirpt_full_recommend_url", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscribe_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, String paramString)
  {
    String str = paramQQAppInterface.getCurrentAccountUin();
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(str, 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_red_point");
    localStringBuilder.append(str);
    localEditor.putBoolean(localStringBuilder.toString(), true);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_folder_red_dot");
    localStringBuilder.append(str);
    localEditor.putBoolean(localStringBuilder.toString(), true);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_show");
    localStringBuilder.append(str);
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_msg");
    localStringBuilder.append(str);
    localEditor.putString(localStringBuilder.toString(), paramString);
    localEditor.commit();
    paramString = TroopBarAssistantManager.a();
    paramString.a(paramQQAppInterface, false);
    paramString.b(paramQQAppInterface, true);
    paramString.c(paramQQAppInterface, true);
    paramString.d(paramQQAppInterface, true);
    paramString.b(paramQQAppInterface);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscript_inner_recommend", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean a(AppInterface paramAppInterface, boolean paramBoolean, String paramString)
  {
    paramAppInterface = paramAppInterface.getApp().getSharedPreferences(paramAppInterface.getCurrentAccountUin(), 4).edit();
    paramAppInterface.putBoolean("subscript_full_recommend", paramBoolean);
    paramAppInterface.putString("subscirpt_full_recommend_url", paramString);
    return paramAppInterface.commit();
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    BaseApplication localBaseApplication = paramQQAppInterface.getApp();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    boolean bool2 = false;
    paramQQAppInterface = localBaseApplication.getSharedPreferences(paramQQAppInterface, 0);
    boolean bool1 = bool2;
    if (paramQQAppInterface.getBoolean("subscript_inner_recommend", false))
    {
      bool1 = bool2;
      if (!paramQQAppInterface.getBoolean("subscript_full_recommend", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscript_full_recommend_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static String b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_msg");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscript_full_recommend_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_red_point");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscript_full_recommend", false);
  }
  
  public static int c(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscript_inner_recommend_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscript_inner_recommend_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putInt(localStringBuilder.toString(), paramInt);
    localEditor.commit();
  }
  
  public static void c(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    SharedPreferences.Editor localEditor = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_folder_red_dot");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    localEditor.putBoolean(localStringBuilder.toString(), paramBoolean);
    localEditor.commit();
  }
  
  public static boolean c(QQAppInterface paramQQAppInterface)
  {
    Object localObject1 = paramQQAppInterface.getApp();
    Object localObject2 = paramQQAppInterface.getCurrentAccountUin();
    boolean bool2 = false;
    localObject1 = ((BaseApplication)localObject1).getSharedPreferences((String)localObject2, 0);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("is_show_subscribe_red_point");
    ((StringBuilder)localObject2).append(paramQQAppInterface.getCurrentAccountUin());
    boolean bool1 = bool2;
    if (((SharedPreferences)localObject1).getBoolean(((StringBuilder)localObject2).toString(), true))
    {
      bool1 = bool2;
      if (f(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscribe_discovery_btn", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_show");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 1) != 0;
  }
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_folder_red_dot");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  public static boolean f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscribe_discovery_btn", true);
  }
  
  private void i()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
    }
  }
  
  private void j()
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountApiIPublicAccountObserver.getBusinessObserver());
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptObserver);
    }
  }
  
  private void k()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewViewStub != null))
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() == 0)
        {
          localObject = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772241);
          ((Animation)localObject).setFillAfter(true);
          ((Animation)localObject).setAnimationListener(new SubscriptRecommendController.8(this));
          a(0);
          this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
        }
      }
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = 1;
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      if (this.jdField_a_of_type_AndroidViewViewStub == null)
      {
        localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          this.jdField_a_of_type_AndroidViewViewStub = ((ViewStub)((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131376992));
          localObject = this.jdField_a_of_type_AndroidViewViewStub;
          if (localObject != null)
          {
            ((ViewStub)localObject).setOnInflateListener(new SubscriptRecommendController.4(this));
            this.jdField_a_of_type_AndroidViewView = this.jdField_a_of_type_AndroidViewViewStub.inflate();
            b();
            h();
          }
        }
      }
      else
      {
        e();
        a(this.d);
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).findViewById(2131370110);
      if (localObject != null) {
        ((View)localObject).setPadding(0, 0, 0, paramInt);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    if (localQQAppInterface != null) {
      ((SubscriptHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER)).a(paramString);
    }
  }
  
  void a(List<SubscriptRecommendAccountInfo> paramList)
  {
    WeakReference localWeakReference = this.jdField_a_of_type_JavaLangRefWeakReference;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter == null) {
        this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter = new SubscriptRecommendAdapter((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptPicManager);
      }
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a();
      this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter.a(paramList);
    }
  }
  
  public boolean a()
  {
    Activity localActivity = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    boolean bool = false;
    if (localActivity == null) {
      return false;
    }
    View localView = localActivity.findViewById(2131366219);
    WindowManager localWindowManager = (WindowManager)localActivity.getSystemService("window");
    int i = localWindowManager.getDefaultDisplay().getWidth();
    int j = localWindowManager.getDefaultDisplay().getHeight();
    int k = (int)localActivity.getResources().getDimension(2131299168);
    int m = (int)localActivity.getResources().getDimension(2131299174);
    int n = this.d;
    int i1 = localView.getHeight();
    int i2 = localView.getWidth();
    int i3 = ImmersiveUtils.getStatusBarHeight(localActivity);
    if ((i < i2) || (j - (k + m + n) - i3 < i1)) {
      bool = true;
    }
    return bool;
  }
  
  @TargetApi(9)
  public void b()
  {
    boolean bool = ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Object localObject1 = ((Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get()).getResources();
    if (bool) {
      i = 2131166116;
    } else {
      i = 2131166106;
    }
    int i = ((Resources)localObject1).getColor(i);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
    this.jdField_a_of_type_AndroidViewView.setOnClickListener(new SubscriptRecommendController.5(this));
    Object localObject2 = (ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378091);
    if (localObject2 != null)
    {
      if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
        i = 2131167251;
      } else {
        i = 2131166391;
      }
      ((ImageView)localObject2).setBackgroundResource(i);
    }
    localObject2 = (TextView)this.jdField_a_of_type_AndroidViewView.findViewById(2131378784);
    if (bool) {
      i = 2131166105;
    } else {
      i = 2131166104;
    }
    ((TextView)localObject2).setTextColor(((Resources)localObject1).getColor(i));
    if (this.jdField_a_of_type_ComTencentWidgetHorizontalListView == null)
    {
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView = ((HorizontalListView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376987));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setDividerWidth((int)((Resources)localObject1).getDimension(2131298062));
      this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter);
      if (Build.VERSION.SDK_INT >= 9) {
        this.jdField_a_of_type_ComTencentWidgetHorizontalListView.setOverScrollMode(2);
      }
    }
    if (this.jdField_a_of_type_AndroidWidgetImageButton == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageButton = ((ImageButton)this.jdField_a_of_type_AndroidViewView.findViewById(2131364703));
      localObject1 = this.jdField_a_of_type_AndroidWidgetImageButton;
      if (!bool) {
        i = 2130843363;
      } else {
        i = 2130843365;
      }
      ((ImageButton)localObject1).setImageResource(i);
      this.jdField_a_of_type_AndroidWidgetImageButton.setOnClickListener(new SubscriptRecommendController.6(this));
    }
  }
  
  public void c()
  {
    if (a())
    {
      Object localObject = (Activity)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      if (localObject == null) {
        return;
      }
      int i = DisplayUtil.a((Context)localObject, 100.0F);
      localObject = (ImageView)((Activity)localObject).findViewById(2131373220);
      this.b = ((ImageView)localObject).getHeight();
      this.c = ((ImageView)localObject).getWidth();
      ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(i, i));
    }
  }
  
  public void d()
  {
    c();
  }
  
  void e()
  {
    if ((this.jdField_a_of_type_AndroidViewView != null) && (this.jdField_a_of_type_AndroidViewViewStub != null))
    {
      Object localObject = this.jdField_a_of_type_JavaLangRefWeakReference;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        if (this.jdField_a_of_type_AndroidViewView.getVisibility() != 0)
        {
          localObject = AnimationUtils.loadAnimation((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), 2130772242);
          ((Animation)localObject).setFillAfter(true);
          ((Animation)localObject).setAnimationListener(new SubscriptRecommendController.7(this));
          this.jdField_a_of_type_AndroidViewViewStub.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.startAnimation((Animation)localObject);
        }
      }
    }
  }
  
  public void f()
  {
    j();
    SubscriptRecommendAdapter localSubscriptRecommendAdapter = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter;
    if (localSubscriptRecommendAdapter != null) {
      localSubscriptRecommendAdapter.b();
    }
  }
  
  public void g()
  {
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.9(this));
  }
  
  public void h()
  {
    SubscriptRecommendAdapter localSubscriptRecommendAdapter = this.jdField_a_of_type_ComTencentBizPubaccountSubscriptSubscriptRecommendAdapter;
    if (localSubscriptRecommendAdapter != null)
    {
      localSubscriptRecommendAdapter.notifyDataSetChanged();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptRecommendController", 2, "scriptRecommendAdapter is null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController
 * JD-Core Version:    0.7.0.1
 */