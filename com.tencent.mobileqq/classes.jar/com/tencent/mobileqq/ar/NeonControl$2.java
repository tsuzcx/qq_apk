package com.tencent.mobileqq.ar;

import amnq;
import amtr;
import amts;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class NeonControl$2
  implements Runnable
{
  public NeonControl$2(amtr paramamtr, amts paramamts, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_Amts.b));
    localHashMap.put("selimg_frame_consume", String.valueOf(this.jdField_a_of_type_Int));
    azmz.a(BaseApplication.getContext()).a("", "scanner_selimg_frame_consume", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Amts.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Amts.b) }));
      amnq.a().a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.2
 * JD-Core Version:    0.7.0.1
 */