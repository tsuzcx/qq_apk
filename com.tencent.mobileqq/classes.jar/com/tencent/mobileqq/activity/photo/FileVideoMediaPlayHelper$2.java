package com.tencent.mobileqq.activity.photo;

import ajob;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

public class FileVideoMediaPlayHelper$2
  implements Runnable
{
  public FileVideoMediaPlayHelper$2(ajob paramajob) {}
  
  public void run()
  {
    if (ajob.a(this.this$0) != null) {
      ajob.a(this.this$0).stopPreLoad(ajob.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.2
 * JD-Core Version:    0.7.0.1
 */