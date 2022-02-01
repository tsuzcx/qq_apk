package com.tencent.biz.pubaccount.readinjoy.comment.ui;

import android.widget.PopupWindow.OnDismissListener;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadinjoyCommentListBaseAdapter;

class ReadInJoyCommentPopUpWindow$1
  implements PopupWindow.OnDismissListener
{
  public void onDismiss()
  {
    ReadInJoyCommentPopUpWindow.a(this.a);
    if (ReadInJoyCommentPopUpWindow.a(this.a) != null) {
      ReadInJoyCommentPopUpWindow.a(this.a).c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.ui.ReadInJoyCommentPopUpWindow.1
 * JD-Core Version:    0.7.0.1
 */