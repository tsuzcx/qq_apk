package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.lang.ref.WeakReference;

class ArkAiDictUpdateMgr$8
  implements Runnable
{
  ArkAiDictUpdateMgr$8(ArkAiDictUpdateMgr paramArkAiDictUpdateMgr, String paramString, ArkAiDictUpdateMgr.PreDownloadState paramPreDownloadState, ArkAiDictUpdateMgr.IDownloadDictFileCallback paramIDownloadDictFileCallback) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ArkAiDictUpdateMgr.a(this.this$0).get();
    if (localQQAppInterface == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, qq app interface is null, return from task");
      return;
    }
    ((ArkAppCenter)localQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER)).a().a(this.jdField_a_of_type_JavaLangString, 0L, new ArkAiDictUpdateMgr.8.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8
 * JD-Core Version:    0.7.0.1
 */