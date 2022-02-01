package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import java.lang.ref.WeakReference;

public class GdtAdWSVerticalItemWidgetButtonController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver g;
  public AdExposureChecker.ExposureCallback h = null;
  private View i;
  private TextView j;
  private stSimpleMetaFeed k;
  private stNewIconStyle l;
  private WSVerticalPageFragment m;
  private WSVerticalPageAdapter n;
  
  public GdtAdWSVerticalItemWidgetButtonController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.m = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      stNewIconStyle localstNewIconStyle = this.l;
      if ((localstNewIconStyle != null) && (!TextUtils.isEmpty(localstNewIconStyle.title)))
      {
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        this.j.setText(this.l.title);
        return;
      }
    }
    this.j.setVisibility(8);
    this.i.setVisibility(8);
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData != null) && ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)))
    {
      this.k = localWSVerticalItemData.b();
      this.l = this.k.new_icon;
    }
  }
  
  protected void b()
  {
    stNewIconStyle localstNewIconStyle = this.l;
    if ((localstNewIconStyle != null) && (localstNewIconStyle.tag_type == 0))
    {
      a(true);
      return;
    }
    a(false);
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131624931;
  }
  
  protected void j()
  {
    this.i = c(2131434068);
    this.i.setOnClickListener(this);
    this.j = ((TextView)c(2131434070));
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getId() == 2131434068) && (this.k != null) && (this.m != null))
    {
      if (g == null)
      {
        g = new GdtAppReceiver();
        g.register(BaseApplicationImpl.getContext());
      }
      paramView = new GdtAd(GdtAdUtil.a(this.k));
      if (this.h == null) {
        this.h = new GdtAdWSVerticalItemWidgetButtonController.1(this);
      }
      AdExposureChecker.onClick(d(), paramView, new WeakReference(this.h));
      this.n = this.m.b();
      paramView = this.n;
      if ((paramView != null) && (paramView.b() != null))
      {
        paramView = this.n.b();
        if ((paramView != null) && (paramView.f != null) && (c() != null) && (((WSVerticalItemData)c()).e() != null))
        {
          GdtAdUtil.a(d(), this.k, g, paramView.f, true);
          ((WSVerticalItemData)c()).e().isGdtAdclicked = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemWidgetButtonController
 * JD-Core Version:    0.7.0.1
 */