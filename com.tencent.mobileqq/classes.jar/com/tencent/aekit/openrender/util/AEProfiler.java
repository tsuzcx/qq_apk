package com.tencent.aekit.openrender.util;

import com.tencent.ttpic.baseutils.fps.BenchUtil;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class AEProfiler
  extends AEProfilerBase
{
  private static final String TAG = "AEProfilerInstance";
  public static final int TYPE_DETECT = 1;
  public static final int TYPE_FILTER = 2;
  public static final int TYPE_PROCESS = 0;
  private static final AEProfiler ourInstance = new AEProfiler();
  private HashMap<String, Long> detectTimeCostMap = new HashMap();
  private HashMap<String, Long> filterTimeCostMap = new HashMap();
  private boolean isEnable = false;
  private HashMap<String, Long> processTimeCostMap = new HashMap();
  
  public static AEProfiler getInstance()
  {
    return ourInstance;
  }
  
  public void add(int paramInt, String paramString, long paramLong)
  {
    if (!this.isEnable) {
      return;
    }
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          return;
        }
        this.filterTimeCostMap.put(paramString, Long.valueOf(paramLong));
        return;
      }
      this.detectTimeCostMap.put(paramString, Long.valueOf(paramLong));
      return;
    }
    this.processTimeCostMap.put(paramString, Long.valueOf(paramLong));
  }
  
  public long end(String paramString)
  {
    return end(paramString, false);
  }
  
  public long end(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BenchUtil.SHOWPREVIEW_BENCH_TAG);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      return BenchUtil.benchEnd(localStringBuilder.toString());
    }
    return BenchUtil.benchEnd(paramString);
  }
  
  public long endByTag(String paramString)
  {
    super.endByTag(paramString);
    long l = end(paramString);
    add(0, paramString, l);
    return l;
  }
  
  public String print()
  {
    if (!this.isEnable) {
      return "{}";
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("{");
    if (this.mOneFrameCost != 0L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"OneFrameCost\": ");
      ((StringBuilder)localObject).append(this.mOneFrameCost);
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    if (this.processTimeCostMap.get("IAEProfiler-drawFrame") != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"DrawFrame\": ");
      ((StringBuilder)localObject).append(this.processTimeCostMap.get("IAEProfiler-drawFrame"));
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    if (this.processTimeCostMap.get("IAEProfiler-initFilters") != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"initFilters\": ");
      ((StringBuilder)localObject).append(this.processTimeCostMap.get("IAEProfiler-initFilters"));
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    if (this.processTimeCostMap.get("IAEProfiler-configFilters") != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"configFilters\": ");
      ((StringBuilder)localObject).append(this.processTimeCostMap.get("IAEProfiler-configFilters"));
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    if (this.processTimeCostMap.get("IAEProfiler-chainFilters") != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"chainFilters\": ");
      ((StringBuilder)localObject).append(this.processTimeCostMap.get("IAEProfiler-chainFilters"));
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    if (this.processTimeCostMap.get("IAEProfiler-detectFrame") != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("\"detectFrame\": ");
      ((StringBuilder)localObject).append(this.processTimeCostMap.get("IAEProfiler-detectFrame"));
      ((StringBuilder)localObject).append(", ");
      localStringBuilder1.append(((StringBuilder)localObject).toString());
    }
    Object localObject = this.filterTimeCostMap.entrySet().iterator();
    Map.Entry localEntry;
    StringBuilder localStringBuilder2;
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\"");
      localStringBuilder2.append((String)localEntry.getKey());
      localStringBuilder2.append("\": ");
      localStringBuilder2.append(localEntry.getValue());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localObject = this.detectTimeCostMap.entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      localEntry = (Map.Entry)((Iterator)localObject).next();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("\"");
      localStringBuilder2.append((String)localEntry.getKey());
      localStringBuilder2.append("\": ");
      localStringBuilder2.append(localEntry.getValue());
      localStringBuilder2.append(", ");
      localStringBuilder1.append(localStringBuilder2.toString());
    }
    localStringBuilder1.delete(localStringBuilder1.length() - 2, localStringBuilder1.length());
    localStringBuilder1.append("}");
    LogUtils.d("AEProfilerInstance", localStringBuilder1.toString());
    return localStringBuilder1.toString();
  }
  
  public void reset()
  {
    super.reset();
    long l;
    if (this.processTimeCostMap.get("IAEProfiler-initFilters") != null) {
      l = ((Long)this.processTimeCostMap.get("IAEProfiler-initFilters")).longValue();
    } else {
      l = 0L;
    }
    this.filterTimeCostMap.clear();
    this.detectTimeCostMap.clear();
    this.processTimeCostMap.clear();
    this.processTimeCostMap.put("IAEProfiler-initFilters", Long.valueOf(l));
  }
  
  public void setEnable(boolean paramBoolean)
  {
    this.isEnable = paramBoolean;
    BenchUtil.ENABLE_LOG = paramBoolean;
    this.mEnableBase = paramBoolean;
  }
  
  public void setEnableGLFinish(boolean paramBoolean)
  {
    BenchUtil.ENABLE_PERFORMANCE_RECORD = paramBoolean;
  }
  
  public void start(String paramString)
  {
    start(paramString, false);
  }
  
  public void start(String paramString, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(BenchUtil.SHOWPREVIEW_BENCH_TAG);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      BenchUtil.benchStart(localStringBuilder.toString());
      return;
    }
    BenchUtil.benchStart(paramString);
  }
  
  public void startByTag(String paramString)
  {
    super.startByTag(paramString);
    start(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aekit.openrender.util.AEProfiler
 * JD-Core Version:    0.7.0.1
 */