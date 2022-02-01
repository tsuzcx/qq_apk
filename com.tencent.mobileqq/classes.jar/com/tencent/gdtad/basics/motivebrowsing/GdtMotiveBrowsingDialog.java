package com.tencent.gdtad.basics.motivebrowsing;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.DialogInterface.OnShowListener;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnSystemUiVisibilityChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoModel;
import com.tencent.gdtad.basics.motivevideo.data.GdtMotiveVideoPageData;
import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.GdtWebViewProxy;
import com.tencent.gdtad.inject.IGdtWebView;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.gdtad.util.GdtUtil;
import com.tencent.mobileqq.mvvm.ViewModelProviderHelper;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebView;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DestInfo;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingDialog;", "Landroid/app/Dialog;", "Landroidx/lifecycle/LifecycleOwner;", "Landroidx/lifecycle/ViewModelStoreOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "countDownTime", "", "hasCountDownComplete", "", "isError", "isSuccess", "mActivity", "Landroid/app/Activity;", "mGdtWebViewProxy", "Lcom/tencent/gdtad/inject/GdtWebViewProxy;", "mIntent", "Landroid/content/Intent;", "mIsReportLoadingFinishEvent", "mLifecycleRegistry", "Landroidx/lifecycle/LifecycleRegistry;", "mModel", "Lcom/tencent/gdtad/basics/motivevideo/data/GdtMotiveVideoModel;", "mQQCustomDialog", "Lcom/tencent/mobileqq/utils/QQCustomDialog;", "mRootView", "Landroid/view/View;", "mSavedActivityIntent", "mViewModelStore", "Landroidx/lifecycle/ViewModelStore;", "mWebView", "Lcom/tencent/biz/ui/TouchWebView;", "mWebViewBuilder", "Lcom/tencent/gdtad/inject/IGdtWebView;", "titleContainer", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingTitle;", "viewModel", "Lcom/tencent/gdtad/basics/motivebrowsing/GdtMotiveBrowsingViewModel;", "dispatchLifeCycleEvent", "", "event", "Landroidx/lifecycle/Lifecycle$Event;", "doOnBackEvent", "fitSpecialScreen", "activity", "titlePart", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "getViewModelStore", "handleMotiveBrowsingData", "browsingData", "Lcom/tencent/gdtad/basics/motivebrowsing/MotiveBrowsingData;", "initData", "initTitle", "initView", "initWeb", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestory", "onDialogCancelClick", "onDialogConfirmClick", "onStart", "onStop", "sendRewardedCallback", "setDataModel", "mode", "setIntent", "intent", "watchTimeNotCompleteMention", "Companion", "qqad-impl_release"}, k=1, mv={1, 1, 16})
public final class GdtMotiveBrowsingDialog
  extends ReportDialog
  implements LifecycleOwner, ViewModelStoreOwner
{
  public static final GdtMotiveBrowsingDialog.Companion a = new GdtMotiveBrowsingDialog.Companion(null);
  private Activity b;
  private View c;
  private TouchWebView d;
  private IGdtWebView e;
  private LifecycleRegistry f = new LifecycleRegistry((LifecycleOwner)this);
  private final ViewModelStore g = new ViewModelStore();
  private boolean h;
  private GdtMotiveBrowsingViewModel i;
  private QQCustomDialog j;
  private GdtMotiveVideoModel k;
  private GdtMotiveBrowsingTitle l;
  private int m;
  private Intent n;
  private Intent o;
  private boolean p;
  private boolean q;
  private boolean r;
  private GdtWebViewProxy s = new GdtWebViewProxy();
  
  public GdtMotiveBrowsingDialog(@NotNull Context paramContext)
  {
    super(paramContext, 16973834);
    this.b = ((Activity)paramContext);
  }
  
  private final void a(Lifecycle.Event paramEvent)
  {
    try
    {
      this.f.handleLifecycleEvent(paramEvent);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleLifecycleEvent fail : event -> ");
      localStringBuilder.append(paramEvent);
      QLog.i("GdtMotiveBrowsingDialog", 1, localStringBuilder.toString(), localThrowable);
    }
  }
  
  private final void a(MotiveBrowsingData paramMotiveBrowsingData)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("handleMotiveBrowsingData browsingData: ");
    ((StringBuilder)localObject).append(paramMotiveBrowsingData);
    localObject = ((StringBuilder)localObject).toString();
    boolean bool = true;
    QLog.i("GdtMotiveBrowsingDialog", 1, (String)localObject);
    int i1 = paramMotiveBrowsingData.a();
    localObject = paramMotiveBrowsingData.b();
    int i2 = paramMotiveBrowsingData.c();
    if (i1 != 0)
    {
      if (i1 != 1) {
        return;
      }
      if (i2 > 0) {
        bool = false;
      }
      this.h = bool;
      paramMotiveBrowsingData = this.l;
      if (paramMotiveBrowsingData != null) {
        paramMotiveBrowsingData.a(i2);
      }
    }
    else
    {
      paramMotiveBrowsingData = this.d;
      if (paramMotiveBrowsingData != null) {
        paramMotiveBrowsingData.evaluateJavascript((String)localObject, (ValueCallback)GdtMotiveBrowsingDialog.handleMotiveBrowsingData.1.a);
      }
    }
  }
  
  private final void b()
  {
    Object localObject1 = getWindow();
    Object localObject2;
    if (Build.VERSION.SDK_INT >= 28)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject2 = ((Window)localObject1).getAttributes();
      ((WindowManager.LayoutParams)localObject2).layoutInDisplayCutoutMode = 1;
      ((Window)localObject1).setAttributes((WindowManager.LayoutParams)localObject2);
    }
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((Window)localObject1).setFlags(1024, 1024);
    ((Window)localObject1).setVolumeControlStream(3);
    localObject1 = ((Window)localObject1).getDecorView();
    if (localObject1 != null)
    {
      localObject1 = (ViewGroup)localObject1;
      ((ViewGroup)localObject1).setSystemUiVisibility(7942);
      if (Build.VERSION.SDK_INT >= 19) {
        ((ViewGroup)localObject1).setOnSystemUiVisibilityChangeListener((View.OnSystemUiVisibilityChangeListener)new GdtMotiveBrowsingDialog.initView.1((ViewGroup)localObject1));
      }
      this.c = LayoutInflater.from((Context)this.b).inflate(2131624946, (ViewGroup)localObject1, false);
      localObject2 = this.c;
      if (localObject2 == null)
      {
        QLog.i("GdtMotiveBrowsingDialog", 1, "mRootView == null");
        return;
      }
      setContentView((View)localObject2);
      setOnDismissListener((DialogInterface.OnDismissListener)new GdtMotiveBrowsingDialog.initView.2(this));
      setOnShowListener((DialogInterface.OnShowListener)new GdtMotiveBrowsingDialog.initView.3(this));
      ((ViewGroup)localObject1).getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new GdtMotiveBrowsingDialog.initView.4(this, (ViewGroup)localObject1));
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
  }
  
  private final void c()
  {
    if (this.k == null)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "mModel == null");
      return;
    }
    Object localObject = ViewModelProviderHelper.a((ViewModelStoreOwner)this).get(GdtMotiveBrowsingViewModel.class);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "ViewModelProviderHelper.…ingViewModel::class.java)");
    this.i = ((GdtMotiveBrowsingViewModel)localObject);
    int i2 = GdtUtil.a(this.k);
    int i1 = i2;
    if (i2 <= 0) {
      i1 = 15;
    }
    this.m = i1;
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    ((GdtMotiveBrowsingViewModel)localObject).a(this.m);
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    GdtLifeCycleExtKt.a(this, (LiveData)((GdtMotiveBrowsingViewModel)localObject).a(), (Function1)new GdtMotiveBrowsingDialog.initData.1((GdtMotiveBrowsingDialog)this));
    this.o = this.b.getIntent();
    this.b.setIntent(this.n);
    GdtADFlyingStreamingReportHelper.a().a(this.k);
  }
  
  private final void d()
  {
    Object localObject1 = MobileQQ.sMobileQQ;
    Object localObject2 = null;
    localObject1 = ((MobileQQ)localObject1).waitAppRuntime(null).getAppRuntime("modular_web");
    if (localObject1 != null)
    {
      localObject1 = (AppInterface)localObject1;
      this.d = new TouchWebView((Context)this.b);
      this.e = this.s.a();
      Object localObject3 = this.e;
      if (localObject3 != null)
      {
        Activity localActivity = this.b;
        ((IGdtWebView)localObject3).a((Context)localActivity, localActivity, null, (AppInterface)localObject1, (IGdtWebViewListener)new GdtMotiveBrowsingDialog.initWeb.1(this));
      }
      localObject3 = this.e;
      if (localObject3 != null) {
        ((IGdtWebView)localObject3).a((WebView)this.d);
      }
      localObject3 = this.e;
      if (localObject3 != null) {
        ((IGdtWebView)localObject3).a(null);
      }
      localObject3 = this.e;
      if (localObject3 != null) {
        ((IGdtWebView)localObject3).a(null, (AppInterface)localObject1, null);
      }
      localObject1 = this.c;
      if (localObject1 != null) {
        localObject1 = (FrameLayout)((View)localObject1).findViewById(2131450086);
      } else {
        localObject1 = null;
      }
      if (localObject1 != null) {
        ((FrameLayout)localObject1).addView((View)this.d);
      }
      localObject3 = this.k;
      localObject1 = localObject2;
      if (localObject3 != null)
      {
        localObject3 = ((GdtMotiveVideoModel)localObject3).b();
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject3).dest_info;
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject3 = ((qq_ad_get.QQAdGetRsp.AdInfo.DestInfo)localObject3).landing_page;
            localObject1 = localObject2;
            if (localObject3 != null) {
              localObject1 = ((PBStringField)localObject3).get();
            }
          }
        }
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.d;
        if (localObject2 != null) {
          ((TouchWebView)localObject2).loadUrl((String)localObject1);
        }
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("initWebView url = ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.i("GdtMotiveBrowsingDialog", 1, ((StringBuilder)localObject2).toString());
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.common.app.AppInterface");
  }
  
  private final void e()
  {
    this.l = new GdtMotiveBrowsingTitle((Context)this.b);
    Object localObject = this.l;
    if (localObject != null) {
      ((GdtMotiveBrowsingTitle)localObject).setOnCloseClickListener((Function0)new GdtMotiveBrowsingDialog.initTitle.1((GdtMotiveBrowsingDialog)this));
    }
    int i1 = ViewUtils.dpToPx(15.0F);
    localObject = this.l;
    if (localObject != null) {
      ((GdtMotiveBrowsingTitle)localObject).setPadding(i1, i1, i1, i1);
    }
    localObject = new FrameLayout.LayoutParams(-1, -1);
    GdtMotiveBrowsingTitle localGdtMotiveBrowsingTitle = this.l;
    if (localGdtMotiveBrowsingTitle != null) {
      localGdtMotiveBrowsingTitle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    localObject = this.c;
    if (localObject != null) {
      localObject = (FrameLayout)((View)localObject).findViewById(2131447506);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      ((FrameLayout)localObject).addView((View)this.l);
    }
    ImmersiveUtils.clearCoverForStatus(this.b.getWindow(), true);
    ImmersiveUtils.setStatusTextColor(true, this.b.getWindow());
    a(this.b, (View)localObject);
  }
  
  private final void f()
  {
    Object localObject = this.j;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    localObject = this.b;
    this.j = DialogUtil.a((Context)localObject, 0, null, (CharSequence)((Activity)localObject).getString(2131889956, new Object[] { Integer.valueOf(this.m) }), this.b.getString(2131889953), this.b.getString(2131889954), (DialogInterface.OnClickListener)new GdtMotiveBrowsingDialog.watchTimeNotCompleteMention.1(this), (DialogInterface.OnClickListener)new GdtMotiveBrowsingDialog.watchTimeNotCompleteMention.2(this));
    localObject = this.j;
    if (localObject != null)
    {
      ((QQCustomDialog)localObject).show();
      localObject = ((QQCustomDialog)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setSystemUiVisibility(7942);
        }
      }
      localObject = this.i;
      if (localObject == null) {
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
      }
      ((GdtMotiveBrowsingViewModel)localObject).c();
    }
    localObject = this.j;
    if (localObject != null) {
      ((QQCustomDialog)localObject).setOnDismissListener((DialogInterface.OnDismissListener)new GdtMotiveBrowsingDialog.watchTimeNotCompleteMention.4(this));
    }
  }
  
  private final void g()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick confirm");
    QQCustomDialog localQQCustomDialog = this.j;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.j = ((QQCustomDialog)null);
  }
  
  private final void h()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "DialogInterface onClick onCancel");
    QQCustomDialog localQQCustomDialog = this.j;
    if (localQQCustomDialog != null) {
      localQQCustomDialog.dismiss();
    }
    this.j = ((QQCustomDialog)null);
    i();
    super.onBackPressed();
  }
  
  private final void i()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "sendRewardedCallback");
    Object localObject1 = this.k;
    if (localObject1 != null)
    {
      localObject1 = ((GdtMotiveVideoModel)localObject1).a();
      if (localObject1 != null)
      {
        localObject1 = ((GdtMotiveVideoPageData)localObject1).motiveBrowsingKey;
        if (localObject1 != null)
        {
          Object localObject2 = StringsKt.split$default((CharSequence)localObject1, new String[] { "#" }, false, 0, 6, null);
          if ((true ^ ((Collection)localObject2).isEmpty()))
          {
            localObject2 = new Intent((String)((List)localObject2).get(0));
            ((Intent)localObject2).putExtra("duration_time", this.m * 1000L);
            ((Intent)localObject2).putExtra("elapsed_time", this.m * 1000L);
            ((Intent)localObject2).putExtra("profitable_flag", this.h);
            ((Intent)localObject2).putExtra("KEY_MOTIVE_BROWSING", (String)localObject1);
            this.b.sendBroadcast((Intent)localObject2);
          }
        }
      }
    }
    GdtADFlyingStreamingReportHelper.a().a(1020025L);
  }
  
  private final void j()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onDestory");
    this.b.setIntent(this.o);
    Object localObject = this.j;
    if (localObject != null) {
      ((QQCustomDialog)localObject).dismiss();
    }
    this.j = ((QQCustomDialog)null);
    localObject = this.e;
    if (localObject != null)
    {
      if (localObject != null) {
        ((IGdtWebView)localObject).c();
      }
      this.e = ((IGdtWebView)null);
    }
    localObject = this.d;
    if (localObject != null)
    {
      if (localObject != null) {
        localObject = ((TouchWebView)localObject).getParent();
      } else {
        localObject = null;
      }
      if ((localObject != null) && ((localObject instanceof ViewGroup))) {
        ((ViewGroup)localObject).removeAllViewsInLayout();
      }
      this.d = ((TouchWebView)null);
    }
    a(Lifecycle.Event.ON_DESTROY);
    localObject = this.b;
    int i1;
    if ((localObject != null) && (((Activity)localObject).isChangingConfigurations())) {
      i1 = 1;
    } else {
      i1 = 0;
    }
    if (i1 == 0)
    {
      QLog.i("GdtMotiveBrowsingDialog", 1, "mViewModelStore.clear()");
      this.g.clear();
    }
    GdtADFlyingStreamingReportHelper.a().c();
    localObject = this.i;
    if (localObject == null) {
      Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    }
    ((GdtMotiveBrowsingViewModel)localObject).b().d();
  }
  
  public final void a()
  {
    GdtADFlyingStreamingReportHelper.a().a(1020026L);
    QLog.i("GdtMotiveBrowsingDialog", 1, "doOnBackEvent");
    if (!this.h)
    {
      f();
      return;
    }
    i();
    super.onBackPressed();
    GdtADFlyingStreamingReportHelper.a().a(1020043L);
  }
  
  public final void a(@NotNull Activity paramActivity, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    if (paramView != null)
    {
      LiuHaiUtils.f(paramActivity);
      if (LiuHaiUtils.b())
      {
        Object localObject = paramView.getLayoutParams();
        if (localObject != null)
        {
          localObject = (LinearLayout.LayoutParams)localObject;
          ((LinearLayout.LayoutParams)localObject).topMargin = LiuHaiUtils.e(paramActivity);
          paramView.setLayoutParams((ViewGroup.LayoutParams)localObject);
          paramActivity = new StringBuilder();
          paramActivity.append("fitSpecialScreen addHeight = ");
          paramActivity.append(((LinearLayout.LayoutParams)localObject).topMargin);
          QLog.i("GdtMotiveBrowsingDialog", 1, paramActivity.toString());
          return;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      }
    }
  }
  
  public final void a(@NotNull Intent paramIntent)
  {
    Intrinsics.checkParameterIsNotNull(paramIntent, "intent");
    this.n = paramIntent;
  }
  
  public final void a(@NotNull GdtMotiveVideoModel paramGdtMotiveVideoModel)
  {
    Intrinsics.checkParameterIsNotNull(paramGdtMotiveVideoModel, "mode");
    this.k = paramGdtMotiveVideoModel;
  }
  
  @NotNull
  public Lifecycle getLifecycle()
  {
    return (Lifecycle)this.f;
  }
  
  @NotNull
  public ViewModelStore getViewModelStore()
  {
    return this.g;
  }
  
  public void onBackPressed()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onBackPressed");
    a();
  }
  
  protected void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    QLog.i("GdtMotiveBrowsingDialog", 1, "onCreate");
    a(Lifecycle.Event.ON_CREATE);
    b();
    e();
    d();
    c();
    GdtADFlyingStreamingReportHelper.a().a(1020033L);
    GdtADFlyingStreamingReportHelper.a().a(1020006L);
  }
  
  protected void onStart()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onStart");
    super.onStart();
    IGdtWebView localIGdtWebView = this.e;
    if (localIGdtWebView != null) {
      localIGdtWebView.a();
    }
    a(Lifecycle.Event.ON_START);
    a(Lifecycle.Event.ON_RESUME);
  }
  
  protected void onStop()
  {
    QLog.i("GdtMotiveBrowsingDialog", 1, "onStop");
    super.onStop();
    IGdtWebView localIGdtWebView = this.e;
    if (localIGdtWebView != null) {
      localIGdtWebView.b();
    }
    a(Lifecycle.Event.ON_PAUSE);
    a(Lifecycle.Event.ON_STOP);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivebrowsing.GdtMotiveBrowsingDialog
 * JD-Core Version:    0.7.0.1
 */