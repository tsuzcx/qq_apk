package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import android.os.Handler;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.PreviewCallback;
import com.tencent.mobileqq.app.ThreadManager;
import org.jetbrains.annotations.Nullable;

class Makeup2DJsModule$3
  implements IStoreAvatar2D.PreviewCallback
{
  Makeup2DJsModule$3(Makeup2DJsModule paramMakeup2DJsModule, Activity paramActivity, String paramString) {}
  
  public void a(int paramInt, @Nullable int[] paramArrayOfInt)
  {
    if (paramInt != 0) {
      return;
    }
    ThreadManager.getUIHandlerV2().post(new Makeup2DJsModule.3.1(this, paramArrayOfInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.3
 * JD-Core Version:    0.7.0.1
 */