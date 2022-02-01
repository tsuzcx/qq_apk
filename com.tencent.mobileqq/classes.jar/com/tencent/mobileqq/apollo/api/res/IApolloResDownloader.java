package com.tencent.mobileqq.apollo.api.res;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.vip.DownloadListener;
import mqq.app.AppRuntime;

@QAPI(process={"all"})
public abstract interface IApolloResDownloader
  extends QRouteApi
{
  public abstract void checkDownloadFaceData(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnFaceDataDownloadListener paramOnFaceDataDownloadListener);
  
  public abstract void downLoadCmshowRes(AppRuntime paramAppRuntime, String paramString1, String paramString2, Bundle paramBundle, DownloadListener paramDownloadListener);
  
  public abstract void downLoadSpecialAction(AppRuntime paramAppRuntime, String paramString1, String paramString2);
  
  public abstract void downloadApolloAudio(AppInterface paramAppInterface, IApolloResDownloader.OnAudioDownloadListener paramOnAudioDownloadListener, int paramInt, boolean paramBoolean);
  
  public abstract void downloadApolloRes(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract void downloadApolloResOrder(AppRuntime paramAppRuntime, String paramString, IApolloResDownloader.OnApolloDownLoadListener paramOnApolloDownLoadListener, int paramInt1, int[] paramArrayOfInt, int paramInt2, int paramInt3, boolean paramBoolean);
  
  public abstract String getAudioFilePath(int paramInt);
  
  public abstract int[] readRoleDefaultDressIds(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.res.IApolloResDownloader
 * JD-Core Version:    0.7.0.1
 */