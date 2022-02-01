package com.tencent.biz.qqstory.playvideo;

import android.text.InputFilter;
import android.text.Spanned;
import com.tencent.mobileqq.utils.StringUtil;

class QQStoryCommentDialog$ChineseLengthFilter
  implements InputFilter
{
  protected final int a;
  
  public CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    int i = this.b.a(paramSpanned);
    paramInt3 = this.b.a(paramSpanned.subSequence(paramInt3, paramInt4));
    paramInt1 = this.b.a(paramCharSequence.subSequence(paramInt1, paramInt2));
    paramInt4 = this.a - (i - paramInt3);
    if (paramInt4 <= 0) {
      return "";
    }
    if (paramInt4 >= paramInt1) {
      return null;
    }
    paramSpanned = new StringBuilder();
    i = paramCharSequence.length();
    paramInt1 = 0;
    paramInt2 = 0;
    while (paramInt1 < i)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (StringUtil.isChinese(c)) {
        paramInt3 = 3;
      } else {
        paramInt3 = 1;
      }
      paramInt2 += paramInt3;
      if (paramInt2 > paramInt4) {
        break;
      }
      paramSpanned.append(c);
      paramInt1 += 1;
    }
    return paramSpanned.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog.ChineseLengthFilter
 * JD-Core Version:    0.7.0.1
 */