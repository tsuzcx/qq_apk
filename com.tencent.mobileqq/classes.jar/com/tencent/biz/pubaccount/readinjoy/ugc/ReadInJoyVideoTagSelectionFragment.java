package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.Intent;
import android.database.DataSetObserver;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.TagInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyFlowLayout;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.ArrayList;
import lzc;
import lzd;
import lze;
import lzf;
import lzg;
import lzh;
import lzi;

public class ReadInJoyVideoTagSelectionFragment
  extends IphoneTitleBarFragment
  implements View.OnClickListener
{
  private DataSetObserver jdField_a_of_type_AndroidDatabaseDataSetObserver = new lzc(this);
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new lze(this);
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private lzh jdField_a_of_type_Lzh;
  private lzi jdField_a_of_type_Lzi;
  private DataSetObserver jdField_b_of_type_AndroidDatabaseDataSetObserver = new lzd(this);
  private View jdField_b_of_type_AndroidViewView;
  private QQToast jdField_b_of_type_ComTencentMobileqqWidgetQQToast;
  private View c;
  
  private void b()
  {
    this.c.setVisibility(0);
  }
  
  private void c()
  {
    this.c = this.jdField_e_of_type_AndroidViewView.findViewById(2131367355);
    this.c.setOnClickListener(this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_e_of_type_AndroidViewView.findViewById(2131367360));
    this.jdField_a_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131367359);
    this.jdField_b_of_type_AndroidViewView = this.jdField_e_of_type_AndroidViewView.findViewById(2131367362);
    ReadInJoyFlowLayout localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131367361);
    this.jdField_a_of_type_Lzh = new lzh(getActivity(), 2130969664);
    this.jdField_a_of_type_Lzh.registerDataSetObserver(this.jdField_a_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Lzh);
    localReadInJoyFlowLayout.setOnItemClickListener(new lzf(this));
    localReadInJoyFlowLayout = (ReadInJoyFlowLayout)this.jdField_e_of_type_AndroidViewView.findViewById(2131367363);
    this.jdField_a_of_type_Lzi = new lzi(getActivity(), 2130969664);
    this.jdField_a_of_type_Lzi.registerDataSetObserver(this.jdField_b_of_type_AndroidDatabaseDataSetObserver);
    localReadInJoyFlowLayout.setAdapter(this.jdField_a_of_type_Lzi);
    this.jdField_a_of_type_Lzi.notifyDataSetChanged();
    localReadInJoyFlowLayout.setOnItemClickListener(new lzg(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131438915, 0);
    this.jdField_b_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getActivity(), 2131438914, 0);
    d();
  }
  
  private void d()
  {
    Object localObject3 = getActivity().getIntent();
    Object localObject1;
    if (localObject3 != null)
    {
      localObject1 = ((Intent)localObject3).getStringExtra("EXTRA_TOPIC_ID");
      if (localObject1 == null) {}
    }
    for (;;)
    {
      try
      {
        localObject1 = Long.valueOf((String)localObject1);
        ArrayList localArrayList = ((Intent)localObject3).getParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST");
        localObject3 = localObject1;
        if (localArrayList != null)
        {
          this.jdField_a_of_type_Lzh.addAll(localArrayList);
          localObject3 = localObject1;
        }
        this.jdField_a_of_type_Lzh.notifyDataSetChanged();
        ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
        if (localObject3 == null) {
          break label97;
        }
        ReadInJoyLogicEngine.a().b(((Long)localObject3).longValue());
        return;
      }
      catch (NumberFormatException localNumberFormatException)
      {
        QLog.d("ReadInJoyVideoTagSelectionFragment", 2, "handleIntent: fail to get topicId");
      }
      Object localObject2 = null;
      continue;
      label97:
      ReadInJoyLogicEngine.a().f(null);
      return;
      localObject3 = null;
    }
  }
  
  private void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetNavbarNavBarCommon.a(true);
    b(2131432417, this);
    this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(-16265040);
    this.jdField_e_of_type_AndroidWidgetTextView.setBackgroundResource(0);
    a(getString(2131438909));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(2131432414);
    PublicFragmentActivity localPublicFragmentActivity;
    SystemBarCompact localSystemBarCompact;
    if ((getActivity() != null) && ((getActivity() instanceof PublicFragmentActivity)))
    {
      localPublicFragmentActivity = (PublicFragmentActivity)getActivity();
      localSystemBarCompact = localPublicFragmentActivity.mSystemBarComp;
      if ((localSystemBarCompact != null) && (b()) && (a()) && (ImmersiveUtils.isSupporImmersive() == 1))
      {
        if (!ThemeUtil.isInNightMode(localPublicFragmentActivity.getAppRuntime())) {
          break label149;
        }
        if ((SystemUtil.b()) || (SystemUtil.d())) {
          break label136;
        }
        localSystemBarCompact.setStatusBarColor(-7829368);
      }
    }
    return;
    label136:
    localSystemBarCompact.setStatusBarColor(-7829368);
    localSystemBarCompact.setStatusBarDarkMode(true);
    return;
    label149:
    if ((Build.VERSION.SDK_INT >= 23) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      localPublicFragmentActivity.getWindow().getDecorView().setSystemUiVisibility(9216);
      localSystemBarCompact.setStatusBarColor(-1);
      return;
    }
    if (!SystemUtil.d())
    {
      localSystemBarCompact.setStatusBarColor(-2368549);
      return;
    }
    localSystemBarCompact.setStatusBarColor(-1);
    localSystemBarCompact.setStatusBarDarkMode(true);
  }
  
  private void f()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("public_fragment_window_feature", 1);
    localIntent.putExtra("EXTRA_SELECTION_REACH_MAXIMUM_NUMBER", this.jdField_a_of_type_Lzh.a());
    PublicFragmentActivity.Launcher.a(getActivity(), localIntent, PublicTransFragmentActivity.class, ReadInJoyVideoSearchTagFragment.class, 1000);
  }
  
  private void g()
  {
    Intent localIntent = new Intent();
    ArrayList localArrayList = new ArrayList();
    int j = this.jdField_a_of_type_Lzh.getCount();
    int i = 0;
    while (i < j)
    {
      localArrayList.add(this.jdField_a_of_type_Lzh.getItem(i));
      i += 1;
    }
    localIntent.putParcelableArrayListExtra("EXTRA_SELECTED_TAG_LIST", localArrayList);
    getActivity().setResult(-1, localIntent);
    getActivity().finish();
  }
  
  protected int a()
  {
    return 2130969663;
  }
  
  protected void a(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.a(paramLayoutInflater, paramViewGroup, paramBundle);
    c();
  }
  
  public boolean d()
  {
    g();
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1000) && (paramInt2 == -1))
    {
      paramIntent = (TagInfo)paramIntent.getParcelableExtra("SEARCH_TAG_RESULT");
      if ((paramIntent != null) && (!this.jdField_a_of_type_Lzh.a(paramIntent)) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.c())) {
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131367355: 
      this.c.setVisibility(8);
      f();
      return;
    }
    g();
  }
  
  public void onPause()
  {
    super.onPause();
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onResume()
  {
    super.onResume();
    e();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.ReadInJoyVideoTagSelectionFragment
 * JD-Core Version:    0.7.0.1
 */