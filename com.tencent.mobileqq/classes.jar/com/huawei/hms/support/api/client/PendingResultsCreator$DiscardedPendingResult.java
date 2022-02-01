package com.huawei.hms.support.api.client;

public class PendingResultsCreator$DiscardedPendingResult<R extends Result>
  extends EmptyPendingResult
{
  public PendingResultsCreator$DiscardedPendingResult() {}
  
  public PendingResultsCreator$DiscardedPendingResult(R paramR)
  {
    setResult(paramR);
  }
  
  public boolean isCanceled()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.PendingResultsCreator.DiscardedPendingResult
 * JD-Core Version:    0.7.0.1
 */