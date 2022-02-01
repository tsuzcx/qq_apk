package com.tencent.mobileqq.app;

import android.os.Handler;
import android.os.Message;

public class QWalletObserver
  implements BusinessObserver
{
  private Handler a;
  
  public QWalletObserver(Handler paramHandler)
  {
    this.a = paramHandler;
  }
  
  public void a()
  {
    this.a = null;
  }
  
  public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
  {
    int i = 1;
    if (this.a == null) {}
    while ((paramInt != 1) && (paramInt != 0)) {
      return;
    }
    Handler localHandler = this.a;
    if (paramBoolean) {}
    for (;;)
    {
      localHandler.obtainMessage(paramInt, i, 0, paramObject).sendToTarget();
      return;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.QWalletObserver
 * JD-Core Version:    0.7.0.1
 */