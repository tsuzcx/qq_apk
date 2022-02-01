package com.tencent.aelight.camera.download.old.api.impl;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.aelight.camera.ae.download.old.AEOldResManager;
import com.tencent.aelight.camera.download.old.api.AEOldDownloadCallBack;
import com.tencent.aelight.camera.download.old.api.AEOldResInfo;
import com.tencent.aelight.camera.download.old.api.IAEOldResDownload;

public class AEOldResDownloadImpl
  implements IAEOldResDownload
{
  public void requestDownload(@NonNull AEOldResInfo paramAEOldResInfo, @Nullable AEOldDownloadCallBack paramAEOldDownloadCallBack, boolean paramBoolean)
  {
    AEOldResManager.a().b(paramAEOldResInfo, paramAEOldDownloadCallBack, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.download.old.api.impl.AEOldResDownloadImpl
 * JD-Core Version:    0.7.0.1
 */