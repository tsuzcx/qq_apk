package com.tencent.biz.pubaccount.readinjoy.ugc;

import ajyc;
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
import bbay;
import bbkx;
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
import osj;
import pbg;
import qff;

public class ReadInJoyDraftboxFragment
  extends IphoneTitleBarFragment
{
  private List<ReadInJoyDraftboxItem> jdField_a_of_type_JavaUtilList = new ArrayList();
  private pbg jdField_a_of_type_Pbg = osj.a().a();
  private qff jdField_a_of_type_Qff;
  
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
      if ((bbay.b()) || (bbay.d())) {
        break label146;
      }
      localFragmentActivity.mSystemBarComp.setStatusBarColor(-7829368);
    }
    for (;;)
    {
      this.leftView.setTextColor(-14408926);
      this.leftView.setBackgroundResource(2130848492);
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
      if ((Build.VERSION.SDK_INT >= 23) && (!bbay.b()) && (!bbay.d()))
      {
        localFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
        localFragmentActivity.mSystemBarComp.setStatusBarColor(-1);
      }
      else if (!bbay.d())
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
    this.jdField_a_of_type_Qff = new qff(getActivity(), this.jdField_a_of_type_JavaUtilList);
    if (this.mContentView != null)
    {
      paramLayoutInflater = (SwipListView)this.mContentView.findViewById(2131365384);
      paramLayoutInflater.setAdapter(this.jdField_a_of_type_Qff);
      paramLayoutInflater.setDragEnable(true);
      paramLayoutInflater.setDivider(new ColorDrawable(Color.parseColor("#FFF2F2F2")));
      paramLayoutInflater.setDividerHeight(bbkx.a(0.5F));
      paramLayoutInflater.setEmptyView(this.mContentView.findViewById(2131365383));
    }
    setTitle(ajyc.a(2131712991));
    if (this.leftView != null) {
      this.leftView.setText(ajyc.a(2131712992));
    }
    a();
  }
  
  public int getContentLayoutId()
  {
    return 2131559909;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyDraftboxFragment
 * JD-Core Version:    0.7.0.1
 */