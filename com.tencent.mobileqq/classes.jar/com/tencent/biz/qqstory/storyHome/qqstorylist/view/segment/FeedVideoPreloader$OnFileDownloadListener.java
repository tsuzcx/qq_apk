package com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment;

import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.base.preload.DownloadTask;
import com.tencent.biz.qqstory.base.preload.SimplePreloadListener;
import java.io.File;
import java.util.Map;

class FeedVideoPreloader$OnFileDownloadListener
  extends SimplePreloadListener
{
  public FeedVideoPreloader$OnFileDownloadListener(FeedVideoPreloader paramFeedVideoPreloader)
  {
    super("Q.qqstory.download.preload.FeedVideoPreloader");
  }
  
  public void a(String paramString, int paramInt1, ErrorMessage paramErrorMessage, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.a(paramString, paramInt1, paramErrorMessage, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, paramErrorMessage, paramDownloadTask);
  }
  
  protected void a(String paramString, int paramInt, ErrorMessage paramErrorMessage, DownloadTask paramDownloadTask)
  {
    FeedVideoPreloader.CurrentVid localCurrentVid = this.a.g;
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
      if (this.a.a(paramString))
      {
        if (this.a.c != null) {
          this.a.c.a(paramString, paramDownloadTask.f);
        }
      }
      else if (this.a.c != null) {
        this.a.c.a(paramString, paramDownloadTask.f, localCurrentVid.a());
      }
    }
  }
  
  public void b(String paramString, int paramInt, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt, paramDownloadTask);
    if ((this.a.c != null) && ((paramInt == 0) || (paramInt == 1))) {
      this.a.c.b(paramString, paramDownloadTask.f);
    }
  }
  
  public void b(String paramString, int paramInt1, File paramFile, int paramInt2, DownloadTask paramDownloadTask)
  {
    super.b(paramString, paramInt1, paramFile, paramInt2, paramDownloadTask);
    a(paramString, paramInt1, new ErrorMessage(), paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedVideoPreloader.OnFileDownloadListener
 * JD-Core Version:    0.7.0.1
 */