package com.tencent.comic.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQQComicSoHelper
  extends QRouteApi
{
  public abstract String getComicPlayerSoPath();
  
  public abstract String getComicPlayerSoZipPath();
  
  public abstract void onSoDownloadCompleted(AppRuntime paramAppRuntime, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.comic.api.IQQComicSoHelper
 * JD-Core Version:    0.7.0.1
 */