package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import com.tencent.qphone.base.util.QLog;

class QWalletIPCModule$7
  implements IPreloadService.OnGetPathListener
{
  QWalletIPCModule$7(QWalletIPCModule paramQWalletIPCModule, ResultReceiver paramResultReceiver) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QWalletIPCModule", 2, "QWalletIPC downloadUrls" + paramPathResult);
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.7
 * JD-Core Version:    0.7.0.1
 */