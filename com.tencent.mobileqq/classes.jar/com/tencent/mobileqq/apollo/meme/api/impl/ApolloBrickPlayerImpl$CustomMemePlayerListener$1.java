package com.tencent.mobileqq.apollo.meme.api.impl;

import com.tencent.mobileqq.apollo.meme.FrameData;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

class ApolloBrickPlayerImpl$CustomMemePlayerListener$1
  implements Runnable
{
  ApolloBrickPlayerImpl$CustomMemePlayerListener$1(ApolloBrickPlayerImpl.CustomMemePlayerListener paramCustomMemePlayerListener, byte[] paramArrayOfByte, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, MemeAction paramMemeAction) {}
  
  public void run()
  {
    try
    {
      byte[] arrayOfByte = (byte[])this.a.clone();
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("[cmshow]ApolloBrickPlayer", 1, "onRecordFrame error:", localOutOfMemoryError);
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    if ((!ApolloBrickPlayerImpl.access$1200().containsKey(this.b)) || (((FrameData)ApolloBrickPlayerImpl.access$1200().get(this.b)).d() < this.c)) {
      ApolloBrickPlayerImpl.access$1200().put(this.b, new FrameData(this.c, (byte[])localObject, this.d, this.e, this.f));
    }
    Object localObject = new ApolloBrickPlayerImpl.CustomMemePlayerListener.1.1(this, (byte[])localObject);
    ApolloBrickPlayerImpl.CustomMemePlayerListener.a(this.this$0, (Runnable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.meme.api.impl.ApolloBrickPlayerImpl.CustomMemePlayerListener.1
 * JD-Core Version:    0.7.0.1
 */