package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stFloatingLayerCardStyle;
import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import com.tencent.mobileqq.utils.ViewUtils;
import java.lang.ref.WeakReference;

public class GdtAdWSVerticalItemBottomController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver g;
  public AdExposureChecker.ExposureCallback h = null;
  private TextView i;
  private ImageView j;
  private stNewIconStyle k;
  private View l;
  private TextView m;
  private stSimpleMetaFeed n;
  private WSVerticalPageFragment o;
  private WSVerticalPageAdapter p;
  
  public GdtAdWSVerticalItemBottomController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.o = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(String paramString, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramstSimpleMetaFeed != null))
    {
      if (this.n.floatingLayerCardStyle.cardType == 1002)
      {
        this.i.setVisibility(0);
        this.i.setText(paramString);
        return;
      }
      paramstSimpleMetaFeed = new SpannableStringBuilder();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("ao");
      paramstSimpleMetaFeed.append(localStringBuilder.toString());
      paramString = e().getDrawable(2130840561);
      paramString.setBounds(ViewUtils.dpToPx(4.0F), ViewUtils.dpToPx(-5.0F), ViewUtils.dpToPx(25.0F), ViewUtils.dpToPx(6.0F));
      paramstSimpleMetaFeed.setSpan(new ImageSpan(paramString), paramstSimpleMetaFeed.length() - 2, paramstSimpleMetaFeed.length(), 33);
      if (!TextUtils.isEmpty(paramstSimpleMetaFeed))
      {
        this.i.setVisibility(0);
        this.j.setVisibility(0);
        this.i.setText(paramstSimpleMetaFeed);
        return;
      }
      this.i.setVisibility(8);
      this.j.setVisibility(8);
      return;
    }
    this.i.setVisibility(8);
    this.j.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      stNewIconStyle localstNewIconStyle = this.k;
      if ((localstNewIconStyle != null) && (!TextUtils.isEmpty(localstNewIconStyle.title)))
      {
        this.m.setVisibility(0);
        this.l.setVisibility(0);
        this.m.setText(this.k.title);
        return;
      }
    }
    this.m.setVisibility(8);
    this.l.setVisibility(8);
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)))
    {
      this.n = localWSVerticalItemData.b();
      this.k = this.n.new_icon;
    }
  }
  
  protected void b()
  {
    Object localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      localObject = ((WSVerticalItemData)localObject).b();
      a(((stSimpleMetaFeed)localObject).feed_desc, (stSimpleMetaFeed)localObject);
    }
    localObject = this.k;
    if ((localObject != null) && (((stNewIconStyle)localObject).tag_type == 0) && (this.n.floatingLayerCardStyle.cardType == 1002))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131624927;
  }
  
  protected void j()
  {
    this.i = ((TextView)c(2131434079));
    this.j = ((ImageView)c(2131434062));
    this.l = c(2131434069);
    this.m = ((TextView)c(2131434071));
    this.i.setOnClickListener(this);
    this.l.setOnClickListener(this);
    this.j.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.n != null) && (d() != null) && (this.o != null))
    {
      WSLog.b("GdtWSVerticalItemBottomController", "跳转到广告落地页");
      if (g == null)
      {
        g = new GdtAppReceiver();
        g.register(BaseApplicationImpl.getContext());
      }
      paramView = new GdtAd(GdtAdUtil.a(this.n));
      if (this.h == null) {
        this.h = new GdtAdWSVerticalItemBottomController.1(this);
      }
      AdExposureChecker.onClick(d(), paramView, new WeakReference(this.h));
      this.p = this.o.b();
      paramView = this.p;
      if ((paramView != null) && (paramView.b() != null))
      {
        paramView = this.p.b();
        if ((paramView != null) && (paramView.f != null) && (c() != null) && (((WSVerticalItemData)c()).e() != null))
        {
          GdtAdUtil.a(d(), this.n, g, paramView.f, true);
          ((WSVerticalItemData)c()).e().isGdtAdclicked = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemBottomController
 * JD-Core Version:    0.7.0.1
 */