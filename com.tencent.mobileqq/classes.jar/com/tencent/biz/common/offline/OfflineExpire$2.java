package com.tencent.biz.common.offline;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class OfflineExpire$2
  implements Runnable
{
  OfflineExpire$2(WeakReference paramWeakReference, ArrayList paramArrayList) {}
  
  public void run()
  {
    Object localObject = (QQAppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localObject == null)
    {
      QLog.i(OfflineExpire.a, 1, "app == null, download wont start");
      return;
    }
    localObject = (PreDownloadController)((QQAppInterface)localObject).getManager(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2);
    int k = this.jdField_a_of_type_JavaUtilArrayList.size();
    int i = 0;
    label50:
    OfflineExpire.OfflinePreDownloadTask localOfflinePreDownloadTask;
    String str1;
    String str2;
    String str3;
    if (i < k)
    {
      localOfflinePreDownloadTask = (OfflineExpire.OfflinePreDownloadTask)this.jdField_a_of_type_JavaUtilArrayList.get(i);
      str1 = localOfflinePreDownloadTask.a.a;
      str2 = localOfflinePreDownloadTask.a.c;
      str3 = localOfflinePreDownloadTask.a.b;
      if (!localOfflinePreDownloadTask.a.f) {
        break label197;
      }
    }
    label197:
    for (int j = 1;; j = 2)
    {
      boolean bool = ((PreDownloadController)localObject).requestPreDownload(10066, "app", str1, k - i, str2, str3, j, 0, OfflineEnvHelper.a(localOfflinePreDownloadTask.a.a), localOfflinePreDownloadTask);
      QLog.i(OfflineExpire.a, 1, "requestPreDownload bid=" + localOfflinePreDownloadTask.a.a + " re=" + bool);
      i += 1;
      break label50;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.2
 * JD-Core Version:    0.7.0.1
 */