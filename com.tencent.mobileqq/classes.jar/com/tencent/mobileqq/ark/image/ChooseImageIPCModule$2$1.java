package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class ChooseImageIPCModule$2$1
  extends DownloadListener
{
  ChooseImageIPCModule$2$1(ChooseImageIPCModule.2 param2, String paramString) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    QLog.d("ArkApp.ChooseImageIPCModule", 1, String.format("ArkMultiProc.download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadTask.a) }));
    Bundle localBundle = new Bundle();
    localBundle.putInt("code", paramDownloadTask.a);
    paramDownloadTask = EIPCResult.createResult(0, localBundle);
    this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.this$0.callbackResult(this.jdField_a_of_type_ComTencentMobileqqArkImageChooseImageIPCModule$2.a, paramDownloadTask);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule.2.1
 * JD-Core Version:    0.7.0.1
 */