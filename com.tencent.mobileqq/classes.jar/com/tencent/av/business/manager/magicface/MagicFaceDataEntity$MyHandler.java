package com.tencent.av.business.manager.magicface;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.av.AVLog;

class MagicFaceDataEntity$MyHandler
  extends Handler
{
  MagicFaceDataEntity$MyHandler(MagicFaceDataEntity paramMagicFaceDataEntity, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MagicFaceDataEntity handleMessage A: ");
    localStringBuilder.append(this.a.a);
    localStringBuilder.append("|");
    localStringBuilder.append(paramMessage.what);
    AVLog.printColorLog("MagicFaceDataEntity", localStringBuilder.toString());
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          if (this.a.a == 1)
          {
            paramMessage = (Integer)paramMessage.obj;
            this.a.a(paramMessage.intValue());
          }
        }
        else if (this.a.a == 1)
        {
          paramMessage = this.a;
          paramMessage.a = 0;
          paramMessage.d();
        }
      }
      else if (this.a.a == 0)
      {
        paramMessage = this.a;
        paramMessage.a = 1;
        paramMessage.c();
      }
    }
    else if (this.a.a == 1) {
      MagicFaceDataEntity.a(this.a, (Object[])paramMessage.obj);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.business.manager.magicface.MagicFaceDataEntity.MyHandler
 * JD-Core Version:    0.7.0.1
 */