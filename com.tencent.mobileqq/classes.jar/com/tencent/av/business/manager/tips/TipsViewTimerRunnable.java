package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.tips.data.AvTipsItemBase;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  volatile AvTipsItemBase jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile AvTipsItemBase jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(AvTipsItemBase paramAvTipsItemBase, long paramLong)
  {
    int i = 0;
    if (paramAvTipsItemBase != null)
    {
      if (paramAvTipsItemBase.a()) {
        return false;
      }
      if (SystemClock.elapsedRealtime() - paramLong >= paramAvTipsItemBase.c() * 1000) {
        i = 1;
      }
      return i ^ 0x1;
    }
    return false;
  }
  
  private void c()
  {
    VideoAppInterface localVideoAppInterface = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface;
    if (localVideoAppInterface == null) {
      return;
    }
    localVideoAppInterface.a().removeCallbacks(this);
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().postDelayed(this, 1000L);
  }
  
  public AvTipsItemBase a()
  {
    return this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase;
  }
  
  public void a()
  {
    AvTipsItemBase localAvTipsItemBase = this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase;
    this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
    this.jdField_a_of_type_Long = 0L;
    TipsManager localTipsManager = (TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localTipsManager != null) {
      localTipsManager.a(localAvTipsItemBase);
    }
  }
  
  public boolean a(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return false;
    }
    this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase = paramAvTipsItemBase;
    if (!paramAvTipsItemBase.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public AvTipsItemBase b()
  {
    return this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase;
  }
  
  public void b()
  {
    AvTipsItemBase localAvTipsItemBase = this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase;
    this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = null;
    this.jdField_b_of_type_Long = 0L;
    TipsManager localTipsManager = (TipsManager)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localTipsManager != null) {
      localTipsManager.b(localAvTipsItemBase);
    }
  }
  
  public boolean b(AvTipsItemBase paramAvTipsItemBase)
  {
    if (paramAvTipsItemBase == null) {
      return false;
    }
    this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase = paramAvTipsItemBase;
    if (!paramAvTipsItemBase.a())
    {
      this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_b_of_type_Long = 0L;
    return true;
  }
  
  public void run()
  {
    boolean bool;
    if (a(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase, this.jdField_a_of_type_Long))
    {
      bool = true;
    }
    else
    {
      a();
      bool = false;
    }
    if (a(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase, this.jdField_b_of_type_Long)) {
      bool = true;
    } else {
      b();
    }
    this.jdField_a_of_type_Boolean = bool;
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */