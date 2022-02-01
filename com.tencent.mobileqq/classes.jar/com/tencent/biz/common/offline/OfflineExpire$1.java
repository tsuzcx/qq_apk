package com.tencent.biz.common.offline;

import android.content.Intent;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import mqq.app.AppRuntime;

final class OfflineExpire$1
  implements AsyncBack
{
  OfflineExpire$1(WeakReference paramWeakReference, String paramString1, int paramInt, String paramString2) {}
  
  public void loaded(String paramString, int paramInt)
  {
    paramString = (AppRuntime)this.a.get();
    if (paramString != null)
    {
      paramString = (IPreDownloadController)paramString.getRuntimeService(IPreDownloadController.class, "");
      localObject = this.b;
      long l;
      if (BidDownloader.a(paramInt)) {
        l = this.c;
      } else {
        l = -1L;
      }
      paramString.preDownloadSuccess((String)localObject, l);
    }
    paramString = OfflineExpire.a;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("finish predown bid=");
    ((StringBuilder)localObject).append(this.d);
    ((StringBuilder)localObject).append(", code=");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i(paramString, 1, ((StringBuilder)localObject).toString());
    OfflineExpire.a();
    if (OfflineExpire.b() == 0)
    {
      paramString = new Intent("com.tencent.process.tmdownloader.exit");
      localObject = new ArrayList();
      ((ArrayList)localObject).add("com.tencent.mobileqq:TMAssistantDownloadSDKService");
      paramString.putStringArrayListExtra("procNameList", (ArrayList)localObject);
      paramString.putExtra("verify", OfflineExpire.a((ArrayList)localObject, false));
      if (QLog.isColorLevel()) {
        QLog.d(OfflineExpire.a, 2, "sendBroadcast to close TMAssistant sdk process");
      }
      BaseApplication.getContext().sendBroadcast(paramString);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.common.offline.OfflineExpire.1
 * JD-Core Version:    0.7.0.1
 */