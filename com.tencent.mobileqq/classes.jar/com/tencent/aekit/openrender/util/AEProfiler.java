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
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      this.processTimeCostMap.put(paramString, Long.valueOf(paramLong));
      return;
    case 2: 
      this.filterTimeCostMap.put(paramString, Long.valueOf(paramLong));
      return;
    }
    this.detectTimeCostMap.put(paramString, Long.valueOf(paramLong));
  }
  
  public long end(String paramString)
  {
    return end(paramString, false);
  }
  
  public long end(String paramString, boolean paramBoolean)
  {
    if (paramBoolean) {
      return BenchUtil.benchEnd(BenchUtil.SHOWPREVIEW_BENCH_TAG + " " + paramString);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    if (this.mOneFrameCost != 0L) {
      localStringBuilder.append("\"OneFrameCost\": " + this.mOneFrameCost + ", ");
    }
    if (this.processTimeCostMap.get("IAEProfiler-drawFrame") != null) {
      localStringBuilder.append("\"DrawFrame\": " + this.processTimeCostMap.get("IAEProfiler-drawFrame") + ", ");
    }
    if (this.processTimeCostMap.get("IAEProfiler-initFilters") != null) {
      localStringBuilder.append("\"initFilters\": " + this.processTimeCostMap.get("IAEProfiler-initFilters") + ", ");
    }
    if (this.processTimeCostMap.get("IAEProfiler-configFilters") != null) {
      localStringBuilder.append("\"configFilters\": " + this.processTimeCostMap.get("IAEProfiler-configFilters") + ", ");
    }
    if (this.processTimeCostMap.get("IAEProfiler-chainFilters") != null) {
      localStringBuilder.append("\"chainFilters\": " + this.processTimeCostMap.get("IAEProfiler-chainFilters") + ", ");
    }
    if (this.processTimeCostMap.get("IAEProfiler-detectFrame") != null) {
      localStringBuilder.append("\"detectFrame\": " + this.processTimeCostMap.get("IAEProfiler-detectFrame") + ", ");
    }
    Iterator localIterator = this.filterTimeCostMap.entrySet().iterator();
    Map.Entry localEntry;
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\"" + (String)localEntry.getKey() + "\": " + localEntry.getValue() + ", ");
    }
    localIterator = this.detectTimeCostMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localEntry = (Map.Entry)localIterator.next();
      localStringBuilder.append("\"" + (String)localEntry.getKey() + "\": " + localEntry.getValue() + ", ");
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    localStringBuilder.append("}");
    LogUtils.d("AEProfilerInstance", localStringBuilder.toString());
    return localStringBuilder.toString();
  }
  
  public void reset()
  {
    super.reset();
    long l = 0L;
    if (this.processTimeCostMap.get("IAEProfiler-initFilters") != null) {
      l = ((Long)this.processTimeCostMap.get("IAEProfiler-initFilters")).longValue();
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
      BenchUtil.benchStart(BenchUtil.SHOWPREVIEW_BENCH_TAG + " " + paramString);
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