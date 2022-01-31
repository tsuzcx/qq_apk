package com.tencent.mobileqq.armap;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Debug.MemoryInfo;
import android.os.Process;
import azri;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class ARMapTracer$ReportRunnable
  implements Runnable
{
  public float a;
  public int a;
  public long a;
  public String a;
  public boolean a;
  public float b;
  public float c;
  public float d;
  
  public ARMapTracer$ReportRunnable(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    if (this.jdField_a_of_type_Long < 0L) {
      this.jdField_a_of_type_Long = 0L;
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_Long /= 1000L;
        Object localObject = new HashMap(10);
        Debug.MemoryInfo[] arrayOfMemoryInfo = ((ActivityManager)BaseApplication.getContext().getSystemService("activity")).getProcessMemoryInfo(new int[] { Process.myPid() });
        if ((arrayOfMemoryInfo != null) && (arrayOfMemoryInfo.length > 0))
        {
          i = arrayOfMemoryInfo[0].getTotalPss();
          m = arrayOfMemoryInfo[0].otherPss;
          k = arrayOfMemoryInfo[0].nativePss;
          j = arrayOfMemoryInfo[0].dalvikPss;
          ((HashMap)localObject).put("fpsAvg", String.valueOf(this.jdField_a_of_type_Float));
          ((HashMap)localObject).put("fps0", String.valueOf(this.b));
          ((HashMap)localObject).put("fps18", String.valueOf(this.c));
          ((HashMap)localObject).put("fps25", String.valueOf(this.d));
          ((HashMap)localObject).put("duration", String.valueOf(this.jdField_a_of_type_Long));
          ((HashMap)localObject).put("pss", String.valueOf(i));
          ((HashMap)localObject).put("level", String.valueOf(this.jdField_a_of_type_Int));
          ((HashMap)localObject).put("devType", String.valueOf(ARMapTracer.a()));
          azri.a(BaseApplication.getContext()).a(this.jdField_a_of_type_JavaLangString, "actARMapTrace", this.jdField_a_of_type_Boolean, this.jdField_a_of_type_Long, i, (HashMap)localObject, null);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder(200);
            ((StringBuilder)localObject).append("ReportRunnable [").append("suc: ").append(this.jdField_a_of_type_Boolean).append(", duration: ").append(this.jdField_a_of_type_Long).append(", fpsAvg: ").append(this.jdField_a_of_type_Float).append(", fps0: ").append(this.b).append(", fps18: ").append(this.c).append(", fps25: ").append(this.d).append(", level: ").append(this.jdField_a_of_type_Int).append(", pss: ").append(i).append(", otherPss: ").append(m).append(", nativePss: ").append(k).append(", dalvikPss: ").append(j).append("]");
            QLog.i("ARMapTracer", 2, ((StringBuilder)localObject).toString());
          }
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return;
      }
      int i = 0;
      int j = 0;
      int k = 0;
      int m = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.armap.ARMapTracer.ReportRunnable
 * JD-Core Version:    0.7.0.1
 */