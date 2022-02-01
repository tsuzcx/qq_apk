package com.tencent.mobileqq.ar;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import bhhr;
import com.tencent.mobileqq.mqsafeedit.BaseApplication;
import com.tencent.mobileqq.statistics.StatisticCollector;
import java.util.HashMap;

public final class ArNativeSoLoader$1
  implements Runnable
{
  public ArNativeSoLoader$1(String paramString, byte paramByte, SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("param_soLoaderName", this.jdField_a_of_type_JavaLangString);
    ((HashMap)localObject).put("param_FailCode", String.valueOf(this.jdField_a_of_type_Byte));
    StatisticCollector localStatisticCollector = StatisticCollector.getInstance(BaseApplication.getContext());
    if (this.jdField_a_of_type_Byte == 0) {}
    for (boolean bool = true;; bool = false)
    {
      localStatisticCollector.collectPerformance(null, "AREnable", bool, 0L, 0L, (HashMap)localObject, null);
      localObject = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
      ((SharedPreferences.Editor)localObject).putInt("ar_native_so_load_result" + this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Byte);
      bhhr.a((SharedPreferences.Editor)localObject);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ArNativeSoLoader.1
 * JD-Core Version:    0.7.0.1
 */