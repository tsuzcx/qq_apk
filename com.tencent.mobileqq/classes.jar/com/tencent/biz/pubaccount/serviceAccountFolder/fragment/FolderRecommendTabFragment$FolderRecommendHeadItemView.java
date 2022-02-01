package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.biz.subscribe.widget.relativevideo.ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter;
import com.tencent.biz.videostory.support.VSReporter;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;
import cooperation.qzone.mobilereport.MobileReportManager;
import java.util.List;
import mqq.os.MqqHandler;

public class FolderRecommendTabFragment$FolderRecommendHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private FolderRecommendTabFragment.BannerPagerAdapter jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter;
  private ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  
  public FolderRecommendTabFragment$FolderRecommendHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559757;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.b();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)paramView.findViewById(2131376714));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.requestParentDisallowInterecptTouchEvent(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377854));
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter = new ServiceFolderFollowPBHeadView.ServiceAccountFoldAdapter(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.a(SubscribeUtils.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.a(FolderRecommendTabFragment.a());
    this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter = new FolderRecommendTabFragment.BannerPagerAdapter(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountServiceAccountFolderFragmentFolderRecommendTabFragment$BannerPagerAdapter);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)paramView.findViewById(2131376715));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, 0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(AIOUtils.a(6.0F, paramContext.getResources()));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new FolderRecommendTabFragment.FolderRecommendHeadItemView.2(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366390));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366389));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20201119210154_6KQkLOzrpX.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new FolderRecommendTabFragment.FolderRecommendHeadItemView.1(this, paramBoolean));
  }
  
  public void a(boolean paramBoolean, String paramString1, String paramString2)
  {
    if ((FolderRecommendTabFragment.jdField_a_of_type_AndroidWidgetTextView == null) || (FolderRecommendTabFragment.jdField_a_of_type_AndroidWidgetLinearLayout == null) || (FolderRecommendTabFragment.jdField_b_of_type_AndroidWidgetLinearLayout == null)) {
      return;
    }
    if (paramBoolean)
    {
      FolderRecommendTabFragment.d = paramString2;
      FolderRecommendTabFragment.jdField_a_of_type_AndroidWidgetTextView.setText(paramString1);
      FolderRecommendTabFragment.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      FolderRecommendTabFragment.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      MobileReportManager.getInstance().reportActionLive("", "25", "qq_live", "find_page", "bottom_button", 101, 1, System.currentTimeMillis(), "");
      return;
    }
    FolderRecommendTabFragment.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    FolderRecommendTabFragment.jdField_b_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      if (FolderRecommendTabFragment.jdField_b_of_type_AndroidViewView != null) {
        FolderRecommendTabFragment.jdField_b_of_type_AndroidViewView.setVisibility(8);
      }
      return;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
  }
  
  public void setAdapterData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter != null) {
      this.jdField_a_of_type_ComTencentBizSubscribeWidgetRelativevideoServiceFolderFollowPBHeadView$ServiceAccountFoldAdapter.a(paramObject);
    }
  }
  
  public void setData(Object paramObject)
  {
    super.setData(paramObject);
  }
  
  public void setTopBannerVisibility(boolean paramBoolean)
  {
    if (paramBoolean) {
      if (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() == 8)
      {
        this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(0);
        VSReporter.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView
 * JD-Core Version:    0.7.0.1
 */