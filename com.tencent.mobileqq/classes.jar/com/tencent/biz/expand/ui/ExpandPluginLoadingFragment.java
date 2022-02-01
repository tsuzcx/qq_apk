package com.tencent.biz.expand.ui;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.biz.expand.utils.LoadingLifecycle;
import com.tencent.biz.expand.utils.OnApplicationBackgroundListener;
import com.tencent.biz.expand.utils.ProcessUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guardinterface.IGuardInterface;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandPluginLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "mBoxingView", "Lcom/tencent/image/URLImageView;", "mCloseButton", "Landroid/view/View;", "mCountDownDuration", "", "mCountDownLoading", "Landroid/widget/TextView;", "mCurrentLoadingStatus", "Lcom/tencent/biz/expand/ui/LoadingStatus;", "getMCurrentLoadingStatus", "()Lcom/tencent/biz/expand/ui/LoadingStatus;", "setMCurrentLoadingStatus", "(Lcom/tencent/biz/expand/ui/LoadingStatus;)V", "mDismissFrom", "", "getMDismissFrom", "()I", "setMDismissFrom", "(I)V", "mDownloadDuration", "", "getMDownloadDuration", "()J", "setMDownloadDuration", "(J)V", "mDownloadStartTime", "getMDownloadStartTime", "setMDownloadStartTime", "mErrorCode", "getMErrorCode", "setMErrorCode", "mHasDownload", "", "getMHasDownload", "()Z", "setMHasDownload", "(Z)V", "mIsDownloading", "getMIsDownloading", "setMIsDownloading", "mIsHotStart", "getMIsHotStart", "setMIsHotStart", "mIsPluginProcessExits", "getMIsPluginProcessExits", "setMIsPluginProcessExits", "mLifecycleCallbacks", "Lcom/tencent/biz/expand/utils/LoadingLifecycle;", "getMLifecycleCallbacks", "()Lcom/tencent/biz/expand/utils/LoadingLifecycle;", "setMLifecycleCallbacks", "(Lcom/tencent/biz/expand/utils/LoadingLifecycle;)V", "mLoadingEndTime", "getMLoadingEndTime", "setMLoadingEndTime", "mLoadingError", "Landroid/widget/ImageView;", "mLoadingStartTime", "getMLoadingStartTime", "setMLoadingStartTime", "mLoadingSubWording", "mLoadingWording", "mPerProgress", "mPerProgressWhenDownload", "mProgressBar", "Landroid/widget/ProgressBar;", "mReceiver", "Landroid/content/BroadcastReceiver;", "getMReceiver", "()Landroid/content/BroadcastReceiver;", "mRetryLoading", "mRootView", "mStartPluginState", "getMStartPluginState", "setMStartPluginState", "finish", "", "from", "getLoadCountDownWhenDownload", "getLoadPerProgress", "getPluginState", "initStatusBar", "loadImageView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "registerLifecycleAndReceiver", "reportLoadingEvent", "resetReportStartTime", "resumeRootViewVisibility", "setDownloadEnd", "setDownloadStart", "setIsHotStart", "isHotStart", "setLoadEndTime", "endTime", "setRetryClickListener", "listener", "Landroid/view/View$OnClickListener;", "unRegisterLifecycleAndReceiver", "updateDismissFrom", "updateDownloadProgress", "progress", "updateLoadCountDown", "downloadSecond", "loadSecond", "updateLoadProgress", "updateLoadingStatus", "status", "loadError", "errorReason", "updateProgress", "process", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment
  extends QPublicBaseFragment
{
  public static final ExpandPluginLoadingFragment.Companion a;
  private final double jdField_a_of_type_Double = a();
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  @NotNull
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = (BroadcastReceiver)new ExpandPluginLoadingFragment.mReceiver.1(this);
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  @NotNull
  private LoadingStatus jdField_a_of_type_ComTencentBizExpandUiLoadingStatus = LoadingStatus.LOADING;
  @Nullable
  private LoadingLifecycle jdField_a_of_type_ComTencentBizExpandUtilsLoadingLifecycle;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = c();
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private final int e = (int)(this.jdField_d_of_type_Int * 0.4D);
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandUiExpandPluginLoadingFragment$Companion = new ExpandPluginLoadingFragment.Companion(null);
  }
  
  private final double a()
  {
    if (DeviceInfoUtils.a()) {
      return 2.0D;
    }
    if (DeviceInfoUtils.b()) {
      return 4.0D;
    }
    return 3.0D;
  }
  
  private final int b()
  {
    QRoutePluginInfo localQRoutePluginInfo = QRoute.plugin("expand").queryPluginInfo();
    if (localQRoutePluginInfo != null) {
      return localQRoutePluginInfo.getState();
    }
    return -5;
  }
  
  private final int c()
  {
    if (DeviceInfoUtils.a()) {
      return 15;
    }
    if (DeviceInfoUtils.b()) {
      return 5;
    }
    return 10;
  }
  
  private final void f(int paramInt)
  {
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateProgress.1(this, paramInt));
  }
  
  private final void j()
  {
    this.jdField_a_of_type_ComTencentBizExpandUtilsLoadingLifecycle = new LoadingLifecycle((OnApplicationBackgroundListener)new ExpandPluginLoadingFragment.registerLifecycleAndReceiver.1(this));
    GuardManager.a.a((IGuardInterface)this.jdField_a_of_type_ComTencentBizExpandUtilsLoadingLifecycle);
    QLog.d("ExpandPluginLoadingFragment", 2, "add background callbacks");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private final void k()
  {
    LoadingLifecycle localLoadingLifecycle = this.jdField_a_of_type_ComTencentBizExpandUtilsLoadingLifecycle;
    if (localLoadingLifecycle != null)
    {
      localLoadingLifecycle.c();
      GuardManager.a.b((IGuardInterface)localLoadingLifecycle);
      QLog.d("ExpandPluginLoadingFragment", 2, "remove background callbacks");
    }
    this.jdField_a_of_type_ComTencentBizExpandUtilsLoadingLifecycle = ((LoadingLifecycle)null);
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  private final void l()
  {
    Object localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    localObject1 = ((QFragmentActivity)localObject1).getResources().getDrawable(2130839794);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = new Bundle();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    localObject1 = URLDrawable.getDrawable("https://down.qq.com/innovate/qqexpend/match/boxing.png", (URLDrawable.URLDrawableOptions)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject2 != null) {
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
    }
  }
  
  private final void m()
  {
    long l1;
    HashMap localHashMap;
    Map localMap;
    if (this.jdField_b_of_type_Long == 0L)
    {
      l1 = System.currentTimeMillis();
      this.jdField_b_of_type_Long = l1;
      l1 = this.jdField_b_of_type_Long;
      long l2 = this.jdField_a_of_type_Long;
      localHashMap = new HashMap();
      ((Map)localHashMap).put("duration", String.valueOf(l1 - l2));
      ((Map)localHashMap).put("ext_int1", String.valueOf(this.jdField_a_of_type_Int));
      ((Map)localHashMap).put("download_duration", String.valueOf(this.jdField_c_of_type_Long));
      localMap = (Map)localHashMap;
      if (!this.jdField_a_of_type_Boolean) {
        break label283;
      }
      str = "2";
      label118:
      localMap.put("launch_type", str);
      localMap = (Map)localHashMap;
      if (!this.jdField_d_of_type_Boolean) {
        break label291;
      }
    }
    label283:
    label291:
    for (String str = "2";; str = "1")
    {
      localMap.put("process_status", str);
      ((Map)localHashMap).put("start_plugin_state", String.valueOf(this.jdField_b_of_type_Int));
      ((Map)localHashMap).put("dismiss_plugin_state", String.valueOf(b()));
      ((Map)localHashMap).put("error_code", String.valueOf(this.jdField_c_of_type_Int));
      QLog.i("ExpandPluginLoadingFragment", 1, "dismiss duration " + localHashMap);
      ExpandReportUtils.a("loading#launch_loading#view", true, -1L, -1L, (Map)localHashMap, true, true);
      return;
      l1 = this.jdField_b_of_type_Long;
      break;
      str = "1";
      break label118;
    }
  }
  
  private final void n()
  {
    if (getActivity().mSystemBarComp == null) {
      getActivity().setImmersiveStatus(0);
    }
    for (;;)
    {
      QFragmentActivity localQFragmentActivity = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQFragmentActivity, "activity");
      ImmersiveUtils.setStatusTextColor(true, localQFragmentActivity.getWindow());
      return;
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public final int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public final void a()
  {
    QLog.i("ExpandPluginLoadingFragment", 2, "rootView visibility set VISIBLE");
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    localView.setVisibility(0);
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    if ((this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus != LoadingStatus.LOADING) || (getActivity() == null)) {
      return;
    }
    int i = (int)Math.ceil(paramDouble1 + paramDouble2);
    QLog.d("ExpandPluginLoadingFragment", 2, "downloadTime " + paramDouble1 + " loadTime " + paramDouble2 + " isDownloading " + this.jdField_b_of_type_Boolean + " remainTime " + i);
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateLoadCountDown.1(this, i));
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandPluginLoadingFragment.updateLoadCountDown.2(this, paramDouble1, paramDouble2), 2000L);
  }
  
  public final void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public final void a(long paramLong)
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      QLog.e("ExpandPluginLoadingFragment", 2, "endTime has value!!!");
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public final void a(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
    if (localTextView != null) {
      localTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public final void a(@NotNull LoadingStatus paramLoadingStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramLoadingStatus, "<set-?>");
    this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus = paramLoadingStatus;
  }
  
  public final void a(@NotNull LoadingStatus paramLoadingStatus, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramLoadingStatus, "status");
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateLoadingStatus.1(this, paramLoadingStatus, paramInt2, paramInt1));
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public final void b()
  {
    this.jdField_c_of_type_Boolean = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      d(3);
    }
  }
  
  public final void b(int paramInt)
  {
    if (paramInt <= 100) {
      f((int)(paramInt * 0.6D));
    }
  }
  
  public final boolean b()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public final void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      this.jdField_d_of_type_Long = 0L;
      d(1);
    }
  }
  
  public final void c(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandPluginLoadingFragment.updateLoadProgress.1(this, paramInt), 500L);
  }
  
  public final void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ExpandReportUtils.a("click#launch_download_error_page#retry_btn", true, -1L, -1L, null, true, true);
  }
  
  public final void d(int paramInt)
  {
    QLog.d("ExpandPluginLoadingFragment", 2, "updateDismissFrom " + paramInt);
    if (this.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public final void e(int paramInt)
  {
    d(paramInt);
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.finish.1(this));
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @NotNull ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    Intrinsics.checkParameterIsNotNull(paramViewGroup, "container");
    paramLayoutInflater = paramLayoutInflater.inflate(2131561230, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…dialog, container, false)");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131370734));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370740));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131370752));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131370763));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378650));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131379465);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131370753));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365405));
    paramLayoutInflater = this.jdField_d_of_type_AndroidWidgetTextView;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setVisibility(8);
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener((View.OnClickListener)new ExpandPluginLoadingFragment.onCreateView.1(this));
    }
    n();
    l();
    this.jdField_a_of_type_Boolean = ProcessUtils.a(getArguments().getInt("plugin_process_id", 0));
    QLog.i("ExpandPluginLoadingFragment", 2, "isHotStart " + this.jdField_a_of_type_Boolean + ' ');
    if (this.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
      }
      paramLayoutInflater.setVisibility(8);
    }
    this.jdField_b_of_type_Int = b();
    this.jdField_d_of_type_Boolean = ProcessUtils.a("com.tencent.mobileqq:plugins");
    d(0);
    a(this, LoadingStatus.LOADING, 0, 0, 6, null);
    QLog.i("ExpandPluginLoadingFragment", 1, "plugin state " + this.jdField_b_of_type_Int);
    if (this.jdField_b_of_type_Int == 3) {
      a(0.0D, this.jdField_a_of_type_Double);
    }
    j();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ExpandPluginLauncher.a.a().a(this);
    ExpandReportUtils.a("expose#launch_loading#view", true, -1L, -1L, null, true, true);
    QLog.i("ExpandPluginLoadingFragment", 1, "expose loadingFragment " + System.identityHashCode(this));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    QLog.i("ExpandPluginLoadingFragment", 4, "onDestroy " + System.identityHashCode(this));
    k();
    ExpandPluginLauncher.a.a().a();
    if ((this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus == LoadingStatus.LOADING) || (this.jdField_a_of_type_ComTencentBizExpandUiLoadingStatus == LoadingStatus.LOADING_SUCCESS)) {
      m();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    QLog.i("ExpandPluginLoadingFragment", 4, "onPause " + System.identityHashCode(this));
    super.onPause();
  }
  
  public void onResume()
  {
    QLog.i("ExpandPluginLoadingFragment", 4, "onResume " + System.identityHashCode(this));
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandPluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */