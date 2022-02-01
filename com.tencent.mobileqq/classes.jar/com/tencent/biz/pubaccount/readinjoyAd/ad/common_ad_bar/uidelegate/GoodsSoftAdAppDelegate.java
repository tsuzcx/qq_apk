package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.pubaccount.NativeAd.report.constant.AdClickPos;
import com.tencent.biz.pubaccount.NativeAd.report.constant.ReportAction;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.ReadInJoyAdActionManager;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_action.report_action.ReadInJoyAdReportUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.ReadInJoyCommonSoftAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.style.RoundProgressStyle;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_download.view.RIJDownloadView;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class GoodsSoftAdAppDelegate
  extends IUIDelegate
{
  private ImageView i;
  private TextView j;
  private TextView k;
  private RIJDownloadView l;
  private ImageView m;
  
  public GoodsSoftAdAppDelegate(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  private void a(AdClickPos paramAdClickPos)
  {
    if (this.h != null)
    {
      this.h.setClickPos(0);
      this.h.setAdClickPos(paramAdClickPos);
      ReadInJoyAdActionManager.a(this.h, (Activity)this.b, 35, 1, 4, null);
    }
  }
  
  public int a()
  {
    return 2131629296;
  }
  
  public void b()
  {
    if (this.c != null)
    {
      if (this.b == null) {
        return;
      }
      this.i = ((ImageView)this.c.findViewById(2131435219));
      this.j = ((TextView)this.c.findViewById(2131447463));
      this.k = ((TextView)this.c.findViewById(2131431733));
      this.m = ((ImageView)this.c.findViewById(2131433065));
      this.l = ((RIJDownloadView)this.c.findViewById(2131432115));
      this.l.setInFloatingBar(true);
    }
  }
  
  public void b(AdData paramAdData)
  {
    super.b(paramAdData);
    if ((this.b != null) && (paramAdData != null))
    {
      if (paramAdData.aE == null) {
        return;
      }
      String str1 = paramAdData.aE.optString("adImg", "");
      String str2 = paramAdData.aE.optString("goodsName", "");
      String str3 = paramAdData.aE.optString("buttonTxt", "");
      ReadInJoyCommonSoftAdUtils.a(this.b, this.i, str1, 8, 30, -1);
      this.j.setText(str2);
      this.k.setText(str3);
      paramAdData = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
      if (paramAdData == null) {
        return;
      }
      this.l.setAdvertisementInfo(paramAdData);
      this.l.setProgressStyle(RoundProgressStyle.FastWebSoftAd);
    }
  }
  
  public void c()
  {
    a(new View[] { this.i, this.j, this.k, this.l, this.m });
    this.c.setOnClickListener(new GoodsSoftAdAppDelegate.1(this));
  }
  
  public void d() {}
  
  public void e()
  {
    if (this.f) {
      return;
    }
    ReadInJoyAdReportUtils.a(this.h, 35, 1, 4);
    super.e();
  }
  
  public void g()
  {
    super.g();
    RIJDownloadView localRIJDownloadView = this.l;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.a();
    }
  }
  
  public void h()
  {
    super.h();
    RIJDownloadView localRIJDownloadView = this.l;
    if (localRIJDownloadView != null) {
      localRIJDownloadView.b();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
    case 2131433065: 
      this.e = true;
      if (this.d != null) {
        this.d.b();
      }
      if (this.h != null)
      {
        this.h.setClickPos(3);
        this.h.adClickPos = AdClickPos.SoftAdClose;
        ReadInJoyAdReportUtils.a(ReportAction.CLICK, Integer.valueOf(0), this.h, 35, 1, 4);
        return;
      }
      break;
    case 2131432115: 
      if (this.l != null)
      {
        if (((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).isAppAdvertisementInfo(this.h))
        {
          this.l.a(AdClickPos.SoftAdClickBtn, 8);
          return;
        }
        a(AdClickPos.SoftAdClickBtn);
        return;
      }
      break;
    case 2131431733: 
    case 2131435219: 
    case 2131447463: 
      a(AdClickPos.SoftAdComponent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GoodsSoftAdAppDelegate
 * JD-Core Version:    0.7.0.1
 */