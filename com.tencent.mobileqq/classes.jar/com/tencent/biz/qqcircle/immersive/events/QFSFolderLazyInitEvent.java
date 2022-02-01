package com.tencent.biz.qqcircle.immersive.events;

import android.os.Handler;
import androidx.annotation.NonNull;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import com.tencent.qphone.base.util.QLog;

public class QFSFolderLazyInitEvent
  extends SimpleBaseEvent
{
  public static final int LAZY_INIT_TYPE_OWNER_PROFILE = 1;
  public static final int LAZY_INIT_TYPE_PUBLISH_PART = 2;
  long mDelayLazyInitTime;
  boolean mInMainThread;
  int mLazyInitType;
  
  public QFSFolderLazyInitEvent(int paramInt, long paramLong, boolean paramBoolean)
  {
    this.mLazyInitType = paramInt;
    this.mDelayLazyInitTime = paramLong;
    this.mInMainThread = paramBoolean;
  }
  
  private void a(@NonNull QFSFolderLazyInitEvent.ILazyInitCallback paramILazyInitCallback)
  {
    RFThreadManager.getUIHandler().postDelayed(new QFSFolderLazyInitEvent.1(this, paramILazyInitCallback), this.mDelayLazyInitTime);
  }
  
  private void b(@NonNull QFSFolderLazyInitEvent.ILazyInitCallback paramILazyInitCallback)
  {
    RFThreadManager.getSerialThreadHandler().postDelayed(new QFSFolderLazyInitEvent.2(this, paramILazyInitCallback), this.mDelayLazyInitTime);
  }
  
  public void execute(QFSFolderLazyInitEvent.ILazyInitCallback paramILazyInitCallback)
  {
    if (paramILazyInitCallback == null)
    {
      QLog.e("QFSFolderLazyInitEvent", 1, new Object[] { "execute failed,no callback!type:", Integer.valueOf(this.mLazyInitType), ",delayTime:", Long.valueOf(this.mDelayLazyInitTime) });
      return;
    }
    if (this.mInMainThread)
    {
      a(paramILazyInitCallback);
      return;
    }
    b(paramILazyInitCallback);
  }
  
  public int getLazyInitType()
  {
    return this.mLazyInitType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent
 * JD-Core Version:    0.7.0.1
 */