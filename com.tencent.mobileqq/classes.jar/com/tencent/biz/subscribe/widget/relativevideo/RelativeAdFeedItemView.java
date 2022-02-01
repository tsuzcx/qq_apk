package com.tencent.biz.subscribe.widget.relativevideo;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta.StFeed;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.storyHome.discover.RoundCornerImageView;
import com.tencent.biz.subscribe.SubImageLoader;
import com.tencent.biz.subscribe.SubscribeLaucher;
import com.tencent.biz.subscribe.SubscribeUtils;
import com.tencent.biz.subscribe.baseUI.BaseWidgetView;
import com.tencent.biz.subscribe.widget.textview.AsyncRichTextView;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.aditem.GdtHandler;
import com.tencent.gdtad.aditem.GdtHandler.Params;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.SquareImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.vip.pb.vac_adv_get.DropList;
import cooperation.vip.pb.vac_adv_get.VacFeedsAdvMetaInfo;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.AdvertiserInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.VideoInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.ReportInfo;

public class RelativeAdFeedItemView
  extends BaseWidgetView<CertifiedAccountMeta.StFeed>
  implements View.OnClickListener, View.OnLongClickListener
{
  private RelativeLayout c;
  private AsyncRichTextView d;
  private TextView e;
  private TextView f;
  private RoundCornerImageView g;
  private Set<String> h = new HashSet();
  private SquareImageView i;
  private int j = ImmersiveUtils.getScreenWidth() / 2;
  private Drawable k = getResources().getDrawable(2130841060);
  private View l;
  private ImageView m;
  private ActionSheet n;
  private CertifiedAccountMeta.StFeed o;
  private vac_adv_get.VacFeedsAdvMetaInfo p;
  private RelativeAdFeedItemView.AdInnerClickListener q;
  private GdtAppReceiver r;
  private boolean s;
  
  public RelativeAdFeedItemView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public RelativeAdFeedItemView(Context paramContext, RelativeAdFeedItemView.AdInnerClickListener paramAdInnerClickListener)
  {
    super(paramContext);
    this.q = paramAdInnerClickListener;
  }
  
  private void b()
  {
    if (this.p == null) {
      return;
    }
    try
    {
      GdtHandler.Params localParams = new GdtHandler.Params();
      this.r = new GdtAppReceiver();
      this.r.register(getContext());
      localParams.q = 1;
      if ((getContext() instanceof Activity)) {
        localParams.r = new WeakReference((Activity)getContext());
      }
      localParams.a = new GdtAd(this.p.adv_rsp);
      localParams.b = true;
      localParams.e = true;
      if ((this.p.adv_rsp != null) && (this.p.adv_rsp.display_info != null) && (this.p.adv_rsp.display_info.creative_size.get() == 185))
      {
        localParams.f = true;
        localParams.g = true;
      }
      localParams.i = true;
      Object localObject = new int[2];
      this.g.getLocationInWindow((int[])localObject);
      this.g.getLocationOnScreen((int[])localObject);
      localParams.j = new Rect(localObject[0], localObject[1], localObject[0] + this.g.getWidth(), localObject[1] + this.g.getHeight());
      localParams.s = new WeakReference(this.r);
      localObject = new Bundle();
      ((Bundle)localObject).putString("big_brother_source_key", "biz_src_ads");
      ((Bundle)localObject).putString("big_brother_ref_source_key", "biz_src_renzhenghao");
      localParams.p = ((Bundle)localObject);
      GdtHandler.a(localParams);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void a()
  {
    if (this.n == null)
    {
      this.n = ActionSheet.createMenuSheet(getContext());
      ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from(getContext()).inflate(2131624387, null);
      localViewGroup.findViewById(2131444545).setOnClickListener(this);
      localViewGroup.findViewById(2131439099).setOnClickListener(this);
      localViewGroup.findViewById(2131430272).setOnClickListener(this);
      this.n.setActionContentView(localViewGroup, null);
    }
    this.n.show();
  }
  
  @RequiresApi(api=8)
  protected void a(CertifiedAccountMeta.StFeed paramStFeed)
  {
    if (paramStFeed != null)
    {
      if (!paramStFeed.adBuffer.has()) {
        return;
      }
      this.o = paramStFeed;
      try
      {
        this.p = new vac_adv_get.VacFeedsAdvMetaInfo();
        this.p.mergeFrom(paramStFeed.adBuffer.get().toByteArray());
      }
      catch (Exception paramStFeed)
      {
        paramStFeed.printStackTrace();
      }
      paramStFeed = this.p;
      if (paramStFeed == null) {
        return;
      }
      if ((paramStFeed.adv_rsp != null) && (this.p.adv_rsp.display_info != null))
      {
        if (this.p.adv_rsp.display_info.basic_info != null)
        {
          float f1;
          if (this.p.adv_rsp.display_info.basic_info.pic_width.get() >= this.p.adv_rsp.display_info.basic_info.pic_height.get()) {
            f1 = 0.5625F;
          } else {
            f1 = 1.777778F;
          }
          this.g.getLayoutParams().height = ((int)(this.j * f1));
          this.g.getLayoutParams().width = this.j;
          this.g.requestLayout();
          this.d.setText(this.p.adv_rsp.display_info.basic_info.txt.get());
          paramStFeed = this.p.adv_rsp.display_info.basic_info.img.get();
          if (!TextUtils.isEmpty(paramStFeed)) {
            SubImageLoader.a(paramStFeed, this.g);
          }
        }
        if (this.p.adv_rsp.display_info.advertiser_info != null)
        {
          this.e.setText(this.p.adv_rsp.display_info.advertiser_info.corporate_image_name.get());
          SubImageLoader.a(this.p.adv_rsp.display_info.advertiser_info.corporate_logo.get(), this.i);
        }
        if ((this.p.adv_rsp.display_info.creative_size.get() != 185) && (this.p.adv_rsp.display_info.creative_size.get() != 585))
        {
          this.f.setVisibility(8);
        }
        else
        {
          if (this.p.adv_rsp.display_info.video_info != null)
          {
            int i1 = this.p.adv_rsp.display_info.video_info.media_duration.get() / 60;
            int i2 = this.p.adv_rsp.display_info.video_info.media_duration.get();
            this.f.setText(String.format("%02d:%02d", new Object[] { Integer.valueOf(i1), Integer.valueOf(i2 % 60) }));
          }
          this.f.setVisibility(0);
        }
      }
      paramStFeed = this.p;
      if ((paramStFeed != null) && (paramStFeed.adv_rsp != null) && (this.p.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.p.adv_rsp.report_info.exposure_url.get())) && (!this.h.contains(this.p.adv_rsp.report_info.exposure_url.get())))
      {
        SubscribeUtils.a(this.p.adv_rsp.report_info.exposure_url.get());
        this.h.add(this.p.adv_rsp.report_info.exposure_url.get());
      }
      if (this.s)
      {
        this.i.setFilterColor(1711276032);
        this.g.setColorFilter(1711276032);
        this.d.setTextColor(-5723992);
        this.e.setTextColor(-10132123);
        this.f.setTextColor(-5723992);
        this.f.setBackgroundDrawable(getResources().getDrawable(2130839097));
      }
    }
  }
  
  protected void a(Context paramContext, View paramView)
  {
    this.d = ((AsyncRichTextView)findViewById(2131448455));
    this.e = ((TextView)findViewById(2131448280));
    this.g = ((RoundCornerImageView)findViewById(2131436373));
    this.g.setCorner(ImmersiveUtils.dpToPx(4.0F));
    this.i = ((SquareImageView)findViewById(2131436269));
    this.f = ((TextView)findViewById(2131448448));
    this.l = findViewById(2131437590);
    this.m = ((ImageView)findViewById(2131436249));
    this.c = ((RelativeLayout)findViewById(2131444909));
    this.c.setOnClickListener(this);
    this.c.setOnLongClickListener(this);
  }
  
  protected int getLayoutId()
  {
    return 2131624388;
  }
  
  public void onClick(View paramView)
  {
    Object localObject;
    switch (paramView.getId())
    {
    default: 
      break;
    case 2131444909: 
      b();
      break;
    case 2131444545: 
      localObject = this.o;
      if ((localObject != null) && (((CertifiedAccountMeta.StFeed)localObject).adBuffer.has()))
      {
        localObject = this.q;
        if (localObject != null)
        {
          ((RelativeAdFeedItemView.AdInnerClickListener)localObject).b(this.o);
          localObject = this.p;
          if ((localObject != null) && (((vac_adv_get.VacFeedsAdvMetaInfo)localObject).adv_rsp != null) && (this.p.adv_rsp.report_info != null) && (!TextUtils.isEmpty(this.p.adv_rsp.report_info.negative_feedback_url.get()))) {
            SubscribeUtils.a(this.p.adv_rsp.report_info.negative_feedback_url.get().replace("__ACT_TYPE__", "2001"));
          }
        }
      }
      this.n.cancel();
      break;
    case 2131439099: 
      if (this.p.droplist != null)
      {
        localObject = this.p.droplist.get().iterator();
        while (((Iterator)localObject).hasNext())
        {
          vac_adv_get.DropList localDropList = (vac_adv_get.DropList)((Iterator)localObject).next();
          if ((localDropList.action_type != null) && (localDropList.action_type.get() == 1)) {
            SubscribeLaucher.a(localDropList.jumpurl.get());
          }
        }
      }
      this.n.cancel();
      break;
    case 2131430272: 
      this.n.cancel();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    GdtAppReceiver localGdtAppReceiver = this.r;
    if (localGdtAppReceiver != null) {
      localGdtAppReceiver.unregister(getContext());
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    a();
    return true;
  }
  
  public void setIsInNightMode(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.relativevideo.RelativeAdFeedItemView
 * JD-Core Version:    0.7.0.1
 */