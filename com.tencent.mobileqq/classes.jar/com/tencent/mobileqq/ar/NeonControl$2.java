package com.tencent.mobileqq.ar;

import apba;
import aphc;
import aphd;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class NeonControl$2
  implements Runnable
{
  public NeonControl$2(aphc paramaphc, aphd paramaphd, int paramInt) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("neon_opened", String.valueOf(this.jdField_a_of_type_Aphd.b));
    localHashMap.put("selimg_frame_consume", String.valueOf(this.jdField_a_of_type_Int));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "scanner_selimg_frame_consume", true, 0L, 0L, localHashMap, "");
    if (QLog.isColorLevel())
    {
      QLog.i("NeonControl", 2, String.format("doReport selimg count:%d avgConsume:%dms neonOpened:%d", new Object[] { Integer.valueOf(this.jdField_a_of_type_Aphd.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.jdField_a_of_type_Aphd.b) }));
      apba.a().a(this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.NeonControl.2
 * JD-Core Version:    0.7.0.1
 */