package com.tencent.mm.vfs;

import java.util.Map;

public abstract interface StatisticsCallback
{
  public static final int PHASE_MAINTENANCE = 2;
  public static final int PHASE_MAINTENANCE_BEGIN = 1;
  public static final int PHASE_MAINTENANCE_CANCELLED = 4;
  public static final int PHASE_MAINTENANCE_END = 3;
  public static final int PHASE_MAINTENANCE_FAILURE = 5;
  public static final int PHASE_MAINTENANCE_FAST = 7;
  public static final int PHASE_MAINTENANCE_SKIPPED = 6;
  
  public abstract void deleteFiles(CancellationSignalCompat paramCancellationSignalCompat);
  
  public abstract void reportError(Throwable paramThrowable);
  
  public abstract void statistics(String paramString, int paramInt, Map<String, Object> paramMap);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mm.vfs.StatisticsCallback
 * JD-Core Version:    0.7.0.1
 */