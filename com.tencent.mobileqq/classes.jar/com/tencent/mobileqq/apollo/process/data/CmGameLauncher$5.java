package com.tencent.mobileqq.apollo.process.data;

import android.app.Activity;
import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloSoLoaderImpl;
import com.tencent.qphone.base.util.QLog;

class CmGameLauncher$5
  implements IApolloSoLoader.OnCmSoLoadCompleteCallback
{
  CmGameLauncher$5(CmGameLauncher paramCmGameLauncher) {}
  
  public void a(int paramInt)
  {
    QLog.i("cmgame_process.CmGameLauncher", 1, "[onSoLoadComplete], ret:" + paramInt);
    ApolloSoLoaderImpl.removeLoadCallback(CmGameLauncher.a(this.a));
    Activity localActivity = this.a.a();
    if (paramInt == 0) {
      if ((localActivity != null) && (!CmGameLauncher.c(this.a)))
      {
        CmGameLauncher.a(this.a, true);
        CmGameLauncher.c(this.a);
      }
    }
    while (localActivity == null) {
      return;
    }
    localActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameLauncher.5
 * JD-Core Version:    0.7.0.1
 */