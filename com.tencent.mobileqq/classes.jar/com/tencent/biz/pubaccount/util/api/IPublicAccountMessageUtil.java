package com.tencent.biz.pubaccount.util.api;

import android.content.Context;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IPublicAccountMessageUtil
  extends QRouteApi
{
  public static final String ACTION_OPEN_LOCAL = "open_local";
  
  public abstract Object fromByteArray(byte[] paramArrayOfByte);
  
  public abstract Object fromXML(String paramString);
  
  public abstract boolean jumpNative(String paramString, Context paramContext);
  
  public abstract byte[] toByteArray(Object paramObject);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.api.IPublicAccountMessageUtil
 * JD-Core Version:    0.7.0.1
 */