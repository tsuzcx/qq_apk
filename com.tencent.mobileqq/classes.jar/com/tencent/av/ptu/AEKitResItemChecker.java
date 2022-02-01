package com.tencent.av.ptu;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.AEResUtil;

public class AEKitResItemChecker
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 0L;
  private final int b;
  
  public AEKitResItemChecker(int paramInt)
  {
    this.b = paramInt;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 1;
  }
  
  public boolean a(VideoAppInterface paramVideoAppInterface)
  {
    if (this.jdField_a_of_type_Int == 1) {}
    label63:
    label191:
    for (;;)
    {
      return true;
      int i;
      if (!b())
      {
        long l1 = System.currentTimeMillis();
        if ((paramVideoAppInterface != null) && (l1 > this.jdField_a_of_type_Long))
        {
          long l2 = AudioHelper.c();
          if (PtuResChecker.b(this.b)) {
            if (paramVideoAppInterface.g())
            {
              i = 1;
              this.jdField_a_of_type_Int = i;
              long l3 = AudioHelper.c();
              QLog.w("PtuResChecker", 1, "check, packageIdx[" + this.b + "], isResReady[" + this.jdField_a_of_type_Int + "], cost[" + (l3 - l2) / 1000000L + "ms]");
              this.jdField_a_of_type_Long = (l1 + 30000L);
            }
          }
        }
      }
      for (;;)
      {
        if (this.jdField_a_of_type_Int == 1) {
          break label191;
        }
        return false;
        i = 0;
        break;
        PtuResChecker.a(paramVideoAppInterface.getApp(), this.b);
        break label63;
        if (QLog.isDevelopLevel())
        {
          QLog.w("PtuResChecker", 1, "check, call too frequency or app is null.");
          continue;
          this.jdField_a_of_type_Int = 1;
        }
      }
    }
  }
  
  public boolean b()
  {
    if (PtuResChecker.b(this.b)) {
      return PtuResChecker.b();
    }
    return AEResUtil.b(PtuResChecker.a(this.b));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ptu.AEKitResItemChecker
 * JD-Core Version:    0.7.0.1
 */