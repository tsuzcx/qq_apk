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
    URLDrawable.depImp.mLog.e(QQLiveImage.TAG + this.this$0.ID, 1, "[TVK_IMediaPlayer] OnVideoOutputFrame: sIsForeground = false, try recyleFor2Background....");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.image.QQLiveImage.8
 * JD-Core Version:    0.7.0.1
 */