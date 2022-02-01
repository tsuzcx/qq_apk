package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;
import java.util.List;
import mqq.os.MqqHandler;
import ubf;
import ubh;
import zbi;
import znb;
import zxp;

public class FolderRecommendTabFragment$FolderRecommendHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  private ubf jdField_a_of_type_Ubf;
  private znb jdField_a_of_type_Znb;
  private TextView b;
  
  public FolderRecommendTabFragment$FolderRecommendHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559646;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Znb != null) {
      this.jdField_a_of_type_Znb.b();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)paramView.findViewById(2131376072));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.requestParentDisallowInterecptTouchEvent(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377157));
    this.jdField_a_of_type_Znb = new znb(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Znb.a(zbi.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Znb);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Znb.a(FolderRecommendTabFragment.a());
    this.jdField_a_of_type_Ubf = new ubf(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Ubf);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)paramView.findViewById(2131376073));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, 0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(AIOUtils.dp2px(6.0F, paramContext.getResources()));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new ubh(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366118));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377160));
    this.b = ((TextView)paramView.findViewById(2131377161));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366117));
    paramContext = URLDrawable.getDrawable("https://sola.gtimg.cn/aoi/sola/20200530172043_bPKKBWfucM.png", null);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(paramContext);
  }
  
  public void a(Object paramObject) {}
  
  public void a(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new FolderRecommendTabFragment.FolderRecommendHeadItemView.1(this, paramBoolean));
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      this.b.setVisibility(8);
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    this.b.setVisibility(0);
  }
  
  public void setAdapterData(Object paramObject)
  {
    paramObject = (List)paramObject;
    if (this.jdField_a_of_type_Znb != null) {
      this.jdField_a_of_type_Znb.a(paramObject);
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
        zxp.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView
 * JD-Core Version:    0.7.0.1
 */