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
  private NewIntent jdField_a_of_type_MqqAppNewIntent;
  private WeakReference<AsyncBack> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private WeakReference<AppRuntime> jdField_b_of_type_MqqUtilWeakReference;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public HtmlOffline$HtmlOfflineObserver(@NonNull AsyncBack paramAsyncBack, @NonNull AppRuntime paramAppRuntime, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, @NonNull NewIntent paramNewIntent)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAsyncBack);
    this.jdField_b_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean3;
    this.c = paramBoolean2;
    this.jdField_a_of_type_MqqAppNewIntent = paramNewIntent;
  }
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.jdField_a_of_type_MqqAppNewIntent.setObserver(null);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("-->offline:checkUpdate,onReceive:isSuccess=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("HtmlCheckUpdate", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (AsyncBack)this.jdField_a_of_type_MqqUtilWeakReference.get();
    AppRuntime localAppRuntime = (AppRuntime)this.jdField_b_of_type_MqqUtilWeakReference.get();
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
      if (!this.jdField_a_of_type_Boolean) {
        break label220;
      }
      if (this.jdField_b_of_type_Boolean)
      {
        HtmlOffline.c(paramBundle, localAppRuntime, this.c, (AsyncBack)localObject);
        return;
      }
      HtmlOffline.c(paramBundle, localAppRuntime, this.c, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.HtmlOffline.HtmlOfflineObserver
 * JD-Core Version:    0.7.0.1
 */