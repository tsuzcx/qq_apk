package com.tencent.mobileqq.activity.aio.item;

import android.os.Bundle;
import com.tencent.biz.qqstory.view.widget.AutoStartProgressBar;
import com.tencent.mobileqq.data.MessageForTribeShortVideo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class TribeShortVideoItemBuilder$4
  extends DownloadListener
{
  TribeShortVideoItemBuilder$4(TribeShortVideoItemBuilder paramTribeShortVideoItemBuilder, TribeShortVideoItemBuilder.TribeShortVideoMsgHolder paramTribeShortVideoMsgHolder, MessageForTribeShortVideo paramMessageForTribeShortVideo) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    String str = paramDownloadTask.b().getString("filePath");
    if (paramDownloadTask.c == 0)
    {
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("download video success! videoFile:");
        paramDownloadTask.append(str);
        QLog.w("TribeShortVideoItemBuilder", 2, paramDownloadTask.toString());
      }
      paramDownloadTask = this.a;
      paramDownloadTask.s = true;
      paramDownloadTask.c.b();
      this.a.c.setVisibility(8);
      this.c.a(this.a.b, this.b.uniseq, this.b.videoWidth, this.b.videoHeight, this.b.coverImgUrl, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.TribeShortVideoItemBuilder.4
 * JD-Core Version:    0.7.0.1
 */