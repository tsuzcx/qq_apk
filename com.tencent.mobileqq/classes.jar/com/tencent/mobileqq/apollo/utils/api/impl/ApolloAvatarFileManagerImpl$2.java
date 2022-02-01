package com.tencent.mobileqq.apollo.utils.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.meme.GetFrameCallback;
import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.utils.api.IApolloAvatarFileManager.OnGetFramePathListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloAvatarFileManagerImpl$2
  implements GetFrameCallback
{
  ApolloAvatarFileManagerImpl$2(ApolloAvatarFileManagerImpl paramApolloAvatarFileManagerImpl, int paramInt, List paramList, IApolloAvatarFileManager.OnGetFramePathListener paramOnGetFramePathListener) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull MemeAction paramMemeAction)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString)))
    {
      ApolloAvatarFileManagerImpl.access$100(this.d).put(Integer.valueOf(this.a), paramString);
      this.b.add(paramString);
      paramString = this.c;
      if (paramString != null) {
        paramString.a(true, this.b, this.a);
      }
    }
    else
    {
      paramString = this.c;
      if (paramString != null) {
        paramString.a(false, null, this.a);
      }
      paramString = new StringBuilder();
      paramString.append("GetFrameCallback onComplete :");
      paramString.append(paramBoolean);
      QLog.e("[cmshow]ApolloAvatarFileManagerImpl", 1, paramString.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloAvatarFileManagerImpl.2
 * JD-Core Version:    0.7.0.1
 */