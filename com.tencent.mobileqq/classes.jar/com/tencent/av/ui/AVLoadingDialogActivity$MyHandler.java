package com.tencent.av.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class AVLoadingDialogActivity$MyHandler
  extends Handler
{
  final String a;
  
  AVLoadingDialogActivity$MyHandler(String paramString)
  {
    this.a = paramString;
  }
  
  public void handleMessage(Message paramMessage)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramMessage.obj != null)
    {
      localObject1 = localObject2;
      if ((paramMessage.obj instanceof WeakReference))
      {
        Object localObject3 = (WeakReference)paramMessage.obj;
        localObject1 = localObject2;
        if (localObject3 != null)
        {
          localObject3 = ((WeakReference)localObject3).get();
          localObject1 = localObject2;
          if (localObject3 != null)
          {
            localObject1 = localObject2;
            if ((localObject3 instanceof AVLoadingDialogActivity)) {
              localObject1 = (AVLoadingDialogActivity)localObject3;
            }
          }
        }
      }
    }
    switch (paramMessage.what)
    {
    }
    do
    {
      do
      {
        return;
      } while (localObject1 == null);
      QLog.d(this.a, 1, "avideo handleMessage MSG_START_AVACTIVITY");
      paramMessage = (Intent)((AVLoadingDialogActivity)localObject1).getIntent().getParcelableExtra("avactivity_intent");
      AudioHelper.a(this.a + ".MSG_START_AVACTIVITY", paramMessage.getExtras());
      ((AVLoadingDialogActivity)localObject1).startActivity(paramMessage);
      ((AVLoadingDialogActivity)localObject1).overridePendingTransition(2131034270, 0);
      return;
    } while (localObject1 == null);
    ((AVLoadingDialogActivity)localObject1).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity.MyHandler
 * JD-Core Version:    0.7.0.1
 */