package com.tencent.mobileqq.apollo.web.jsmodule;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.apollo.meme.ICMSRecordCallback;
import com.tencent.mobileqq.apollo.web.api.impl.ApolloJsPluginImpl.AvatarInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class PendantAvatarJsModule$2
  implements ICMSRecordCallback
{
  PendantAvatarJsModule$2(PendantAvatarJsModule paramPendantAvatarJsModule, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    if ((paramBoolean) && (!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if ((paramString2 != null) && (paramString1 != null))
      {
        this.c.b.put(paramString2, new ApolloJsPluginImpl.AvatarInfo(paramString1, this.a));
        this.c.a(paramString2, paramInt, this.a, this.b);
      }
      return;
    }
    QLog.e("[cmshow]AvatarJsModule", 1, new Object[] { "recordAction fail ", Integer.valueOf(paramInt), paramString1, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.PendantAvatarJsModule.2
 * JD-Core Version:    0.7.0.1
 */