package com.tencent.mobileqq.app.face;

import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;

public abstract interface DecodeCompletionListener
{
  public abstract void onDecodeTaskCompleted(FaceInfo paramFaceInfo, Bitmap paramBitmap);
  
  public abstract void onDecodeTaskCompletedNeedDownload(AppInterface paramAppInterface, FaceInfo paramFaceInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.face.DecodeCompletionListener
 * JD-Core Version:    0.7.0.1
 */