package com.tencent.mobileqq.activity.aio.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.data.MessageForText;

class TextItemBuilder$5
  extends ClickableSpan
{
  TextItemBuilder$5(TextItemBuilder paramTextItemBuilder, MessageForText paramMessageForText, ETTextView paramETTextView, CharSequence paramCharSequence) {}
  
  public void onClick(View paramView)
  {
    if (MessageFoldable.a(this.a))
    {
      this.b.cancelLongPress();
      this.b.setTextMsg(this.c);
      MessageFoldable.b(this.a);
      TextItemBuilder.a(this.d, this.a.istroop);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.d.e.getResources().getColor(2131166388));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */