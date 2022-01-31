package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class PreloadManagerProxy$4
  extends ResultReceiver
{
  PreloadManagerProxy$4(PreloadManagerProxy paramPreloadManagerProxy, Handler paramHandler, PreloadManager.OnGetPathListener paramOnGetPathListener)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    if ((paramInt == 0) && (paramBundle != null))
    {
      paramInt = paramBundle.getInt("result_code");
      paramBundle = (PreloadManager.PathResult)paramBundle.getSerializable("path_result");
      if (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(paramInt, paramBundle);
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
    } while (this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener == null);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadPreloadManager$OnGetPathListener.onResult(1, PreloadManager.PathResult.getFailRes(null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.PreloadManagerProxy.4
 * JD-Core Version:    0.7.0.1
 */