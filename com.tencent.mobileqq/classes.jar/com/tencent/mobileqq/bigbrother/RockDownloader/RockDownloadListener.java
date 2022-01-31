package com.tencent.mobileqq.bigbrother.RockDownloader;

import com.tencent.mobileqq.data.RockDownloadInfo;
import java.io.Serializable;

public abstract class RockDownloadListener
  implements Serializable
{
  public static final int ERROR_CODE_BLOCK_IN_GP = 10012;
  public static final int ERROR_CODE_CKV_ERROR = 10005;
  public static final int ERROR_CODE_DOWNLOAD_INFO_VERIFY_FAIL = 10001;
  public static final int ERROR_CODE_GET_PERMISSION_ERROR = 10002;
  public static final int ERROR_CODE_HIDDEN_APK_ERROR = 10007;
  public static final int ERROR_CODE_NOT_WIFI_NETWORK_ERROR = 10009;
  public static final int ERROR_CODE_OVER_THRESHOLD_ERROR = 10006;
  public static final int ERROR_CODE_PARSE_APK_ERROR = 10008;
  public static final int ERROR_CODE_REPEATED_TASK_ERROR = 10011;
  public static final int ERROR_CODE_SERVER_ERROR = 10003;
  public static final int ERROR_CODE_TMA_NOT_READY_ERROR = 10010;
  public static final int ERROR_CODE_UNKNOW_COMMAND = 10004;
  
  public abstract void onDownloadCancel(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onDownloadFail(RockDownloadInfo paramRockDownloadInfo, String paramString, int paramInt);
  
  public abstract void onDownloadFinish(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onDownloadProceedOn(RockDownloadInfo paramRockDownloadInfo, int paramInt);
  
  public abstract void onDownloadStart(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onDownloadSuccess(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onDownloadWait(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onPermissionDeny(RockDownloadInfo paramRockDownloadInfo);
  
  public abstract void onPermissionPermit(RockDownloadInfo paramRockDownloadInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.bigbrother.RockDownloader.RockDownloadListener
 * JD-Core Version:    0.7.0.1
 */