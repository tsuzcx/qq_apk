package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.apollo.web.ipc.IStoreAvatar2D.DownloadGameCallback;
import java.io.Serializable;
import org.jetbrains.annotations.NotNull;

class LightGameJsModule$2
  implements IStoreAvatar2D.DownloadGameCallback
{
  LightGameJsModule$2(LightGameJsModule paramLightGameJsModule, String paramString) {}
  
  public void a(@NotNull Serializable paramSerializable)
  {
    LightGameJsModule.a(this.b, this.a, (StartCheckParam)paramSerializable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule.2
 * JD-Core Version:    0.7.0.1
 */