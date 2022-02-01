package com.tencent.aelight.camera.aeeditor.view;

import android.text.TextUtils;
import android.util.LruCache;
import com.tencent.aelight.camera.log.AEQLog;
import java.util.ArrayList;

public class AEEditorMusicWaveRandomGenerator
{
  private static LruCache<String, ArrayList<Double>> a = new LruCache(10);
  private static ArrayList<Double> b;
  
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
    ArrayList localArrayList = b;
    if (localArrayList == null)
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() mRandoms == null.");
      return a();
    }
    if (paramInt == localArrayList.size())
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index == mRandoms.size().");
      d = a();
      b.add(paramInt, Double.valueOf(d));
      return d;
    }
    if (paramInt < 0)
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index < 0.");
      return a();
    }
    if (paramInt > b.size())
    {
      AEQLog.a("AEEditorMusicWaveRandomGenerator", "obtainRandomValue() index > mRandoms.size().");
      d = a();
      int i = b.size();
      while (i <= paramInt)
      {
        d = a();
        b.add(i, Double.valueOf(d));
        i += 1;
      }
    }
    double d = ((Double)b.get(paramInt)).doubleValue();
    return d;
  }
  
  static void a(String paramString1, String paramString2, int paramInt)
  {
    String str = paramString1;
    if (TextUtils.isEmpty(paramString1)) {
      str = paramString2;
    }
    if ((a != null) && (!TextUtils.isEmpty(str)) && (a.get(str) != null))
    {
      b = (ArrayList)a.get(str);
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
    paramString2 = a;
    if (paramString2 != null) {
      paramString2.put(str, paramString1);
    }
    b = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.view.AEEditorMusicWaveRandomGenerator
 * JD-Core Version:    0.7.0.1
 */