package com.tencent.mobileqq.activity.aio.photo;

import android.os.Bundle;
import com.tencent.mobileqq.filemanager.core.IFileVideoDownloadInfoListener;
import com.tencent.mobileqq.filemanager.fileviewer.data.BaseVideoBiz;
import com.tencent.superplayer.api.SuperPlayerVideoInfo;
import java.util.ArrayList;

class AIOImageProviderService$7
  implements IFileVideoDownloadInfoListener
{
  AIOImageProviderService$7(AIOImageProviderService paramAIOImageProviderService, BaseVideoBiz paramBaseVideoBiz, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.e.y != null) {
      this.e.y.a(this.b, this.c, this.d, "I:E", new String[] { String.valueOf(paramInt), paramString }, null, null, -1, null);
    }
  }
  
  public void a(SuperPlayerVideoInfo paramSuperPlayerVideoInfo)
  {
    if (this.e.y != null)
    {
      ArrayList localArrayList = paramSuperPlayerVideoInfo.getCookie();
      Bundle localBundle = new Bundle();
      localBundle.putString("savepath", paramSuperPlayerVideoInfo.getLocalSavePath());
      localBundle.putStringArrayList("cookies", localArrayList);
      localBundle.putString("contextid", this.a.a());
      localBundle.putString("fileid", paramSuperPlayerVideoInfo.getFileId());
      this.e.y.a(this.b, this.c, this.d, this.a.c(), paramSuperPlayerVideoInfo.getPlayUrls(), null, null, -1, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOImageProviderService.7
 * JD-Core Version:    0.7.0.1
 */