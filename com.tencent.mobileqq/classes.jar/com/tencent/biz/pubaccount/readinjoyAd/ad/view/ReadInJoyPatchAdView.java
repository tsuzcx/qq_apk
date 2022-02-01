package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.kandian.ad.api.IRIJPatchAdUtilService;
import com.tencent.mobileqq.kandian.base.utils.api.IReadInJoyDisplayUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KanDianUrlRoundCornerImageView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URL;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONException;
import org.json.JSONObject;

public class ReadInJoyPatchAdView
  extends FrameLayout
  implements View.OnClickListener
{
  public AdvertisementInfo a;
  public ReadInJoyPatchAdView.PatchAdListener b;
  private VideoPlayParam c;
  private int d;
  private KandianUrlImageView e;
  private TextView f;
  private KanDianUrlRoundCornerImageView g;
  private TextView h;
  private TextView i;
  private TextView j;
  private Handler k;
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInJoyPatchAdView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    f();
    g();
    h();
  }
  
  private void b(int paramInt)
  {
    if (this.k == null) {
      return;
    }
    Object localObject1 = this.a;
    if ((localObject1 != null) && (this.b != null)) {
      try
      {
        localObject1 = new JSONObject(((AdvertisementInfo)localObject1).mAdExtInfo);
        if (((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAdDisplaySeconds((JSONObject)localObject1) == paramInt)
        {
          this.b.a(this.c, this.d);
          this.k.sendEmptyMessageDelayed(1203, 1000L);
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
    Object localObject2 = this.f;
    if (localObject2 != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("秒");
      ((TextView)localObject2).setText(localStringBuilder.toString());
    }
    if (paramInt >= 1)
    {
      localObject2 = new Message();
      ((Message)localObject2).what = 1201;
      ((Message)localObject2).obj = Integer.valueOf(paramInt - 1);
      this.k.sendMessageDelayed((Message)localObject2, 1000L);
    }
    if (paramInt < 1) {
      this.k.sendEmptyMessage(1202);
    }
  }
  
  private void f()
  {
    View localView = ((LayoutInflater)getContext().getSystemService("layout_inflater")).inflate(2131626112, this);
    this.e = ((KandianUrlImageView)localView.findViewById(2131435401));
    this.f = ((TextView)localView.findViewById(2131445912));
    this.g = ((KanDianUrlRoundCornerImageView)localView.findViewById(2131427703));
    this.h = ((TextView)localView.findViewById(2131427869));
    this.i = ((TextView)localView.findViewById(2131427750));
    this.j = ((TextView)localView.findViewById(2131439877));
  }
  
  private void g()
  {
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  private int getPosAdState()
  {
    VideoPlayParam localVideoPlayParam = this.c;
    if (localVideoPlayParam == null) {
      return 0;
    }
    return localVideoPlayParam.D.patchStatus.c.get();
  }
  
  private int getPreAdState()
  {
    VideoPlayParam localVideoPlayParam = this.c;
    if (localVideoPlayParam == null) {
      return 0;
    }
    return localVideoPlayParam.D.patchStatus.a.get();
  }
  
  private void h()
  {
    this.k = new ReadInJoyPatchAdView.1(this, Looper.getMainLooper());
  }
  
  private void i()
  {
    TextView localTextView = this.f;
    if (localTextView != null) {
      localTextView.setText("0秒");
    }
    if (this.b != null)
    {
      a();
      this.b.b(this.c, this.d, 0);
    }
  }
  
  public void a()
  {
    Handler localHandler = this.k;
    if (localHandler != null)
    {
      localHandler.removeMessages(1201);
      this.k.removeMessages(1202);
    }
  }
  
  public void a(int paramInt)
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.b;
    if (localPatchAdListener != null)
    {
      localPatchAdListener.a(this.c, this.d, paramInt);
      this.b.b(this.c, this.d, 1);
    }
  }
  
  public void a(VideoPlayParam paramVideoPlayParam, AdvertisementInfo paramAdvertisementInfo, int paramInt)
  {
    if (paramAdvertisementInfo == null) {
      return;
    }
    this.d = paramInt;
    this.a = paramAdvertisementInfo;
    this.c = paramVideoPlayParam;
    this.i.setText(paramAdvertisementInfo.mTitle);
    this.h.setText(paramAdvertisementInfo.mAdTxt);
    this.j.setText(((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).getPatchAdButtonText(getContext(), paramAdvertisementInfo));
    try
    {
      paramVideoPlayParam = new URL(paramAdvertisementInfo.mAdImg);
      URL localURL = new URL(paramAdvertisementInfo.mAdCorporateLogo);
      ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).configImage(this.e, paramVideoPlayParam, getContext(), false);
      ((IReadInJoyDisplayUtils)QRoute.api(IReadInJoyDisplayUtils.class)).configImage(this.g, localURL, getContext(), false);
    }
    catch (Exception paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
    }
    this.g.setCorner(((IRIJAdUIService)QRoute.api(IRIJAdUIService.class)).dp2px(2.0F, getContext().getResources()));
    try
    {
      paramVideoPlayParam = new JSONObject(paramAdvertisementInfo.mAdExtInfo);
      paramInt = ((IRIJPatchAdUtilService)QRoute.api(IRIJPatchAdUtilService.class)).getPatchAdDisplaySeconds(paramVideoPlayParam);
      if (paramInt < 0)
      {
        a();
        return;
      }
      if (this.k != null)
      {
        paramVideoPlayParam = new Message();
        paramVideoPlayParam.what = 1201;
        paramVideoPlayParam.obj = Integer.valueOf(paramInt);
        this.k.sendMessage(paramVideoPlayParam);
        return;
      }
    }
    catch (JSONException paramVideoPlayParam)
    {
      paramVideoPlayParam.printStackTrace();
    }
  }
  
  public void b()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.b;
    if (localPatchAdListener != null) {
      localPatchAdListener.c(this.c, this.d);
    }
  }
  
  public void c()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.b;
    if (localPatchAdListener != null) {
      localPatchAdListener.d(this.c, this.d);
    }
  }
  
  public void d()
  {
    ReadInJoyPatchAdView.PatchAdListener localPatchAdListener = this.b;
    if (localPatchAdListener != null) {
      localPatchAdListener.b(this.c, this.d, 0);
    }
  }
  
  public boolean e()
  {
    int m = getPreAdState();
    boolean bool = true;
    if (m != 1)
    {
      if (getPosAdState() == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  public VideoPlayParam getVideoPlayParam()
  {
    return this.c;
  }
  
  public void onClick(View paramView)
  {
    int n = paramView.getId();
    int m = 5;
    if (n == 2131427703) {
      m = 2;
    } else if (n == 2131427750) {
      m = 3;
    } else if ((n != 2131435401) && (n == 2131439877)) {
      m = 8;
    }
    if (this.b != null)
    {
      a();
      this.b.a(this.c, this.d, m);
      this.b.b(this.c, this.d, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setOnPatchAdListener(ReadInJoyPatchAdView.PatchAdListener paramPatchAdListener)
  {
    this.b = paramPatchAdListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyPatchAdView
 * JD-Core Version:    0.7.0.1
 */