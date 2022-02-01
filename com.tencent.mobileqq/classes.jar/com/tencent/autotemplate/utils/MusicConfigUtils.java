package com.tencent.autotemplate.utils;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.autotemplate.model.rhythm.TAVEffectPoint;
import com.tencent.autotemplate.parse.RhythmDataBean;
import com.tencent.autotemplate.parse.RhythmDataBean.PackedEffectPoints;
import java.util.Iterator;
import java.util.List;

public class MusicConfigUtils
{
  public static long getMusicStartTime(String paramString)
  {
    try
    {
      paramString = JsonUtils.parseRhythmTemplate(null, paramString).allData.iterator();
      while (paramString.hasNext())
      {
        RhythmDataBean.PackedEffectPoints localPackedEffectPoints = (RhythmDataBean.PackedEffectPoints)paramString.next();
        if ((localPackedEffectPoints != null) && (localPackedEffectPoints.name != null) && (localPackedEffectPoints.effectPoints != null) && (TextUtils.equals(localPackedEffectPoints.name, "StartValueTrail")) && (localPackedEffectPoints.effectPoints != null) && (!localPackedEffectPoints.effectPoints.isEmpty()))
        {
          long l = ((TAVEffectPoint)localPackedEffectPoints.effectPoints.get(0)).getTime();
          return l;
        }
      }
    }
    catch (Exception paramString)
    {
      Log.e("MusicConfigUtils", "getMusicStartTime err:" + paramString);
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.MusicConfigUtils
 * JD-Core Version:    0.7.0.1
 */