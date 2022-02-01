package com.tencent.aelight.camera.qqstory.api;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPeakIpcController
  extends QRouteApi
{
  public abstract void report(String paramString1, String paramString2);
  
  public abstract void report(String paramString1, String paramString2, String paramString3, long paramLong, String paramString4);
  
  public abstract void updatePeakVideoAndPicStatus(MessageRecord paramMessageRecord, int paramInt1, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.qqstory.api.IPeakIpcController
 * JD-Core Version:    0.7.0.1
 */