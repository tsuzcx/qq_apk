package com.tencent.aekit.openrender.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.render.BuildConfig;
import java.util.ArrayList;
import java.util.List;

public class RenderMonitor
{
  private static String TAG = RenderMonitor.class.getSimpleName();
  private static List<String> dumpInfos = new ArrayList();
  private static List<String> renderChain = new ArrayList();
  
  public static void end()
  {
    int j = 0;
    if (BuildConfig.DEBUG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("render chain:\n");
      int i = 0;
      while (i < renderChain.size())
      {
        localStringBuilder.append(String.format("[%s] %s\n", new Object[] { String.valueOf(i), renderChain.get(i) }));
        i += 1;
      }
      LogUtils.i(TAG, localStringBuilder.toString());
      i = j;
      while (i < dumpInfos.size())
      {
        LogUtils.i(TAG, "renderer " + i + ":\n" + (String)dumpInfos.get(i));
        i += 1;
      }
    }
  }
  
  public static void record(String paramString1, String paramString2)
  {
    if (BuildConfig.DEBUG)
    {
      dumpInfos.add(paramString2);
      renderChain.add(paramString1);
    }
  }
  
  public static void start()
  {
    if (BuildConfig.DEBUG)
    {
      dumpInfos.clear();
      renderChain.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.RenderMonitor
 * JD-Core Version:    0.7.0.1
 */