package com.huawei.hms.support.api.client;

import com.huawei.hms.common.api.OptionalPendingResult;
import com.huawei.hms.common.api.internal.OptionalPendingResultImpl;

public final class PendingResultsCreator
{
  public static PendingResult<Status> discardedPendingResult()
  {
    return new PendingResultsCreator.DiscardedPendingResult();
  }
  
  public static <R extends Result> PendingResult<R> discardedPendingResult(R paramR)
  {
    return new PendingResultsCreator.DiscardedPendingResult(paramR);
  }
  
  public static <R extends Result> OptionalPendingResult<R> instantPendingResult(R paramR)
  {
    return new OptionalPendingResultImpl(new PendingResultsCreator.InstantPendingResult(paramR));
  }
  
  public static PendingResult<Status> instantPendingResult(Status paramStatus)
  {
    return new PendingResultsCreator.InstantPendingResult(paramStatus);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.PendingResultsCreator
 * JD-Core Version:    0.7.0.1
 */