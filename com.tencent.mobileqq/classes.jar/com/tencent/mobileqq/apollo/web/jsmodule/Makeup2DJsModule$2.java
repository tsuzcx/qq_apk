package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.store.ApolloStoreViewController.PlayActionData;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.PreviewActionCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.Nullable;

class Makeup2DJsModule$2
  implements IStoreAvatar2D.PreviewActionCallback
{
  Makeup2DJsModule$2(Makeup2DJsModule paramMakeup2DJsModule, String paramString, Activity paramActivity) {}
  
  public void a(int paramInt, @Nullable ApolloStoreViewController.PlayActionData paramPlayActionData)
  {
    ThreadManager.getUIHandler().post(new Makeup2DJsModule.2.1(this, paramPlayActionData));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Makeup2DJsModule.2
 * JD-Core Version:    0.7.0.1
 */