package com.tencent.mobileqq.activity.qqsettingme.api.impl;

import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.qqsettingme.api.IFaceDrawableApi;
import com.tencent.mobileqq.app.face.FaceDrawable;

public class FaceDrawableApiImpl
  implements IFaceDrawableApi
{
  public void cancelFaceDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    if ((paramDrawable2 != paramDrawable1) && ((paramDrawable2 instanceof FaceDrawable))) {
      ((FaceDrawable)paramDrawable2).cancel();
    }
  }
  
  public Drawable getFaceDrawable(AppInterface paramAppInterface, String paramString, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("");
    return FaceDrawable.getFaceDrawable(paramAppInterface, 1, localStringBuilder.toString(), 4, paramDrawable1, paramDrawable2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qqsettingme.api.impl.FaceDrawableApiImpl
 * JD-Core Version:    0.7.0.1
 */