package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.model.IReadInJoyModel;
import com.tencent.mobileqq.activity.aio.AIOUtils;

class ComponentHeaderPublish$1
  extends ClickableSpan
{
  ComponentHeaderPublish$1(ComponentHeaderPublish paramComponentHeaderPublish) {}
  
  public void onClick(View paramView)
  {
    RIJJumpUtils.a(this.a.getContext(), this.a.a.a.a(), 1, false, 8, false);
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-14132075);
    paramTextPaint.setTextSize(AIOUtils.a(2, 14, this.a.getResources()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderPublish.1
 * JD-Core Version:    0.7.0.1
 */