package com.tencent.aelight.camera.aioeditor.shortvideo.util.storage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class StorageManager$1
  extends BroadcastReceiver
{
  StorageManager$1(StorageManager paramStorageManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (paramIntent.getAction() == null) {
      return;
    }
    paramContext = this.a.jdField_a_of_type_JavaLangString;
    this.a.b();
    if ((this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager$OnSdCardChangedListener != null) && (!paramContext.equals(this.a.jdField_a_of_type_JavaLangString)))
    {
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_UNMOUNTED"))
      {
        this.a.a();
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager$OnSdCardChangedListener.a(0, this.a.jdField_a_of_type_JavaLangString);
        return;
      }
      if (paramIntent.getAction().equals("android.intent.action.MEDIA_MOUNTED")) {
        this.a.jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoUtilStorageStorageManager$OnSdCardChangedListener.a(1, this.a.jdField_a_of_type_JavaLangString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.util.storage.StorageManager.1
 * JD-Core Version:    0.7.0.1
 */