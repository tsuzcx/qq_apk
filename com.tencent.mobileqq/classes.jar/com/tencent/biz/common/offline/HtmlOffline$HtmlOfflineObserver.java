package com.tencent.biz.common.offline;

import android.os.Bundle;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;
import mqq.observer.BusinessObserver;
import mqq.util.WeakReference;
import tencent.im.sso.offlinpkg.OfflinePkg.RspBody;

class HtmlOffline$HtmlOfflineObserver
  implements BusinessObserver
{
  private WeakReference<AsyncBack> a;
  private WeakReference<AppRuntime> b;
  private boolean c;
  private boolean d;
  private boolean e;
  private NewIntent f;
  
  public HtmlOffline$HtmlOfflineObserver(@NonNull AsyncBack paramAsyncBack, @NonNull AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NonNull NewIntent paramNewIntent)
  {
    this.a = new WeakReference(paramAsyncBack);
    this.b = new WeakReference(paramAppRuntime);
    this.c = paramBoolean1;
    this.d = paramBoolean3;
    this.e = paramBoolean2;
    this.f = paramNewIntent;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.f.setObserver(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->offline:checkUpdate,onReceive:isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("HtmlCheckUpdate", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AsyncBack)this.a.get();
    AppRuntime localAppRuntime = (AppRuntime)this.b.get();
    boolean bool = false;
    if ((localObject == null) || (localAppRuntime == null) || (paramBoolean)) {}
    try
    {
      paramBundle = paramBundle.getByteArray("data");
      if (paramBundle == null) {
        break label220;
      }
      OfflinePkg.RspBody localRspBody = new OfflinePkg.RspBody();
      localRspBody.mergeFrom(paramBundle);
      paramBundle = new String(localRspBody.str_offline_pkg.get().toByteArray(), "UTF-8");
      if (localObject != null) {
        ((AsyncBack)localObject).loaded(paramBundle, 0);
      }
      if (!this.c) {
        break label220;
      }
      if (this.d)
      {
        HtmlOffline.c(paramBundle, localAppRuntime, this.e, (AsyncBack)localObject);
        return;
      }
      HtmlOffline.c(paramBundle, localAppRuntime, this.e, null);
      return;
    }
    catch (Exception paramBundle)
    {
      label194:
      break label194;
    }
    ((AsyncBack)localObject).loaded("{\"r\":-1}", 2);
    return;
    if (localObject != null) {
      ((AsyncBack)localObject).loaded("{\"r\":-1}", 2);
    }
    label220:
    return;
    paramBoolean = bool;
    if (localAppRuntime == null) {
      paramBoolean = true;
    }
    QLog.d("HtmlCheckUpdate", 2, new Object[] { "-->offline:checkUpdate,app is null:", Boolean.valueOf(paramBoolean) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.HtmlOfflineObserver
 * JD-Core Version:    0.7.0.1
 */