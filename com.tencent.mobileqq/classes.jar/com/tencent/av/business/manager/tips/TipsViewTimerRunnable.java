package com.tencent.av.business.manager.tips;

import android.os.Handler;
import android.os.SystemClock;
import com.tencent.av.app.VideoAppInterface;
import lli;
import mdf;

public class TipsViewTimerRunnable
  implements Runnable
{
  volatile long jdField_a_of_type_Long = 0L;
  VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  Object jdField_a_of_type_JavaLangObject = new Object();
  volatile mdf jdField_a_of_type_Mdf = null;
  volatile boolean jdField_a_of_type_Boolean = false;
  volatile long jdField_b_of_type_Long = 0L;
  volatile mdf jdField_b_of_type_Mdf = null;
  
  public TipsViewTimerRunnable(VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
  }
  
  private boolean a(mdf parammdf, long paramLong)
  {
    boolean bool = true;
    if ((parammdf == null) || (parammdf.a())) {
      bool = false;
    }
    for (;;)
    {
      return bool;
      if (SystemClock.elapsedRealtime() - paramLong >= parammdf.c() * 1000) {}
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
  
  public mdf a()
  {
    return this.jdField_a_of_type_Mdf;
  }
  
  public void a()
  {
    mdf localmdf = this.jdField_a_of_type_Mdf;
    this.jdField_a_of_type_Mdf = null;
    this.jdField_a_of_type_Long = 0L;
    lli locallli = (lli)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallli != null) {
      locallli.a(localmdf);
    }
  }
  
  public boolean a(mdf parammdf)
  {
    if (parammdf == null) {
      return false;
    }
    this.jdField_a_of_type_Mdf = parammdf;
    if (!parammdf.a())
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      this.jdField_a_of_type_Boolean = true;
      c();
      return true;
    }
    this.jdField_a_of_type_Long = 0L;
    return true;
  }
  
  public mdf b()
  {
    return this.jdField_b_of_type_Mdf;
  }
  
  public void b()
  {
    mdf localmdf = this.jdField_b_of_type_Mdf;
    this.jdField_b_of_type_Mdf = null;
    this.jdField_b_of_type_Long = 0L;
    lli locallli = (lli)this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(11);
    if (locallli != null) {
      locallli.b(localmdf);
    }
  }
  
  public boolean b(mdf parammdf)
  {
    if (parammdf == null) {
      return false;
    }
    this.jdField_b_of_type_Mdf = parammdf;
    if (!parammdf.a())
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
    if (a(this.jdField_a_of_type_Mdf, this.jdField_a_of_type_Long))
    {
      bool1 = true;
      if (!a(this.jdField_b_of_type_Mdf, this.jdField_b_of_type_Long)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.business.manager.tips.TipsViewTimerRunnable
 * JD-Core Version:    0.7.0.1
 */