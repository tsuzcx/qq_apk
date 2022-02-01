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
  ViewStub a = null;
  public View b = null;
  SubscriptRecommendAdapter c;
  HorizontalListView d;
  public WeakReference<Activity> e;
  QQAppInterface f;
  SubscriptPicManager g;
  ImageButton h = null;
  public boolean i = true;
  public int j = 0;
  int k = 0;
  int l = 0;
  private int m = 0;
  private SubscriptObserver n = new SubscriptRecommendController.1(this);
  private IPublicAccountObserver o = (IPublicAccountObserver)QRoute.api(IPublicAccountObserver.class);
  private IPublicAccountObserver.OnCallback p = new SubscriptRecommendController.2(this);
  
  public SubscriptRecommendController(Activity paramActivity, QQAppInterface paramQQAppInterface, SubscriptPicManager paramSubscriptPicManager)
  {
    this.e = new WeakReference(paramActivity);
    this.f = paramQQAppInterface;
    this.g = paramSubscriptPicManager;
    this.m = ((int)paramActivity.getResources().getDimension(2131298737));
    j();
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.3(this));
    this.o.setOnCallback(this.p);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscribe_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 0);
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
  
  public static int b(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("subscript_full_recommend_version");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), -1);
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
  
  public static void d(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putBoolean("subscribe_discovery_btn", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static boolean d(QQAppInterface paramQQAppInterface)
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
  
  public static boolean e(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscript_full_recommend", false);
  }
  
  public static String f(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getString("subscirpt_full_recommend_url", "");
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface)
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
      if (k(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static boolean h(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_show");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getInt(localStringBuilder.toString(), 1) != 0;
  }
  
  public static String i(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("pa_subscribe_config_msg");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getString(localStringBuilder.toString(), "");
  }
  
  private void j()
  {
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.addObserver(this.n);
      this.f.addObserver(this.o.getBusinessObserver());
    }
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface)
  {
    SharedPreferences localSharedPreferences = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("is_show_subscribe_folder_red_dot");
    localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
    return localSharedPreferences.getBoolean(localStringBuilder.toString(), true);
  }
  
  private void k()
  {
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface != null)
    {
      localQQAppInterface.removeObserver(this.o.getBusinessObserver());
      this.f.removeObserver(this.n);
    }
  }
  
  public static boolean k(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("subscribe_discovery_btn", true);
  }
  
  private void l()
  {
    if ((this.b != null) && (this.a != null))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        if (this.b.getVisibility() == 0)
        {
          localObject = AnimationUtils.loadAnimation((Context)this.e.get(), 2130772307);
          ((Animation)localObject).setFillAfter(true);
          ((Animation)localObject).setAnimationListener(new SubscriptRecommendController.8(this));
          a(0);
          this.b.startAnimation((Animation)localObject);
        }
      }
    }
  }
  
  void a()
  {
    this.j = 1;
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      if (this.a == null)
      {
        localObject = this.e;
        if ((localObject != null) && (((WeakReference)localObject).get() != null))
        {
          this.a = ((ViewStub)((Activity)this.e.get()).findViewById(2131445356));
          localObject = this.a;
          if (localObject != null)
          {
            ((ViewStub)localObject).setOnInflateListener(new SubscriptRecommendController.4(this));
            this.b = this.a.inflate();
            b();
            i();
          }
        }
      }
      else
      {
        f();
        a(this.m);
      }
      ReportController.b(this.f, "CliOper", "", "", "0X8006431", "0X8006431", 0, 0, "", "", "", "");
    }
  }
  
  void a(int paramInt)
  {
    Object localObject = this.e;
    if (localObject != null)
    {
      if (((WeakReference)localObject).get() == null) {
        return;
      }
      localObject = ((Activity)this.e.get()).findViewById(2131437272);
      if (localObject != null) {
        ((View)localObject).setPadding(0, 0, 0, paramInt);
      }
    }
  }
  
  public void a(View paramView)
  {
    this.j = 3;
    this.b = paramView;
    this.b.setVisibility(0);
  }
  
  void a(String paramString)
  {
    QQAppInterface localQQAppInterface = this.f;
    if (localQQAppInterface != null) {
      ((SubscriptHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SUBSCRIPT_HANDLER)).a(paramString);
    }
  }
  
  void a(List<SubscriptRecommendAccountInfo> paramList)
  {
    WeakReference localWeakReference = this.e;
    if (localWeakReference != null)
    {
      if (localWeakReference.get() == null) {
        return;
      }
      if (this.c == null) {
        this.c = new SubscriptRecommendAdapter((Activity)this.e.get(), this.f, this.g);
      }
      this.c.a();
      this.c.a(paramList);
    }
  }
  
  @TargetApi(9)
  public void b()
  {
    boolean bool = ThemeUtil.isInNightMode(this.f);
    Object localObject1 = ((Activity)this.e.get()).getResources();
    if (bool) {
      i1 = 2131166843;
    } else {
      i1 = 2131166833;
    }
    int i1 = ((Resources)localObject1).getColor(i1);
    this.b.setBackgroundColor(i1);
    this.b.setOnClickListener(new SubscriptRecommendController.5(this));
    Object localObject2 = (ImageView)this.b.findViewById(2131446597);
    if (localObject2 != null)
    {
      if (ThemeUtil.isInNightMode(this.f)) {
        i1 = 2131168246;
      } else {
        i1 = 2131167227;
      }
      ((ImageView)localObject2).setBackgroundResource(i1);
    }
    localObject2 = (TextView)this.b.findViewById(2131447463);
    if (bool) {
      i1 = 2131166832;
    } else {
      i1 = 2131166831;
    }
    ((TextView)localObject2).setTextColor(((Resources)localObject1).getColor(i1));
    if (this.d == null)
    {
      this.d = ((HorizontalListView)this.b.findViewById(2131445351));
      this.d.setDividerWidth((int)((Resources)localObject1).getDimension(2131298738));
      this.d.setAdapter(this.c);
      if (Build.VERSION.SDK_INT >= 9) {
        this.d.setOverScrollMode(2);
      }
    }
    if (this.h == null)
    {
      this.h = ((ImageButton)this.b.findViewById(2131430806));
      localObject1 = this.h;
      if (!bool) {
        i1 = 2130844317;
      } else {
        i1 = 2130844319;
      }
      ((ImageButton)localObject1).setImageResource(i1);
      this.h.setOnClickListener(new SubscriptRecommendController.6(this));
    }
  }
  
  public boolean c()
  {
    Activity localActivity = (Activity)this.e.get();
    boolean bool = false;
    if (localActivity == null) {
      return false;
    }
    View localView = localActivity.findViewById(2131432507);
    WindowManager localWindowManager = (WindowManager)localActivity.getSystemService("window");
    int i1 = localWindowManager.getDefaultDisplay().getWidth();
    int i2 = localWindowManager.getDefaultDisplay().getHeight();
    int i3 = (int)localActivity.getResources().getDimension(2131299920);
    int i4 = (int)localActivity.getResources().getDimension(2131299926);
    int i5 = this.m;
    int i6 = localView.getHeight();
    int i7 = localView.getWidth();
    int i8 = ImmersiveUtils.getStatusBarHeight(localActivity);
    if ((i1 < i7) || (i2 - (i3 + i4 + i5) - i8 < i6)) {
      bool = true;
    }
    return bool;
  }
  
  public void d()
  {
    if (c())
    {
      Object localObject = (Activity)this.e.get();
      if (localObject == null) {
        return;
      }
      int i1 = DisplayUtil.a((Context)localObject, 100.0F);
      localObject = (ImageView)((Activity)localObject).findViewById(2131440829);
      this.k = ((ImageView)localObject).getHeight();
      this.l = ((ImageView)localObject).getWidth();
      ((ImageView)localObject).setLayoutParams(new LinearLayout.LayoutParams(i1, i1));
    }
  }
  
  public void e()
  {
    d();
  }
  
  void f()
  {
    if ((this.b != null) && (this.a != null))
    {
      Object localObject = this.e;
      if (localObject != null)
      {
        if (((WeakReference)localObject).get() == null) {
          return;
        }
        if (this.b.getVisibility() != 0)
        {
          localObject = AnimationUtils.loadAnimation((Context)this.e.get(), 2130772308);
          ((Animation)localObject).setFillAfter(true);
          ((Animation)localObject).setAnimationListener(new SubscriptRecommendController.7(this));
          this.a.setVisibility(0);
          this.b.setVisibility(0);
          this.b.startAnimation((Animation)localObject);
        }
      }
    }
  }
  
  public void g()
  {
    k();
    SubscriptRecommendAdapter localSubscriptRecommendAdapter = this.c;
    if (localSubscriptRecommendAdapter != null) {
      localSubscriptRecommendAdapter.b();
    }
  }
  
  public void h()
  {
    ThreadManager.getSubThreadHandler().post(new SubscriptRecommendController.9(this));
  }
  
  public void i()
  {
    SubscriptRecommendAdapter localSubscriptRecommendAdapter = this.c;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptRecommendController
 * JD-Core Version:    0.7.0.1
 */