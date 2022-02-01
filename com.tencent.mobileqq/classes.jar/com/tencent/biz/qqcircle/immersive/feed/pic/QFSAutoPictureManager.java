package com.tencent.biz.qqcircle.immersive.feed.pic;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.richframework.animation.interpolator.BezierInterpolator;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicInteger;

public class QFSAutoPictureManager
{
  private int a;
  private RecyclerView b;
  private Handler c;
  private final AtomicInteger d;
  private int e;
  private int f;
  private int g;
  private boolean h;
  
  private Message a(int paramInt, Object paramObject)
  {
    Message localMessage = g();
    if (localMessage == null)
    {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[fillMessage] msg should not be null.");
      return null;
    }
    localMessage.what = paramInt;
    localMessage.obj = paramObject;
    return localMessage;
  }
  
  private void a(int paramInt)
  {
    if (this.d == null) {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, new Object[] { "[updateState] state: ", Integer.valueOf(paramInt), " | atomic state is null." });
    }
    QLog.d("Auto-PIC-QFSAutoPictureManager", 1, new Object[] { "[updateState] state: ", Integer.valueOf(paramInt), " | hash code:", Integer.valueOf(hashCode()) });
    this.d.set(paramInt);
  }
  
  private void a(Message paramMessage)
  {
    if (paramMessage == null) {
      return;
    }
    if (paramMessage.what == 669900)
    {
      e();
      return;
    }
    if (paramMessage.what == 669901) {
      d();
    }
  }
  
  private boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    if (this.h) {
      return false;
    }
    QLog.d("Auto-PIC-QFSAutoPictureManager", 1, new Object[] { "[handleTouchEvent] rv: ", Integer.valueOf(paramView.hashCode()), " | e: ", Integer.valueOf(paramMotionEvent.getAction()) });
    this.h = true;
    a();
    b();
    return false;
  }
  
  private void b()
  {
    RecyclerView localRecyclerView = this.b;
    if (localRecyclerView == null) {
      return;
    }
    localRecyclerView.smoothScrollBy(1, 0);
  }
  
  private void b(Message paramMessage)
  {
    Handler localHandler = this.c;
    if (localHandler == null)
    {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[sendMessage] main handler should not be null.");
      return;
    }
    if (paramMessage == null)
    {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[sendMessage] message should not be null.");
      return;
    }
    localHandler.sendMessage(paramMessage);
  }
  
  private void c()
  {
    RecyclerView localRecyclerView = this.b;
    if (localRecyclerView != null) {
      localRecyclerView.stopScroll();
    }
  }
  
  private void d()
  {
    int i = this.f;
    if (i >= this.g - 1)
    {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, new Object[] { "[handleAnimStart] pic pos position: ", Integer.valueOf(i), " | pic count: ", Integer.valueOf(this.g), ", flow end." });
      return;
    }
    BezierInterpolator localBezierInterpolator = new BezierInterpolator(0.13F, 0.77F, 0.11F, 1.0F);
    QLog.d("Auto-PIC-QFSAutoPictureManager", 1, new Object[] { "[handleAnimStart] handle anim start, mScreenWidth: ", Integer.valueOf(this.e), " | mAutoPictureInterval: ", Integer.valueOf(this.a) });
    this.b.smoothScrollBy(this.e, 0, localBezierInterpolator, this.a);
  }
  
  private void e()
  {
    QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[sendStartAnimMsg] send start anim msg.");
    b(a(669901, null));
  }
  
  private boolean f()
  {
    return (this.d.get() == 0) || (this.d.get() == 3);
  }
  
  private Message g()
  {
    Handler localHandler = this.c;
    if (localHandler == null) {
      return new Message();
    }
    return localHandler.obtainMessage();
  }
  
  public void a()
  {
    if (f())
    {
      QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[release] current is idle state....");
      return;
    }
    QLog.d("Auto-PIC-QFSAutoPictureManager", 1, "[handleRelease] handle release...");
    a(3);
    Handler localHandler = this.c;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.pic.QFSAutoPictureManager
 * JD-Core Version:    0.7.0.1
 */