package com.tencent.mobileqq.activity.qwallet.preload;

import ahcg;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.app.QQAppInterface;
import mqq.app.AppRuntime;

public class QWalletIPCModule$1
  implements Runnable
{
  public QWalletIPCModule$1(ahcg paramahcg, Bundle paramBundle, int paramInt, AppRuntime paramAppRuntime) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("id");
    QWalletIPCModule.1.1 local1 = new QWalletIPCModule.1.1(this, null);
    PreloadManager localPreloadManager = (PreloadManager)((QQAppInterface)this.jdField_a_of_type_MqqAppAppRuntime).getManager(151);
    if (localPreloadManager != null)
    {
      localPreloadManager.a(str, local1);
      return;
    }
    local1.send(-7, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.1
 * JD-Core Version:    0.7.0.1
 */