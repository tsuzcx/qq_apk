package com.tencent.ark;

import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;

class ArkViewImplement$ArkInputConnection
  extends BaseInputConnection
{
  ArkViewImplement mHolder;
  
  public ArkViewImplement$ArkInputConnection(ArkViewImplement paramArkViewImplement1, View paramView, ArkViewImplement paramArkViewImplement2, boolean paramBoolean)
  {
    super(paramView, paramBoolean);
    this.mHolder = paramArkViewImplement2;
  }
  
  public boolean commitText(CharSequence paramCharSequence, int paramInt)
  {
    this.mHolder.setInputText(paramCharSequence);
    return true;
  }
  
  public boolean deleteSurroundingText(int paramInt1, int paramInt2)
  {
    int i = paramInt1;
    if (paramInt2 == 0) {
      for (;;)
      {
        int j = paramInt1 - 1;
        i = j;
        if (paramInt1 <= 0) {
          break;
        }
        this.mHolder.deleteInputText();
        paramInt1 = j;
      }
    }
    return super.deleteSurroundingText(i, paramInt2);
  }
  
  public boolean sendKeyEvent(KeyEvent paramKeyEvent)
  {
    int i;
    if (paramKeyEvent.getAction() == 0)
    {
      i = paramKeyEvent.getKeyCode();
      if (i != 67) {
        break label31;
      }
      this.mHolder.deleteInputText();
    }
    for (;;)
    {
      return super.sendKeyEvent(paramKeyEvent);
      label31:
      if (i == 66)
      {
        this.mHolder.setInputText("\n");
      }
      else if (((i >= 7) && (i <= 18)) || ((i >= 55) && (i <= 56)))
      {
        char c = (char)paramKeyEvent.getUnicodeChar();
        this.mHolder.setInputText(Character.toString(c));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewImplement.ArkInputConnection
 * JD-Core Version:    0.7.0.1
 */