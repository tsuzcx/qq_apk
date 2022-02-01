package com.tencent.ark.open;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.ark.Logger;
import com.tencent.ark.ark.Application;
import java.util.Map;

final class ArkAppCacheMgr$2
  implements Runnable
{
  ArkAppCacheMgr$2(String paramString, ArkAppCacheMgr.OnGetAppIcon paramOnGetAppIcon) {}
  
  public void run()
  {
    synchronized ()
    {
      Object localObject2 = (ArkAppCacheMgr.ApplicationIconHolder)ArkAppCacheMgr.access$000().get(this.val$appName);
      if (localObject2 != null) {
        ((ArkAppCacheMgr.ApplicationIconHolder)localObject2).refCount += 1;
      }
      if (localObject2 != null)
      {
        ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.2.1(this, (ArkAppCacheMgr.ApplicationIconHolder)localObject2));
        return;
      }
      ??? = ArkAppMgr.getInstance().getAppPathFromLocal(this.val$appName);
      ark.Application localApplication2;
      int i;
      int j;
      if (!TextUtils.isEmpty((CharSequence)???))
      {
        localApplication2 = ark.Application.Create(this.val$appName, (String)???);
        if (localApplication2 == null)
        {
          Logger.logI("ArkApp.ArkAppCacheMgr", "getAppIcon.application == null .error!!");
        }
        else
        {
          i = localApplication2.GetIconWidth();
          j = localApplication2.GetIconHeight();
          if ((i <= 0) || (j <= 0)) {}
        }
      }
      try
      {
        localObject2 = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        label143:
        ark.Application localApplication1;
        break label143;
      }
      Logger.logI("ArkApp.ArkAppCacheMgr", "getAppIcon.createBitmap fail!!");
      localObject2 = null;
      localApplication1 = localApplication2;
      ??? = localObject2;
      if (localObject2 != null)
      {
        localApplication1 = localApplication2;
        ??? = localObject2;
        if (!localApplication2.CopyIconToBitmap((Bitmap)localObject2))
        {
          Logger.logI("ArkApp.ArkAppCacheMgr", "getAppIcon.copyToBitmap fail!!");
          localApplication1 = localApplication2;
          ??? = localObject2;
          break label221;
          Logger.logI("ArkApp.ArkAppCacheMgr", "getAppIcon.getSize.error!!");
          ??? = null;
          localApplication1 = localApplication2;
          break label221;
          localApplication1 = null;
          ??? = localApplication1;
        }
      }
      label221:
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("ArkTemp.getAppIcon is only template, from package appName=");
      ((StringBuilder)localObject2).append(this.val$appName);
      Logger.logI("ArkApp.ArkAppCacheMgr", ((StringBuilder)localObject2).toString());
      localObject2 = new ArkAppCacheMgr.ApplicationIconHolder(null);
      ((ArkAppCacheMgr.ApplicationIconHolder)localObject2).bmp = ((Bitmap)???);
      ArkAppCacheMgr.access$000().put(this.val$appName, localObject2);
      ArkDispatchTask.getInstance().postToMainThread(new ArkAppCacheMgr.2.2(this, (ArkAppCacheMgr.ApplicationIconHolder)localObject2));
      if (localApplication1 != null) {
        localApplication1.Release();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.ArkAppCacheMgr.2
 * JD-Core Version:    0.7.0.1
 */