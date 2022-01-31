package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import ljf;
import maq;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile maq jdField_a_of_type_Maq = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile maq jdField_b_of_type_Maq = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(maq parammaq, long paramLong)
  {
    boolean bool = true;
    if ((parammaq == null) || (parammaq.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammaq.c() * 1000) {}
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
  
  public maq a()
  {
    return this.jdField_a_of_type_Maq;
  }
  
  public void a()
  {
    maq localmaq = this.jdField_a_of_type_Maq;
    this.jdField_a_of_type_Maq = null;
    this.jdField_a_of_type_Long = 0L;
    ljf localljf = (ljf)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localljf != null) {
      localljf.a(localmaq);
    }
  }
  
  public boolean a(maq parammaq)
  {
    if (parammaq == null) {
      return false;
    }
    this.jdField_a_of_type_Maq = parammaq;
    if (!parammaq.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public maq b()
  {
    return this.jdField_b_of_type_Maq;
  }
  
  public void b()
  {
    maq localmaq = this.jdField_b_of_type_Maq;
    this.jdField_b_of_type_Maq = null;
    this.jdField_b_of_type_Long = 0L;
    ljf localljf = (ljf)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (localljf != null) {
      localljf.b(localmaq);
    }
  }
  
  public boolean b(maq parammaq)
  {
    if (parammaq == null) {
      return false;
    }
    this.jdField_b_of_type_Maq = parammaq;
    if (!parammaq.a())
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
    if (a(this.jdField_a_of_type_Maq, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Maq, this.jdField_b_of_type_Long)) {
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