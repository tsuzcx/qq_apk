package com.tencent.biz.expand.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment;
import com.tencent.biz.expand.flutter.ExpandFlutterContainerFragment.Companion;
import com.tencent.biz.expand.provider.AppRuntimeProvider;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportV4Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandFriendSubFragment;", "Landroid/support/v4/app/Fragment;", "Lcom/tencent/biz/expand/provider/AppRuntimeProvider;", "Landroid/view/View$OnClickListener;", "appRuntimeProvider", "(Lcom/tencent/biz/expand/provider/AppRuntimeProvider;)V", "appRuntime", "Lmqq/app/AppRuntime;", "getAppRuntime", "()Lmqq/app/AppRuntime;", "fragmentText", "", "getFragmentText", "()Ljava/lang/String;", "setFragmentText", "(Ljava/lang/String;)V", "identify", "", "getIdentify", "()I", "setIdentify", "(I)V", "onClick", "", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "onStart", "onStop", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"ValidFragment"})
public final class ExpandFriendSubFragment
  extends ReportV4Fragment
  implements View.OnClickListener, AppRuntimeProvider
{
  public static final ExpandFriendSubFragment.Companion a;
  private int jdField_a_of_type_Int;
  @NotNull
  private String jdField_a_of_type_JavaLangString;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  
  static
  {
    jdField_a_of_type_ComTencentBizExpandUiExpandFriendSubFragment$Companion = new ExpandFriendSubFragment.Companion(null);
  }
  
  public ExpandFriendSubFragment(@NotNull AppRuntimeProvider paramAppRuntimeProvider)
  {
    this.jdField_a_of_type_ComTencentBizExpandProviderAppRuntimeProvider = paramAppRuntimeProvider;
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = System.identityHashCode(this);
  }
  
  @NotNull
  public AppRuntime a()
  {
    return this.jdField_a_of_type_ComTencentBizExpandProviderAppRuntimeProvider.a();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      this.jdField_a_of_type_JavaUtilHashMap.clear();
    }
  }
  
  public void onClick(@Nullable View paramView)
  {
    ExpandFlutterContainerFragment.a.a((Context)getActivity(), "QQCirSearchDetailWidget", MapsKt.mutableMapOf(new Pair[] { TuplesKt.to("hostId", "8531243") }), new byte[0]);
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onCreate fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramViewGroup = new FrameLayout(paramLayoutInflater.getContext());
    paramBundle = getArguments().getString("ARGS_TEXT");
    if (paramBundle == null) {
      Intrinsics.throwNpe();
    }
    this.jdField_a_of_type_JavaLangString = paramBundle;
    paramLayoutInflater = new TextView(paramLayoutInflater.getContext());
    paramLayoutInflater.setText((CharSequence)(this.jdField_a_of_type_JavaLangString + "  Account: " + a().getAccount()));
    paramLayoutInflater.setOnClickListener((View.OnClickListener)this);
    paramBundle = new FrameLayout.LayoutParams(-2, -2);
    paramBundle.gravity = 17;
    paramViewGroup.addView((View)paramLayoutInflater, (ViewGroup.LayoutParams)paramBundle);
    paramLayoutInflater = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onCreateView fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
    paramLayoutInflater = (View)paramViewGroup;
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onDestroy fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
  
  public void onPause()
  {
    super.onPause();
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onPause fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
  
  public void onResume()
  {
    super.onResume();
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onResume fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
  
  public void onStart()
  {
    super.onStart();
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onStart fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
  
  public void onStop()
  {
    super.onStop();
    LogUtils localLogUtils = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSubFragment", 2, "onStop fragment [" + this.jdField_a_of_type_Int + "][" + this.jdField_a_of_type_JavaLangString + ']');
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandFriendSubFragment
 * JD-Core Version:    0.7.0.1
 */