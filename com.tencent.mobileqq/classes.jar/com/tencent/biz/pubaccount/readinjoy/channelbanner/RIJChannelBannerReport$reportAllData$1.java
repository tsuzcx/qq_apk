package com.tencent.biz.pubaccount.readinjoy.channelbanner;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import oqf;
import oqh;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "run"}, k=3, mv={1, 1, 16})
public final class RIJChannelBannerReport$reportAllData$1
  implements Runnable
{
  public RIJChannelBannerReport$reportAllData$1(oqf paramoqf, Map paramMap1, Map paramMap2, Map paramMap3, Map paramMap4) {}
  
  public final void run()
  {
    Iterator localIterator = this.a.entrySet().iterator();
    oqh localoqh;
    while (localIterator.hasNext())
    {
      localoqh = (oqh)((Map.Entry)localIterator.next()).getValue();
      oqf.a(this.this$0, "0X800B157", localoqh);
    }
    localIterator = this.b.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localoqh = (oqh)((Map.Entry)localIterator.next()).getValue();
      oqf.a(this.this$0, "0X800B158", localoqh);
    }
    localIterator = this.c.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localoqh = (oqh)((Map.Entry)localIterator.next()).getValue();
      oqf.a(this.this$0, "0X800B159", localoqh);
    }
    localIterator = this.d.entrySet().iterator();
    while (localIterator.hasNext())
    {
      localoqh = (oqh)((Map.Entry)localIterator.next()).getValue();
      oqf.a(this.this$0, "0X800B15A", localoqh);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.channelbanner.RIJChannelBannerReport.reportAllData.1
 * JD-Core Version:    0.7.0.1
 */