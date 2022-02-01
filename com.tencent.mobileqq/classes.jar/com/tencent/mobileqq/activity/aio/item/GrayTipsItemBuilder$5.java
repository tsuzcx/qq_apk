package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.activity.aio.core.DiscussChatPie;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.ActionSheet;

class GrayTipsItemBuilder$5
  extends ClickableSpan
{
  GrayTipsItemBuilder$5(GrayTipsItemBuilder paramGrayTipsItemBuilder, int paramInt) {}
  
  public void onClick(View paramView)
  {
    if ((this.b.c instanceof Activity))
    {
      paramView = ActionSheet.create(this.b.c);
      paramView.addButton(2131888816);
      paramView.addCancelButton(2131887648);
      paramView.setOnButtonClickListener(new GrayTipsItemBuilder.5.1(this, paramView));
      paramView.show();
      BaseChatPie localBaseChatPie = ((BaseActivity)this.b.c).getChatFragment().k();
      if ((localBaseChatPie instanceof DiscussChatPie)) {
        ((DiscussChatPie)localBaseChatPie).bi = paramView;
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(-12541697);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */