package com.tencent.biz.subscribe.comment;

import android.text.Editable;
import android.view.KeyEvent;
import android.widget.EditText;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class EmoView$4
  implements EmoView.EmoClickListener
{
  EmoView$4(EmoView paramEmoView) {}
  
  public boolean a()
  {
    if (EmoView.e(this.a) == null) {
      return false;
    }
    EmoView.e(this.a).dispatchKeyEvent(new KeyEvent(0L, 0L, 0, 67, 0, 0));
    return true;
  }
  
  public boolean a(String paramString)
  {
    if (EmoView.e(this.a) == null) {
      return false;
    }
    if ((EmoView.f(this.a) > 0) && (EmoView.e(this.a).getText().length() + paramString.length() > EmoView.f(this.a)))
    {
      QQToast.makeText(this.a.getContext(), 0, HardCodeUtil.a(2131902157), 0);
      return false;
    }
    EmoView.a(EmoView.e(this.a), paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView.4
 * JD-Core Version:    0.7.0.1
 */