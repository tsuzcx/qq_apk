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
    boolean bool = true;
    if ((paramAvTipsItemBase == null) || (paramAvTipsItemBase.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= paramAvTipsItemBase.c() * 1000) {}
      for (int i = 1; i != 0; i = 0) {
        return false;
      }
    }
  }
  
  private void c()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoAppInterface == null) {}
    do
    {
      return;
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a().removeCallbacks(this);
    } while (!this.jdField_a_of_type_Boolean);
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
    boolean bool2 = true;
    boolean bool1 = false;
    if (a(this.jdField_a_of_type_ComTencentAvTipsDataAvTipsItemBase, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_ComTencentAvTipsDataAvTipsItemBase, this.jdField_b_of_type_Long)) {
        break label55;
      }
      bool1 = bool2;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool1;
      c();
      return;
      a();
      break;
      label55:
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */