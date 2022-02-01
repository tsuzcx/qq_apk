package com.tencent.biz.pubaccount.weishi_new.player;

import com.tencent.biz.pubaccount.weishi_new.player.wrapper.IWSPlayerPreDownloader.Listener;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.app.ThreadManager;

class WSVideoPreDownloadManager$2
  implements IWSPlayerPreDownloader.Listener
{
  WSVideoPreDownloadManager$2(WSVideoPreDownloadManager paramWSVideoPreDownloadManager) {}
  
  public void a(String paramString1, int paramInt, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVideoPreDownloadManager.java][onPreLoadFailed] ERROR!! videoUrl:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" ERROR code: ");
    localStringBuilder.append(paramInt);
    WSLog.d("WS_VIDEO_PRE_DL", localStringBuilder.toString());
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).a(paramString1, paramInt, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, false), 5, null, true);
  }
  
  public void a(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<<<<<<[WSVideoPreDownloadManager.java][onPreLoadSuccess] SUCCESS!! videoUrl:");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(" SUCCESS");
    WSLog.g("WS_VIDEO_PRE_DL", localStringBuilder.toString());
    if (WSVideoPreDownloadManager.a(this.a) != null) {
      WSVideoPreDownloadManager.a(this.a).a(paramString1, paramString2);
    }
    ThreadManager.post(new WSVideoPreDownloadManager.PreDownloadNotAlreadyVideoTask(this.a, true), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager.2
 * JD-Core Version:    0.7.0.1
 */