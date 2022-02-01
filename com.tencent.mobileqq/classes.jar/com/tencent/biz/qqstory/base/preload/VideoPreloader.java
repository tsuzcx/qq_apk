package com.tencent.biz.qqstory.base.preload;

import android.annotation.TargetApi;
import com.tencent.biz.qqstory.model.SuperManager;
import java.util.List;

@TargetApi(14)
public class VideoPreloader
  implements IVideoPreloader
{
  public int a;
  
  public void a()
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(this.a);
  }
  
  public void a(int paramInt)
  {
    this.a = paramInt;
  }
  
  public void a(IVideoPreloader.OnPreloadListener paramOnPreloadListener)
  {
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramOnPreloadListener);
  }
  
  public void a(List<DownloadTask> paramList, boolean paramBoolean)
  {
    if (paramList == null) {
      return;
    }
    ((PreloadDownloaderManager)SuperManager.a(6)).a(paramList, this.a, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.VideoPreloader
 * JD-Core Version:    0.7.0.1
 */