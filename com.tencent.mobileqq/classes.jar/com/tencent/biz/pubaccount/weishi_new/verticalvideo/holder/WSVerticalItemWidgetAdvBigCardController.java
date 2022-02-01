package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSBigCardCommercialInfo;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSBezierInterpolator;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.utils.ViewUtils;

public class WSVerticalItemWidgetAdvBigCardController
  extends AbsWsVerticalUIGroup
  implements View.OnClickListener
{
  private View g;
  private TextView h;
  private TextView i;
  private KandianUrlImageView j;
  private WSVerticalPageFragment k;
  private int l;
  private boolean m = false;
  private WSBigCardCommercialInfo n;
  private WSVerticalItemWidgetAdvBigCardController.BigCardStatusChangeListener o;
  private ValueAnimator p;
  private ValueAnimator q;
  private WSBezierInterpolator r;
  private WSBezierInterpolator s;
  private int t;
  
  public WSVerticalItemWidgetAdvBigCardController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder, int paramInt)
  {
    super(paramContext);
    this.t = paramInt;
    if (paramWSVerticalVideoHolder != null) {
      paramContext = paramWSVerticalVideoHolder.d;
    } else {
      paramContext = null;
    }
    this.k = paramContext;
    this.r = new WSBezierInterpolator(0.42F, 0.0F, 1.0F, 1.0F);
    this.s = new WSBezierInterpolator(0.0F, 0.0F, 0.58F, 1.0F);
  }
  
  private void f(int paramInt)
  {
    if (!l())
    {
      WSLog.a("WSAdvBigCardController", "planToHideCard return");
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("planToHideCard delayTime:");
    localStringBuilder.append(paramInt);
    WSLog.a("WSAdvBigCardController", localStringBuilder.toString());
    p();
    this.q.setStartDelay(paramInt);
    this.q.start();
  }
  
  private boolean l()
  {
    WSBigCardCommercialInfo localWSBigCardCommercialInfo = this.n;
    return (localWSBigCardCommercialInfo != null) && (localWSBigCardCommercialInfo.j());
  }
  
  private void m()
  {
    if (WeishiUtils.o()) {
      return;
    }
    f(0);
  }
  
  private void n()
  {
    WSVerticalJumpUtils.a(this.k, (WSVerticalItemData)c(), true);
  }
  
  private void o()
  {
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    int i1 = q();
    this.p = ObjectAnimator.ofFloat(this.b, "translationY", new float[] { i1, 0 });
    this.p.setInterpolator(this.r);
    this.p.setDuration(300L);
    this.p.addListener(new WSVerticalItemWidgetAdvBigCardController.1(this, i1, 0));
  }
  
  private void p()
  {
    ValueAnimator localValueAnimator = this.q;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    int i1 = q();
    this.q = ObjectAnimator.ofFloat(this.b, "translationY", new float[] { 0, i1 });
    this.q.setInterpolator(this.s);
    this.q.setDuration(300L);
    this.q.addListener(new WSVerticalItemWidgetAdvBigCardController.2(this, 0, i1));
  }
  
  private int q()
  {
    if (this.l <= ViewUtils.dip2px(92.0F))
    {
      int i1 = this.t;
      int i2 = ViewUtils.dip2px(92.0F);
      this.l = (i1 + i2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("initTransitionDistance:");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", bottomHeight:");
      localStringBuilder.append(i1);
      localStringBuilder.append(", selfHeight:");
      localStringBuilder.append(i2);
      WSLog.a("WSAdvBigCardController", localStringBuilder.toString());
    }
    return this.l;
  }
  
  private void r()
  {
    Object localObject = (WSVerticalItemData)c();
    if ((localObject != null) && (((WSVerticalItemData)localObject).b() != null)) {
      localObject = ((WSVerticalItemData)localObject).b().feed_desc;
    } else {
      localObject = null;
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    StringBuilder localStringBuilder2 = new StringBuilder();
    localStringBuilder2.append("feedDesc:");
    localStringBuilder2.append((String)localObject);
    localStringBuilder1.append(localStringBuilder2.toString());
    if (this.n != null)
    {
      localStringBuilder1.append(", wsCommercialInfo:[");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("bigCardIcon:");
      ((StringBuilder)localObject).append(this.n.f());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",bigCardTitle:");
      ((StringBuilder)localObject).append(this.n.e());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",bigCardBtnText:");
      ((StringBuilder)localObject).append(this.n.g());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",smallCardText:");
      ((StringBuilder)localObject).append(this.n.c());
      localStringBuilder1.append(((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(",smallCardIcon:");
      ((StringBuilder)localObject).append(this.n.b());
      ((StringBuilder)localObject).append("]");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    else
    {
      localStringBuilder1.append(", wsCommercialInfo empty");
    }
    WSLog.a("WSAdvBigCardController", localStringBuilder1.toString());
  }
  
  private void s()
  {
    if (this.b == null)
    {
      WSLog.a("WSAdvBigCardController", "resetCardStatus view null");
      return;
    }
    this.b.setTranslationY(q());
    this.b.setVisibility(8);
  }
  
  private void t()
  {
    if (!l())
    {
      WSLog.a("WSAdvBigCardController", "planToShowCard return");
      return;
    }
    this.m = false;
    o();
    int i1 = this.n.h();
    this.p.setStartDelay(i1);
    this.p.start();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("planToShowCard delayStartTime:");
    localStringBuilder.append(i1);
    WSLog.a("WSAdvBigCardController", localStringBuilder.toString());
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if ((localWSVerticalItemData.f() instanceof WSBigCardCommercialInfo))
    {
      this.n = ((WSBigCardCommercialInfo)localWSVerticalItemData.f());
      r();
      return;
    }
    this.n = null;
  }
  
  public void a(WSVerticalItemWidgetAdvBigCardController.BigCardStatusChangeListener paramBigCardStatusChangeListener)
  {
    this.o = paramBigCardStatusChangeListener;
  }
  
  protected void b()
  {
    if (l())
    {
      WSLog.b("WSAdvBigCardController", "onUpdateUI");
      this.h.setText(this.n.e());
      this.i.setText(this.n.g());
      this.j.setImage(WeishiUtils.c(this.n.f()));
      s();
      if (this.m) {
        t();
      }
    }
    a(8);
  }
  
  protected void d(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageSelected， position:");
    localStringBuilder.append(paramInt);
    WSLog.b("WSAdvBigCardController", localStringBuilder.toString());
    if (!l())
    {
      this.m = true;
      return;
    }
    t();
  }
  
  protected void e(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPageUnselected， position:");
    localStringBuilder.append(paramInt);
    WSLog.b("WSAdvBigCardController", localStringBuilder.toString());
    if (!l()) {
      return;
    }
    f(0);
  }
  
  protected void f()
  {
    WSLog.b("WSAdvBigCardController", "onRecycle");
    ValueAnimator localValueAnimator = this.p;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
    localValueAnimator = this.q;
    if (localValueAnimator != null) {
      localValueAnimator.cancel();
    }
  }
  
  protected int i()
  {
    return 2131626030;
  }
  
  protected void j()
  {
    this.g = c(2131429427);
    this.h = ((TextView)c(2131429429));
    this.i = ((TextView)c(2131429426));
    this.j = ((KandianUrlImageView)c(2131429430));
    this.g.setOnClickListener(this);
    this.i.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.g)
    {
      m();
      return;
    }
    if (paramView == this.i) {
      n();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetAdvBigCardController
 * JD-Core Version:    0.7.0.1
 */