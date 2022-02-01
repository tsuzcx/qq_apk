package com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFeedsSoftAdTest
  implements View.OnClickListener
{
  private static VideoInfo jdField_a_of_type_ComTencentBizPubaccountVideoInfo;
  private static String jdField_a_of_type_JavaLangString = "";
  private static String jdField_b_of_type_JavaLangString;
  private int jdField_a_of_type_Int = 0;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private VideoFeedsSoftAdBarDelegateForAd jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd;
  GdtAdListener jdField_a_of_type_ComTencentGdtadApiGdtAdListener = new VideoFeedsSoftAdTest.1(this);
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ArrayList<VideoFeedsSoftAdTest.QuestionItem> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private URLImageView jdField_b_of_type_ComTencentImageURLImageView;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private final String jdField_c_of_type_JavaLangString = "7071947377624233";
  private TextView d;
  
  public VideoFeedsSoftAdTest(Activity paramActivity, VideoFeedsSoftAdBarDelegateForAd paramVideoFeedsSoftAdBarDelegateForAd)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd = paramVideoFeedsSoftAdBarDelegateForAd;
  }
  
  private static String a(VideoInfo paramVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(jdField_a_of_type_JavaLangString);
    localStringBuilder.append("&");
    localStringBuilder.append("myanswer=");
    localStringBuilder.append(jdField_b_of_type_JavaLangString);
    localStringBuilder.append("&");
    localStringBuilder.append("rowkey=");
    localStringBuilder.append(paramVideoInfo.a.mRowKey);
    localStringBuilder.append("&");
    localStringBuilder.append("first_row_ad=");
    localStringBuilder.append(paramVideoInfo.a.mAdAid);
    return localStringBuilder.toString();
  }
  
  private static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      RIJJumpUtils.a(paramActivity, a(jdField_a_of_type_ComTencentBizPubaccountVideoInfo));
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    if ((paramIntent == null) || (paramActivity == null)) {}
    for (;;)
    {
      return;
      try
      {
        if (!TextUtils.isEmpty(paramIntent.getStringExtra("arg_callback")))
        {
          paramIntent = paramIntent.getExtras();
          boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
          boolean bool2 = paramIntent.getBoolean("is_end", false);
          if ((bool1) || (bool2))
          {
            a(paramActivity);
            return;
          }
        }
      }
      catch (Throwable paramActivity)
      {
        QLog.e("VideoFeedsSoftAdTest", 1, "dealRedPacketMVResult " + paramActivity.getMessage());
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    jdField_a_of_type_ComTencentBizPubaccountVideoInfo = paramVideoInfo;
  }
  
  public static boolean a(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    return (paramAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementSoftInfo.J));
  }
  
  private void d()
  {
    VideoFeedsSoftAdTest.QuestionItem localQuestionItem = (VideoFeedsSoftAdTest.QuestionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Int + 1 + "." + localQuestionItem.jdField_a_of_type_JavaLangString);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localQuestionItem.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localQuestionItem.jdField_c_of_type_JavaLangString);
    this.d.setText(localQuestionItem.d);
  }
  
  public void a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.a(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#50000000"));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(AIOUtils.a(16.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData)
  {
    if ((jdField_a_of_type_ComTencentBizPubaccountVideoInfo == null) || (jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a == null)) {
      return;
    }
    jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.setClickPos(paramInt2);
    jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a.setAdClickPos(paramAdClickPos);
    ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, jdField_a_of_type_ComTencentBizPubaccountVideoInfo.a, 35, paramInt1, 5, paramBoolean1, paramBoolean2, paramSoftAdReportData);
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131375221));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362750));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362751));
    this.d = ((TextView)paramView.findViewById(2131362752));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362026));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131377004));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372537));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131375227));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362025);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374180));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131374181));
    VideoFeedsSoftAdBarController.a(this.jdField_a_of_type_ComTencentImageURLImageView, "https://img.nfa.qq.com/gmaster_prod/16091136/gmaster_228bua0gpwu8_qb_public_account_readinjoy_video_feeds_listview_item_header_soft_ad_test_big_bar_arrow.png", 0, 15, 15, -1, this.jdField_a_of_type_AndroidAppActivity);
    VideoFeedsSoftAdBarController.a(this.jdField_b_of_type_ComTencentImageURLImageView, "http://img.nfa.qq.com/gmaster_prod/16091136/gmaster_8k3y6sh9nr0_qb_public_account_readinjoy_video_feeds_listview_item_header_soft_ad_test_big_video_icon.png", 0, 12, 12, -1, this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_b_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetTextView.setOnClickListener(this);
    this.d.setOnClickListener(this);
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this);
    this.jdField_a_of_type_ComTencentImageURLImageView.setOnClickListener(this);
  }
  
  public void a(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    a(paramAdvertisementSoftInfo.J);
    this.jdField_a_of_type_Int = 0;
    b();
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    jdField_b_of_type_JavaLangString = "";
    try
    {
      paramString = new JSONObject(paramString);
      jdField_a_of_type_JavaLangString = paramString.optString("resultUrl");
      paramString = paramString.optJSONArray("list");
      int i = 0;
      while (i < paramString.length())
      {
        VideoFeedsSoftAdTest.QuestionItem localQuestionItem = new VideoFeedsSoftAdTest.QuestionItem();
        localQuestionItem.jdField_a_of_type_JavaLangString = paramString.optJSONObject(i).optString("question");
        localQuestionItem.jdField_b_of_type_JavaLangString = paramString.optJSONObject(i).optString("answer1");
        localQuestionItem.jdField_c_of_type_JavaLangString = paramString.optJSONObject(i).optString("answer2");
        localQuestionItem.d = paramString.optJSONObject(i).optString("answer3");
        this.jdField_a_of_type_JavaUtilArrayList.add(localQuestionItem);
        i += 1;
      }
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void a(boolean paramBoolean)
  {
    SoftAdReportData localSoftAdReportData = new SoftAdReportData();
    if (paramBoolean) {}
    for (localSoftAdReportData.b = 14;; localSoftAdReportData.b = 15)
    {
      a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), true, null, true, localSoftAdReportData);
      a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), false, null, true, localSoftAdReportData);
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Int < this.jdField_a_of_type_JavaUtilArrayList.size())
    {
      this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      d();
      this.jdField_a_of_type_Int += 1;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    a(false);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void onClick(View paramView)
  {
    SoftAdReportData localSoftAdReportData = new SoftAdReportData();
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      b();
      localSoftAdReportData.b = 14;
      a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
      jdField_b_of_type_JavaLangString += "Q1_";
      continue;
      localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localSoftAdReportData.b = 14;
      a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
      b();
      jdField_b_of_type_JavaLangString += "Q2_";
      continue;
      localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      localSoftAdReportData.b = 14;
      localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
      a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
      b();
      jdField_b_of_type_JavaLangString += "Q3_";
      continue;
      localSoftAdReportData.b = 15;
      a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
      ReadInJoyMotiveAdModule.a().a(this.jdField_a_of_type_AndroidAppActivity, "7071947377624233", 0L, 0L, 0, 0, this.jdField_a_of_type_ComTencentGdtadApiGdtAdListener);
      continue;
      c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.g();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest
 * JD-Core Version:    0.7.0.1
 */