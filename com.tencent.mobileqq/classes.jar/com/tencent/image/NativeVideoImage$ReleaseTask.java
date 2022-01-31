package com.tencent.image;

import com.tencent.qphone.base.util.QLog;
import com.tencent.video.decode.AbstractAVDecode;

class NativeVideoImage$ReleaseTask
  implements Runnable
{
  AbstractAVDecode mDecoder;
  
  public NativeVideoImage$ReleaseTask(AbstractAVDecode paramAbstractAVDecode)
  {
    this.mDecoder = paramAbstractAVDecode;
  }
  
  public void run()
  {
    if (this.mDecoder != null) {}
    try
    {
      this.mDecoder.close();
      this.mDecoder = null;
      if (QLog.isColorLevel()) {
        QLog.d(NativeVideoImage.TAG, 2, "..ReleaseTask close AVDecode..");
      }
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.NativeVideoImage.ReleaseTask
 * JD-Core Version:    0.7.0.1
 */