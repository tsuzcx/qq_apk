package com.huawei.hms.support.api.client;

public abstract class ConvertedResult<R extends Result>
{
  public abstract <S extends Result> ConvertedResult<S> convertResult(ResultConvert<? super R, ? extends S> paramResultConvert);
  
  public abstract void finalExec(ResultCallbacks<? super R> paramResultCallbacks);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.hms.support.api.client.ConvertedResult
 * JD-Core Version:    0.7.0.1
 */