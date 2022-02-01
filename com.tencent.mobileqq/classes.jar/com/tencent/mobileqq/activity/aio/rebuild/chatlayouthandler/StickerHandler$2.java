package com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.pic.api.IPicPreDownload;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import java.io.File;
import java.net.URL;

class StickerHandler$2
  implements Runnable
{
  StickerHandler$2(StickerHandler paramStickerHandler, MessageRecord paramMessageRecord) {}
  
  public void run()
  {
    File localFile = AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)this.a, 1, null).toString());
    if ((localFile == null) || (!localFile.exists())) {
      ((IPicPreDownload)StickerHandler.d(this.this$0).getRuntimeService(IPicPreDownload.class, "")).productFromAIO((MessageForPic)this.a, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.chatlayouthandler.StickerHandler.2
 * JD-Core Version:    0.7.0.1
 */