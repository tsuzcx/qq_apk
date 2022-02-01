package com.tencent.aelight.camera.aeeditor.module.edit.multi.data;

import android.support.annotation.NonNull;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.CutModelKt;
import com.tencent.qcircle.weseevideo.camera.mvauto.redo.VideoResourceModelKt;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SpeedFloatUtil
{
  private static final Map<Float, String> a = new HashMap();
  
  static
  {
    a.put(Float.valueOf(0.5F), "0.5");
    a.put(Float.valueOf(0.75F), "0.75");
    a.put(Float.valueOf(1.0F), "1.0");
    a.put(Float.valueOf(1.5F), "1.5");
    a.put(Float.valueOf(2.0F), "2.0");
  }
  
  private static String a(float paramFloat)
  {
    Iterator localIterator = a.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if ((localEntry != null) && (a(paramFloat, ((Float)localEntry.getKey()).floatValue()))) {
        return (String)localEntry.getValue();
      }
    }
    return "none";
  }
  
  public static String a(@NonNull List<CutModelKt> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      CutModelKt localCutModelKt = (CutModelKt)paramList.get(i);
      if ((localCutModelKt != null) && (localCutModelKt.getResource() != null))
      {
        localStringBuilder.append(a(localCutModelKt.getResource().getScaleSpeed()));
        if (i != paramList.size() - 1) {
          localStringBuilder.append(",");
        }
      }
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static boolean a(float paramFloat1, float paramFloat2)
  {
    return Math.abs(paramFloat1 - paramFloat2) < 0.001D;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aeeditor.module.edit.multi.data.SpeedFloatUtil
 * JD-Core Version:    0.7.0.1
 */