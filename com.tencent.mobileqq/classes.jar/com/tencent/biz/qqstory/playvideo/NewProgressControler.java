package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper;
import com.tencent.biz.qqstory.playvideo.player.ProgressVideoViewWrapper.ProgressListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;

public class NewProgressControler
  implements ProgressVideoViewWrapper.ProgressListener
{
  protected long a;
  protected Handler a;
  private SplitedProgressBar jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
  protected WeakReference<IVideoView> a;
  protected Timer a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  protected boolean a;
  protected long b;
  public long c;
  
  public NewProgressControler(SplitedProgressBar paramSplitedProgressBar)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(null);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new NewProgressControler.1(this, Looper.getMainLooper());
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = paramSplitedProgressBar;
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(1);
  }
  
  private void a(long paramLong)
  {
    int i = 100;
    int j;
    if (this.b > 0L)
    {
      j = (int)paramLong * 100 / (int)this.b;
      if (j <= 100) {}
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(0, i);
      return;
      i = j;
      continue;
      i = 0;
    }
  }
  
  private void a(long paramLong1, long paramLong2)
  {
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    a(paramLong1);
    SLog.a("Q.qqstory.player:NewProgressControler", "seek ft:%d , ed:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      SLog.d("Q.qqstory.player:NewProgressControler", "progress already canceled. can't start.");
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    f();
    if (this.b < 0L)
    {
      d();
      return;
    }
    e();
  }
  
  private void d()
  {
    NewProgressControler.2 local2 = new NewProgressControler.2(this);
    this.jdField_a_of_type_AndroidOsHandler.post(local2);
  }
  
  private void e()
  {
    try
    {
      Timer localTimer = new Timer();
      NewProgressControler.3 local3 = new NewProgressControler.3(this);
      localTimer.scheduleAtFixedRate(local3, 0L, 50L);
      this.jdField_a_of_type_JavaUtilTimer = localTimer;
      this.jdField_a_of_type_JavaUtilTimerTask = local3;
      SLog.b("Q.qqstory.player:NewProgressControler", "startTimer");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  private void f()
  {
    try
    {
      if (this.jdField_a_of_type_AndroidOsHandler != null) {
        this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      }
      if (this.jdField_a_of_type_JavaUtilTimer != null) {
        this.jdField_a_of_type_JavaUtilTimer.cancel();
      }
      if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
        this.jdField_a_of_type_JavaUtilTimerTask.cancel();
      }
      SLog.b("Q.qqstory.player:NewProgressControler", "cancelTimer");
      return;
    }
    finally {}
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void a(long paramLong1, long paramLong2, IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      SLog.a("Q.qqstory.player:NewProgressControler", "progress callback :onSeek , ft:%d , et:%d", Long.valueOf(paramLong1), Long.valueOf(paramLong2));
      a(paramLong1, paramLong2);
    }
  }
  
  public void a(IVideoView paramIVideoView)
  {
    if ((paramIVideoView instanceof ProgressVideoViewWrapper)) {}
    for (IVideoView localIVideoView = ((ProgressVideoViewWrapper)paramIVideoView).a();; localIVideoView = paramIVideoView)
    {
      if (localIVideoView == this.jdField_a_of_type_JavaLangRefWeakReference.get())
      {
        SLog.b("Q.qqstory.player:NewProgressControler", "cannot set the same video view");
        return;
      }
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(localIVideoView);
      if ((paramIVideoView instanceof ProgressVideoViewWrapper)) {
        ((ProgressVideoViewWrapper)paramIVideoView).a(this);
      }
      for (;;)
      {
        f();
        a(0L, paramIVideoView.b());
        return;
        SLog.b("Yarkey", "cannot set the same video view");
      }
    }
  }
  
  public void b()
  {
    SLog.b("Q.qqstory.player:NewProgressControler", "pauseProgressBar");
    f();
  }
  
  public void b(IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      SLog.b("Q.qqstory.player:NewProgressControler", "progress callback :onStart");
      c();
      return;
    }
    SLog.b("Yarkey", "onStart ignore !!");
  }
  
  public void c(IVideoView paramIVideoView)
  {
    if (paramIVideoView == this.jdField_a_of_type_JavaLangRefWeakReference.get())
    {
      SLog.b("Q.qqstory.player:NewProgressControler", "progress callback :onPause");
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.NewProgressControler
 * JD-Core Version:    0.7.0.1
 */