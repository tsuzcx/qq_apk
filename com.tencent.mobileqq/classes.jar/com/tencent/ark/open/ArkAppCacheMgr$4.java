package com.tencent.ark.open;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark.Application;
import java.util.Map;

final class ArkAppCacheMgr$4
  implements Runnable
{
  ArkAppCacheMgr$4(String paramString, ArkAppCacheMgr.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    synchronized ()
    {
      ArkAppCacheMgr.ApplicationIconHolder localApplicationIconHolder = (ArkAppCacheMgr.ApplicationIconHolder)ArkAppCacheMgr.access$300().get(this.val$appName);
      if (localApplicationIconHolder != null) {
        localApplicationIconHolder.refCount += 1;
      }
      if (localApplicationIconHolder != null)
      {
        ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.4.1(this, localApplicationIconHolder));
        return;
      }
    }
    ??? = ArkAppMgr.getInstance().getAppPathByNameFromLocal(this.val$appName, "", "0.0.0.1", false);
    ark.Application localApplication2;
    ark.Application localApplication1;
    if (!TextUtils.isEmpty((CharSequence)???))
    {
      localApplication2 = ark.Application.Create(this.val$appName, (String)???);
      if (localApplication2 == null)
      {
        ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "getAppIcon.application == null .error!!");
        ??? = null;
        localApplication1 = localApplication2;
      }
    }
    for (;;)
    {
      ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "ArkTemp.getAppIcon is only template, from package appName=" + this.val$appName);
      Object localObject4 = new ArkAppCacheMgr.ApplicationIconHolder(null);
      ((ArkAppCacheMgr.ApplicationIconHolder)localObject4).bmp = ((Bitmap)???);
      ArkAppCacheMgr.access$300().put(this.val$appName, localObject4);
      ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.4.2(this, (ArkAppCacheMgr.ApplicationIconHolder)localObject4));
      if (localApplication1 == null) {
        break;
      }
      localApplication1.Release();
      return;
      int i = localApplication2.GetIconWidth();
      int j = localApplication2.GetIconHeight();
      if ((i <= 0) || (j <= 0))
      {
        ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "getAppIcon.getSize.error!!");
        ??? = null;
        localApplication1 = localApplication2;
      }
      else
      {
        try
        {
          localObject4 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          localApplication1 = localApplication2;
          ??? = localObject4;
          if (localObject4 == null) {
            continue;
          }
          localApplication1 = localApplication2;
          ??? = localObject4;
          if (localApplication2.CopyIconToBitmap((Bitmap)localObject4)) {
            continue;
          }
          ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "getAppIcon.copyToBitmap fail!!");
          localApplication1 = localApplication2;
          ??? = localObject4;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          for (;;)
          {
            ArkAppCacheMgr.access$000().logI("ArkApp.ArkAppCacheMgr", "getAppIcon.createBitmap fail!!");
            localObject4 = null;
          }
        }
        localApplication1 = null;
        Object localObject2 = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.4
 * JD-Core Version:    0.7.0.1
 */