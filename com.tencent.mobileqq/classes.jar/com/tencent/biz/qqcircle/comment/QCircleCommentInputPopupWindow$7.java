package com.tencent.biz.qqcircle.comment;

import android.content.SharedPreferences.Editor;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.comment.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonPanel;
import com.tencent.qphone.base.util.QLog;

class QCircleCommentInputPopupWindow$7
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  QCircleCommentInputPopupWindow$7(QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow) {}
  
  public void a()
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardClosed");
    if (QCircleCommentInputPopupWindow.g(this.a))
    {
      QCircleCommentInputPopupWindow.b(this.a, false);
      if (QCircleCommentInputPopupWindow.h(this.a) != null) {
        QCircleCommentInputPopupWindow.h(this.a).setVisibility(0);
      }
      if (QCircleCommentInputPopupWindow.i(this.a) != null) {
        QCircleCommentInputPopupWindow.i(this.a).setVisibility(0);
      }
    }
    else if (!this.a.m)
    {
      this.a.dismiss();
    }
    this.a.h = false;
  }
  
  public void a(int paramInt)
  {
    QLog.d("QCircleBaseInputPopupWindow", 1, "onSoftKeyboardOpened");
    if (this.a.e != paramInt)
    {
      QCircleCommentInputPopupWindow localQCircleCommentInputPopupWindow = this.a;
      localQCircleCommentInputPopupWindow.e = paramInt;
      QCircleCommentInputPopupWindow.f(localQCircleCommentInputPopupWindow);
      this.a.b.putInt("GroupSoftKeyboardHeight", paramInt);
      this.a.b.commit();
    }
    this.a.f();
    this.a.h = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.7
 * JD-Core Version:    0.7.0.1
 */