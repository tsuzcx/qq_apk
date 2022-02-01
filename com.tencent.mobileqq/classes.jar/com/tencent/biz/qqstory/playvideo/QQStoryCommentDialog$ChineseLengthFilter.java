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
    int i = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramSpanned);
    paramInt3 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramSpanned.subSequence(paramInt3, paramInt4));
    paramInt1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryCommentDialog.a(paramCharSequence.subSequence(paramInt1, paramInt2));
    paramInt4 = this.jdField_a_of_type_Int - (i - paramInt3);
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
    if (paramInt1 < i)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (StringUtil.c(c)) {}
      for (paramInt3 = 3;; paramInt3 = 1)
      {
        paramInt2 += paramInt3;
        if (paramInt2 > paramInt4) {
          break label154;
        }
        paramSpanned.append(c);
        paramInt1 += 1;
        break;
      }
    }
    label154:
    return paramSpanned.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.QQStoryCommentDialog.ChineseLengthFilter
 * JD-Core Version:    0.7.0.1
 */