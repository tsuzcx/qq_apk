package com.tencent.av.gaudio;

import java.lang.ref.WeakReference;
import lcu;
import mjg;
import mqq.os.MqqHandler;

class AVNotifyCenter$UpdateChattingTime
  implements Runnable
{
  WeakReference<AVNotifyCenter> a;
  
  public AVNotifyCenter$UpdateChattingTime(AVNotifyCenter paramAVNotifyCenter)
  {
    this.a = new WeakReference(paramAVNotifyCenter);
  }
  
  public void run()
  {
    AVNotifyCenter localAVNotifyCenter = (AVNotifyCenter)this.a.get();
    if (localAVNotifyCenter == null) {}
    do
    {
      return;
      if (localAVNotifyCenter.a(String.valueOf(localAVNotifyCenter.jdField_b_of_type_Lcu.jdField_a_of_type_Long)))
      {
        localAVNotifyCenter.jdField_b_of_type_JavaLangRunnable = null;
        return;
      }
      if (localAVNotifyCenter.a != null) {
        localAVNotifyCenter.a.postDelayed(this, 2000L);
      }
    } while (!localAVNotifyCenter.f);
    String str = mjg.a(localAVNotifyCenter.c);
    if (localAVNotifyCenter.jdField_b_of_type_Lcu.jdField_a_of_type_Int == 3)
    {
      localAVNotifyCenter.a(29, 0, Long.toString(localAVNotifyCenter.jdField_b_of_type_Lcu.jdField_a_of_type_Long), str);
      return;
    }
    localAVNotifyCenter.a(29, 0, localAVNotifyCenter.jdField_b_of_type_Lcu.b, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.av.gaudio.AVNotifyCenter.UpdateChattingTime
 * JD-Core Version:    0.7.0.1
 */