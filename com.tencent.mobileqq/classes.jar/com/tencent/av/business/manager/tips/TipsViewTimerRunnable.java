package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import lin;
import mbd;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile mbd jdField_a_of_type_Mbd = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile mbd jdField_b_of_type_Mbd = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(mbd parammbd, long paramLong)
  {
    boolean bool = true;
    if ((parammbd == null) || (parammbd.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammbd.c() * 1000) {}
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
  
  public mbd a()
  {
    return this.jdField_a_of_type_Mbd;
  }
  
  public void a()
  {
    mbd localmbd = this.jdField_a_of_type_Mbd;
    this.jdField_a_of_type_Mbd = null;
    this.jdField_a_of_type_Long = 0L;
    lin locallin = (lin)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallin != null) {
      locallin.a(localmbd);
    }
  }
  
  public boolean a(mbd parammbd)
  {
    if (parammbd == null) {
      return false;
    }
    this.jdField_a_of_type_Mbd = parammbd;
    if (!parammbd.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public mbd b()
  {
    return this.jdField_b_of_type_Mbd;
  }
  
  public void b()
  {
    mbd localmbd = this.jdField_b_of_type_Mbd;
    this.jdField_b_of_type_Mbd = null;
    this.jdField_b_of_type_Long = 0L;
    lin locallin = (lin)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallin != null) {
      locallin.b(localmbd);
    }
  }
  
  public boolean b(mbd parammbd)
  {
    if (parammbd == null) {
      return false;
    }
    this.jdField_b_of_type_Mbd = parammbd;
    if (!parammbd.a())
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
    if (a(this.jdField_a_of_type_Mbd, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Mbd, this.jdField_b_of_type_Long)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */