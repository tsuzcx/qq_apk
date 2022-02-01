package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ActionEntity;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.jump_action.ReadInJoyAdJumpUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.GameComponentReport;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.GameGiftsImageView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.HorizontalProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.util.RIJAdDownloadExKt;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGameComponentInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.AdGiftInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;

public class GamesComponentAdDelegate
  extends IUIDelegate
{
  private URLImageView i;
  private TextView j;
  private GameGiftsImageView k;
  private TextView l;
  private RIJDownloadView m;
  private ImageView n;
  
  public GamesComponentAdDelegate(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(TextView paramTextView, String paramString)
  {
    if ((paramTextView != null) && (!TextUtils.isEmpty(paramString))) {
      paramTextView.setText(paramString);
    }
  }
  
  public static void a(AdData paramAdData)
  {
    boolean bool = FastWeqAdUtils.e(paramAdData);
    long l2 = 6L;
    long l1;
    if (bool)
    {
      l1 = 7L;
      long l3 = 3010203L;
      l2 = l1;
      l1 = l3;
    }
    for (;;)
    {
      break label77;
      if (FastWeqAdUtils.c(paramAdData))
      {
        l1 = 3010303L;
      }
      else if (FastWeqAdUtils.f(paramAdData))
      {
        l1 = 3010403L;
      }
      else
      {
        l1 = l2;
        if (!FastWeqAdUtils.g(paramAdData)) {
          break;
        }
        l1 = 3010503L;
      }
    }
    label77:
    AdvertisementInfo localAdvertisementInfo = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
    if (localAdvertisementInfo == null) {
      return;
    }
    GameComponentReport.a(localAdvertisementInfo, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(paramAdData), GameComponentReport.a(paramAdData, l1, l2, null, "1"), ReportAction.EXPOSE, ActionEntity.ArticleFloat, Integer.valueOf(0));
  }
  
  public int a()
  {
    return 2131624885;
  }
  
  public void b()
  {
    if (this.c != null)
    {
      if (this.b == null) {
        return;
      }
      this.i = ((URLImageView)this.c.findViewById(2131435219));
      this.j = ((TextView)this.c.findViewById(2131447463));
      this.k = ((GameGiftsImageView)this.c.findViewById(2131434281));
      this.l = ((TextView)this.c.findViewById(2131433984));
      this.m = ((RIJDownloadView)this.c.findViewById(2131432115));
      this.n = ((ImageView)this.c.findViewById(2131433065));
      this.m.setInFloatingBar(true);
    }
  }
  
  public void b(AdData paramAdData)
  {
    super.b(paramAdData);
    if (paramAdData.as != null)
    {
      ReadInJoyCommonSoftAdUtils.a(this.b, this.i, paramAdData.as.l, 12, 48, -1);
      a(this.j, paramAdData.as.b);
      a(this.l, paramAdData.as.i);
      if (FastWeqAdUtils.c(paramAdData))
      {
        Object localObject = new ArrayList();
        if (!TextUtils.isEmpty(paramAdData.as.B.e)) {
          ((ArrayList)localObject).add(paramAdData.as.B.e);
        }
        if (!TextUtils.isEmpty(paramAdData.as.B.f)) {
          ((ArrayList)localObject).add(paramAdData.as.B.f);
        }
        if (!TextUtils.isEmpty(paramAdData.as.B.g)) {
          ((ArrayList)localObject).add(paramAdData.as.B.g);
        }
        if (((ArrayList)localObject).size() > 0)
        {
          this.k.setVisibility(0);
          this.k.setImages((ArrayList)localObject);
        }
        if (!TextUtils.isEmpty(paramAdData.as.B.h)) {
          this.l.setText(paramAdData.as.B.h);
        }
        localObject = this.l.getLayoutParams();
        if ((localObject instanceof LinearLayout.LayoutParams)) {
          ((LinearLayout.LayoutParams)localObject).leftMargin = AIOUtils.b(6.0F, this.b.getResources());
        }
        this.l.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      else if (FastWeqAdUtils.e(paramAdData))
      {
        this.k.setVisibility(8);
      }
      this.h = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
      if (this.h == null) {
        return;
      }
      this.m.setAdvertisementInfo(this.h);
      this.m.setProgressStyle(HorizontalProgressStyle.FastWebGameStyle);
    }
  }
  
  public void c()
  {
    a(new View[] { this.m, this.n });
    this.c.setOnClickListener(new GamesComponentAdDelegate.1(this));
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.f) {
      return;
    }
    boolean bool = FastWeqAdUtils.e(this.g);
    long l1 = 3010203L;
    long l3 = 6L;
    long l2;
    if (bool) {
      l2 = 7L;
    }
    for (;;)
    {
      break;
      if (FastWeqAdUtils.c(this.g))
      {
        l1 = 3010303L;
        l2 = l3;
      }
      else if (FastWeqAdUtils.f(this.g))
      {
        l1 = 3010403L;
        l2 = l3;
      }
      else
      {
        l2 = l3;
        if (FastWeqAdUtils.g(this.g))
        {
          l1 = 3010503L;
          l2 = l3;
        }
      }
    }
    GameComponentReport.a(this.m.getAdInfo(), ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.g), GameComponentReport.a(this.g, l1, l2, null, "1"), ReportAction.EXPOSE, ActionEntity.ArticleFloat, Integer.valueOf(0));
    super.e();
  }
  
  public boolean f()
  {
    return (this.g != null) && (this.g.ax == 1);
  }
  
  public void g()
  {
    super.g();
    RIJDownloadView localRIJDownloadView = this.m;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a();
    }
  }
  
  public void h()
  {
    super.h();
    RIJDownloadView localRIJDownloadView = this.m;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    int i1 = paramView.getId();
    long l1;
    if (i1 != 2131432115)
    {
      if (i1 != 2131433065) {
        return;
      }
      this.e = true;
      if (this.d != null)
      {
        this.d.b();
        boolean bool = FastWeqAdUtils.e(this.g);
        l1 = 3010208L;
        if (!bool) {
          for (;;)
          {
            if (FastWeqAdUtils.c(this.g)) {
              l1 = 3010308L;
            } else if (FastWeqAdUtils.f(this.g)) {
              l1 = 3010408L;
            } else if (FastWeqAdUtils.g(this.g)) {
              l1 = 3010506L;
            }
          }
        }
        paramView = this.m.getAdInfo();
        if (paramView != null)
        {
          paramView.adClickPos = AdClickPos.SoftAdClose;
          GameComponentReport.b(Integer.valueOf(0), paramView, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.g), GameComponentReport.a(this.g, l1, 9L, null, "1"));
        }
      }
    }
    else if (this.m != null)
    {
      if ((!RIJAdDownloadExKt.e(this.h)) && (!RIJAdDownloadExKt.g(this.h)) && (!RIJAdDownloadExKt.f(this.h)))
      {
        paramView = Integer.valueOf(0);
        if ((this.b instanceof Activity)) {
          paramView = ReadInJoyAdJumpUtils.a(this.h, (Activity)this.b);
        }
        this.h.adClickPos = AdClickPos.SoftAdClickBtn;
        l1 = 3010404L;
        if (FastWeqAdUtils.d(this.h)) {
          l1 = 3010205L;
        }
        for (;;)
        {
          break;
          if (FastWeqAdUtils.b(this.h)) {
            l1 = 3010305L;
          } else if (FastWeqAdUtils.f(this.h)) {
            l1 = 3010405L;
          } else if (FastWeqAdUtils.e(this.h)) {
            l1 = 3010505L;
          }
        }
        GameComponentReport.a(paramView, this.h, ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getBusiJson(this.h), GameComponentReport.a(this.h, l1, 9L, "", "1"));
        return;
      }
      this.m.a(AdClickPos.SoftAdClickBtn, 8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate
 * JD-Core Version:    0.7.0.1
 */