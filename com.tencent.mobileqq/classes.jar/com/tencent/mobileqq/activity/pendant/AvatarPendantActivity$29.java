package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.model.CmAvatarFaceInfo;
import com.tencent.mobileqq.apollo.screenshot.api.IApolloAvatarVideoProcessor.OnProcessFinishListener;
import com.tencent.mobileqq.app.ThreadManagerV2;

class AvatarPendantActivity$29
  implements IApolloAvatarVideoProcessor.OnProcessFinishListener
{
  AvatarPendantActivity$29(AvatarPendantActivity paramAvatarPendantActivity, CmAvatarFaceInfo paramCmAvatarFaceInfo) {}
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.29.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.29
 * JD-Core Version:    0.7.0.1
 */