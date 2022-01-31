package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.security.InvalidParameterException;
import java.util.Timer;
import java.util.TimerTask;
import nmg;
import nmh;
import nmi;

public class ProgressControler
{
  public int a;
  protected long a;
  public Handler a;
  private SplitedProgressBar jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar;
  private Object jdField_a_of_type_JavaLangObject;
  public WeakReference a;
  public Timer a;
  private TimerTask jdField_a_of_type_JavaUtilTimerTask;
  public boolean a;
  public long b;
  public long c;
  
  public ProgressControler(SplitedProgressBar paramSplitedProgressBar)
  {
    this.jdField_a_of_type_AndroidOsHandler = new nmg(this, Looper.getMainLooper());
    if (paramSplitedProgressBar == null) {
      throw new InvalidParameterException("ProgressControler: progressBar is null");
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar = paramSplitedProgressBar;
  }
  
  private void g()
  {
    Timer localTimer = new Timer();
    nmi localnmi = new nmi(this);
    localTimer.scheduleAtFixedRate(localnmi, 0L, 50L);
    this.jdField_a_of_type_JavaUtilTimer = localTimer;
    this.jdField_a_of_type_JavaUtilTimerTask = localnmi;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.a();
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  protected void a()
  {
    nmh localnmh = new nmh(this);
    this.jdField_a_of_type_AndroidOsHandler.post(localnmh);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setTotalCount(paramInt);
  }
  
  public void a(int paramInt, long paramLong)
  {
    int j = 100;
    int i = 0;
    if (this.b > 0L)
    {
      int k = (int)paramLong * 100 / (int)this.b;
      i = k;
      if (k > 100) {
        i = j;
      }
    }
    for (;;)
    {
      if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.b))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ProgressControler", 2, "setProgressNow index < 0 || index >= mProgressBar.mTotalCount, index = " + paramInt + ", mTotalCount = " + this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.b);
        }
        if (this.jdField_a_of_type_JavaUtilTimer != null) {
          this.jdField_a_of_type_JavaUtilTimer.cancel();
        }
        if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
          this.jdField_a_of_type_JavaUtilTimerTask.cancel();
        }
        return;
      }
      this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(paramInt, i);
      return;
    }
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, IVideoView paramIVideoView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIVideoView);
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    g();
  }
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b()
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
  }
  
  public void b(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong;
    this.c = this.jdField_a_of_type_Long;
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      a(paramInt, paramLong);
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
  }
  
  public int c()
  {
    int i = 0;
    if (this.b > 0L)
    {
      int j = (int)this.c * 100 / (int)this.b;
      i = j;
      if (j > 100) {
        return 100;
      }
    }
    return i;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.w("ProgressControler", 2, "progress already canceled. can't resume.");
      }
      return;
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilTimer != null) {
      this.jdField_a_of_type_JavaUtilTimer.cancel();
    }
    if (this.jdField_a_of_type_JavaUtilTimerTask != null) {
      this.jdField_a_of_type_JavaUtilTimerTask.cancel();
    }
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
    if (this.b < 0L)
    {
      a();
      return;
    }
    g();
  }
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = true;
    b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(0);
  }
  
  public void f()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setVisibility(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler
 * JD-Core Version:    0.7.0.1
 */