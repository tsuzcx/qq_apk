package com.tencent.biz.qqcircle.fragments.person;

import android.content.SharedPreferences.Editor;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qphone.base.util.QLog;

class QCircleTroopAddPopupWindow$1
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  QCircleTroopAddPopupWindow$1(QCircleTroopAddPopupWindow paramQCircleTroopAddPopupWindow) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (!QCircleTroopAddPopupWindow.e(this.a)) {
      this.a.dismiss();
    }
    QCircleTroopAddPopupWindow.b(this.a, false);
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (QCircleTroopAddPopupWindow.a(this.a) != paramInt)
    {
      QCircleTroopAddPopupWindow.a(this.a, paramInt);
      QCircleTroopAddPopupWindow.b(this.a).putInt("GroupSoftKeyboardHeight", paramInt);
      QCircleTroopAddPopupWindow.c(this.a).commit();
    }
    QCircleTroopAddPopupWindow.d(this.a);
    QCircleTroopAddPopupWindow.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.person.QCircleTroopAddPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */