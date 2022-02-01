package com.tencent.mobileqq.bigbrother.RockDownloader;

import android.support.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.util.ArrayList;
import javax.annotation.Nonnull;

public class RockDownloaderProxy
{
  @android.support.annotation.Nullable
  public static ArrayList<RockDownloadInfo> a(@NonNull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return RockDownloader.a(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable QueryAPKListener paramQueryAPKListener)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setQueryAPKListener(paramQueryAPKListener);
    RockDownloader.b(localRockDownloaderTask);
  }
  
  public static void a(@Nonnull RockDownloadInfo paramRockDownloadInfo, @javax.annotation.Nullable RockDownloadListener paramRockDownloadListener)
  {
    if (!NetworkUtil.isWifiEnabled(BaseApplicationImpl.context))
    {
      if (paramRockDownloadListener != null)
      {
        paramRockDownloadListener.onDownloadFail(paramRockDownloadInfo, HardCodeUtil.a(2131713416), 10009);
        paramRockDownloadListener.onDownloadFinish(paramRockDownloadInfo);
      }
      return;
    }
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    localRockDownloaderTask.setRockDownloadListener(paramRockDownloadListener);
    RockDownloader.a(localRockDownloaderTask);
  }
  
  public static boolean a(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return RockDownloader.b(localRockDownloaderTask);
  }
  
  public static boolean b(@Nonnull RockDownloadInfo paramRockDownloadInfo)
  {
    RockDownloaderTask localRockDownloaderTask = new RockDownloaderTask();
    localRockDownloaderTask.setDownloadInfo(paramRockDownloadInfo);
    localRockDownloaderTask.setTaskCheckLevel(1);
    localRockDownloaderTask.setRuntime(BaseApplicationImpl.getApplication().getRuntime());
    return RockDownloader.a(localRockDownloaderTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloaderProxy
 * JD-Core Version:    0.7.0.1
 */