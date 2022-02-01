package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.IsCmFaceAddedCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class WhiteFaceJsModule$1
  implements IStoreAvatar2D.IsCmFaceAddedCallback
{
  WhiteFaceJsModule$1(WhiteFaceJsModule paramWhiteFaceJsModule, String paramString) {}
  
  public void a(int paramInt, @Nullable String paramString1, @NotNull String paramString2)
  {
    paramString1 = String.format("%s({\"result\":%d,\"data\":{\"status\":%s}, \"msg\":\"%s\"});", new Object[] { this.a, Integer.valueOf(paramInt), paramString1, paramString2 });
    if (QLog.isColorLevel()) {
      QLog.d("WhiteFaceJsModule", 2, new Object[] { "IPC_APOLLO_IS_CM_FACE_ADDED, result=", paramString1 });
    }
    this.b.d(paramString1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.WhiteFaceJsModule.1
 * JD-Core Version:    0.7.0.1
 */