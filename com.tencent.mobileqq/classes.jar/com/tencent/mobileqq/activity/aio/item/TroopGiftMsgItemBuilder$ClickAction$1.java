package com.tencent.mobileqq.activity.aio.item;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.widget.XEditTextEx;
import java.util.concurrent.atomic.AtomicBoolean;

class TroopGiftMsgItemBuilder$ClickAction$1
  implements TextWatcher
{
  TroopGiftMsgItemBuilder$ClickAction$1(TroopGiftMsgItemBuilder.ClickAction paramClickAction) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a.a.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.removeTextChangedListener(this);
    this.a.a.a.jdField_a_of_type_ComTencentWidgetXEditTextEx.setTag(2131374332, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.ClickAction.1
 * JD-Core Version:    0.7.0.1
 */