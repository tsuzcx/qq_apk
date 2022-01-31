package com.tencent.mobileqq.activity.qwallet.widget;

public class NumAnim$SpannableValue
{
  int preffixLen;
  int suffixIndex;
  String valueStr;
  
  public NumAnim$SpannableValue(String paramString, int paramInt1, int paramInt2)
  {
    this.valueStr = paramString;
    this.preffixLen = paramInt1;
    this.suffixIndex = paramInt2;
    if ((paramString == null) || (paramInt1 > paramString.length()) || (paramInt2 > paramString.length())) {
      throw new IndexOutOfBoundsException("params invalid! valueStr:" + paramString + ", preffixLen:" + paramInt1 + ", suffixIndex:" + paramInt2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.widget.NumAnim.SpannableValue
 * JD-Core Version:    0.7.0.1
 */