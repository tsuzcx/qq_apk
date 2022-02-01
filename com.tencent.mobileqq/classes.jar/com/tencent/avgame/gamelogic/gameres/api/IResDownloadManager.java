package com.tencent.avgame.gamelogic.gameres.api;

import com.tencent.mobileqq.qroute.annotation.Service;
import com.tencent.mobileqq.transfile.INetEngineListener;
import mqq.app.api.IRuntimeService;
import mqq.manager.Manager;

@Service(needUin=false, process={"all"})
public abstract interface IResDownloadManager
  extends INetEngineListener, IRuntimeService, Manager
{
  public static final int ERR_CHECK_UNZIP = 4;
  public static final int ERR_RENAME = 1;
  public static final int ERR_RETRY_FAILED = 3;
  public static final int ERR_UNZIP = 2;
  public static final int FULL_MARKS_NEED_UNZIP = 90;
  public static final int HttpCommunicatorEngine = 0;
  public static final int ResultMd5VerifyFail = -6103066;
  
  public abstract void addListener(IResDownloadManager.IResDownloadListener paramIResDownloadListener);
  
  public abstract boolean download(IResDownloadManager.DownloadParam paramDownloadParam);
  
  public abstract boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt);
  
  public abstract boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject);
  
  public abstract boolean download(String paramString1, String paramString2, String paramString3, boolean paramBoolean, int paramInt, Object paramObject, IResDownloadManager.IResDownloadListener paramIResDownloadListener);
  
  public abstract boolean isFileExist(String paramString1, String paramString2, boolean paramBoolean, String paramString3, int paramInt);
  
  public abstract void removeListener(IResDownloadManager.IResDownloadListener paramIResDownloadListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.api.IResDownloadManager
 * JD-Core Version:    0.7.0.1
 */