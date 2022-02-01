package com.tencent.biz.pubaccount.readinjoy.comment.data;

import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule.Ox978RespCallBack;
import com.tencent.qphone.base.util.QLog;

class CommentViewItem$5
  implements UserOperationModule.Ox978RespCallBack
{
  CommentViewItem$5(CommentViewItem paramCommentViewItem) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommentViewItem", 2, new Object[] { "", "add to follow isSuccess: " + paramBoolean });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.comment.data.CommentViewItem.5
 * JD-Core Version:    0.7.0.1
 */