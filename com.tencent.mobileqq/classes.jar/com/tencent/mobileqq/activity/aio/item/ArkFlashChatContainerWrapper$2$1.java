package com.tencent.mobileqq.activity.aio.item;

import afii;
import afjv;
import android.os.Bundle;
import com.tencent.ark.ArkViewModelBase.AppInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.qphone.base.util.QLog;

public class ArkFlashChatContainerWrapper$2$1
  implements Runnable
{
  public ArkFlashChatContainerWrapper$2$1(afjv paramafjv, boolean paramBoolean, Bundle paramBundle) {}
  
  public void run()
  {
    int i;
    if (this.jdField_a_of_type_Boolean) {
      if (this.jdField_a_of_type_AndroidOsBundle != null)
      {
        i = this.jdField_a_of_type_AndroidOsBundle.getInt("resourceId");
        if ((i != -1) && (this.jdField_a_of_type_Afjv.a.c == i))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ArkApp", 2, "onDownloadRes onSuccess resouceId " + i);
          }
          FlashChatManager localFlashChatManager = (FlashChatManager)afii.a().getManager(217);
          ArkFlashChatContainerWrapper.b(this.jdField_a_of_type_Afjv.a).path = localFlashChatManager.a(this.jdField_a_of_type_Afjv.a.c, ArkFlashChatContainerWrapper.c(this.jdField_a_of_type_Afjv.a).name, ArkFlashChatContainerWrapper.d(this.jdField_a_of_type_Afjv.a).appMinVersion);
          this.jdField_a_of_type_Afjv.a.a(ArkFlashChatContainerWrapper.e(this.jdField_a_of_type_Afjv.a).path, 0, null);
        }
      }
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_AndroidOsBundle == null);
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("resourceId");
    } while ((i == -1) || (this.jdField_a_of_type_Afjv.a.c != i));
    if (QLog.isColorLevel()) {
      QLog.d("ArkApp.ArkAioContainerWrapper", 2, "onDownloadRes onError resouceId " + i);
    }
    this.jdField_a_of_type_Afjv.a.a(ArkFlashChatContainerWrapper.f(this.jdField_a_of_type_Afjv.a).path, -2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.ArkFlashChatContainerWrapper.2.1
 * JD-Core Version:    0.7.0.1
 */