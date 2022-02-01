package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ShareChat$MyResultReceiver
  extends ResultReceiver
{
  private int a;
  private int b;
  private long c;
  private WeakReference<ShareChat.SharePanel> d;
  
  public ShareChat$MyResultReceiver(Handler paramHandler, ShareChat.SharePanel paramSharePanel, int paramInt1, int paramInt2, long paramLong)
  {
    super(paramHandler);
    this.d = new WeakReference(paramSharePanel);
    this.a = paramInt1;
    this.b = paramInt2;
    this.c = paramLong;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    paramBundle = (ShareChat.SharePanel)this.d.get();
    if (paramBundle == null) {
      return;
    }
    int j = this.a;
    int i = 2;
    StringBuilder localStringBuilder;
    if (j != 1)
    {
      if ((j != 2) && (j != 3))
      {
        if (j != 4)
        {
          if (j != 5) {
            return;
          }
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[");
          localStringBuilder.append(paramInt);
          localStringBuilder.append("], seq[");
          localStringBuilder.append(this.c);
          localStringBuilder.append("]");
          QLog.w("ShareChat", 1, localStringBuilder.toString());
          paramBundle.a(5, this.b, 3);
          return;
        }
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("startTroop2DCode.PARAM_QRForwardReceiver, resultCode[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("], mIHandle[");
        localStringBuilder.append(paramBundle.f);
        localStringBuilder.append("]");
        QLog.w("ShareChat", 1, localStringBuilder.toString());
        if (paramBundle.f != null)
        {
          paramBundle = paramBundle.f;
          j = this.b;
          if (paramInt != -1) {
            i = 3;
          }
          paramBundle.b(5, j, i);
        }
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("shareToMobileQQ.onReceiveResult, resultCode[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("], seq[");
        localStringBuilder.append(this.c);
        localStringBuilder.append("]");
        QLog.w("ShareChat", 1, localStringBuilder.toString());
        j = this.b;
        if (paramInt != -1) {
          i = 3;
        }
        paramBundle.a(0, j, i);
      }
    }
    else
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shareToQzone.onReceiveResult, resultCode[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("], seq[");
      localStringBuilder.append(this.c);
      localStringBuilder.append("]");
      QLog.w("ShareChat", 1, localStringBuilder.toString());
      j = this.b;
      if (paramInt != -1) {
        i = 3;
      }
      paramBundle.a(1, j, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */