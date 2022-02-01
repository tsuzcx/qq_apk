package com.tencent.mobileqq.activity.photo;

import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class FileVideoMediaPlayHelper$2
  implements Runnable
{
  FileVideoMediaPlayHelper$2(FileVideoMediaPlayHelper paramFileVideoMediaPlayHelper) {}
  
  public void run()
  {
    if (FileVideoMediaPlayHelper.a(this.this$0) != null) {
      FileVideoMediaPlayHelper.a(this.this$0).stopPreLoad(FileVideoMediaPlayHelper.b(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.2
 * JD-Core Version:    0.7.0.1
 */