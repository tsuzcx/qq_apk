package com.tencent.biz.expand.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.QFragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog;
import com.tencent.mobileqq.extendfriend.wiget.FillBirthdayDialog.OnConfirmListener;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/expand/ui/ExpandBirthPickFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ExpandBirthPickFragment
  extends QPublicBaseFragment
{
  public static final ExpandBirthPickFragment.Companion a = new ExpandBirthPickFragment.Companion(null);
  
  @NotNull
  public View onCreateView(@Nullable LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    paramLayoutInflater = new FrameLayout((Context)getActivity());
    paramLayoutInflater.setBackgroundColor(0);
    if (getActivity().mSystemBarComp == null) {
      getActivity().setImmersiveStatus(0);
    }
    for (;;)
    {
      paramViewGroup = getActivity();
      Intrinsics.checkExpressionValueIsNotNull(paramViewGroup, "activity");
      paramViewGroup = new FillBirthdayDialog((Context)paramViewGroup, getArguments().getInt("birth_date", 0), (FillBirthdayDialog.OnConfirmListener)new ExpandBirthPickFragment.onCreateView.fillBirthdayDialog.1(this));
      if (QLog.isColorLevel()) {
        QLog.d("ExpandRouter", 2, "showFillBirthdayDialog do show");
      }
      paramViewGroup.show();
      return (View)paramLayoutInflater;
      getActivity().mSystemBarComp.setStatusBarDrawable(null);
      getActivity().mSystemBarComp.setStatusBarColor(0);
      getActivity().mSystemBarComp.setStatusColor(0);
    }
  }
  
  public void onPause()
  {
    QFragmentActivity localQFragmentActivity = getActivity();
    if (localQFragmentActivity != null) {
      localQFragmentActivity.overridePendingTransition(0, 0);
    }
    super.onPause();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.expand.ui.ExpandBirthPickFragment
 * JD-Core Version:    0.7.0.1
 */