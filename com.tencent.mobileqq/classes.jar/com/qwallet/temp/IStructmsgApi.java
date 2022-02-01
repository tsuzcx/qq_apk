package com.qwallet.temp;

import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IStructmsgApi
  extends QRouteApi
{
  public abstract void handleStructMsgElement(MessageRecord paramMessageRecord);
  
  public abstract boolean instanceofMessageForStructing(Object paramObject);
  
  public abstract void notifyAdExposureCheckersDestroy();
  
  public abstract void notifyAdExposureCheckersPause();
  
  public abstract void notifyAdExposureCheckersResume();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.qwallet.temp.IStructmsgApi
 * JD-Core Version:    0.7.0.1
 */