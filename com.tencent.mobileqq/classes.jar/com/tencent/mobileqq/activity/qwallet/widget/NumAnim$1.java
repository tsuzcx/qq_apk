package com.tencent.mobileqq.activity.qwallet.widget;

class NumAnim$1
  implements NumAnim.Ruler
{
  NumAnim$1(NumAnim paramNumAnim) {}
  
  public NumAnim.SpannableValue getNumber(double paramDouble)
  {
    String str;
    if ((paramDouble >= 1000.0D) && (paramDouble < 10000.0D))
    {
      str = " ";
      str = str + "¥" + NumAnim.formatNumber(paramDouble, true);
      if (paramDouble < 10000.0D) {
        break label114;
      }
    }
    label114:
    for (int i = str.indexOf("万");; i = str.indexOf("."))
    {
      return new NumAnim.SpannableValue(str, str.indexOf("¥") + 1, i);
      if ((paramDouble >= 0.0D) && (paramDouble < 1000.0D))
      {
        str = "  ";
        break;
      }
      str = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.NumAnim.1
 * JD-Core Version:    0.7.0.1
 */