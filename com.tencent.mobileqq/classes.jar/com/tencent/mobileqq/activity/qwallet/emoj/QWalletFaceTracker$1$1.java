package com.tencent.mobileqq.activity.qwallet.emoj;

import axng;
import com.tencent.mobileqq.activity.qwallet.preload.PreloadManager.PathResult;
import com.tencent.mobileqq.soload.LoadExtResult;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ytcommon.util.YTCommonInterface;

class QWalletFaceTracker$1$1
  implements axng
{
  QWalletFaceTracker$1$1(QWalletFaceTracker.1 param1, PreloadManager.PathResult paramPathResult) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0) {
      if (QLog.isColorLevel()) {
        QLog.i(QWalletFaceTracker.TAG, 2, "load so success");
      }
    }
    do
    {
      try
      {
        YTCommonInterface.initAuth(this.this$1.val$context, "youtusdk_mqq.licence", 0);
        QWalletFaceTracker.nativeInit();
        QWalletFaceTracker.GlobalInit(this.val$pathRes.folderPath + "/");
        this.this$1.this$0.NativeConstructor();
        this.this$1.this$0.hasSDkInit = true;
        if (this.this$1.val$baseRecognizer != null) {
          this.this$1.val$baseRecognizer.OnInitResultCallback(this.this$1.this$0.hasSDkInit);
        }
        return;
      }
      catch (Throwable paramLoadExtResult)
      {
        do
        {
          QLog.e(QWalletFaceTracker.TAG, 1, "initAuth occur an error: " + paramLoadExtResult);
          this.this$1.this$0.hasSDkInit = false;
        } while (this.this$1.val$baseRecognizer == null);
        this.this$1.val$baseRecognizer.OnInitResultCallback(this.this$1.this$0.hasSDkInit);
        return;
      }
      QLog.e(QWalletFaceTracker.TAG, 1, "load so error rescode:" + paramInt + ",loadExtResult:" + paramLoadExtResult);
      this.this$1.this$0.hasSDkInit = false;
    } while (this.this$1.val$baseRecognizer == null);
    this.this$1.val$baseRecognizer.OnInitResultCallback(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.QWalletFaceTracker.1.1
 * JD-Core Version:    0.7.0.1
 */