package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_IDownloadMgr;

class FileVideoMediaPlayHelper$1
  implements Runnable
{
  FileVideoMediaPlayHelper$1(FileVideoMediaPlayHelper paramFileVideoMediaPlayHelper, int paramInt) {}
  
  public void run()
  {
    if (FileVideoMediaPlayHelper.a(this.this$0) == null) {
      return;
    }
    if (FileVideoMediaPlayHelper.b(this.this$0) > 0)
    {
      FileVideoMediaPlayHelper.a(this.this$0).setRemainTime(20160714, FileVideoMediaPlayHelper.c(this.this$0), 2147483647);
      FileVideoMediaPlayHelper.a(this.this$0).stopPreLoad(FileVideoMediaPlayHelper.b(this.this$0));
    }
    int i = FileVideoMediaPlayHelper.a(this.this$0).startPreLoadWithSavePath(20160714, this.this$0.g.c[0], FileManagerUtil.a(this.this$0.g.b), 0L, 0, this.this$0.g.b, 0);
    FileVideoMediaPlayHelper.a(this.this$0, i);
    FileVideoMediaPlayHelper.a(this.this$0).setPlayerState(20160714, i, 6);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[");
      localStringBuilder.append(this.this$0.g.k);
      localStringBuilder.append("],playid +[");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] download Block, new blockId:");
      localStringBuilder.append(FileVideoMediaPlayHelper.b(this.this$0));
      QLog.d("FileVideoMediaPlayHelper.filevideoPeek", 4, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.FileVideoMediaPlayHelper.1
 * JD-Core Version:    0.7.0.1
 */