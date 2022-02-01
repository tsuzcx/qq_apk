package com.tencent.biz.pubaccount.readinjoy.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyChannelViewPagerController;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ChannelModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.dt.RIJDtParamBuilder;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo.RedPoint;
import com.tencent.biz.widgets.TabLayout;
import com.tencent.biz.widgets.TabLayout.TabAdapter;
import com.tencent.biz.widgets.TabLayout.TabAdapter.TabViewHolder;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.List;
import java.util.Map;

public class ReadInJoyTabAdapter
  extends TabLayout.TabAdapter<TabChannelCoverInfo>
{
  public static final String a;
  private ReadInJoyChannelViewPagerController jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController;
  private Map<Integer, BaseReportData> jdField_a_of_type_JavaUtilMap;
  private TabLayout b;
  
  static
  {
    jdField_a_of_type_JavaLangString = ReadInJoyTabAdapter.class.getSimpleName();
  }
  
  public ReadInJoyTabAdapter(Context paramContext, List<TabChannelCoverInfo> paramList, TabLayout paramTabLayout, ReadInJoyChannelViewPagerController paramReadInJoyChannelViewPagerController)
  {
    super(paramContext, paramList);
    this.b = paramTabLayout;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController = paramReadInJoyChannelViewPagerController;
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)getItem(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.d());
    if (localTabChannelCoverInfo != null) {}
    for (int i = localTabChannelCoverInfo.mChannelCoverId;; i = 0)
    {
      VideoReport.reportEvent("clck", new RIJDtParamBuilder().a(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId)).a("14").b("channel_bar").c("click_channel").a().a("eid", "channel_button").a("ref_channel", Integer.valueOf(i)).a());
      return;
    }
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2)
  {
    if (paramTabChannelCoverInfo.redPoint != null)
    {
      BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
      localRedTypeInfo.red_type.set(0);
      localRedTypeInfo.red_content.set("");
      localRedTypeInfo.red_desc.set("");
      if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Boolean)
      {
        long l = System.currentTimeMillis() / 1000L;
        boolean bool = a(paramTabChannelCoverInfo, l);
        if ((paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Long <= l) && ((paramTabChannelCoverInfo.redPoint.b == 0L) || (paramTabChannelCoverInfo.redPoint.b >= l)))
        {
          a(paramTabChannelCoverInfo, paramInt, paramImageView1, paramImageView2, bool);
          return;
        }
        paramImageView2.setVisibility(8);
        paramImageView1.setVisibility(8);
        return;
      }
      paramImageView2.setVisibility(8);
      paramImageView1.setVisibility(8);
      return;
    }
    paramImageView2.setVisibility(8);
    paramImageView1.setVisibility(8);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt, ImageView paramImageView1, ImageView paramImageView2, boolean paramBoolean)
  {
    if (paramTabChannelCoverInfo.redPoint.jdField_a_of_type_Int == 0) {
      paramImageView2.setVisibility(0);
    }
    while ((paramInt >= b()) || (paramBoolean)) {
      return;
    }
    if (ReadInJoyChannelViewPagerController.b)
    {
      paramImageView1.setVisibility(0);
      paramImageView2 = new TranslateAnimation(1, 1.0F, 1, -1.0F, 1, -1.0F, 1, 1.0F);
      paramImageView2.setDuration(3000L);
      paramImageView2.setRepeatCount(1);
      paramImageView2.setStartOffset(1000L);
      paramImageView2.setFillAfter(true);
      paramImageView1.startAnimation(paramImageView2);
    }
    paramTabChannelCoverInfo.redPoint.c = (System.currentTimeMillis() / 1000L);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a(paramTabChannelCoverInfo);
  }
  
  private void a(TabChannelCoverInfo paramTabChannelCoverInfo1, TextView paramTextView, ImageView paramImageView1, ImageView paramImageView2, TabChannelCoverInfo paramTabChannelCoverInfo2)
  {
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverPicUrl))
    {
      paramImageView2.setVisibility(0);
      paramImageView2.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mChannelCoverPicUrl, true));
    }
    if (!TextUtils.isEmpty(paramTabChannelCoverInfo2.mIconUrl)) {
      paramImageView1.setVisibility(0);
    }
    try
    {
      paramImageView1.setImageDrawable(URLDrawable.getDrawable(paramTabChannelCoverInfo2.mIconUrl, true));
      if ((!TextUtils.isEmpty(paramTabChannelCoverInfo2.mChannelCoverName)) && (paramTabChannelCoverInfo2.onlyCover == 0))
      {
        paramTextView.setText(paramTabChannelCoverInfo1.mChannelCoverName);
        if (paramTabChannelCoverInfo1.fontsColor != 0)
        {
          i = paramTabChannelCoverInfo1.fontsColor;
          paramTextView.setTextColor(i);
          paramTextView.setVisibility(0);
        }
      }
      else
      {
        return;
      }
    }
    catch (Exception paramImageView1)
    {
      for (;;)
      {
        int i;
        if (QLog.isColorLevel())
        {
          QLog.d(jdField_a_of_type_JavaLangString, 2, "load channel cover error : " + paramImageView1);
          continue;
          i = -16777216;
        }
      }
    }
  }
  
  private void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, int paramInt, TextView paramTextView)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController != null)
    {
      paramTabViewHolder = paramTabViewHolder.a(2131369369);
      if (paramInt != this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.d()) {
        break label93;
      }
      paramTextView.setTextColor(paramTextView.getResources().getColor(2131166919));
      paramTextView.setTypeface(Typeface.defaultFromStyle(1));
      paramTabViewHolder.setVisibility(0);
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyReadInJoyChannelViewPagerController.a() == 0)
      {
        paramTextView = (ViewGroup.MarginLayoutParams)paramTabViewHolder.getLayoutParams();
        paramTextView.leftMargin = ViewUtils.b(0.0F);
        paramTextView.rightMargin = ViewUtils.b(0.0F);
        paramTabViewHolder.setLayoutParams(paramTextView);
      }
      return;
      label93:
      paramTextView.setTextColor(paramTextView.getResources().getColor(2131166920));
      paramTextView.setTypeface(Typeface.defaultFromStyle(0));
      paramTabViewHolder.setVisibility(4);
    }
  }
  
  private void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramVarArgs[i].setVisibility(8);
      i += 1;
    }
  }
  
  private int b()
  {
    if (ChannelModeConfigHandler.a()) {
      return 11;
    }
    return 6;
  }
  
  public int a()
  {
    return 2131560344;
  }
  
  protected void a(TabLayout.TabAdapter.TabViewHolder paramTabViewHolder, TabChannelCoverInfo paramTabChannelCoverInfo, int paramInt)
  {
    TextView localTextView = (TextView)paramTabViewHolder.a(2131380651);
    Object localObject = (ImageView)paramTabViewHolder.a(2131369690);
    ImageView localImageView1 = (ImageView)paramTabViewHolder.a(2131369693);
    ImageView localImageView2 = (ImageView)paramTabViewHolder.a(2131372214);
    a(new View[] { localTextView, localObject, localImageView1, localImageView2 });
    ImageView localImageView3 = (ImageView)paramTabViewHolder.a(2131369789);
    if (paramTabChannelCoverInfo != null)
    {
      a(paramTabChannelCoverInfo, localTextView, (ImageView)localObject, localImageView1, paramTabChannelCoverInfo);
      a(paramTabChannelCoverInfo, paramInt, localImageView2, localImageView3);
      paramTabViewHolder.a().setOnClickListener(new ReadInJoyTabAdapter.1(this, paramTabChannelCoverInfo, paramInt, paramTabChannelCoverInfo, localImageView3));
      if (this.b != null)
      {
        int i = this.b.getFirstVisiblePosition();
        int j = this.b.getLastVisiblePosition();
        if ((paramInt >= i) && (paramInt <= j) && (this.jdField_a_of_type_JavaUtilMap != null))
        {
          localObject = new ReportData();
          ((BaseReportData)localObject).a = paramTabChannelCoverInfo;
          ((BaseReportData)localObject).l = paramInt;
          this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramTabChannelCoverInfo.mChannelCoverId), localObject);
        }
      }
    }
    a(paramTabViewHolder, paramInt, localTextView);
  }
  
  public void a(Map<Integer, BaseReportData> paramMap)
  {
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  @VisibleForTesting
  boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, long paramLong)
  {
    return (paramTabChannelCoverInfo.redPoint.c != 0L) && ((float)(paramLong - paramTabChannelCoverInfo.redPoint.c) > 2.5F) && ((float)(paramLong / 3600L - paramTabChannelCoverInfo.redPoint.c / 3600L) < 1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyTabAdapter
 * JD-Core Version:    0.7.0.1
 */