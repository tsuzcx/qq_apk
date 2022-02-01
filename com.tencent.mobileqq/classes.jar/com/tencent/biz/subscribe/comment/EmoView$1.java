package com.tencent.biz.subscribe.comment;

import android.os.Handler;
import android.os.Message;

class EmoView$1
  extends Handler
{
  EmoView$1(EmoView paramEmoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    int i;
    if (paramMessage.what == 0)
    {
      i = EmoView.a(this.a) + 1;
      if ((i <= 4) && (EmoView.a(this.a)[EmoView.a(this.a)] == 0)) {}
    }
    else
    {
      return;
    }
    EmoView.a(this.a, i);
    EmoView.a(this.a)[EmoView.a(this.a)] = 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView.1
 * JD-Core Version:    0.7.0.1
 */