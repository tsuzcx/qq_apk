package com.tencent.luggage.wxa.op;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.page.m;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class f$7
  implements View.OnClickListener
{
  f$7(f paramf) {}
  
  public void onClick(View paramView)
  {
    String str = f.a(this.a);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onClick, mIsPipVideoRelatedPagePushed: ");
    localStringBuilder.append(f.g(this.a));
    localStringBuilder.append(", mPipVideoRelatedPage: ");
    localStringBuilder.append(f.a(f.h(this.a)));
    com.tencent.luggage.wxa.qz.o.d(str, localStringBuilder.toString());
    if (f.c(this.a))
    {
      com.tencent.luggage.wxa.qz.o.d(f.a(this.a), "onClick when mIsTransfering, return");
    }
    else if ((!f.b(this.a)) && (f.h(this.a) != null))
    {
      if (f.g(this.a))
      {
        f.i(this.a).b(f.h(this.a), "scene_other");
      }
      else
      {
        str = f.h(this.a).getCurrentUrl();
        f.i(this.a).b(str);
      }
      f.a(this.a, true);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.op.f.7
 * JD-Core Version:    0.7.0.1
 */