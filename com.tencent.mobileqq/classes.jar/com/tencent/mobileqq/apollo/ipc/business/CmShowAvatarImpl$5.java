package com.tencent.mobileqq.apollo.ipc.business;

import com.tencent.mobileqq.apollo.meme.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class CmShowAvatarImpl$5
  implements IMemePlayerListener
{
  CmShowAvatarImpl$5(CmShowAvatarImpl paramCmShowAvatarImpl, int paramInt, ICMSRecordCallback paramICMSRecordCallback) {}
  
  public void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    CmShowAvatarImpl.b(this.c).remove(paramMemeAction);
    if (QLog.isColorLevel())
    {
      paramMemeAction = new StringBuilder();
      paramMemeAction.append("recordDynamicAvatar onRecordDone actionId:");
      paramMemeAction.append(this.a);
      paramMemeAction.append(" success:");
      paramMemeAction.append(paramBoolean);
      paramMemeAction.append(" ");
      paramMemeAction.append(paramString2);
      paramMemeAction.append(" key: ");
      paramMemeAction.append(paramString1);
      paramMemeAction.append(" map size:");
      paramMemeAction.append(CmShowAvatarImpl.b(this.c).size());
      QLog.i("[cmshow]CmShowAvatarImpl", 1, paramMemeAction.toString());
    }
    this.b.a(paramBoolean, paramString2, paramString1, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ipc.business.CmShowAvatarImpl.5
 * JD-Core Version:    0.7.0.1
 */