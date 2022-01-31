package com.tencent.mobileqq.activity.qwallet.preload;

import agpe;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

public class PreloadManagerProxy$5
  extends ResultReceiver
{
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("result_code");
      paramBundle = (PreloadManager.PathResult)paramBundle.getSerializable("path_result");
      if (this.a != null) {
        this.a.onResult(paramInt, paramBundle);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "downloadUrls" + paramBundle);
      }
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PreloadManagerProxy", 2, "downloadUrls IPC wrong");
      }
    } while (this.a == null);
    this.a.onResult(1, PreloadManager.PathResult.getFailRes(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy.5
 * JD-Core Version:    0.7.0.1
 */