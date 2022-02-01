package com.tencent.mobileqq.apollo.web.jsmodule;

import android.app.Activity;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.CheckAvatarResCallback;
import java.io.Serializable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

class Avatar2DJsModule$1
  implements IStoreAvatar2D.CheckAvatarResCallback
{
  Avatar2DJsModule$1(Avatar2DJsModule paramAvatar2DJsModule, String paramString1, String paramString2, Activity paramActivity) {}
  
  public void a(int paramInt, @NotNull String paramString, Serializable paramSerializable)
  {
    Avatar2DJsModule.a(this.d, paramInt, 1, paramString, this.a, (ArrayList)paramSerializable, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.Avatar2DJsModule.1
 * JD-Core Version:    0.7.0.1
 */