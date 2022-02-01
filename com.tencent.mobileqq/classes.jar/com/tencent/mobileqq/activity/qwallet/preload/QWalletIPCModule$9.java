package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.OnGetPathsListener;
import com.tencent.mobileqq.qwallet.preload.IPreloadService.PathResult;
import eipc.EIPCResult;
import java.util.HashMap;

class QWalletIPCModule$9
  implements IPreloadService.OnGetPathsListener
{
  QWalletIPCModule$9(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void a(int paramInt, HashMap<String, IPreloadService.PathResult> paramHashMap)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("result_code", paramInt);
    localBundle.putSerializable("path_result", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.9
 * JD-Core Version:    0.7.0.1
 */