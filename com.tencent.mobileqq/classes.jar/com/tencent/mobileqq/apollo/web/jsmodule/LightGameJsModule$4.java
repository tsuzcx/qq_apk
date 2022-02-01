package com.tencent.mobileqq.apollo.web.jsmodule;

import com.tencent.qphone.base.util.QLog;

class LightGameJsModule$4
  implements Runnable
{
  LightGameJsModule$4(LightGameJsModule paramLightGameJsModule, int paramInt) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[IPC_APOLLO_DOWNLOAD_GAME] callJs: window.onGameDownloadProgress(");
      ((StringBuilder)localObject).append(this.a);
      ((StringBuilder)localObject).append(")");
      QLog.d("[cmshow]LightGameJsModule", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.this$0;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("window.onGameDownloadProgress &&　window.onGameDownloadProgress(");
    localStringBuilder.append(this.a);
    localStringBuilder.append(")");
    ((LightGameJsModule)localObject).d(localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.web.jsmodule.LightGameJsModule.4
 * JD-Core Version:    0.7.0.1
 */