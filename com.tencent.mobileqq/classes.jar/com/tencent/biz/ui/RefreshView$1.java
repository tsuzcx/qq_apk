package com.tencent.biz.ui;

import android.os.Handler;
import android.os.Message;

class RefreshView$1
  extends Handler
{
  RefreshView$1(RefreshView paramRefreshView) {}
  
  public void handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 0) {
      return;
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.ui.RefreshView.1
 * JD-Core Version:    0.7.0.1
 */