package com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import bhgr;
import bhjr;
import com.tencent.biz.pubaccount.readinjoy.struct.ColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.selectvideo.SelectVideoFragment;
import com.tencent.biz.pubaccount.readinjoy.view.widget.TabLayoutCompat;
import com.tencent.biz.pubaccount.readinjoy.view.widget.ViewPagerCompat;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.util.VersionUtils;
import com.tencent.widget.immersive.ImmersiveTitleBar2;
import java.util.ArrayList;
import pfd;
import pfh;
import rab;
import rju;
import rjv;
import rjw;

public class SelectVideoTabFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  public static String a;
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2131717175, 2131717186 };
  private int jdField_a_of_type_Int;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private TabLayoutCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat;
  private ViewPagerCompat jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private PublicBaseFragment jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  private ImmersiveTitleBar2 jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2;
  private ArrayList<PublicBaseFragment> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private pfh jdField_a_of_type_Pfh = new rju(this);
  private String b = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = "KEY_BUNDLE";
  }
  
  private void a()
  {
    if ((VersionUtils.isM()) && (!bhjr.b()) && (!bhjr.d()))
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
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = ViolaFragment.newInstance(rab.b() + this.jdField_a_of_type_Int, null, true);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    this.jdField_a_of_type_JavaUtilArrayList.add(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.a(new rjw(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabMode(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabGravity(1);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorHeight(bhgr.a(getActivity(), 2.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorColor(Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingLeft(bhgr.a(getActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingRight(bhgr.a(getActivity(), 32.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setSelectedTabIndicatorPaddingBottom(bhgr.a(getActivity(), 0.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextColors(Color.parseColor("#737373"), Color.parseColor("#262626"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setTabTextSize(bhgr.c(getActivity(), 16.0F));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat.setupWithViewPager(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat, false);
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    pfd.a().a(this.jdField_a_of_type_Pfh);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131364596) {
      getActivity().finish();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    paramLayoutInflater = View.inflate(this.jdField_a_of_type_AndroidAppActivity, 2131560267, null);
    V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
    return paramLayoutInflater;
  }
  
  public void onDetach()
  {
    pfd.a().b(this.jdField_a_of_type_Pfh);
    super.onDetach();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    this.jdField_a_of_type_ComTencentWidgetImmersiveImmersiveTitleBar2 = ((ImmersiveTitleBar2)paramView.findViewById(2131379037));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131364596));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat = ((ViewPagerCompat)paramView.findViewById(2131377292));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetTabLayoutCompat = ((TabLayoutCompat)paramView.findViewById(2131377289));
    b();
    c();
    d();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setScrollable(false);
    paramView = getActivity().getSupportFragmentManager();
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setAdapter(new rjv(this, paramView));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetViewPagerCompat.setCurrentItem(0);
    a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.selectvideotab.SelectVideoTabFragment
 * JD-Core Version:    0.7.0.1
 */