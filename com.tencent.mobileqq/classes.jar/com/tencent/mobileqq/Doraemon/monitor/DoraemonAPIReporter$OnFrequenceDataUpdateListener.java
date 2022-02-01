package com.tencent.mobileqq.Doraemon.monitor;

import java.util.HashMap;

public abstract interface DoraemonAPIReporter$OnFrequenceDataUpdateListener
{
  public abstract void a(String paramString1, int paramInt, String paramString2, String paramString3, long paramLong1, long paramLong2);
  
  public abstract void a(String paramString, HashMap<String, APIQuotaItem> paramHashMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.Doraemon.monitor.DoraemonAPIReporter.OnFrequenceDataUpdateListener
 * JD-Core Version:    0.7.0.1
 */