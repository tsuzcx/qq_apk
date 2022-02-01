package com.tencent.mobileqq.app;

import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.search.RequestSearchWord.Rcmd;

public abstract interface UniteSearchHandler$RequestSearchWordCallback
{
  public abstract void a(PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.UniteSearchHandler.RequestSearchWordCallback
 * JD-Core Version:    0.7.0.1
 */