package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class CellTextView$3
  extends Handler
{
  CellTextView$3(CellTextView paramCellTextView, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    CellTextView localCellTextView = this.a;
    localCellTextView.i = true;
    localCellTextView.a(6, paramMessage.arg1, paramMessage.arg2, 0);
    paramMessage = this.a.h;
    this.a.a();
    this.a.n.p();
    this.a.h = paramMessage;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.CellTextView.3
 * JD-Core Version:    0.7.0.1
 */