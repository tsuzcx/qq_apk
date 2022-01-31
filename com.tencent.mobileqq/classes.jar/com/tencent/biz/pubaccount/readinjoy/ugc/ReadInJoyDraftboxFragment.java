package com.tencent.biz.pubaccount.readinjoy.ugc;

import alud;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import bdep;
import bdoo;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyDraftboxItem;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;
import owy;
import pgo;
import qpi;

public class ReadInJoyDraftboxFragment
  extends IphoneTitleBarFragment
{
  private List<ReadInJoyDraftboxItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private pgo jdField_a_of_type_Pgo = owy.a().a();
  private qpi jdField_a_of_type_Qpi;
  
  private void b()
  {
    ThreadManager.getSubThreadHandler().post(new ReadInJoyDraftboxFragment.1(this));
  }
  
  private static boolean b(ReadInJoyDraftboxItem paramReadInJoyDraftboxItem)
  {
    return (paramReadInJoyDraftboxItem.type != 1) && (paramReadInJoyDraftboxItem.type != 3) && (paramReadInJoyDraftboxItem.type != 2);
  }
  
  public void a()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null) {
      return;
    }
    if ((localFragmentActivity.mNeedStatusTrans) && (ImmersiveUtils.isSupporImmersive() == 1))
    {
      localFragmentActivity.getWindow().addFlags(67108864);
      ImmersiveUtils.a(localFragmentActivity.getWindow(), localFragmentActivity.isClearCoverLayer);
      if (localFragmentActivity.mSystemBarComp == null) {
        localFragmentActivity.mSystemBarComp = new SystemBarCompact(localFragmentActivity, true, -1);
      }
      localFragmentActivity.mSystemBarComp.init();
      if (!ThemeUtil.isInNightMode(localFragmentActivity.app)) {
        break label166;
      }
      if ((bdep.b()) || (bdep.d())) {
        break label146;
      }
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848998);
      if (this.centerView != null) {
        this.centerView.setTextColor(-16777216);
      }
      this.vg.setBackgroundColor(-1);
      return;
      label146:
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
      localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      continue;
      label166:
      if ((Build.VERSION.SDK_INT >= 23) && (!bdep.b()) && (!bdep.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bdep.d())
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-2368549);
      }
      else
      {
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
        localFragmentActivity.mSystemBarComp.setStatusBarDarkMode(true);
      }
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    this.jdField_a_of_type_Qpi = new qpi(getActivity(), this.jdField_a_of_type_JavaUtilList);
    if (this.mContentView != null)
    {
      paramLayoutInflater = (SwipListView)this.mContentView.findViewById(2131365470);
      paramLayoutInflater.setAdapter(this.jdField_a_of_type_Qpi);
      paramLayoutInflater.setDragEnable(true);
      paramLayoutInflater.setDivider(new ColorDrawable(Color.parseColor("#FFF2F2F2")));
      paramLayoutInflater.setDividerHeight(bdoo.a(0.5F));
      paramLayoutInflater.setEmptyView(this.mContentView.findViewById(2131365469));
    }
    setTitle(alud.a(2131713386));
    if (this.leftView != null) {
      this.leftView.setText(alud.a(2131713387));
    }
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131560004;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  public void onResume()
  {
    super.onResume();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment
 * JD-Core Version:    0.7.0.1
 */