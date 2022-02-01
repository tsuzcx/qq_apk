package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageAdapter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemWidgetController
  extends AbsWsVerticalUIGroup
  implements View.OnClickListener
{
  private KandianUrlImageView g;
  private View h;
  private TextView i;
  private AbsWSRichWidgetData j;
  private WSVerticalPageFragment k;
  private boolean l;
  
  public WSVerticalItemWidgetController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.k = paramWSVerticalVideoHolder.d;
    }
  }
  
  @SuppressLint({"UseCompatLoadingForDrawables"})
  private void f(int paramInt)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.g.getLayoutParams();
    if (paramInt == 3)
    {
      this.h.setBackgroundResource(2130843740);
      this.i.setCompoundDrawables(null, null, null, null);
      localLayoutParams.width = WeishiUIUtil.j;
      localLayoutParams.height = WeishiUIUtil.j;
      localLayoutParams.leftMargin = WeishiUIUtil.g;
    }
    else if (paramInt == 1)
    {
      this.h.setBackgroundResource(2130843741);
      this.i.setCompoundDrawablesWithIntrinsicBounds(null, null, e().getDrawable(2130853501), null);
      this.i.setCompoundDrawablePadding(WeishiUIUtil.b);
      localLayoutParams.width = WeishiUIUtil.t;
      localLayoutParams.height = WeishiUIUtil.n;
      localLayoutParams.leftMargin = 0;
    }
    this.g.setLayoutParams(localLayoutParams);
  }
  
  private void m()
  {
    int m = l();
    Object localObject = this.j;
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (localObject != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(((AbsWSRichWidgetData)localObject).c()))
      {
        bool1 = bool2;
        if (!TextUtils.isEmpty(this.j.b())) {
          if ((m != 3) && (m != 1)) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
        }
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[updateWidgetBtnContent] des : ");
    ((StringBuilder)localObject).append(((WSVerticalItemData)c()).b().feed_desc);
    ((StringBuilder)localObject).append(", isGone :");
    ((StringBuilder)localObject).append(bool1);
    WSLog.a("WSVerticalItemWidgetController", ((StringBuilder)localObject).toString());
    this.g.setImageBitmap(null);
    if (bool1)
    {
      this.h.setVisibility(8);
      return;
    }
    f(m);
    this.h.setVisibility(0);
    localObject = this.j.c();
    String str = this.j.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[updateWidgetBtnContent] text:");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", iconUrl:");
    localStringBuilder.append(str);
    WSLog.a("WSVerticalItemWidgetController", localStringBuilder.toString());
    this.i.setText((CharSequence)localObject);
    WSPicLoader.a().a(this.g, str, null);
    if (n()) {
      o();
    }
  }
  
  private boolean n()
  {
    Object localObject = this.k;
    if ((localObject != null) && (((WSVerticalPageFragment)localObject).b() != null) && (this.k.b().b() != null))
    {
      localObject = (WSVerticalItemData)this.k.b().b().e;
      if (localObject == null) {
        return false;
      }
      WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
      if (localWSVerticalItemData != null)
      {
        stSimpleMetaFeed localstSimpleMetaFeed = localWSVerticalItemData.b();
        if (localstSimpleMetaFeed != null)
        {
          if (localWSVerticalItemData.f() == null) {
            return false;
          }
          return TextUtils.equals(((WSVerticalItemData)localObject).b().id, localstSimpleMetaFeed.id);
        }
      }
    }
    return false;
  }
  
  private void o()
  {
    if (!this.l)
    {
      this.l = true;
      WSVerticalBeaconReport.a(this.k.k(), this.k.l(), (WSVerticalItemData)c());
    }
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData != null) {
      this.j = localWSVerticalItemData.f();
    }
  }
  
  protected void b()
  {
    m();
  }
  
  protected void d(int paramInt)
  {
    this.l = false;
    if (this.h.getVisibility() == 0) {
      WSVerticalBeaconReport.a(this.k.k(), this.k.l(), (WSVerticalItemData)c());
    }
  }
  
  protected void e(int paramInt) {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626095;
  }
  
  protected void j()
  {
    this.h = c(2131449430);
    this.h.setOnClickListener(this);
    this.g = ((KandianUrlImageView)c(2131449432));
    this.i = ((TextView)c(2131449431));
  }
  
  public int l()
  {
    AbsWSRichWidgetData localAbsWSRichWidgetData = this.j;
    if (localAbsWSRichWidgetData != null) {
      return localAbsWSRichWidgetData.d();
    }
    return 0;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449430) {
      WSVerticalJumpUtils.a(this.k, (WSVerticalItemData)c());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemWidgetController
 * JD-Core Version:    0.7.0.1
 */