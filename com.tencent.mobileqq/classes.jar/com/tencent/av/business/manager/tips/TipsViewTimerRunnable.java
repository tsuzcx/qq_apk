package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import ljk;
import mav;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile mav jdField_a_of_type_Mav = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile mav jdField_b_of_type_Mav = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(mav parammav, long paramLong)
  {
    boolean bool = true;
    if ((parammav == null) || (parammav.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammav.c() * 1000) {}
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
  
  public mav a()
  {
    return this.jdField_a_of_type_Mav;
  }
  
  public void a()
  {
    mav localmav = this.jdField_a_of_type_Mav;
    this.jdField_a_of_type_Mav = null;
    this.jdField_a_of_type_Long = 0L;
    ljk localljk = (ljk)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localljk != null) {
      localljk.a(localmav);
    }
  }
  
  public boolean a(mav parammav)
  {
    if (parammav == null) {
      return false;
    }
    this.jdField_a_of_type_Mav = parammav;
    if (!parammav.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public mav b()
  {
    return this.jdField_b_of_type_Mav;
  }
  
  public void b()
  {
    mav localmav = this.jdField_b_of_type_Mav;
    this.jdField_b_of_type_Mav = null;
    this.jdField_b_of_type_Long = 0L;
    ljk localljk = (ljk)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localljk != null) {
      localljk.b(localmav);
    }
  }
  
  public boolean b(mav parammav)
  {
    if (parammav == null) {
      return false;
    }
    this.jdField_b_of_type_Mav = parammav;
    if (!parammav.a())
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
    if (a(this.jdField_a_of_type_Mav, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Mav, this.jdField_b_of_type_Long)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */