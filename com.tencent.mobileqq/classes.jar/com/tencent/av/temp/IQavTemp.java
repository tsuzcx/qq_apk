package com.tencent.av.temp;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IQavTemp
  extends QRouteApi
{
  public abstract String getAudio3ALicenseFilename();
  
  public abstract boolean isVideoChatting(AppRuntime paramAppRuntime);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.temp.IQavTemp
 * JD-Core Version:    0.7.0.1
 */