package com.tencent.av.ui.funchat.record;

import bdmc;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Locale;

public final class QavRecordReporter$1
  implements Runnable
{
  public QavRecordReporter$1(int paramInt1, int paramInt2, long paramLong1, long paramLong2, int paramInt3, long paramLong3, long paramLong4, int paramInt4, int paramInt5) {}
  
  public void run()
  {
    boolean bool = true;
    Object localObject = String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf(this.jdField_a_of_type_Int / 1000.0F) });
    int j = (int)(this.jdField_b_of_type_Int * 1.0F / (float)(this.jdField_a_of_type_Long - this.jdField_b_of_type_Long) * 1000.0F);
    int i = (int)(this.jdField_c_of_type_Int * 1.0F / (float)(this.jdField_a_of_type_Long - this.jdField_c_of_type_Long) * 1000.0F);
    String str = String.format(Locale.getDefault(), "%.1f", new Object[] { Float.valueOf((float)this.jdField_d_of_type_Long / 1000.0F) });
    j = Math.max(0, j);
    i = Math.max(0, i);
    HashMap localHashMap = new HashMap();
    localHashMap.put("cores", String.valueOf(this.jdField_d_of_type_Int));
    localHashMap.put("frequency", localObject);
    localHashMap.put("videoFps", String.valueOf(j));
    localHashMap.put("mp4Fps", String.valueOf(i));
    localHashMap.put("strDuration", str);
    localHashMap.put("stopType", String.valueOf(this.e));
    if (QLog.isColorLevel()) {
      QLog.i("QavRecordReporter", 2, "onRecordEnd  params=" + localHashMap);
    }
    localObject = bdmc.a(BaseApplicationImpl.getContext());
    if (this.e != 3) {}
    for (;;)
    {
      ((bdmc)localObject).a("", "av_record_fps", bool, this.jdField_d_of_type_Long, 0L, localHashMap, "", false);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordReporter.1
 * JD-Core Version:    0.7.0.1
 */