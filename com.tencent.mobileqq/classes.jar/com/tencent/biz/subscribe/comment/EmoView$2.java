package com.tencent.biz.subscribe.comment;

import android.widget.GridView;
import com.tencent.qphone.base.util.QLog;

class EmoView$2
  implements Runnable
{
  EmoView$2(EmoView paramEmoView, int paramInt, GridView paramGridView, EmoWindowAdapter paramEmoWindowAdapter) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GridView initPage:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("  currentView size:");
    localStringBuilder.append(this.b.getWidth());
    localStringBuilder.append("  ");
    localStringBuilder.append(this.b.getHeight());
    localStringBuilder.append("  dataSize:");
    localStringBuilder.append(this.c.getCount());
    QLog.d("CommentInputPopupWindow", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView.2
 * JD-Core Version:    0.7.0.1
 */