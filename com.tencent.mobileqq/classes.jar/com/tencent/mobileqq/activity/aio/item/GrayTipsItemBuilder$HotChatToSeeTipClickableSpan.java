package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.content.Context;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class GrayTipsItemBuilder$HotChatToSeeTipClickableSpan
  extends ClickableSpan
{
  private WeakReference<QQAppInterface> a;
  private WeakReference<Context> b;
  
  GrayTipsItemBuilder$HotChatToSeeTipClickableSpan(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.a = new WeakReference(paramQQAppInterface);
    this.b = new WeakReference(paramContext);
  }
  
  public void onClick(View paramView)
  {
    paramView = (QQAppInterface)this.a.get();
    if (((this.b.get() instanceof Activity)) && (paramView != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("GrayTipsItemBuilder", 2, "handleHotChatToSeeTip span click ");
      }
      HotChatManager.a(null, false);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.HotChatToSeeTipClickableSpan
 * JD-Core Version:    0.7.0.1
 */