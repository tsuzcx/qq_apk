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
        localObject = (RhythmDataBean.PackedEffectPoints)paramString.next();
        if ((localObject != null) && (((RhythmDataBean.PackedEffectPoints)localObject).name != null) && (((RhythmDataBean.PackedEffectPoints)localObject).effectPoints != null) && (TextUtils.equals(((RhythmDataBean.PackedEffectPoints)localObject).name, "StartValueTrail")) && (((RhythmDataBean.PackedEffectPoints)localObject).effectPoints != null) && (!((RhythmDataBean.PackedEffectPoints)localObject).effectPoints.isEmpty()))
        {
          long l = ((TAVEffectPoint)((RhythmDataBean.PackedEffectPoints)localObject).effectPoints.get(0)).getTime();
          return l;
        }
      }
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getMusicStartTime err:");
      ((StringBuilder)localObject).append(paramString);
      Log.e("MusicConfigUtils", ((StringBuilder)localObject).toString());
    }
    return -1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.autotemplate.utils.MusicConfigUtils
 * JD-Core Version:    0.7.0.1
 */