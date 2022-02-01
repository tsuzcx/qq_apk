package com.tencent.biz.common.offline;

import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

final class OfflineExpire$2
  implements Runnable
{
  OfflineExpire$2(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject1 = (AppRuntime)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject1 == null)
    {
      QLog.i(OfflineExpire.a, 1, "app == null, download wont start");
      return;
    }
    localObject1 = (IPreDownloadController)((AppRuntime)localObject1).getRuntimeService(IPreDownloadController.class, "");
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    while (i < k)
    {
      OfflineExpire.OfflinePreDownloadTask localOfflinePreDownloadTask = (OfflineExpire.OfflinePreDownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      String str1 = localOfflinePreDownloadTask.a.a;
      Object localObject2 = localOfflinePreDownloadTask.a.c;
      String str2 = localOfflinePreDownloadTask.a.b;
      int j;
      if (localOfflinePreDownloadTask.a.f) {
        j = 1;
      } else {
        j = 2;
      }
      boolean bool = ((IPreDownloadController)localObject1).requestPreDownload(10066, "app", str1, k - i, (String)localObject2, str2, j, 0, OfflineEnvHelper.a(localOfflinePreDownloadTask.a.a), localOfflinePreDownloadTask);
      str1 = OfflineExpire.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("requestPreDownload bid=");
      ((StringBuilder)localObject2).append(localOfflinePreDownloadTask.a.a);
      ((StringBuilder)localObject2).append(" re=");
      ((StringBuilder)localObject2).append(bool);
      QLog.i(str1, 1, ((StringBuilder)localObject2).toString());
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.2
 * JD-Core Version:    0.7.0.1
 */