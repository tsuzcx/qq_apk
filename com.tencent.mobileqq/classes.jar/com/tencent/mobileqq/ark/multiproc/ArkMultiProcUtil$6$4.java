package com.tencent.mobileqq.ark.multiproc;

import com.tencent.ark.open.delegate.IArkDelegateNetCallback;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

class ArkMultiProcUtil$6$4
  extends DownloadListener
{
  ArkMultiProcUtil$6$4(ArkMultiProcUtil.6 param6, String paramString, IArkDelegateNetCallback paramIArkDelegateNetCallback) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    QLog.d("ArkApp.ArkMultiProcUtil", 1, String.format("download finish, url=%s, err=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(paramDownloadTask.a) }));
    if (this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback != null) {
      this.jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNetCallback.onDownload(paramDownloadTask.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil.6.4
 * JD-Core Version:    0.7.0.1
 */