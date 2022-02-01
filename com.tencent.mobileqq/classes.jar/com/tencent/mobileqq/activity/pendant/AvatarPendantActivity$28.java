package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;

class AvatarPendantActivity$28
  implements IApolloAvatarFileManager.OnGetFramePathListener
{
  AvatarPendantActivity$28(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.28.1(this, paramBoolean, paramList, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.28
 * JD-Core Version:    0.7.0.1
 */