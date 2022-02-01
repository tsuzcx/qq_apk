package com.tencent.biz.qqcircle.fragments.person;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText;
import cooperation.qqcircle.helpers.QCircleSkinHelper;

class QCircleTroopAddPopupWindow$2
  implements TextWatcher
{
  QCircleTroopAddPopupWindow$2(QCircleTroopAddPopupWindow paramQCircleTroopAddPopupWindow) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable == null) {
      return;
    }
    QCircleTroopAddPopupWindow.f(this.a).removeTextChangedListener(this);
    if (QCircleTroopAddPopupWindow.g(this.a).getText().toString().isEmpty())
    {
      if (QCircleTroopAddPopupWindow.h(this.a) != null) {
        QCircleTroopAddPopupWindow.i(this.a).setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845320));
      }
    }
    else {
      QCircleTroopAddPopupWindow.j(this.a).setBackgroundDrawable(QCircleSkinHelper.getInstance().getDrawable(2130845321));
    }
    QCircleTroopAddPopupWindow.k(this.a).addTextChangedListener(this);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */