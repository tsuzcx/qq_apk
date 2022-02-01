package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stNewIconStyle;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.baseui.AbsWsUIGroup;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalJumpUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;

public class WSVerticalItemBottomWidgetViewController
  extends AbsWsUIGroup<WSVerticalItemData>
  implements View.OnClickListener
{
  private KandianUrlImageView g;
  private KandianUrlImageView h;
  private KandianUrlImageView i;
  private TextView j;
  private View k;
  private stSimpleMetaFeed l;
  private stNewIconStyle m;
  private WSVerticalPageFragment n;
  
  public WSVerticalItemBottomWidgetViewController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.n = paramWSVerticalVideoHolder.d;
    }
  }
  
  private void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
    {
      stNewIconStyle localstNewIconStyle = this.m;
      if ((localstNewIconStyle != null) && (!TextUtils.isEmpty(localstNewIconStyle.title)))
      {
        this.j.setVisibility(0);
        this.i.setVisibility(0);
        this.g.setVisibility(0);
        this.j.setText(this.m.title);
        if (!TextUtils.isEmpty(this.m.iconUrl)) {
          this.i.setImage(WeishiUtils.c(this.m.iconUrl));
        } else {
          this.i.setImageResource(2130844286);
        }
        if (!paramBoolean2) {
          return;
        }
        this.g.setImageResource(2130843737);
        return;
      }
    }
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.g.setVisibility(8);
  }
  
  private void l()
  {
    a(true, true);
    this.g.setImageResource(2130843737);
  }
  
  protected void a()
  {
    Object localObject = (WSVerticalItemData)c();
    if ((localObject != null) && ((((WSVerticalItemData)localObject).b() instanceof stSimpleMetaFeed)))
    {
      this.l = ((WSVerticalItemData)localObject).b();
      this.m = this.l.new_icon;
      localObject = this.m;
      if (localObject != null) {
        WSReportDC898Vertical.a(((stNewIconStyle)localObject).tag_type, this.m.id);
      }
    }
  }
  
  protected void b()
  {
    Object localObject = this.m;
    if ((localObject != null) && ((((stNewIconStyle)localObject).tag_type == 1) || (this.m.tag_type == 2)))
    {
      this.k.setVisibility(0);
      int i1 = this.m.tag_type;
      localObject = this.m.img_url;
      if (i1 == 1)
      {
        this.h.setVisibility(8);
        l();
        return;
      }
      if (i1 == 2)
      {
        a(false, false);
        this.h.setVisibility(0);
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          this.h.setImage(WeishiUtils.c((String)localObject));
          return;
        }
        this.h.setImage(WeishiUtils.c("https://isee.weishi.qq.com/qq/doudi_ban.png"));
      }
    }
    else
    {
      this.k.setVisibility(8);
    }
  }
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626082;
  }
  
  protected void j()
  {
    this.k = c(2131449430);
    this.h = ((KandianUrlImageView)c(2131449412));
    this.g = ((KandianUrlImageView)c(2131449429));
    this.i = ((KandianUrlImageView)c(2131449432));
    this.j = ((TextView)c(2131449431));
    this.k.setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131449430) {
      WSVerticalJumpUtils.b(this.n, this.l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.WSVerticalItemBottomWidgetViewController
 * JD-Core Version:    0.7.0.1
 */