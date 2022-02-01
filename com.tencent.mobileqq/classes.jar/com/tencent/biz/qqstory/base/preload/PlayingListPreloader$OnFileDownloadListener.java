package com.tencent.biz.qqstory.base.preload;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import java.io.File;
import java.util.Map;

class PlayingListPreloader$OnFileDownloadListener
  extends SimplePreloadListener
{
  public PlayingListPreloader$OnFileDownloadListener(PlayingListPreloader paramPlayingListPreloader)
  {
    super("Q.qqstory.download.preload.PlayingListPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    PlayingListPreloader.CurrentVid localCurrentVid = this.a.f;
    if (localCurrentVid == null) {
      return;
    }
    if (!TextUtils.equals(paramString, localCurrentVid.b)) {
      return;
    }
    if (paramErrorMessage.isFail())
    {
      if (TextUtils.isEmpty(localCurrentVid.d))
      {
        paramErrorMessage = paramErrorMessage.errorMsg;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramErrorMessage.errorMsg);
        localStringBuilder.append(" | ");
        localStringBuilder.append(paramErrorMessage.errorMsg);
        paramErrorMessage = localStringBuilder.toString();
      }
      localCurrentVid.d = paramErrorMessage;
      localCurrentVid.e = (paramInt + 1000);
    }
    if (paramDownloadTask.l.containsKey("handleCallback"))
    {
      if (localCurrentVid.c) {
        return;
      }
      localCurrentVid.c = true;
      if (this.a.b(paramString))
      {
        if (this.a.c != null) {
          this.a.c.a(paramString, paramDownloadTask.f, paramInt);
        }
      }
      else if (this.a.c != null) {
        this.a.c.a(paramString, paramDownloadTask.f, localCurrentVid.a(), paramInt);
      }
    }
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.c != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.c.b(paramString, paramDownloadTask.f, paramInt);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.PlayingListPreloader.OnFileDownloadListener
 * JD-Core Version:    0.7.0.1
 */