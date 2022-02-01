package com.huawei.hms.support.api.client;

public class PendingResultsCreator$InstantPendingResult<R extends Result>
  extends EmptyPendingResult
{
  public PendingResultsCreator$InstantPendingResult(R paramR)
  {
    setResult(paramR);
  }
  
  public void cancel()
  {
    throw new IllegalStateException("cancel() is not available.");
  }
  
  public void setResultCallback(ResultCallback paramResultCallback)
  {
    paramResultCallback.onResult(getResult());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.PendingResultsCreator.InstantPendingResult
 * JD-Core Version:    0.7.0.1
 */