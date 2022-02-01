package com.tencent.aelight.camera.api;

import android.os.Bundle;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IQIMWebEffectUnit
  extends QRouteApi
{
  public abstract Bundle generateArgs(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, String paramString, boolean paramBoolean6, int paramInt2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.api.IQIMWebEffectUnit
 * JD-Core Version:    0.7.0.1
 */