package com.tencent.comic.emoticon;

import android.os.Bundle;
import com.tencent.comic.api.IQQComicEmoticonService;
import com.tencent.comic.utils.AppHelper;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.pluginsdk.ipc.PluginCommunicationHandler;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand;
import com.tencent.mobileqq.pluginsdk.ipc.RemoteCommand.OnInvokeFinishLinstener;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class VipComicEmoticonUploadRemoteCmd
  extends RemoteCommand
{
  private boolean a;
  
  public VipComicEmoticonUploadRemoteCmd(String paramString, boolean paramBoolean)
  {
    super(paramString);
    this.a = paramBoolean;
  }
  
  public static void a()
  {
    PluginCommunicationHandler localPluginCommunicationHandler = PluginCommunicationHandler.getInstance();
    if (localPluginCommunicationHandler != null) {
      localPluginCommunicationHandler.register(new VipComicEmoticonUploadRemoteCmd("qqcomicemoticonipccmd", false));
    }
  }
  
  public Bundle invoke(Bundle paramBundle, RemoteCommand.OnInvokeFinishLinstener paramOnInvokeFinishLinstener)
  {
    AppRuntime localAppRuntime = AppHelper.b();
    if (!(localAppRuntime instanceof BaseQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("VipComicEmoticonUploadRemoteCmd", 2, "onRemoteInvoke cannot get QQAppInterface");
      }
      return null;
    }
    if ("Remotecall_uploadEmoticon".equals(paramBundle.getString("qqcomicemoticonipccmd"))) {
      ((IQQComicEmoticonService)localAppRuntime.getRuntimeService(IQQComicEmoticonService.class, "")).uploadComicEmoticon(paramBundle, new VipComicEmoticonUploadRemoteCmd.1(this, paramOnInvokeFinishLinstener));
    }
    return null;
  }
  
  public boolean isSynchronized()
  {
    return this.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.emoticon.VipComicEmoticonUploadRemoteCmd
 * JD-Core Version:    0.7.0.1
 */