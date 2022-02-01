package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import android.view.View;
import com.etrump.mixlayout.ETFont;
import com.etrump.mixlayout.ETLayout;
import com.etrump.mixlayout.ETTextView;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.core.util.EmoticonPanelUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.AnimationTextView.OnSingleClick;
import com.tencent.qphone.base.util.QLog;

class TextItemBuilder$4
  implements AnimationTextView.OnSingleClick
{
  TextItemBuilder$4(TextItemBuilder paramTextItemBuilder, boolean paramBoolean) {}
  
  public void a(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TextItemBuilder", 2, "SingleTap invoked!");
    }
    Object localObject = (AnimationTextView)paramView;
    float f1 = ((AnimationTextView)localObject).touchL - BaseChatItemLayout.getTextBubblePaddingAlignHead();
    float f2 = ((AnimationTextView)localObject).touchT;
    float f3 = TextItemBuilder.y;
    if (this.a) {
      f1 = ((AnimationTextView)localObject).touchL - BaseChatItemLayout.getTextBubblePaddingAlignError();
    }
    localObject = ((AnimationTextView)localObject).getText();
    if ((localObject instanceof QQText))
    {
      localObject = (QQText)localObject;
      localObject = (EmoticonSpan[])((QQText)localObject).getSpans(0, ((QQText)localObject).length(), EmoticonSpan.class);
      int i;
      int j;
      boolean bool1;
      if ((paramView instanceof ETTextView))
      {
        paramView = (ETTextView)paramView;
        i = paramView.mClickEpId;
        j = paramView.mClickcEId;
        if ((paramView.mFont != null) && (paramView.mFont.mFontId != 0) && (paramView.mFont.mFontType == 1)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        if ((bool1) && (paramView.getETLayout() != null))
        {
          paramView = paramView.getETLayout();
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isHanYiFont, onlyEmoji: ");
            localStringBuilder.append(paramView.g);
            QLog.d("ChatItemBuilder", 2, localStringBuilder.toString());
          }
          bool1 = paramView.g ^ true;
        }
      }
      else
      {
        i = -1;
        j = -1;
        bool1 = false;
      }
      boolean bool2;
      if ((i != -1) && (j != -1)) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      EmoticonPanelUtils.a((EmoticonSpan[])localObject, f1, f2 - f3, bool2, i, j, this.b.d, this.b.f, (Activity)this.b.e, bool1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */