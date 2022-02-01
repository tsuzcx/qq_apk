package com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import android.app.Activity;
import android.content.Context;
import android.support.annotation.UiThread;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalVideoHolder;
import com.tencent.biz.pubaccount.weishi_new.view.RoundImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.aditem.GdtAppReceiver;
import java.lang.ref.WeakReference;

public class GdtAdWSVerticalItemTopController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  public static GdtAppReceiver h;
  public AdExposureChecker.ExposureCallback g = null;
  private WSVerticalPageFragment i;
  private WSVerticalPageAdapter j;
  private View k;
  private RoundImageView l;
  private TextView m;
  private stSimpleMetaFeed n;
  
  public GdtAdWSVerticalItemTopController(Context paramContext)
  {
    super(paramContext);
  }
  
  public GdtAdWSVerticalItemTopController(Context paramContext, WSVerticalPageFragment paramWSVerticalPageFragment)
  {
    this(paramContext);
    this.i = paramWSVerticalPageFragment;
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData == null) {
      return;
    }
    if ((localWSVerticalItemData.b() instanceof stSimpleMetaFeed)) {
      this.n = localWSVerticalItemData.b();
    }
  }
  
  @UiThread
  protected void b()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onUpdateUI hashcode******************************");
    ((StringBuilder)localObject).append(hashCode());
    ((StringBuilder)localObject).append(",position:");
    ((StringBuilder)localObject).append(h());
    WSLog.a("GdtAdWSVerticalItemTopController", ((StringBuilder)localObject).toString());
    localObject = (WSVerticalItemData)c();
    if (localObject == null) {
      return;
    }
    if ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed))
    {
      this.m.setText(this.n.poster.nick);
      WSPicLoader.a().a(this.a, this.l, this.n.poster.avatar);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131624929;
  }
  
  protected void j()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.b.getLayoutParams();
    localLayoutParams.height = WeishiUIUtil.b();
    localLayoutParams.width = -2;
    localLayoutParams.topMargin = WeishiUIUtil.b((Activity)this.a);
    localLayoutParams.leftMargin = WeishiUIUtil.a();
    this.b.setLayoutParams(localLayoutParams);
    this.k = c(2131445160);
    this.l = ((RoundImageView)c(2131434074));
    this.m = ((TextView)c(2131434077));
    this.l.setOnClickListener(this);
    this.m.setOnClickListener(this);
    this.k.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if ((this.n != null) && (d() != null) && (this.i != null))
    {
      WSLog.b("GdtAdWSVerticalItemTopController", "跳转到广告落地页");
      if (h == null)
      {
        h = new GdtAppReceiver();
        h.register(BaseApplicationImpl.getContext());
      }
      paramView = new GdtAd(GdtAdUtil.a(this.n));
      if (this.g == null) {
        this.g = new GdtAdWSVerticalItemTopController.1(this);
      }
      AdExposureChecker.onClick(d(), paramView, new WeakReference(this.g));
      this.j = this.i.b();
      paramView = this.j;
      if ((paramView != null) && (paramView.b() != null))
      {
        paramView = this.j.b();
        if ((paramView != null) && (paramView.f != null) && (c() != null) && (((WSVerticalItemData)c()).e() != null))
        {
          GdtAdUtil.a(d(), this.n, h, paramView.f, false);
          ((WSVerticalItemData)c()).e().isGdtAdclicked = true;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.gdt.GdtAdWSVerticalItemTopController
 * JD-Core Version:    0.7.0.1
 */