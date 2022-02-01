package com.tencent.aelight.camera.aeeditor.view;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

public class AEEditorMusicWaveRandomGenerator
{
  private static LruCache<String, ArrayList<Double>> jdField_a_of_type_AndroidUtilLruCache = new LruCache(10);
  private static ArrayList<Double> jdField_a_of_type_JavaUtilArrayList;
  
  private static double a()
  {
    double d2 = Math.random();
    double d1 = d2;
    if (d2 < 0.1D) {
      d1 = d2 + 0.1000000014901161D;
    }
    return d1;
  }
  
  static double a(int paramInt)
  {
    ArrayList localArrayList = jdField_a_of_type_JavaUtilArrayList;
    if (localArrayList == null)
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() mRandoms == null.");
      return a();
    }
    if (paramInt == localArrayList.size())
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index == mRandoms.size().");
      d = a();
      jdField_a_of_type_JavaUtilArrayList.add(paramInt, Double.valueOf(d));
      return d;
    }
    if (paramInt < 0)
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index < 0.");
      return a();
    }
    if (paramInt > jdField_a_of_type_JavaUtilArrayList.size())
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index > mRandoms.size().");
      d = a();
      int i = jdField_a_of_type_JavaUtilArrayList.size();
      while (i <= paramInt)
      {
        d = a();
        jdField_a_of_type_JavaUtilArrayList.add(i, Double.valueOf(d));
        i += 1;
      }
    }
    double d = ((Double)jdField_a_of_type_JavaUtilArrayList.get(paramInt)).doubleValue();
    return d;
  }
  
  static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if ((jdField_a_of_type_AndroidUtilLruCache != null) && (!TextUtils.isEmpty(str)) && (jdField_a_of_type_AndroidUtilLruCache.get(str) != null))
    {
      jdField_a_of_type_JavaUtilArrayList = (ArrayList)jdField_a_of_type_AndroidUtilLruCache.get(str);
      return;
    }
    int i = Math.min(paramInt, 10000);
    paramString1 = new ArrayList();
    paramInt = 0;
    while (paramInt < i)
    {
      paramString1.add(Double.valueOf(a()));
      paramInt += 1;
    }
    paramString2 = jdField_a_of_type_AndroidUtilLruCache;
    if (paramString2 != null) {
      paramString2.put(str, paramString1);
    }
    jdField_a_of_type_JavaUtilArrayList = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveRandomGenerator
 * JD-Core Version:    0.7.0.1
 */