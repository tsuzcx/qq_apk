package com.tencent.avgame.gamelogic;

import bdmc;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public final class QualityReporter$3
  implements Runnable
{
  public QualityReporter$3(long paramLong, HashMap paramHashMap) {}
  
  public void run()
  {
    bdmc.a(BaseApplication.getContext()).a("", "actAVGameHeartBeat", true, this.jdField_a_of_type_Long, 0L, this.jdField_a_of_type_JavaUtilHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.QualityReporter.3
 * JD-Core Version:    0.7.0.1
 */