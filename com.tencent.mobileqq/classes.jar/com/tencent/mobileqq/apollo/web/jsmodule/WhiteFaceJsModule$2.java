package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.AddCmFaceCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.NotNull;

class WhiteFaceJsModule$2
  implements IStoreAvatar2D.AddCmFaceCallback
{
  WhiteFaceJsModule$2(WhiteFaceJsModule paramWhiteFaceJsModule, String paramString) {}
  
  public void a(int paramInt, @NotNull String paramString)
  {
    paramString = String.format("%s({\"result\":%d,\"msg\":\"%s\"});", new Object[] { this.a, Integer.valueOf(paramInt), paramString });
    if (QLog.isColorLevel()) {
      QLog.d("WhiteFaceJsModule", 2, new Object[] { "IPC_APOLLO_ADD_CM_FACE, result=", paramString });
    }
    this.b.d(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.WhiteFaceJsModule.2
 * JD-Core Version:    0.7.0.1
 */