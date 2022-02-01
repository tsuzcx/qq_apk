package com.tencent.biz.pubaccount.serviceAccountFolder.fragment;

import aaek;
import aaqh;
import abbe;
import agej;
import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.subscribe.widget.relativevideo.RelativeFeedBaseHeaderView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQViewPager;
import com.tencent.widget.CirclePageIndicator;
import java.util.List;
import mqq.os.MqqHandler;
import tup;
import tur;

public class FolderRecommendTabFragment$FolderRecommendHeadItemView
  extends RelativeFeedBaseHeaderView
{
  private aaqh jdField_a_of_type_Aaqh;
  private LinearLayoutManager jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager;
  private RecyclerView jdField_a_of_type_AndroidSupportV7WidgetRecyclerView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private QQViewPager jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager;
  private CirclePageIndicator jdField_a_of_type_ComTencentWidgetCirclePageIndicator;
  private tup jdField_a_of_type_Tup;
  private TextView b;
  
  public FolderRecommendTabFragment$FolderRecommendHeadItemView(Context paramContext)
  {
    super(paramContext);
  }
  
  public int a()
  {
    return 2131559644;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aaqh != null) {
      this.jdField_a_of_type_Aaqh.b();
    }
  }
  
  public void a(Context paramContext, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager = ((QQViewPager)paramView.findViewById(2131376306));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.a(true);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView = ((RecyclerView)paramView.findViewById(2131377394));
    this.jdField_a_of_type_Aaqh = new aaqh(getContext(), this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView);
    this.jdField_a_of_type_Aaqh.a(aaek.a());
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setAdapter(this.jdField_a_of_type_Aaqh);
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager = new LinearLayoutManager(getContext());
    this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager.setOrientation(0);
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setLayoutManager(this.jdField_a_of_type_AndroidSupportV7WidgetLinearLayoutManager);
    this.jdField_a_of_type_Aaqh.a(FolderRecommendTabFragment.a());
    this.jdField_a_of_type_Tup = new tup(null);
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager.setAdapter(this.jdField_a_of_type_Tup);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator = ((CirclePageIndicator)paramView.findViewById(2131376307));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setViewPager(this.jdField_a_of_type_ComTencentMobileqqWidgetQQViewPager, 0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setBackgroundColor(0);
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setCirclePadding(agej.a(6.0F, paramContext.getResources()));
    this.jdField_a_of_type_ComTencentWidgetCirclePageIndicator.setOnPageChangeListener(new tur(this));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131366088));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377397));
    this.b = ((TextView)paramView.findViewById(2131377398));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366087));
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
    if (this.jdField_a_of_type_Aaqh != null) {
      this.jdField_a_of_type_Aaqh.a(paramObject);
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
        abbe.a("auth_follow", "service_exp", 0, 0, new String[0]);
      }
    }
    while (this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.getVisibility() != 0) {
      return;
    }
    this.jdField_a_of_type_AndroidSupportV7WidgetRecyclerView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.fragment.FolderRecommendTabFragment.FolderRecommendHeadItemView
 * JD-Core Version:    0.7.0.1
 */