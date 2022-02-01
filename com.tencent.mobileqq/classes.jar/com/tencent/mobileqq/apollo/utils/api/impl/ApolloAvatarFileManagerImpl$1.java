package com.tencent.mobileqq.apollo.utils.api.impl;

import com.tencent.mobileqq.apollo.meme.IMemePlayerListener;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManagerImpl$1
  implements IMemePlayerListener
{
  ApolloAvatarFileManagerImpl$1(ApolloAvatarFileManagerImpl paramApolloAvatarFileManagerImpl, int paramInt, String paramString, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(@NotNull MemeAction paramMemeAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull MemeAction paramMemeAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    if (paramBoolean)
    {
      this.d.putAction2GifFilePath(this.a, this.b, paramString2);
      paramMemeAction = (List)ApolloAvatarFileManagerImpl.access$000(this.d).get(Integer.valueOf(this.a));
      if ((paramMemeAction != null) && (paramMemeAction.size() > 0))
      {
        paramString1 = new StringBuilder();
        paramString1.append("getAllFrameFiles onRecordDone success filePathList: ");
        paramString1.append(paramMemeAction.size());
        QLog.i("[cmshow]ApolloAvatarFileManagerImpl", 2, paramString1.toString());
        this.c.a(true, paramMemeAction, this.a);
        return;
      }
      this.c.a(false, null, this.a);
      paramString1 = new StringBuilder();
      paramString1.append("ICMSPlayerListener onRecordDone :");
      paramString1.append(paramBoolean);
      paramString1.append(" filePathList: ");
      int i;
      if (paramMemeAction == null) {
        i = -1;
      } else {
        i = paramMemeAction.size();
      }
      paramString1.append(i);
      QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramString1.toString());
      return;
    }
    this.c.a(false, null, this.a);
    paramMemeAction = new StringBuilder();
    paramMemeAction.append("ICMSPlayerListener onRecordDone :");
    paramMemeAction.append(paramBoolean);
    QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramMemeAction.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloAvatarFileManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */