package com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.callback.FeedBackClickListener;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdEntityConvertService;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.qroute.QRoute;

public abstract class IUIDelegate
  implements View.OnClickListener
{
  public int a;
  protected Context b;
  protected ViewGroup c;
  protected FeedBackClickListener d;
  public boolean e = false;
  public boolean f = false;
  public AdData g;
  public AdvertisementInfo h;
  
  public IUIDelegate(Context paramContext, int paramInt)
  {
    this.a = paramInt;
    this.b = paramContext;
    this.c = new FrameLayout(paramContext);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(a(), this.c);
    b();
    c();
  }
  
  public abstract int a();
  
  public void a(FeedBackClickListener paramFeedBackClickListener)
  {
    this.d = paramFeedBackClickListener;
  }
  
  public void a(View... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      View localView = paramVarArgs[i];
      if (localView != null) {
        localView.setOnClickListener(this);
      }
      i += 1;
    }
  }
  
  public abstract void b();
  
  public void b(AdData paramAdData)
  {
    if (paramAdData == null) {
      return;
    }
    this.g = paramAdData;
    this.h = ((IRIJAdEntityConvertService)QRoute.api(IRIJAdEntityConvertService.class)).convertAdData2AdsInfo(paramAdData);
  }
  
  public abstract void c();
  
  public abstract void d();
  
  public void e()
  {
    this.f = true;
  }
  
  public void g() {}
  
  public void h() {}
  
  public View i()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate
 * JD-Core Version:    0.7.0.1
 */