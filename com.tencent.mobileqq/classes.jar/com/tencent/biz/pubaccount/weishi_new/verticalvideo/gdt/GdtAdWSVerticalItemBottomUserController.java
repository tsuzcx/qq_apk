package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.share.WSShareParam;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiShareUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSRoundedImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.gdtad.views.image.GdtDrawableLoader;
import com.tencent.gdtad.views.image.GdtDrawableLoader.Listener;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.List;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent;
import tencent.gdt.qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label;

public class GdtAdWSVerticalItemBottomUserController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver g;
  public AdExposureChecker.ExposureCallback h = null;
  private WSVerticalPageFragment i;
  private WSVerticalPageAdapter j;
  private WSRoundedImageView k;
  private TextView l;
  private ImageView m;
  private ImageView n;
  private GdtAdWSCountDownLayout o;
  private GdtAdWSIndustryLabelContainer p;
  private TextView q;
  private TextView r;
  private TextView s;
  private stSimpleMetaFeed t;
  private GdtDrawableLoader.Listener u;
  private GdtDrawableLoader v;
  
  public GdtAdWSVerticalItemBottomUserController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.i = paramWSVerticalVideoHolder.d;
    }
  }
  
  private boolean a(WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject = GdtAdUtil.a(this.t);
    paramWSVerticalItemData = new String[3];
    int i2 = 8;
    try
    {
      localObject = ((qq_ad_get.QQAdGetRsp.AdInfo)localObject).display_info.basic_info.element_structure_content.label.get().iterator();
      int i1 = 0;
      while (((Iterator)localObject).hasNext())
      {
        qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label localLabel = (qq_ad_get.QQAdGetRsp.AdInfo.DisplayInfo.BasicInfo.CreativeElementStructureContent.Label)((Iterator)localObject).next();
        if (!TextUtils.isEmpty(localLabel.content.get()))
        {
          paramWSVerticalItemData[i1] = localLabel.content.get();
          i1 += 1;
        }
      }
      if (!TextUtils.isEmpty(paramWSVerticalItemData[0]))
      {
        this.q.setText(paramWSVerticalItemData[0]);
        this.r.setText(paramWSVerticalItemData[1]);
        this.s.setText(paramWSVerticalItemData[2]);
        localObject = this.q;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[0])) {
          i1 = 0;
        } else {
          i1 = 8;
        }
        ((TextView)localObject).setVisibility(i1);
        localObject = this.r;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[1])) {
          i1 = 0;
        } else {
          i1 = 8;
        }
        ((TextView)localObject).setVisibility(i1);
        localObject = this.s;
        i1 = i2;
        if (!TextUtils.isEmpty(paramWSVerticalItemData[2])) {
          i1 = 0;
        }
        ((TextView)localObject).setVisibility(i1);
        this.p.setVisibility(0);
        return true;
      }
      this.p.setVisibility(8);
      return false;
    }
    catch (Exception paramWSVerticalItemData)
    {
      label240:
      break label240;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtIndustryLabelContainer: 后台未下发labels字段");
    this.p.setVisibility(8);
    return false;
  }
  
  private boolean b(WSVerticalItemData paramWSVerticalItemData)
  {
    try
    {
      long l1 = Long.parseLong(GdtAdUtil.a("countdown_end_time", paramWSVerticalItemData.e()));
      long l2 = System.currentTimeMillis() / 1000L;
      return this.o.a((int)(l1 - l2));
    }
    catch (NumberFormatException paramWSVerticalItemData)
    {
      label35:
      break label35;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtCountDownWidget: 后台未下发倒计时字段");
    this.o.c();
    return false;
  }
  
  private boolean c(WSVerticalItemData paramWSVerticalItemData)
  {
    paramWSVerticalItemData = GdtAdUtil.a(paramWSVerticalItemData.e());
    if (!TextUtils.isEmpty(paramWSVerticalItemData))
    {
      this.v = new GdtDrawableLoader(paramWSVerticalItemData, new WeakReference(this.u));
      this.v.b();
      this.n.setImageDrawable(this.v.a());
      this.n.setVisibility(0);
      return true;
    }
    QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "showGdtMarketingPendantUrl: 后台未下发营销挂件字段");
    this.n.setVisibility(8);
    return false;
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))) {
      this.t = localWSVerticalItemData.b();
    }
  }
  
  protected void b()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData != null)
    {
      if (localWSVerticalItemData.e() == null) {
        return;
      }
      if ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed))
      {
        this.l.setText(this.t.poster.nick);
        WSPicLoader.a().a(this.a, this.k, this.t.poster.avatar);
        this.k.setStrokeWidth(8);
        this.k.setStrokeColor(Color.parseColor("#66FFFFFF"));
        this.m.setVisibility(0);
        QLog.i("GdtAdWSVerticalItemBottomUserController", 4, "onUpdateUI, victoryfxu");
        if ((!b(localWSVerticalItemData)) && (!c(localWSVerticalItemData))) {
          a(localWSVerticalItemData);
        }
      }
    }
  }
  
  protected void f()
  {
    GdtAdWSCountDownLayout localGdtAdWSCountDownLayout = this.o;
    if (localGdtAdWSCountDownLayout != null)
    {
      localGdtAdWSCountDownLayout.b();
      this.o = null;
    }
  }
  
  protected int i()
  {
    return 2131624928;
  }
  
  protected void j()
  {
    this.k = ((WSRoundedImageView)c(2131434073));
    this.l = ((TextView)c(2131434076));
    this.m = ((ImageView)c(2131434063));
    this.n = ((ImageView)c(2131434067));
    this.o = ((GdtAdWSCountDownLayout)c(2131434061));
    this.p = ((GdtAdWSIndustryLabelContainer)c(2131434065));
    this.q = ((TextView)c(2131434118));
    this.r = ((TextView)c(2131434119));
    this.s = ((TextView)c(2131434120));
    this.k.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.o.setOnClickListener(this);
    this.p.setOnClickListener(this);
    this.n.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131434063)
    {
      paramView = new WSShareParam();
      paramView.a = this.t;
      paramView.b = 2;
      paramView.c = this.c;
      paramView.d = WSVerticalBeaconReport.c(this.i.k());
      paramView.e = this.i.l();
      paramView.f = "more_operations";
      paramView.a(this.i);
      WeishiShareUtil.a(this.a, paramView);
      return;
    }
    if ((this.t != null) && (d() != null) && (this.i != null))
    {
      WSLog.b("GdtAdWSVerticalItemBottomUserController", "跳转到广告落地页");
      if (g == null)
      {
        g = new GdtAppReceiver();
        g.register(BaseApplicationImpl.getContext());
      }
      paramView = new GdtAd(GdtAdUtil.a(this.t));
      if (this.h == null) {
        this.h = new GdtAdWSVerticalItemBottomUserController.1(this);
      }
      AdExposureChecker.onClick(d(), paramView, new WeakReference(this.h));
      this.j = this.i.b();
      paramView = this.j;
      if ((paramView != null) && (paramView.b() != null))
      {
        paramView = this.j.b();
        if ((paramView != null) && (paramView.f != null) && (c() != null) && (((WSVerticalItemData)c()).e() != null))
        {
          GdtAdUtil.a(d(), this.t, g, paramView.f, false);
          ((WSVerticalItemData)c()).e().isGdtAdclicked = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemBottomUserController
 * JD-Core Version:    0.7.0.1
 */