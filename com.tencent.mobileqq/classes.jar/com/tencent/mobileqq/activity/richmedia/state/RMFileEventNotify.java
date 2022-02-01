package com.tencent.mobileqq.activity.richmedia.state;

import android.os.FileObserver;
import com.tencent.qphone.base.util.QLog;

class RMFileEventNotify
  extends FileObserver
{
  private boolean a;
  
  private void a()
  {
    if (!this.a)
    {
      this.a = true;
      RMVideoStateMgr.a().a(new RMFileEventNotify.1(this));
    }
  }
  
  public void onEvent(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder;
    if ((paramInt & 0x20) == 32)
    {
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("RMFileEventNotify[onEvent][OPEN]  path=");
        localStringBuilder.append(paramString);
        QLog.d("RMFileEventNotify", 2, localStringBuilder.toString());
      }
    }
    else
    {
      if ((paramInt & 0x400) == 1024)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("RMFileEventNotify[onEvent][DELETE_SELF]  path=");
          localStringBuilder.append(paramString);
          QLog.d("RMFileEventNotify", 2, localStringBuilder.toString());
        }
        a();
        return;
      }
      if ((paramInt & 0x200) == 512)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("RMFileEventNotify[onEvent][DELETE]  path=");
          localStringBuilder.append(paramString);
          QLog.d("RMFileEventNotify", 2, localStringBuilder.toString());
        }
        a();
        return;
      }
      if ((paramInt & 0x8) == 8)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("RMFileEventNotify[onEvent][CLOSE_WRITE]  path=");
          localStringBuilder.append(paramString);
          QLog.d("RMFileEventNotify", 2, localStringBuilder.toString());
        }
        a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMFileEventNotify
 * JD-Core Version:    0.7.0.1
 */