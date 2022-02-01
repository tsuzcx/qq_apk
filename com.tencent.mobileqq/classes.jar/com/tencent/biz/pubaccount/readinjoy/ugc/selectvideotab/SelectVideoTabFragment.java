package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtReportHelper;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyObserver;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;

public class SelectVideoTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131718277, 2131718288 };
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ReadInJoyObserver jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver = new SelectVideoTabFragment.1(this);
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private PublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private ArrayList<PublicBaseFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "KEY_BUNDLE";
  }
  
  private void a()
  {
    if ((VersionUtils.k()) && (!SystemUtil.b()) && (!SystemUtil.d()))
    {
      getActivity().getWindow().getDecorView().setSystemUiVisibility(9216);
      this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2.setBackgroundColor(-1);
    }
  }
  
  private void b()
  {
    Bundle localBundle = getArguments();
    ColumnInfo localColumnInfo;
    if (localBundle != null)
    {
      localColumnInfo = (ColumnInfo)localBundle.getParcelable("key_column_info");
      if (localColumnInfo == null) {
        break label44;
      }
    }
    label44:
    for (int i = localColumnInfo.columnID;; i = 0)
    {
      this.jdField_a_of_type_Int = i;
      this.b = localBundle.getString("arg_callback");
      return;
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment = SelectVideoFragment.a(false);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = ViolaFragment.newInstance(RIJUgcUtils.b() + this.jdField_a_of_type_Int, null, true);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(new SelectVideoTabFragment.3(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(DisplayUtil.a(getActivity(), 2.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(DisplayUtil.a(getActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(DisplayUtil.a(getActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(DisplayUtil.a(getActivity(), 0.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(Color.parseColor("#737373"), Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextSize(DisplayUtil.c(getActivity(), 16.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt1 == 10001) && (paramInt2 == -1)) {
      this.jdField_a_of_type_AndroidAppActivity.finish();
    }
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    ReadInJoyLogicEngineEventDispatcher.a().a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364828) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    RIJDtReportHelper.a.a(getActivity());
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560392, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    ReadInJoyLogicEngineEventDispatcher.a().b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyEngineReadInJoyObserver);
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379533));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364828));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131377738));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131377733));
    b();
    c();
    d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    paramView = getActivity().getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(new SelectVideoTabFragment.2(this, paramView));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(0);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment
 * JD-Core Version:    0.7.0.1
 */