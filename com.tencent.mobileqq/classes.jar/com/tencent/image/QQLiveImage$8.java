package com.tencent.image;

import com.tencent.image.api.ILog;
import com.tencent.image.api.URLDrawableDepWrap;

class QQLiveImage$8
  implements Runnable
{
  QQLiveImage$8(QQLiveImage paramQQLiveImage) {}
  
  public void run()
  {
    this.this$0.recyleFor2Background();
    ILog localILog = URLDrawable.depImp.mLog;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(QQLiveImage.TAG);
    localStringBuilder.append(this.this$0.ID);
    localILog.e(localStringBuilder.toString(), 1, "[TVK_IMediaPlayer] OnVideoOutputFrame: sIsForeground = false, try recyleFor2Background....");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.8
 * JD-Core Version:    0.7.0.1
 */