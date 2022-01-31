package com.tencent.mobileqq.ar.arengine;

import amzf;
import android.os.Build;
import azmz;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;

public class ARReport$1
  implements Runnable
{
  public void run()
  {
    HashMap localHashMap = new HashMap();
    if (amzf.a(this.this$0, this.a)) {
      localHashMap.put("total_render_all_time", String.valueOf(this.a));
    }
    if (amzf.a(this.this$0, this.b)) {
      localHashMap.put("total_render_success_time", String.valueOf(this.b));
    }
    localHashMap.put("buildmodel", Build.MODEL);
    localHashMap.put("cpuNumber", String.valueOf(amzf.a()));
    localHashMap.put("totalram", amzf.a(BaseApplication.getContext()));
    localHashMap.put("cpuname", this.this$0.a());
    azmz.a(BaseApplication.getContext()).a("", "AndroidactARTotal", true, this.a, 0L, localHashMap, "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARReport.1
 * JD-Core Version:    0.7.0.1
 */