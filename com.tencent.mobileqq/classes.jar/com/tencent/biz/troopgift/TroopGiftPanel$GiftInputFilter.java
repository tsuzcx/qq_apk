package com.tencent.biz.troopgift;

import android.text.InputFilter;
import android.text.Spanned;
import java.io.PrintStream;

class TroopGiftPanel$GiftInputFilter
  implements InputFilter
{
  protected int a = -1;
  
  public TroopGiftPanel$GiftInputFilter(TroopGiftPanel paramTroopGiftPanel, int paramInt)
  {
    this.a = paramInt;
  }
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    PrintStream localPrintStream = System.out;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("filter() source = ");
    localStringBuilder.append(paramCharSequence);
    localStringBuilder.append(", dest = ");
    localStringBuilder.append(paramSpanned);
    localStringBuilder.append(", start = ");
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(", dstart = ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(", dend = ");
    localStringBuilder.append(paramInt4);
    localPrintStream.println(localStringBuilder.toString());
    if (paramCharSequence.length() != 1) {
      return "";
    }
    paramInt1 = paramCharSequence.charAt(0);
    if (paramInt1 >= 48)
    {
      if (paramInt1 > 57) {
        return "";
      }
      if ((paramInt3 == 0) && (paramInt1 == 48)) {
        return "";
      }
      if ((this.a > 0) && (paramSpanned.length() >= this.a)) {
        return "";
      }
      return null;
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.troopgift.TroopGiftPanel.GiftInputFilter
 * JD-Core Version:    0.7.0.1
 */