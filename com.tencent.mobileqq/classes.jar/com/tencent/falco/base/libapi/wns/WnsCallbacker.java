package com.tencent.falco.base.libapi.wns;

import android.util.Log;
import java.util.concurrent.atomic.AtomicLong;

public abstract class WnsCallbacker
  implements WnsSendCallback
{
  private static AtomicLong atomicLong = new AtomicLong(0L);
  private final long msgID = genMsgID();
  
  public WnsCallbacker()
  {
    Log.d("WnsCallbacker", "msgID=" + this.msgID);
  }
  
  private static long genMsgID()
  {
    return System.currentTimeMillis() + atomicLong.getAndAdd(1L);
  }
  
  public long getMsgID()
  {
    return this.msgID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.falco.base.libapi.wns.WnsCallbacker
 * JD-Core Version:    0.7.0.1
 */