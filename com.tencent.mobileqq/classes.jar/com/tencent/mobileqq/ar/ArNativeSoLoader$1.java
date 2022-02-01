package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.SharedPreUtils;
import java.util.HashMap;

final class ArNativeSoLoader$1
  implements Runnable
{
  ArNativeSoLoader$1(String paramString, byte paramByte, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    Object localObject1 = new HashMap();
    ((HashMap)localObject1).put("param_soLoaderName", this.a);
    ((HashMap)localObject1).put("param_FailCode", String.valueOf(this.b));
    Object localObject2 = StatisticCollector.getInstance(BaseApplication.getContext());
    boolean bool;
    if (this.b == 0) {
      bool = true;
    } else {
      bool = false;
    }
    ((StatisticCollector)localObject2).collectPerformance(null, "AREnable", bool, 0L, 0L, (HashMap)localObject1, null);
    localObject1 = this.c.edit();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("ar_native_so_load_result");
    ((StringBuilder)localObject2).append(this.a);
    ((SharedPreferences.Editor)localObject1).putInt(((StringBuilder)localObject2).toString(), this.b);
    SharedPreUtils.a((SharedPreferences.Editor)localObject1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */