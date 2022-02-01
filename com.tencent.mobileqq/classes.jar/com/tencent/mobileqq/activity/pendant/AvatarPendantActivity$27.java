package com.tencent.mobileqq.activity.pendant;

import android.os.Handler;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.mobileqq.app.ThreadManagerV2;
import java.util.List;

class AvatarPendantActivity$27
  implements ApolloAvatarFileManager.OnGetFramePathListener
{
  AvatarPendantActivity$27(AvatarPendantActivity paramAvatarPendantActivity) {}
  
  public void a(boolean paramBoolean, List<String> paramList, int paramInt)
  {
    ThreadManagerV2.getUIHandlerV2().post(new AvatarPendantActivity.27.1(this, paramBoolean, paramList, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.pendant.AvatarPendantActivity.27
 * JD-Core Version:    0.7.0.1
 */