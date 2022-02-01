package com.tencent.mobileqq.ark;

import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import java.lang.ref.WeakReference;

class ArkAiDictUpdateMgr$8$1$1
  implements Runnable
{
  ArkAiDictUpdateMgr$8$1$1(ArkAiDictUpdateMgr.8.1 param1, byte[] paramArrayOfByte, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$PreDownloadState.jdField_a_of_type_JavaLangRefWeakReference == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, weakPreDownloadCtrl is null, return");
      return;
    }
    PreDownloadController localPreDownloadController = (PreDownloadController)this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$PreDownloadState.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localPreDownloadController == null)
    {
      ArkAppCenter.c("ArkApp.Dict.Update", "downloadDictFile, preDownloadController is null, return");
      return;
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    long l;
    if (this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$PreDownloadState.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_Boolean)
      {
        String str = this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_JavaLangString;
        if (arrayOfByte == null)
        {
          l = 0L;
          localPreDownloadController.preDownloadSuccess(str, l);
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$IDownloadDictFileCallback.a(arrayOfByte);
      return;
      l = arrayOfByte.length;
      break;
      localPreDownloadController.preDownloadSuccess(this.jdField_a_of_type_ComTencentMobileqqArkArkAiDictUpdateMgr$8$1.a.jdField_a_of_type_JavaLangString, -1L);
      arrayOfByte = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.ArkAiDictUpdateMgr.8.1.1
 * JD-Core Version:    0.7.0.1
 */