package com.tencent.mobileqq.avatar.api.impl;

import android.content.Context;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.armap.NonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;

public class QQNonMainProcAvatarLoaderApiImpl
  implements IQQNonMainProcAvatarLoaderApi
{
  public INonMainProcAvatarLoader getNonMainAppHeadLoader(Context paramContext, int paramInt)
  {
    return new NonMainProcAvatarLoader(paramContext, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.avatar.api.impl.QQNonMainProcAvatarLoaderApiImpl
 * JD-Core Version:    0.7.0.1
 */