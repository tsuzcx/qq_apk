package com.tencent.TMG.ptt;

import android.util.Log;
import com.tencent.TMG.utils.CosFileTransfer;

class PttManager$1
  implements TokenFetcher.GetUploadTokenListener
{
  PttManager$1(PttManager paramPttManager, String paramString, PttListener.UploadFileListener paramUploadFileListener) {}
  
  public void onCompleted(int paramInt, String paramString, TokenFetcher.UploadInfo paramUploadInfo)
  {
    if ((paramInt == 0) && (paramUploadInfo != null)) {
      CosFileTransfer.uploadFile(this.val$srcPath, paramUploadInfo.upload_url, paramUploadInfo.token, 20971520, null, new PttManager.1.1(this));
    }
    do
    {
      return;
      Log.e("PTTManager", "uploadFile|get upload file token failed");
    } while (this.val$monitor == null);
    this.val$monitor.onCompleted(paramInt, this.val$srcPath, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.TMG.ptt.PttManager.1
 * JD-Core Version:    0.7.0.1
 */