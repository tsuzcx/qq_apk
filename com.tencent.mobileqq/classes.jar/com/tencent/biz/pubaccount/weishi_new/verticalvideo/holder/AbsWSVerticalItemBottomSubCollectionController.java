package com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder;

import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageContract.Presenter;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.choicepanel.IWSEpisodeChoiceView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;

public abstract class AbsWSVerticalItemBottomSubCollectionController
  extends AbsWsVerticalUIGroup
{
  protected TextView g;
  protected WSVerticalPageFragment h;
  protected stSimpleMetaFeed i;
  private View j;
  private TextView k;
  
  public AbsWSVerticalItemBottomSubCollectionController(Context paramContext, WSVerticalVideoHolder paramWSVerticalVideoHolder)
  {
    super(paramContext);
    if (paramWSVerticalVideoHolder != null) {
      this.h = paramWSVerticalVideoHolder.d;
    }
  }
  
  private GradientDrawable n()
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(WeishiUIUtil.i);
    localGradientDrawable.setColor(Color.parseColor("#2F2F2F"));
    return localGradientDrawable;
  }
  
  private void o()
  {
    this.h.v().c();
  }
  
  protected void a()
  {
    WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)c();
    if (localWSVerticalItemData != null) {
      this.i = localWSVerticalItemData.b();
    }
  }
  
  protected void b()
  {
    if (l())
    {
      this.j.setVisibility(0);
      this.k.setText(m());
      return;
    }
    this.j.setVisibility(8);
  }
  
  protected void d(int paramInt)
  {
    if (l()) {
      WSVerticalBeaconReport.a(this.h.k(), this.h.l(), this.i, ((WSVerticalPageContract.Presenter)this.h.aO_()).n());
    }
  }
  
  protected void e(int paramInt) {}
  
  protected void f() {}
  
  protected int i()
  {
    return 2131626077;
  }
  
  protected void j()
  {
    this.j = c(2131449399);
    this.j.setOnClickListener(new AbsWSVerticalItemBottomSubCollectionController.1(this));
    this.k = ((TextView)c(2131449401));
    this.g = ((TextView)c(2131449400));
    FrameLayout localFrameLayout = (FrameLayout)c(2131433245);
    this.g.setRotation(270.0F);
    localFrameLayout.setBackgroundDrawable(n());
    this.j.setBackgroundColor(WSFeedUtils.g(2131165578));
  }
  
  protected abstract boolean l();
  
  protected abstract String m();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.holder.AbsWSVerticalItemBottomSubCollectionController
 * JD-Core Version:    0.7.0.1
 */