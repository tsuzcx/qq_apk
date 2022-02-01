package com.tencent.biz.pubaccount.readinjoy.view.widget.banner;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.view.ViewPager.SimpleOnPageChangeListener;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.basic.ProteusSupportUtilBase;
import com.tencent.biz.pubaccount.readinjoy.proteus.item.ProteusItemView;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopBannerInfo.DynamicItem;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.view.ViewPagerScroller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ChannelTopBanner
  extends RelativeLayout
{
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  protected int a;
  protected Context a;
  protected Drawable a;
  protected Handler a;
  protected ViewPager.SimpleOnPageChangeListener a;
  protected LinearLayout.LayoutParams a;
  protected LinearLayout a;
  protected BannerAdapter a;
  private ChannelTopBanner.PagerChangeTransformer jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer;
  protected RollViewPager a;
  protected boolean a;
  protected View[] a;
  protected Drawable b;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private boolean jdField_b_of_type_Boolean = true;
  private boolean c = false;
  
  public ChannelTopBanner(Activity paramActivity)
  {
    super(paramActivity);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler = new ChannelTopBanner.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    a(paramActivity);
  }
  
  private String a(TopBannerInfo paramTopBannerInfo)
  {
    if (paramTopBannerInfo == null) {
      return null;
    }
    return paramTopBannerInfo.mChannelId + "_" + paramTopBannerInfo.mCookie;
  }
  
  private void a(int paramInt)
  {
    View localView1 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a(paramInt);
    View localView2 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a(paramInt - 1);
    View localView3 = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a(paramInt + 1);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.getCount() > 1))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView1, 0.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView2, -1.0F);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer.transformPage(localView3, 1.0F);
    }
  }
  
  private void a(View paramView)
  {
    this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  private void a(TemplateBean paramTemplateBean)
  {
    ReadinjoyReportUtils.a(paramTemplateBean, null, "expose_T");
  }
  
  protected View a()
  {
    View localView = new View(this.jdField_a_of_type_AndroidContentContext);
    if (this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams == null)
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams = new LinearLayout.LayoutParams(UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 11.0F), UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 2.0F));
      this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams.leftMargin = UIUtils.a(this.jdField_a_of_type_AndroidContentContext, 6.0F);
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849730);
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = getResources().getDrawable(2130849731);
    }
    localView.setLayoutParams(this.jdField_a_of_type_AndroidWidgetLinearLayout$LayoutParams);
    localView.setBackgroundDrawable(this.jdField_a_of_type_AndroidGraphicsDrawableDrawable);
    return localView;
  }
  
  public void a()
  {
    int j = this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a();
    if (j == 0) {
      if (QLog.isColorLevel()) {
        QLog.d("ChannelTopBanner", 2, "startRoll error, the count of avatars is 0...");
      }
    }
    for (;;)
    {
      return;
      this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (j > 1)
      {
        this.jdField_a_of_type_ArrayOfAndroidViewView = new View[j];
        int i = 0;
        while (i < j)
        {
          this.jdField_a_of_type_ArrayOfAndroidViewView[i] = a();
          this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_ArrayOfAndroidViewView[i]);
          i += 1;
        }
        this.jdField_a_of_type_ArrayOfAndroidViewView[0].setBackgroundDrawable(this.jdField_b_of_type_AndroidGraphicsDrawableDrawable);
        this.jdField_a_of_type_Int = 1;
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setCurrentItem(this.jdField_a_of_type_Int, false);
        d();
      }
      while (QLog.isColorLevel())
      {
        QLog.d("ChannelTopBanner", 2, "startRoll is called successfully");
        return;
        e();
      }
    }
  }
  
  protected void a(Activity paramActivity)
  {
    LayoutInflater.from(paramActivity).inflate(2131560099, this, true);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager = ((RollViewPager)findViewById(2131381672));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOffscreenPageLimit(5);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setPageMargin(ViewUtils.a(-10.0F));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370555));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnPageChangeListener(new ChannelTopBanner.RollerChangeListener(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setOnTouchStateChangeListener(new ChannelTopBanner.2(this));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter = new BannerAdapter(paramActivity, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager, BannerAdapter.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer = new ChannelTopBanner.PagerChangeTransformer(this, null);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setPageTransformer(true, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerChannelTopBanner$PagerChangeTransformer);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setAdapter(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter);
    paramActivity = new ViewPagerScroller(this.jdField_a_of_type_AndroidContentContext, new LinearInterpolator());
    paramActivity.a(400);
    paramActivity.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager);
    setClipChildren(false);
    this.jdField_b_of_type_AndroidWidgetLinearLayout = ((LinearLayout)findViewById(2131370552));
  }
  
  public void a(ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, TopBannerInfo paramTopBannerInfo)
  {
    int i;
    label73:
    int j;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter != null)
    {
      if (paramTopBannerInfo.items.size() > 0)
      {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a(paramTopBannerInfo);
        a();
        a(true);
      }
    }
    else
    {
      this.jdField_b_of_type_AndroidWidgetLinearLayout.removeAllViews();
      if (paramTopBannerInfo.dynamicItems.size() <= 0) {
        break label267;
      }
      if (jdField_a_of_type_JavaUtilSet.contains(a(paramTopBannerInfo))) {
        break label238;
      }
      i = 1;
      jdField_a_of_type_JavaUtilSet.add(a(paramTopBannerInfo));
      j = 0;
      label90:
      if (j >= paramTopBannerInfo.dynamicItems.size()) {
        return;
      }
      TopBannerInfo.DynamicItem localDynamicItem = (TopBannerInfo.DynamicItem)paramTopBannerInfo.dynamicItems.get(j);
      if ((localDynamicItem == null) || (TextUtils.isEmpty(localDynamicItem.a))) {
        break label255;
      }
      QLog.d("ChannelTopBanner", 2, new Object[] { "json = ", localDynamicItem.a });
      ProteusItemView localProteusItemView = ProteusSupportUtilBase.a(paramReadInJoyBaseAdapter.a(), "default_feeds", ProteusSupportUtilBase.a(localDynamicItem.a));
      if (localProteusItemView == null) {
        break label243;
      }
      ProteusSupportUtilBase.a(localProteusItemView, paramReadInJoyBaseAdapter.a(), "default_feeds", localDynamicItem.a);
      a(localProteusItemView);
      if (i != 0) {
        a(localProteusItemView.a());
      }
    }
    for (;;)
    {
      j += 1;
      break label90;
      a(false);
      break;
      label238:
      i = 0;
      break label73;
      label243:
      QLog.d("ChannelTopBanner", 2, "refreshBanner, header is null.");
      continue;
      label255:
      QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicJSON is null.");
    }
    label267:
    QLog.d("ChannelTopBanner", 2, "refreshBanner, dynamicItems is null.");
  }
  
  protected void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerRollViewPager.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
  }
  
  public void b()
  {
    d();
  }
  
  public void c()
  {
    e();
  }
  
  protected void d()
  {
    this.jdField_b_of_type_Boolean = false;
    if (this.c)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
    }
  }
  
  protected void e()
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.c = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_AndroidOsHandler.sendMessageDelayed(this.jdField_a_of_type_AndroidOsHandler.obtainMessage(), 4000L);
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetBannerBannerAdapter.a();
    }
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.c = false;
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
  }
  
  public void setOnPageChangeListener(ViewPager.SimpleOnPageChangeListener paramSimpleOnPageChangeListener)
  {
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager$SimpleOnPageChangeListener = paramSimpleOnPageChangeListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.banner.ChannelTopBanner
 * JD-Core Version:    0.7.0.1
 */