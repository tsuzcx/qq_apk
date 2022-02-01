package com.tencent.biz.qqcircle.comment;

import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class QCircleCommentInputPopupWindow$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  QCircleCommentInputPopupWindow$2(QCircleCommentInputPopupWindow paramQCircleCommentInputPopupWindow, View paramView) {}
  
  public void onGlobalLayout()
  {
    this.a.getViewTreeObserver().removeGlobalOnLayoutListener(this);
    int i = this.a.getMeasuredHeight();
    QLog.d("QCircleBaseInputPopupWindow", 1, new Object[] { "onGlobalLayout input box height: ", Integer.valueOf(i), " | key board height: ", Integer.valueOf(this.b.e) });
    QCircleCommentInputPopupWindow localQCircleCommentInputPopupWindow = this.b;
    QCircleCommentInputPopupWindow.a(localQCircleCommentInputPopupWindow, localQCircleCommentInputPopupWindow.e, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleCommentInputPopupWindow.2
 * JD-Core Version:    0.7.0.1
 */