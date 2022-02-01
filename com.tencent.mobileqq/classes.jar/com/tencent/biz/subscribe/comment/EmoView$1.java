package com.tencent.biz.subscribe.comment;

import android.os.Handler;
import android.os.Message;

class EmoView$1
  extends Handler
{
  EmoView$1(EmoView paramEmoView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 0)
    {
      int i = EmoView.a(this.a) + 1;
      if (i <= 4)
      {
        if (EmoView.a(this.a)[EmoView.a(this.a)] != 0) {
          return;
        }
        EmoView.a(this.a, i);
        EmoView.a(this.a)[EmoView.a(this.a)] = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.comment.EmoView.1
 * JD-Core Version:    0.7.0.1
 */