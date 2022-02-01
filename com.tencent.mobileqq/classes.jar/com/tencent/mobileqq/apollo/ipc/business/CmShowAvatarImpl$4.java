package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CmShowAvatarImpl$4
  implements GetFrameCallback
{
  CmShowAvatarImpl$4(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt, ICMSRecordCallback paramICMSRecordCallback) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull MemeAction paramMemeAction)
  {
    CmShowAvatarImpl.a(this.c).remove(paramMemeAction);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("recordStaticAvatar onRecordDone actionId:");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" success:");
      localStringBuilder.append(paramBoolean);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(" key: ");
      localStringBuilder.append(paramMemeAction.a(null, null));
      localStringBuilder.append(" map size:");
      localStringBuilder.append(CmShowAvatarImpl.a(this.c).size());
      QLog.i("[cmshow]CmShowAvatarImpl", 1, localStringBuilder.toString());
    }
    this.b.a(paramBoolean, paramString, paramMemeAction.a(null, null), this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.4
 * JD-Core Version:    0.7.0.1
 */