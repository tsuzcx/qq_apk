package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class AvatarPendantActivity$32
  implements IGetGifFrameCallback
{
  AvatarPendantActivity$32(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    if (this.a.app != null) {
      ((IApolloAvatarFileManager)QRoute.api(IApolloAvatarFileManager.class)).putAction2GifFilePath(paramCMSAction.d(), this.a.app.getCurrentUin(), paramString);
    }
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.32.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.32
 * JD-Core Version:    0.7.0.1
 */