package com.tencent.biz.qqcircle.immersive.events;

import com.tencent.qphone.base.util.QLog;

class QFSFolderLazyInitEvent$1
  implements Runnable
{
  QFSFolderLazyInitEvent$1(QFSFolderLazyInitEvent paramQFSFolderLazyInitEvent, QFSFolderLazyInitEvent.ILazyInitCallback paramILazyInitCallback) {}
  
  public void run()
  {
    this.a.a();
    QLog.d("QFSFolderLazyInitEvent", 1, new Object[] { "executeInMain,type:", Integer.valueOf(this.this$0.mLazyInitType) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent.1
 * JD-Core Version:    0.7.0.1
 */