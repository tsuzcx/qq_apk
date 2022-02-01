package com.tencent.biz.qqstory.playvideo;

import android.os.Handler;
import com.tencent.biz.qqstory.playvideo.player.IVideoView;
import com.tencent.biz.qqstory.view.SplitedProgressBar;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class ProgressControler
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
  
  private void a()
  {
    ProgressControler.2 local2 = new ProgressControler.2(this);
    this.jdField_a_of_type_AndroidOsHandler.post(local2);
  }
  
  private void a(long paramLong)
  {
    long l = this.b;
    int i;
    if (l > 0L)
    {
      int j = (int)paramLong * 100 / (int)l;
      i = j;
      if (j > 100) {
        i = 100;
      }
    }
    else
    {
      i = 0;
    }
    this.jdField_a_of_type_ComTencentBizQqstoryViewSplitedProgressBar.setProgress(0, i);
  }
  
  private void b()
  {
    Timer localTimer = new Timer();
    ProgressControler.3 local3 = new ProgressControler.3(this);
    localTimer.scheduleAtFixedRate(local3, 0L, 50L);
    this.jdField_a_of_type_JavaUtilTimer = localTimer;
    this.jdField_a_of_type_JavaUtilTimerTask = local3;
  }
  
  public void a(long paramLong1, long paramLong2, IVideoView paramIVideoView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = this.jdField_a_of_type_Long;
    this.b = paramLong2;
    Object localObject = this.jdField_a_of_type_JavaUtilTimer;
    if (localObject != null) {
      ((Timer)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_JavaUtilTimerTask;
    if (localObject != null) {
      ((TimerTask)localObject).cancel();
    }
    localObject = this.jdField_a_of_type_AndroidOsHandler;
    if (localObject != null) {
      ((Handler)localObject).removeCallbacksAndMessages(null);
    }
    if (paramLong2 <= 0L)
    {
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramIVideoView);
      a();
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(0);
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.ProgressControler
 * JD-Core Version:    0.7.0.1
 */