package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import lih;
import mam;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile mam jdField_a_of_type_Mam = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile mam jdField_b_of_type_Mam = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(mam parammam, long paramLong)
  {
    boolean bool = true;
    if ((parammam == null) || (parammam.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammam.c() * 1000) {}
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
  
  public mam a()
  {
    return this.jdField_a_of_type_Mam;
  }
  
  public void a()
  {
    mam localmam = this.jdField_a_of_type_Mam;
    this.jdField_a_of_type_Mam = null;
    this.jdField_a_of_type_Long = 0L;
    lih locallih = (lih)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallih != null) {
      locallih.a(localmam);
    }
  }
  
  public boolean a(mam parammam)
  {
    if (parammam == null) {
      return false;
    }
    this.jdField_a_of_type_Mam = parammam;
    if (!parammam.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public mam b()
  {
    return this.jdField_b_of_type_Mam;
  }
  
  public void b()
  {
    mam localmam = this.jdField_b_of_type_Mam;
    this.jdField_b_of_type_Mam = null;
    this.jdField_b_of_type_Long = 0L;
    lih locallih = (lih)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallih != null) {
      locallih.b(localmam);
    }
  }
  
  public boolean b(mam parammam)
  {
    if (parammam == null) {
      return false;
    }
    this.jdField_b_of_type_Mam = parammam;
    if (!parammam.a())
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
    if (a(this.jdField_a_of_type_Mam, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Mam, this.jdField_b_of_type_Long)) {
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