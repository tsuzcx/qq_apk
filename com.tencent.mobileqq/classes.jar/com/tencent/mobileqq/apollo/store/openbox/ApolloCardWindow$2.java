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
      ??? = paramDownloadTask.a().getString("path");
      String str = paramDownloadTask.a().getString("url");
      paramDownloadTask = this.a.a((String)???);
      str = MD5Utils.toMD5(str);
      synchronized (ApolloCardWindow.a)
      {
        ApolloCardWindow.a.put(str, paramDownloadTask);
        return;
      }
      return;
    }
    catch (Exception paramDownloadTask)
    {
      QLog.e("ApolloCardWindow", 1, "onDoneFile error:", paramDownloadTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.2
 * JD-Core Version:    0.7.0.1
 */