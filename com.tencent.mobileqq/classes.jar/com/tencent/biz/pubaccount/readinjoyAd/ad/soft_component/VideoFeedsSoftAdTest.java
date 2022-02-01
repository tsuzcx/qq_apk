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
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsSoftAdBarController;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdvertisementSoftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyMotiveAdModule;
import com.tencent.gdtad.api.GdtAdListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJVideoAdService;
import com.tencent.mobileqq.kandian.biz.video.playfeeds.entity.VideoInfo;
import com.tencent.mobileqq.kandian.glue.router.api.IRIJJumpUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class VideoFeedsSoftAdTest
  implements View.OnClickListener
{
  private static VideoInfo jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo;
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
    localStringBuilder.append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mRowKey);
    localStringBuilder.append("&");
    localStringBuilder.append("first_row_ad=");
    localStringBuilder.append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdAid);
    return localStringBuilder.toString();
  }
  
  private static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramActivity, a(jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo));
    }
  }
  
  public static void a(Activity paramActivity, int paramInt, Intent paramIntent)
  {
    if (paramIntent != null)
    {
      if (paramActivity == null) {
        return;
      }
      try
      {
        if (TextUtils.isEmpty(paramIntent.getStringExtra("arg_callback"))) {
          return;
        }
        paramIntent = paramIntent.getExtras();
        boolean bool1 = paramIntent.getBoolean("profitable_flag", false);
        boolean bool2 = paramIntent.getBoolean("is_end", false);
        if ((bool1) || (bool2))
        {
          a(paramActivity);
          return;
        }
      }
      catch (Throwable paramActivity)
      {
        paramIntent = new StringBuilder();
        paramIntent.append("dealRedPacketMVResult ");
        paramIntent.append(paramActivity.getMessage());
        QLog.e("VideoFeedsSoftAdTest", 1, paramIntent.toString());
      }
    }
  }
  
  public static void a(VideoInfo paramVideoInfo)
  {
    jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo = paramVideoInfo;
  }
  
  public static boolean a(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    return (paramAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementSoftInfo.J));
  }
  
  private void d()
  {
    VideoFeedsSoftAdTest.QuestionItem localQuestionItem = (VideoFeedsSoftAdTest.QuestionItem)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    TextView localTextView = this.jdField_a_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_Int + 1);
    localStringBuilder.append(".");
    localStringBuilder.append(localQuestionItem.jdField_a_of_type_JavaLangString);
    localTextView.setText(localStringBuilder.toString());
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localQuestionItem.jdField_b_of_type_JavaLangString);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(localQuestionItem.jdField_c_of_type_JavaLangString);
    this.d.setText(localQuestionItem.d);
  }
  
  public void a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(12.0F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#50000000"));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(AIOUtils.b(16.5F, this.jdField_a_of_type_AndroidAppActivity.getResources()));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData)
  {
    if (jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo != null)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo) == null) {
        return;
      }
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).setClickPos(paramInt2);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo).setAdClickPos(paramAdClickPos);
      ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(jdField_a_of_type_ComTencentMobileqqKandianBizVideoPlayfeedsEntityVideoInfo), 35, paramInt1, 5, paramBoolean1, paramBoolean2, paramSoftAdReportData);
    }
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131374736));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362705));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131362706));
    this.d = ((TextView)paramView.findViewById(2131362707));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131362041));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131376486));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131372122));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramView.findViewById(2131374742));
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131362040);
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373736));
    this.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131373737));
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
    if (paramBoolean) {
      localSoftAdReportData.b = 14;
    } else {
      localSoftAdReportData.b = 15;
    }
    a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), true, null, true, localSoftAdReportData);
    a(2, 0, ReportAction.EXPOSE, Integer.valueOf(0), false, null, true, localSoftAdReportData);
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
    int i = paramView.getId();
    if (i != 2131372122)
    {
      if (i != 2131373736)
      {
        switch (i)
        {
        default: 
          return;
        case 2131362707: 
          i = this.jdField_a_of_type_Int;
          localSoftAdReportData.jdField_a_of_type_Int = i;
          localSoftAdReportData.b = 14;
          localSoftAdReportData.jdField_a_of_type_Int = i;
          a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
          b();
          paramView = new StringBuilder();
          paramView.append(jdField_b_of_type_JavaLangString);
          paramView.append("Q3_");
          jdField_b_of_type_JavaLangString = paramView.toString();
          return;
        case 2131362706: 
          localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
          localSoftAdReportData.b = 14;
          a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
          b();
          paramView = new StringBuilder();
          paramView.append(jdField_b_of_type_JavaLangString);
          paramView.append("Q2_");
          jdField_b_of_type_JavaLangString = paramView.toString();
          return;
        }
        localSoftAdReportData.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
        b();
        localSoftAdReportData.b = 14;
        a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
        paramView = new StringBuilder();
        paramView.append(jdField_b_of_type_JavaLangString);
        paramView.append("Q1_");
        jdField_b_of_type_JavaLangString = paramView.toString();
        return;
      }
      c();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyAdAdSoft_componentVideoFeedsSoftAdBarDelegateForAd.g();
      return;
    }
    localSoftAdReportData.b = 15;
    a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
    ReadInJoyMotiveAdModule.a().a(this.jdField_a_of_type_AndroidAppActivity, "7071947377624233", 0L, 0L, 0, 0, this.jdField_a_of_type_ComTencentGdtadApiGdtAdListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest
 * JD-Core Version:    0.7.0.1
 */