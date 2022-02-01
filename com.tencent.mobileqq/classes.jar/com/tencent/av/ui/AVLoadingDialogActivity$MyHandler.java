package com.tencent.av.ui;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.SeqUtil;
import com.tencent.mobileqq.selectmember.ResultRecord;
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
    if ((paramMessage.obj != null) && ((paramMessage.obj instanceof WeakReference)))
    {
      localObject1 = (WeakReference)paramMessage.obj;
      if (localObject1 != null)
      {
        localObject1 = ((WeakReference)localObject1).get();
        if ((localObject1 != null) && ((localObject1 instanceof AVLoadingDialogActivity)))
        {
          localObject1 = new WeakReference((AVLoadingDialogActivity)localObject1);
          break label71;
        }
      }
    }
    Object localObject1 = null;
    label71:
    int i = paramMessage.what;
    if (i != 0)
    {
      if (i != 1) {
        return;
      }
      if ((localObject1 != null) && (((WeakReference)localObject1).get() != null)) {
        ((AVLoadingDialogActivity)((WeakReference)localObject1).get()).finish();
      }
    }
    else if ((localObject1 != null) && (((WeakReference)localObject1).get() != null))
    {
      paramMessage = (Intent)((AVLoadingDialogActivity)((WeakReference)localObject1).get()).getIntent().getParcelableExtra("avactivity_intent");
      paramMessage.setExtrasClassLoader(ResultRecord.class.getClassLoader());
      long l = SeqUtil.a(paramMessage);
      Object localObject2 = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("avideo handleMessage MSG_START_AVACTIVITY, seq[");
      localStringBuilder.append(l);
      localStringBuilder.append("]");
      QLog.w((String)localObject2, 1, localStringBuilder.toString());
      try
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(this.a);
        ((StringBuilder)localObject2).append(".MSG_START_AVACTIVITY");
        AudioHelper.a(((StringBuilder)localObject2).toString(), paramMessage.getExtras());
        ((AVLoadingDialogActivity)((WeakReference)localObject1).get()).startActivity(paramMessage);
        ((AVLoadingDialogActivity)((WeakReference)localObject1).get()).overridePendingTransition(2130772220, 0);
        return;
      }
      catch (Exception paramMessage)
      {
        localObject1 = this.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("MSG_START_AVACTIVITY, Exception, seq[");
        ((StringBuilder)localObject2).append(l);
        ((StringBuilder)localObject2).append("]");
        QLog.w((String)localObject1, 1, ((StringBuilder)localObject2).toString(), paramMessage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.AVLoadingDialogActivity.MyHandler
 * JD-Core Version:    0.7.0.1
 */