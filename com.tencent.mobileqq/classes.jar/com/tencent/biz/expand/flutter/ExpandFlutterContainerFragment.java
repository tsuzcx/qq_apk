package com.tencent.biz.expand.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.biz.expand.utils.ActivityExtUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.ExpandDTParamBuilder;
import com.tencent.mobileqq.extendfriend.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.extendfriend.utils.ExpandReportUtils;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/flutter/ExpandFlutterContainerFragment;", "Lcom/tencent/mobileqq/flutter/container/QFlutterContainerFragment;", "()V", "EXPAND_FRIEND_TIME_OUT", "", "mErrorView", "Landroid/view/View;", "mFirstOpen", "", "mIsBePaused", "mIsSplashShowing", "mProgressBar", "Landroid/widget/ProgressBar;", "mSplashView", "mStartSplashTime", "", "mStartTime", "getContext", "Landroid/content/Context;", "getSplashView", "handleSplashRemove", "isWrapContent", "onAttach", "", "activity", "Landroid/app/Activity;", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "registerDaTongReport", "view", "reportExpose", "updateLoadingProgress", "upProgress", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterContainerFragment
  extends QFlutterContainerFragment
{
  public static final ExpandFlutterContainerFragment.Companion a;
  private final int jdField_a_of_type_Int = 30000;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandFlutterExpandFlutterContainerFragment$Companion = new ExpandFlutterContainerFragment.Companion(null);
  }
  
  private final void a(int paramInt)
  {
    ThreadManager.getUIHandlerV2().postDelayed((Runnable)new ExpandFlutterContainerFragment.updateLoadingProgress.1(this, paramInt), 200L);
  }
  
  private final void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist((Activity)getActivity());
    VideoReport.setPageId(paramView, "match_page");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExpandFlutterContainerFragment", 1, "reportDaTongRegister");
  }
  
  @NotNull
  public Context a()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getApplicationContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getA…tion().applicationContext");
    return localObject;
  }
  
  @Nullable
  public View a()
  {
    QLog.d("ExpandFlutterContainerFragment", 1, "getSplashView");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    ReportHelper.a();
    if (ExpandFlutterUtils.a.a()) {
      return null;
    }
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(a()).inflate(2131561232, null);
    Object localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131370734);
      Object localObject2 = a().getResources().getDrawable(2130839794);
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mUseApngImage = true;
      localURLDrawableOptions.mExtraInfo = new Bundle();
      localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject2);
      localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject2);
      localObject2 = URLDrawable.getDrawable("https://down.qq.com/innovate/qqexpend/match/boxing.png", localURLDrawableOptions);
      if (localObject1 != null) {
        ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 != null)
      {
        localObject1 = ((View)localObject1).findViewById(2131379465);
        if (localObject1 != null) {
          ((View)localObject1).setOnClickListener((View.OnClickListener)new ExpandFlutterContainerFragment.getSplashView.1(this));
        }
      }
      localObject1 = this.jdField_b_of_type_AndroidViewView;
      if (localObject1 == null) {
        break label250;
      }
    }
    label250:
    for (localObject1 = (ProgressBar)((View)localObject1).findViewById(2131370752);; localObject1 = null)
    {
      this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
      int i = RangesKt.random(new IntRange(10, 15), (Random)Random.Default);
      localObject1 = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject1 != null) {
        ((ProgressBar)localObject1).setProgress(i);
      }
      a(i);
      return this.jdField_b_of_type_AndroidViewView;
      localObject1 = null;
      break;
    }
  }
  
  public final void a()
  {
    ReportHelper.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    QLog.d("ExpandFlutterContainerFragment", 1, "handleSplashRemove");
    if ((!this.jdField_b_of_type_Boolean) || (this.c)) {
      QLog.d("ExpandFlutterContainerFragment", 1, "splash showing " + this.jdField_b_of_type_Boolean + ' ' + this.c);
    }
    do
    {
      return false;
      this.jdField_b_of_type_Boolean = false;
      ReportHelper.a(this.jdField_b_of_type_Long, 2, ExpandFlutterUtils.a.a());
    } while (ExpandFlutterUtils.a.a());
    ExpandFlutterUtils.a.e();
    ProgressBar localProgressBar = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localProgressBar != null) {
      localProgressBar.setProgress(100);
    }
    ThreadManager.getUIHandlerV2().postDelayed((Runnable)new ExpandFlutterContainerFragment.handleSplashRemove.1(this), 500L);
    return true;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttach(@Nullable Activity paramActivity)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandFlutterContainerFragment.onAttach.1(this), this.jdField_a_of_type_Int);
    super.onAttach(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      QLog.d("ExpandFlutterContainerFragment", 1, "onBackEvent splash showing " + this.jdField_b_of_type_Boolean + ' ' + this.c);
      ReportHelper.a(this.jdField_b_of_type_Long, 1, ExpandFlutterUtils.a.a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ExpandReportUtils.a();
    ExpandFlutterUtils.a.a();
    ExpandFlutterUtils.a.b();
    ExpandFlutterIPCClient.a();
    ExpandFlutterUtils.a.c();
    ExpandFlutterUtils.a.d();
  }
  
  @NotNull
  public View onCreateView(@Nullable LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localFragmentActivity, "activity");
    ActivityExtUtils.a((BaseActivity)localFragmentActivity);
    localFragmentActivity = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localFragmentActivity, "activity");
    ImmersiveUtils.setStatusTextColor(false, localFragmentActivity.getWindow());
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = LayoutInflater.from((Context)getActivity()).inflate(2131561217, null);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "LayoutInflater.from(acti…ter_empty_fragment, null)");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131379487);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "mErrorView.findViewById<View>(R.id.title_layout)");
    int i = ViewUtils.c(ImmersiveUtils.getStatusBarHeight((Context)getActivity()));
    paramViewGroup = paramLayoutInflater.getLayoutParams();
    paramLayoutInflater = paramViewGroup;
    if (!(paramViewGroup instanceof ViewGroup.MarginLayoutParams)) {
      paramLayoutInflater = null;
    }
    paramLayoutInflater = (ViewGroup.MarginLayoutParams)paramLayoutInflater;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.topMargin = LayoutAttrsKt.getDp(i);
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater.findViewById(2131370266).setOnClickListener((View.OnClickListener)new ExpandFlutterContainerFragment.onCreateView.1(this));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater.setVisibility(8);
    if (paramBundle == null) {
      throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
    }
    paramLayoutInflater = (FrameLayout)paramBundle;
    paramViewGroup = this.jdField_a_of_type_AndroidViewView;
    if (paramViewGroup == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater.addView(paramViewGroup, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    paramLayoutInflater = new ExpandFlutterFrameLayout(a());
    paramLayoutInflater.addView(paramBundle, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
    a((View)paramLayoutInflater);
    paramLayoutInflater = (View)paramLayoutInflater;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    ExpandFlutterIPCClient.b();
    Object localObject1 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "activity");
    localObject1 = ((FragmentActivity)localObject1).getIntent().getSerializableExtra("params");
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.flutter.router.SerializableMap");
    }
    localObject1 = (SerializableMap)localObject1;
    QLog.d("ExpandFlutterContainerFragment", 2, "onDestroy " + ((SerializableMap)localObject1).getMap().get("startTime"));
    Object localObject2 = ((SerializableMap)localObject1).getMap();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "extra.map");
    ((Map)localObject2).put("startTime", "0");
    localObject2 = getActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "activity");
    ((FragmentActivity)localObject2).getIntent().putExtra("params", (Serializable)localObject1);
  }
  
  public void onPause()
  {
    super.onPause();
    this.c = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isDebugVersion())
      {
        Object localObject = getActivity();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "activity");
        localObject = ((FragmentActivity)localObject).getIntent().getSerializableExtra("params");
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.flutter.router.SerializableMap");
        }
        localObject = ((SerializableMap)localObject).getMap().get("startTime");
        if (localObject == null) {
          throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
        }
        localObject = (String)localObject;
        if (Long.parseLong((String)localObject) > 0L) {
          QLog.d("ExpandFlutterContainerFragment", 4, "time cost: " + (System.currentTimeMillis() - Long.parseLong((String)localObject)));
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */