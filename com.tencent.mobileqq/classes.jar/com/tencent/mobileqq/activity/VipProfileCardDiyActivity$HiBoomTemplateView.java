package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.hiboom.HiBoomConstants;
import com.tencent.mobileqq.hiboom.HiBoomFont;
import com.tencent.mobileqq.hiboom.HiBoomFontDrawer;
import com.tencent.mobileqq.profile.diy.DiyTextView;
import com.tencent.mobileqq.profile.view.SingleTouchLayout;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateService;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.atomic.AtomicBoolean;

public class VipProfileCardDiyActivity$HiBoomTemplateView
  extends RelativeLayout
  implements View.OnClickListener
{
  ImageView a;
  ImageView b;
  View c;
  View d;
  int e;
  int f;
  CallBacker g;
  
  public VipProfileCardDiyActivity$HiBoomTemplateView(VipProfileCardDiyActivity paramVipProfileCardDiyActivity, Context paramContext, int paramInt, boolean paramBoolean)
  {
    super(paramContext);
    paramContext = paramVipProfileCardDiyActivity.getLayoutInflater().inflate(2131627672, this, true);
    this.a = ((ImageView)paramContext.findViewById(2131446981));
    this.b = ((ImageView)paramContext.findViewById(2131445555));
    this.c = paramContext.findViewById(2131435452);
    this.d = paramContext.findViewById(2131440757);
    this.e = paramInt;
    if (paramBoolean)
    {
      this.f = 2;
      HiBoomFont.a().a(paramInt, 1, HiBoomConstants.d);
    }
    else
    {
      this.f = 0;
      this.d.setVisibility(0);
      this.g = new VipProfileCardDiyActivity.HiBoomTemplateView.1(this, paramVipProfileCardDiyActivity);
      paramVipProfileCardDiyActivity.ah.addCallBacker(this.g);
    }
    setOnClickListener(this);
  }
  
  public void onClick(View paramView)
  {
    if (this.h.q != null) {
      this.h.q.setChecked(false);
    }
    setChecked(true);
    Object localObject = this.h;
    ((VipProfileCardDiyActivity)localObject).q = this;
    ((VipProfileCardDiyActivity)localObject).n.setHiBoom(this.e, 1, HiBoomConstants.d);
    localObject = HiBoomFont.a().a(this.e, 1, HiBoomConstants.d);
    if (this.f == 0) {
      if (((HiBoomFontDrawer)localObject).h.get())
      {
        this.f = 1;
      }
      else if (!((HiBoomFontDrawer)localObject).g.get())
      {
        this.f = 1;
        ((HiBoomFontDrawer)localObject).a(true);
      }
    }
    this.h.l.setCenterPoint(this.h.k.getWidth() / 2, this.h.k.getHeight() / 2);
    if (this.h.K)
    {
      localObject = this.h;
      ((VipProfileCardDiyActivity)localObject).K = false;
      ((VipProfileCardDiyActivity)localObject).l.setVisibility(0);
      this.h.e();
    }
    localObject = this.h;
    ((VipProfileCardDiyActivity)localObject).onTextChanged(((VipProfileCardDiyActivity)localObject).f(), 0, 0, 0);
    VasWebviewUtil.a("", "card_mall", "0X8008114", "", 1, 0, 0, HttpUtil.getNetWorkTypeByStr(), "", String.valueOf(this.e));
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.h.ah != null) {
      this.h.ah.removeCallBacker(this.g);
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setBackgroundColor(this.h.b.getColor(2131166670));
      this.b.setVisibility(0);
      return;
    }
    this.c.setBackgroundColor(0);
    this.b.setVisibility(8);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    this.a.setImageDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.VipProfileCardDiyActivity.HiBoomTemplateView
 * JD-Core Version:    0.7.0.1
 */