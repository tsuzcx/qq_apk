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
  private static VideoInfo o;
  private static String p = "";
  private static String q;
  GdtAdListener a = new VideoFeedsSoftAdTest.1(this);
  private ArrayList<VideoFeedsSoftAdTest.QuestionItem> b = new ArrayList();
  private int c = 0;
  private TextView d;
  private TextView e;
  private TextView f;
  private TextView g;
  private RelativeLayout h;
  private Activity i;
  private LinearLayout j;
  private RelativeLayout k;
  private RelativeLayout l;
  private URLImageView m;
  private URLImageView n;
  private View r;
  private VideoFeedsSoftAdBarDelegateForAd s;
  private final String t = "7071947377624233";
  
  public VideoFeedsSoftAdTest(Activity paramActivity, VideoFeedsSoftAdBarDelegateForAd paramVideoFeedsSoftAdBarDelegateForAd)
  {
    this.i = paramActivity;
    this.s = paramVideoFeedsSoftAdBarDelegateForAd;
  }
  
  private static void a(Activity paramActivity)
  {
    if (!TextUtils.isEmpty(p)) {
      ((IRIJJumpUtils)QRoute.api(IRIJJumpUtils.class)).jumpToUrl(paramActivity, b(o));
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
    o = paramVideoInfo;
  }
  
  public static boolean a(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    return (paramAdvertisementSoftInfo != null) && (!TextUtils.isEmpty(paramAdvertisementSoftInfo.T));
  }
  
  private static String b(VideoInfo paramVideoInfo)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(p);
    localStringBuilder.append("&");
    localStringBuilder.append("myanswer=");
    localStringBuilder.append(q);
    localStringBuilder.append("&");
    localStringBuilder.append("rowkey=");
    localStringBuilder.append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mRowKey);
    localStringBuilder.append("&");
    localStringBuilder.append("first_row_ad=");
    localStringBuilder.append(((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(paramVideoInfo).mAdAid);
    return localStringBuilder.toString();
  }
  
  private void d()
  {
    VideoFeedsSoftAdTest.QuestionItem localQuestionItem = (VideoFeedsSoftAdTest.QuestionItem)this.b.get(this.c);
    TextView localTextView = this.d;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.c + 1);
    localStringBuilder.append(".");
    localStringBuilder.append(localQuestionItem.a);
    localTextView.setText(localStringBuilder.toString());
    this.e.setText(localQuestionItem.b);
    this.f.setText(localQuestionItem.c);
    this.g.setText(localQuestionItem.d);
  }
  
  public void a()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.b(12.0F, this.i.getResources()));
    localGradientDrawable.setColor(Color.parseColor("#50000000"));
    this.r.setBackgroundDrawable(localGradientDrawable);
    localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setColor(Color.parseColor("#12B7F5"));
    localGradientDrawable.setCornerRadius(AIOUtils.b(16.5F, this.i.getResources()));
    this.l.setBackgroundDrawable(localGradientDrawable);
  }
  
  public void a(int paramInt1, int paramInt2, ReportAction paramReportAction, Integer paramInteger, boolean paramBoolean1, AdClickPos paramAdClickPos, boolean paramBoolean2, SoftAdReportData paramSoftAdReportData)
  {
    if (o != null)
    {
      if (((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(o) == null) {
        return;
      }
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(o).setClickPos(paramInt2);
      ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(o).setAdClickPos(paramAdClickPos);
      ReadInJoyAdReportUtils.a(paramReportAction, paramInteger, ((IRIJVideoAdService)QRoute.api(IRIJVideoAdService.class)).getAdvertisementInfo(o), 35, paramInt1, 5, paramBoolean1, paramBoolean2, paramSoftAdReportData);
    }
  }
  
  public void a(View paramView)
  {
    this.d = ((TextView)paramView.findViewById(2131442925));
    this.e = ((TextView)paramView.findViewById(2131428387));
    this.f = ((TextView)paramView.findViewById(2131428388));
    this.g = ((TextView)paramView.findViewById(2131428389));
    this.h = ((RelativeLayout)paramView.findViewById(2131427619));
    this.k = ((RelativeLayout)paramView.findViewById(2131444727));
    this.l = ((RelativeLayout)paramView.findViewById(2131439592));
    this.j = ((LinearLayout)paramView.findViewById(2131442931));
    this.r = paramView.findViewById(2131427618);
    this.m = ((URLImageView)paramView.findViewById(2131441410));
    this.n = ((URLImageView)paramView.findViewById(2131441411));
    VideoFeedsSoftAdBarController.a(this.m, "https://img.nfa.qq.com/gmaster_prod/16091136/gmaster_228bua0gpwu8_qb_public_account_readinjoy_video_feeds_listview_item_header_soft_ad_test_big_bar_arrow.png", 0, 15, 15, -1, this.i);
    VideoFeedsSoftAdBarController.a(this.n, "http://img.nfa.qq.com/gmaster_prod/16091136/gmaster_8k3y6sh9nr0_qb_public_account_readinjoy_video_feeds_listview_item_header_soft_ad_test_big_video_icon.png", 0, 12, 12, -1, this.i);
    this.e.setOnClickListener(this);
    this.f.setOnClickListener(this);
    this.g.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
  }
  
  public void a(String paramString)
  {
    this.b.clear();
    q = "";
    try
    {
      paramString = new JSONObject(paramString);
      p = paramString.optString("resultUrl");
      paramString = paramString.optJSONArray("list");
      int i1 = 0;
      while (i1 < paramString.length())
      {
        VideoFeedsSoftAdTest.QuestionItem localQuestionItem = new VideoFeedsSoftAdTest.QuestionItem();
        localQuestionItem.a = paramString.optJSONObject(i1).optString("question");
        localQuestionItem.b = paramString.optJSONObject(i1).optString("answer1");
        localQuestionItem.c = paramString.optJSONObject(i1).optString("answer2");
        localQuestionItem.d = paramString.optJSONObject(i1).optString("answer3");
        this.b.add(localQuestionItem);
        i1 += 1;
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
    if (this.c < this.b.size())
    {
      this.j.setVisibility(0);
      this.k.setVisibility(8);
      d();
      this.c += 1;
      return;
    }
    this.j.setVisibility(8);
    this.k.setVisibility(0);
    a(false);
    this.c = 0;
  }
  
  public void b(AdvertisementSoftInfo paramAdvertisementSoftInfo)
  {
    a(paramAdvertisementSoftInfo.T);
    this.c = 0;
    b();
  }
  
  public void c()
  {
    this.c = 0;
    this.b.clear();
  }
  
  public void onClick(View paramView)
  {
    SoftAdReportData localSoftAdReportData = new SoftAdReportData();
    int i1 = paramView.getId();
    if (i1 != 2131439592)
    {
      if (i1 != 2131441410)
      {
        switch (i1)
        {
        default: 
          return;
        case 2131428389: 
          i1 = this.c;
          localSoftAdReportData.a = i1;
          localSoftAdReportData.b = 14;
          localSoftAdReportData.a = i1;
          a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
          b();
          paramView = new StringBuilder();
          paramView.append(q);
          paramView.append("Q3_");
          q = paramView.toString();
          return;
        case 2131428388: 
          localSoftAdReportData.a = this.c;
          localSoftAdReportData.b = 14;
          a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
          b();
          paramView = new StringBuilder();
          paramView.append(q);
          paramView.append("Q2_");
          q = paramView.toString();
          return;
        }
        localSoftAdReportData.a = this.c;
        b();
        localSoftAdReportData.b = 14;
        a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
        paramView = new StringBuilder();
        paramView.append(q);
        paramView.append("Q1_");
        q = paramView.toString();
        return;
      }
      c();
      this.s.n();
      return;
    }
    localSoftAdReportData.b = 15;
    a(1, 0, ReportAction.CLICK, Integer.valueOf(0), false, AdClickPos.SoftAdComponent, true, localSoftAdReportData);
    ReadInJoyMotiveAdModule.a().a(this.i, "7071947377624233", 0L, 0L, 0, 0, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.soft_component.VideoFeedsSoftAdTest
 * JD-Core Version:    0.7.0.1
 */