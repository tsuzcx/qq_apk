package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import eipc.EIPCResult;

class QWalletIPCModule$8
  implements IPreloadService.OnGetPathListener
{
  QWalletIPCModule$8(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void onResult(int paramInt, IPreloadService.PathResult paramPathResult)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramPathResult);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.8
 * JD-Core Version:    0.7.0.1
 */