package com.tencent.biz.subscribe.comment;

import com.tencent.qphone.base.util.QLog;

class CommentInputPopupWindow$8
  implements Runnable
{
  CommentInputPopupWindow$8(CommentInputPopupWindow paramCommentInputPopupWindow, WorkSpaceView paramWorkSpaceView) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("top   ");
    localStringBuilder.append(this.a.getTop());
    localStringBuilder.append(" bottom： ");
    localStringBuilder.append(this.a.getBottom());
    localStringBuilder.append(" getx :  ");
    localStringBuilder.append(this.a.getX());
    localStringBuilder.append(" gety :  ");
    localStringBuilder.append(this.a.getY());
    localStringBuilder.append("   Width：  ");
    localStringBuilder.append(this.a.getMeasuredWidth());
    localStringBuilder.append("  Height：  ");
    localStringBuilder.append(this.a.getMeasuredHeight());
    QLog.d("CommentInputPopupWindow", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.CommentInputPopupWindow.8
 * JD-Core Version:    0.7.0.1
 */