package com.tencent.mobileqq.apollo.store.openbox;

import android.os.Bundle;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

class ApolloCardWindow$2
  extends DownloadListener
{
  ApolloCardWindow$2(ApolloCardWindow paramApolloCardWindow) {}
  
  public void onDoneFile(DownloadTask paramDownloadTask)
  {
    if (paramDownloadTask == null) {
      return;
    }
    try
    {
      ??? = paramDownloadTask.b().getString("path");
      String str = paramDownloadTask.b().getString("url");
      paramDownloadTask = this.a.a((String)???);
      str = MD5Utils.toMD5(str);
      synchronized (ApolloCardWindow.f)
      {
        ApolloCardWindow.f.put(str, paramDownloadTask);
        return;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("[cmshow]ApolloCardWindow", 1, "onDoneFile error:", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.2
 * JD-Core Version:    0.7.0.1
 */