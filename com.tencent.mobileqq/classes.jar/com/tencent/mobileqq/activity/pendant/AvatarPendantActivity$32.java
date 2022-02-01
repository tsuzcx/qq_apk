package com.tencent.mobileqq.activity.pendant;

import com.tencent.mobileqq.apollo.meme.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class AvatarPendantActivity$32
  implements IGetGifFrameCallback
{
  AvatarPendantActivity$32(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull MemeAction paramMemeAction)
  {
    if (this.a.app != null) {
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).putAction2GifFilePath(paramMemeAction.m(), this.a.app.getCurrentUin(), paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.32
 * JD-Core Version:    0.7.0.1
 */