package com.tencent.comic;

import android.os.Handler;
import android.os.Message;
import com.tencent.comic.utils.QQComicPluginBridge.PluginInstallCallback;
import java.lang.ref.WeakReference;

class VipComicJumpActivity$ComicPluginInstallCallback
  implements QQComicPluginBridge.PluginInstallCallback
{
  private WeakReference<Handler> a;
  
  VipComicJumpActivity$ComicPluginInstallCallback(Handler paramHandler)
  {
    this.a = new WeakReference(paramHandler);
  }
  
  public void a(int paramInt, String paramString)
  {
    Handler localHandler = (Handler)this.a.get();
    if (localHandler != null) {
      localHandler.obtainMessage(1001, paramInt, 0, paramString).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.VipComicJumpActivity.ComicPluginInstallCallback
 * JD-Core Version:    0.7.0.1
 */