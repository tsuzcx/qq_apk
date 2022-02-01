package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager;
import com.tencent.mobileqq.apollo.player.IGetGifFrameCallback;
import com.tencent.mobileqq.app.ThreadManagerV2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class AvatarPendantActivity$31
  implements IGetGifFrameCallback
{
  AvatarPendantActivity$31(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    ApolloAvatarFileManager.a().a(paramCMSAction.d(), paramString);
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.31.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.31
 * JD-Core Version:    0.7.0.1
 */