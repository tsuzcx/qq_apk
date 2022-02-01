package com.tencent.biz.pubaccount.weishi_new.comment;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class WsCommentBusiness$1
  extends Handler
{
  WsCommentBusiness$1(WsCommentBusiness paramWsCommentBusiness, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 11) {
      WsCommentBusiness.a(this.a).a(new Object[] { Integer.valueOf(1), Integer.valueOf(0), "" });
    }
    super.handleMessage(paramMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.comment.WsCommentBusiness.1
 * JD-Core Version:    0.7.0.1
 */