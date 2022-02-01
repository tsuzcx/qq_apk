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
    if (MessageFoldable.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText))
    {
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.cancelLongPress();
      this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.setTextMsg(this.jdField_a_of_type_JavaLangCharSequence);
      MessageFoldable.a(this.jdField_a_of_type_ComTencentMobileqqDataMessageForText);
      TextItemBuilder.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder, this.jdField_a_of_type_ComTencentMobileqqDataMessageForText.istroop);
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    super.updateDrawState(paramTextPaint);
    paramTextPaint.setColor(this.jdField_a_of_type_ComTencentMobileqqActivityAioItemTextItemBuilder.a.getResources().getColor(2131165786));
    paramTextPaint.clearShadowLayer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TextItemBuilder.5
 * JD-Core Version:    0.7.0.1
 */