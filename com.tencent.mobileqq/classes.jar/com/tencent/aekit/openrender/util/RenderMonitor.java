package com.tencent.aekit.openrender.util;

import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.render.BuildConfig;
import java.util.ArrayList;
import java.util.List;

public class RenderMonitor
{
  private static String TAG = "RenderMonitor";
  private static List<String> dumpInfos = new ArrayList();
  private static List<String> renderChain = new ArrayList();
  
  public static void end()
  {
    if (BuildConfig.DEBUG)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("render chain:\n");
      int j = 0;
      int i = 0;
      while (i < renderChain.size())
      {
        ((StringBuilder)localObject).append(String.format("[%s] %s\n", new Object[] { String.valueOf(i), renderChain.get(i) }));
        i += 1;
      }
      LogUtils.i(TAG, ((StringBuilder)localObject).toString());
      i = j;
      while (i < dumpInfos.size())
      {
        localObject = TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("renderer ");
        localStringBuilder.append(i);
        localStringBuilder.append(":\n");
        localStringBuilder.append((String)dumpInfos.get(i));
        LogUtils.i((String)localObject, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.RenderMonitor
 * JD-Core Version:    0.7.0.1
 */