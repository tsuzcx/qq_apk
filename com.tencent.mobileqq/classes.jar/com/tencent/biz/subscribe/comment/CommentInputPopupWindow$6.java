package com.tencent.biz.subscribe.comment;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextWatcher;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class CommentInputPopupWindow$6
  implements TextWatcher
{
  private int b;
  private int c;
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    CommentInputPopupWindow.h(this.a).removeTextChangedListener(this);
    Object localObject;
    StringBuilder localStringBuilder;
    if (paramEditable.length() > CommentInputPopupWindow.i(this.a))
    {
      localObject = this.a.getContext();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(HardCodeUtil.a(2131900373));
      localStringBuilder.append(CommentInputPopupWindow.i(this.a));
      localStringBuilder.append(HardCodeUtil.a(2131900374));
      QQToast.makeText((Context)localObject, localStringBuilder.toString(), 0).show();
      i = this.b;
      paramEditable.delete(i, this.c + i);
    }
    else
    {
      localStringBuilder = null;
      localObject = paramEditable.toString();
      i = this.b;
      String str = ((String)localObject).substring(i, this.c + i);
      i = str.indexOf('/');
      localObject = localStringBuilder;
      if (i >= 0)
      {
        localObject = localStringBuilder;
        if (i < str.length() - 1)
        {
          localObject = new SpannableStringBuilder(paramEditable.toString());
          EmoWindow.a(CommentInputPopupWindow.h(this.a).getContext(), (SpannableStringBuilder)localObject);
        }
      }
      if (localObject != null) {
        i = CommentInputPopupWindow.h(this.a).getSelectionEnd();
      }
    }
    try
    {
      CommentInputPopupWindow.h(this.a).setText((CharSequence)localObject);
    }
    catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
    {
      label230:
      break label230;
    }
    CommentInputPopupWindow.h(this.a).setText(paramEditable.toString());
    int i = paramEditable.toString().length();
    CommentInputPopupWindow.h(this.a).setSelection(i);
    this.c = 0;
    this.b = 0;
    CommentInputPopupWindow.h(this.a).addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramCharSequence == null) {
      return;
    }
    this.b = paramInt1;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.6
 * JD-Core Version:    0.7.0.1
 */