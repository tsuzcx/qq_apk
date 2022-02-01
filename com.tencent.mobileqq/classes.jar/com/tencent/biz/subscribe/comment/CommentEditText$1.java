package com.tencent.biz.subscribe.comment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qphone.base.util.QLog;

class CommentEditText$1
  implements TextWatcher
{
  String a = null;
  int b = -1;
  
  CommentEditText$1(CommentEditText paramCommentEditText) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    paramEditable = this.a;
    if (paramEditable != null) {}
    try
    {
      int i = this.b;
      this.c.setText(paramEditable);
      if (i <= this.c.length()) {
        break label56;
      }
      this.c.setSelection(this.c.length());
      return;
    }
    catch (Exception paramEditable)
    {
      label48:
      label56:
      break label48;
    }
    QLog.e("CommentInputPopupWindow", 1, "setTextError");
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    paramInt2 = paramCharSequence.toString().indexOf("[/", paramInt1);
    int i = paramCharSequence.toString().indexOf(']', paramInt1);
    if (paramInt2 >= paramInt1)
    {
      paramInt1 += paramInt3;
      if ((paramInt2 < paramInt1) && ((i > paramInt1) || (i == -1)))
      {
        this.b = this.c.getSelectionEnd();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramCharSequence.subSequence(0, paramInt2).toString());
        localStringBuilder.append(paramCharSequence.subSequence(paramInt1, paramCharSequence.length()));
        this.a = localStringBuilder.toString();
        return;
      }
    }
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentEditText.1
 * JD-Core Version:    0.7.0.1
 */