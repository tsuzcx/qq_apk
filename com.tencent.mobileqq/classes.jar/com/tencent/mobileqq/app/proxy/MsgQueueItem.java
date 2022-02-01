package com.tencent.mobileqq.app.proxy;

import android.content.ContentValues;
import com.tencent.mobileqq.persistence.Entity;

public class MsgQueueItem
  extends BaseQueueItem
{
  public MsgQueueItem(String paramString1, int paramInt1, String paramString2, ContentValues paramContentValues, String paramString3, String[] paramArrayOfString, int paramInt2, ProxyListener paramProxyListener)
  {
    super(paramString1, paramInt1, paramString2, paramContentValues, paramString3, paramArrayOfString, paramInt2, paramProxyListener);
  }
  
  public MsgQueueItem(String paramString1, int paramInt1, String paramString2, Entity paramEntity, int paramInt2, ProxyListener paramProxyListener)
  {
    super(paramString1, paramInt1, paramString2, paramEntity, paramInt2, paramProxyListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.MsgQueueItem
 * JD-Core Version:    0.7.0.1
 */