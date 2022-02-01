package com.tencent.biz.qqcircle.comment;

import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqcircle.widgets.comment.CommentEditText.OnInputBackListener;
import java.lang.ref.WeakReference;

class QCircleBaseInputPopupWindow$1
  implements CommentEditText.OnInputBackListener
{
  QCircleBaseInputPopupWindow$1(QCircleBaseInputPopupWindow paramQCircleBaseInputPopupWindow) {}
  
  public void a(View paramView)
  {
    if ((this.a.isShowing()) && ((QCircleBaseInputPopupWindow.a(this.a).get() instanceof Activity))) {
      ((Activity)QCircleBaseInputPopupWindow.b(this.a).get()).runOnUiThread(new QCircleBaseInputPopupWindow.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.comment.QCircleBaseInputPopupWindow.1
 * JD-Core Version:    0.7.0.1
 */