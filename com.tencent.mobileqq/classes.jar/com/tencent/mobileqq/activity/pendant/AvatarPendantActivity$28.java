package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.api.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.screenshot.ApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

class AvatarPendantActivity$28
  implements ApolloAvatarVideoProcessor.OnProcessFinishListener
{
  AvatarPendantActivity$28(AvatarPendantActivity paramAvatarPendantActivity, CmAvatarFaceInfo paramCmAvatarFaceInfo) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.28.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.28
 * JD-Core Version:    0.7.0.1
 */