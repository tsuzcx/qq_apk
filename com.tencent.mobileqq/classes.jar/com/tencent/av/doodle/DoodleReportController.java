package com.tencent.av.doodle;

import android.os.SystemClock;
import com.tencent.beacon.event.UserAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class DoodleReportController
{
  private long jdField_a_of_type_Long = 0L;
  private DoodleLogic jdField_a_of_type_ComTencentAvDoodleDoodleLogic = null;
  public boolean a;
  private boolean b = false;
  
  public DoodleReportController(DoodleLogic paramDoodleLogic)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic = paramDoodleLogic;
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
      return;
    }
    b(this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a);
  }
  
  private void b(int paramInt)
  {
    if (this.jdField_a_of_type_Long != 0L)
    {
      long l = SystemClock.elapsedRealtime() - this.jdField_a_of_type_Long;
      if (l > 3000L)
      {
        HashMap localHashMap = new HashMap();
        String str1 = Integer.toHexString(paramInt);
        String str2 = String.valueOf(l);
        localHashMap.put("color", str1);
        localHashMap.put("duration", str2);
        UserAction.onUserAction("actAVFunChatDrawing", true, -1L, -1L, localHashMap, true);
        if (QLog.isColorLevel()) {
          QLog.d("DoodleReportController", 2, "onUserAction colorString = " + str1 + ", durationString = " + str2);
        }
        this.b = true;
      }
    }
  }
  
  public void a()
  {
    a(false);
    if (this.b)
    {
      DoodleUtils.a("0X80077C2");
      return;
    }
    DoodleUtils.a("0X80077C1");
  }
  
  public void a(int paramInt)
  {
    if ((this.jdField_a_of_type_Boolean) && (paramInt != this.jdField_a_of_type_ComTencentAvDoodleDoodleLogic.a))
    {
      b(paramInt);
      this.jdField_a_of_type_Long = SystemClock.elapsedRealtime();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean != paramBoolean)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.doodle.DoodleReportController
 * JD-Core Version:    0.7.0.1
 */