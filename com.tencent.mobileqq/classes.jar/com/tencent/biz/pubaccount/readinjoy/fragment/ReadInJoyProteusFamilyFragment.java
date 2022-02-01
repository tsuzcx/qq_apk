package com.tencent.biz.pubaccount.readinjoy.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.IphoneTitleBarFragment;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.PopupMenuDialog;
import com.tencent.widget.PopupMenuDialog.MenuItem;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public class ReadInJoyProteusFamilyFragment
  extends IphoneTitleBarFragment
  implements ReadInJoyDropFrameHelper.OnFeedsFluencyResultListener, ReadInJoyProteusFamilyUtil.OnProteusFamilyDataLoaded
{
  private Context jdField_a_of_type_AndroidContentContext;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private ReadInJoyProteusFamilyViewController jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController;
  
  private void a()
  {
    if (this.jdField_a_of_type_AndroidContentContext != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController = new ReadInJoyProteusFamilyViewController((Activity)this.jdField_a_of_type_AndroidContentContext);
      ViewGroup localViewGroup = (ViewGroup)this.mContentView.findViewById(2131373588);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.a(localViewGroup);
      b();
    }
  }
  
  private void a(int paramInt)
  {
    if (this.leftView != null)
    {
      this.leftView.setTextColor(paramInt);
      this.leftView.setBackgroundResource(2130849916);
    }
    if (this.centerView != null) {
      this.centerView.setTextColor(paramInt);
    }
  }
  
  private void b()
  {
    setTitle(this.jdField_a_of_type_AndroidContentContext.getString(2131718324));
    RIJAppSetting.a(getTitleBarView());
    a(-16777216);
    Object localObject = this.rightViewImg;
    if (localObject != null)
    {
      ((ImageView)localObject).setImageResource(2130843052);
      ((ImageView)localObject).setVisibility(0);
      ((ImageView)localObject).setBackgroundResource(0);
      ((ImageView)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.2(this, (ImageView)localObject));
    }
    localObject = getTitleBarView();
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new ReadInJoyProteusFamilyFragment.3(this));
    }
  }
  
  public void a(BaseActivity paramBaseActivity, View paramView)
  {
    ArrayList localArrayList = new ArrayList();
    int[] arrayOfInt = new int[3];
    int[] tmp16_14 = arrayOfInt;
    tmp16_14[0] = 0;
    int[] tmp20_16 = tmp16_14;
    tmp20_16[1] = 1;
    int[] tmp24_20 = tmp20_16;
    tmp24_20[2] = 2;
    tmp24_20;
    String str1 = BaseApplicationImpl.getApplication().getString(2131718324);
    String str2 = BaseApplicationImpl.getApplication().getString(2131718324);
    String str3 = BaseApplicationImpl.getApplication().getString(2131718324);
    int i = 0;
    while (i < arrayOfInt.length)
    {
      PopupMenuDialog.MenuItem localMenuItem = new PopupMenuDialog.MenuItem();
      localMenuItem.jdField_a_of_type_Int = arrayOfInt[i];
      localMenuItem.jdField_a_of_type_JavaLangString = new String[] { str1, str2, str3 }[i];
      localMenuItem.b = new int[] { 2130843045, 2130843046, 2130843045 }[i];
      localArrayList.add(localMenuItem);
      i += 1;
    }
    i = ViewUtils.a(125.0F);
    PopupMenuDialog.a(paramBaseActivity, localArrayList, new ReadInJoyProteusFamilyFragment.4(this), new ReadInJoyProteusFamilyFragment.5(this), i, false, -1, 2131755033).showAsDropDown(paramView, -(i - paramView.getWidth()), 0);
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
  }
  
  public void a(boolean paramBoolean, List<BaseArticleInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null) && (paramList.size() > 0)) {
      ThreadManager.getUIHandler().post(new ReadInJoyProteusFamilyFragment.1(this, paramList));
    }
  }
  
  public void doOnCreateView(LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.doOnCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    a();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.a();
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.mContentView.findViewById(2131366896));
    ReadInJoyDropFrameHelper.a().a(8888, this);
  }
  
  public int getContentLayoutId()
  {
    return 2131560372;
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.a(paramInt1, paramInt2, paramIntent);
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.jdField_a_of_type_AndroidContentContext = getActivity();
    ReadInJoyProteusFamilyUtil.a().a(this);
    ReadInJoyProteusFamilyUtil.a().a();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    ReadInJoyProteusFamilyUtil.a().b();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.d();
    }
    ReadInJoyDropFrameHelper.a().b(8888, this);
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.c();
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.g();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.h();
    }
    RIJAppSetting.a(getActivity(), true, RIJAppSetting.a(getActivity()));
  }
  
  public void onStart()
  {
    super.onStart();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.e();
    }
  }
  
  public void onStop()
  {
    super.onStop();
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyFragmentReadInJoyProteusFamilyViewController.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyProteusFamilyFragment
 * JD-Core Version:    0.7.0.1
 */