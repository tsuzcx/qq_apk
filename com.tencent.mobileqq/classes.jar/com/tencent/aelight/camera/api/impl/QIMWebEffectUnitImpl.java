package com.tencent.aelight.camera.api.impl;

import android.os.Bundle;
import com.tencent.aelight.camera.aebase.QIMWebEffectCameraCaptureUnit;
import com.tencent.aelight.camera.api.IQIMWebEffectUnit;

public class QIMWebEffectUnitImpl
  implements IQIMWebEffectUnit
{
  public Bundle generateArgs(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString, boolean paramBoolean6, int paramInt2)
  {
    return QIMWebEffectCameraCaptureUnit.a(paramBoolean1, paramBoolean2, paramInt1, paramBoolean3, paramBoolean4, paramBoolean5, paramString, paramBoolean6, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.api.impl.QIMWebEffectUnitImpl
 * JD-Core Version:    0.7.0.1
 */