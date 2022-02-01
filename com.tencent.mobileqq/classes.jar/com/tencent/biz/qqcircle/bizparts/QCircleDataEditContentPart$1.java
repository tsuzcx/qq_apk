package com.tencent.biz.qqcircle.bizparts;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.biz.qqcircle.proxy.delegate.QCircleToast;
import com.tencent.biz.qqcircle.utils.HardCodeUtil;
import com.tencent.biz.qqcircle.utils.QCircleToastUtil;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;

class QCircleDataEditContentPart$1
  implements TextWatcher
{
  private int b = 0;
  private int c = 0;
  
  QCircleDataEditContentPart$1(QCircleDataEditContentPart paramQCircleDataEditContentPart) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    QCircleDataEditContentPart.a(this.a).removeTextChangedListener(this);
    paramEditable = paramEditable.toString();
    if ((paramEditable.length() > 80) && (this.b + this.c <= paramEditable.length()))
    {
      int i = this.b + this.c - (paramEditable.length() - 80);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramEditable.substring(0, i));
      localStringBuilder.append(paramEditable.substring(this.b + this.c));
      paramEditable = localStringBuilder.toString();
      QCircleDataEditContentPart.a(this.a).setText(paramEditable);
      QCircleDataEditContentPart.a(this.a).setSelection(i);
      QCircleToastUtil.a(-1L, QCircleToast.c, HardCodeUtil.a(2131895661), 1);
    }
    QCircleDataEditContentPart.a(this.a).addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.c = paramInt3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCircleDataEditContentPart.1
 * JD-Core Version:    0.7.0.1
 */