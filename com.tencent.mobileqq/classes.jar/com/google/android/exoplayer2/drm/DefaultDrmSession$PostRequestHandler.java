package com.google.android.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

@SuppressLint({"HandlerLeak"})
class DefaultDrmSession$PostRequestHandler
  extends Handler
{
  public DefaultDrmSession$PostRequestHandler(DefaultDrmSession paramDefaultDrmSession, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  private long getRetryDelayMillis(int paramInt)
  {
    return Math.min((paramInt - 1) * 1000, 5000);
  }
  
  private boolean maybeRetryRequest(Message paramMessage)
  {
    if (paramMessage.arg1 == 1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0) {
      return false;
    }
    int i = paramMessage.arg2 + 1;
    if (i > DefaultDrmSession.access$300(this.this$0)) {
      return false;
    }
    paramMessage = Message.obtain(paramMessage);
    paramMessage.arg2 = i;
    sendMessageDelayed(paramMessage, getRetryDelayMillis(i));
    return true;
  }
  
  public void handleMessage(Message paramMessage)
  {
    try
    {
      int i = paramMessage.what;
      byte[] arrayOfByte;
      if (i != 0)
      {
        if (i == 1) {
          arrayOfByte = this.this$0.callback.executeKeyRequest(this.this$0.uuid, (ExoMediaDrm.KeyRequest)paramMessage.obj);
        } else {
          throw new RuntimeException();
        }
      }
      else {
        arrayOfByte = this.this$0.callback.executeProvisionRequest(this.this$0.uuid, (ExoMediaDrm.ProvisionRequest)paramMessage.obj);
      }
    }
    catch (Exception localException)
    {
      if (maybeRetryRequest(paramMessage)) {
        return;
      }
    }
    this.this$0.postResponseHandler.obtainMessage(paramMessage.what, localException).sendToTarget();
  }
  
  Message obtainMessage(int paramInt, Object paramObject, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.exoplayer2.drm.DefaultDrmSession.PostRequestHandler
 * JD-Core Version:    0.7.0.1
 */