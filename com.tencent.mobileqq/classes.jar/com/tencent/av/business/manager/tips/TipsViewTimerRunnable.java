package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import lif;
import mah;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile mah jdField_a_of_type_Mah = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile mah jdField_b_of_type_Mah = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(mah parammah, long paramLong)
  {
    boolean bool = true;
    if ((parammah == null) || (parammah.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammah.c() * 1000) {}
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
  
  public mah a()
  {
    return this.jdField_a_of_type_Mah;
  }
  
  public void a()
  {
    mah localmah = this.jdField_a_of_type_Mah;
    this.jdField_a_of_type_Mah = null;
    this.jdField_a_of_type_Long = 0L;
    lif locallif = (lif)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallif != null) {
      locallif.a(localmah);
    }
  }
  
  public boolean a(mah parammah)
  {
    if (parammah == null) {
      return false;
    }
    this.jdField_a_of_type_Mah = parammah;
    if (!parammah.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public mah b()
  {
    return this.jdField_b_of_type_Mah;
  }
  
  public void b()
  {
    mah localmah = this.jdField_b_of_type_Mah;
    this.jdField_b_of_type_Mah = null;
    this.jdField_b_of_type_Long = 0L;
    lif locallif = (lif)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallif != null) {
      locallif.b(localmah);
    }
  }
  
  public boolean b(mah parammah)
  {
    if (parammah == null) {
      return false;
    }
    this.jdField_b_of_type_Mah = parammah;
    if (!parammah.a())
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
    if (a(this.jdField_a_of_type_Mah, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Mah, this.jdField_b_of_type_Long)) {
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