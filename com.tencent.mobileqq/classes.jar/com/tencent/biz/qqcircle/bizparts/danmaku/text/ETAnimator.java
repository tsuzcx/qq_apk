package com.tencent.biz.qqcircle.bizparts.danmaku.text;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class ETAnimator
{
  private static HandlerThread b = new HandlerThread("createDecoration");
  private static Bitmap c;
  private WeakReference<TextCellLayout> a;
  private ETAnimator.DecorationUIHandler d;
  private Handler e = new ETAnimator.1(this, b.getLooper());
  
  static
  {
    b.start();
  }
  
  ETAnimator(TextCellLayout paramTextCellLayout, Looper paramLooper)
  {
    this.a = new WeakReference(paramTextCellLayout);
    this.d = new ETAnimator.DecorationUIHandler(paramTextCellLayout, paramLooper);
  }
  
  void a()
  {
    ETAnimator.DecorationUIHandler localDecorationUIHandler = this.d;
    if (localDecorationUIHandler != null) {
      localDecorationUIHandler.obtainMessage(0).sendToTarget();
    }
  }
  
  void a(ETAnimator.DecorationHolder paramDecorationHolder)
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.obtainMessage(2, paramDecorationHolder).sendToTarget();
    }
  }
  
  void b()
  {
    ETAnimator.DecorationUIHandler localDecorationUIHandler = this.d;
    if (localDecorationUIHandler != null)
    {
      localDecorationUIHandler.removeMessages(0);
      this.d.removeMessages(1);
    }
  }
  
  void c()
  {
    Handler localHandler = this.e;
    if (localHandler != null) {
      localHandler.removeMessages(2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.text.ETAnimator
 * JD-Core Version:    0.7.0.1
 */