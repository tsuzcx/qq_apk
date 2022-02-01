package com.huawei.hms.common.api;

import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.client.Result;

@Deprecated
public abstract class OptionalPendingResult<R extends Result>
  extends PendingResult<R>
{
  public abstract R get();
  
  public abstract boolean isDone();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.common.api.OptionalPendingResult
 * JD-Core Version:    0.7.0.1
 */