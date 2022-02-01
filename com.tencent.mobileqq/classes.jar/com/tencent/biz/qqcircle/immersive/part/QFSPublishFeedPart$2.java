package com.tencent.biz.qqcircle.immersive.part;

import com.tencent.biz.qqcircle.immersive.events.QFSFolderLazyInitEvent.ILazyInitCallback;
import com.tencent.qphone.base.util.QLog;

class QFSPublishFeedPart$2
  implements QFSFolderLazyInitEvent.ILazyInitCallback
{
  QFSPublishFeedPart$2(QFSPublishFeedPart paramQFSPublishFeedPart) {}
  
  public void a()
  {
    try
    {
      if (QLog.isDevelopLevel()) {
        QLog.d("[Performance2]QFSPublishFeedPart", 1, "callLazyInit preloadCameraRes");
      }
      QFSPublishFeedPart.b(this.a);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QFSPublishFeedPart", 1, new Object[] { "callLazyInit failed,exception:", localException.toString() });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.part.QFSPublishFeedPart.2
 * JD-Core Version:    0.7.0.1
 */