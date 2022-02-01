package com.tencent.mobileqq.apollo.game.process.data;

import android.app.Activity;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloSoLoaderImpl;
import com.tencent.qphone.base.util.QLog;

class CmGameLauncher$5
  implements IApolloSoLoader.OnCmSoLoadCompleteCallback
{
  CmGameLauncher$5(CmGameLauncher paramCmGameLauncher) {}
  
  public void a(int paramInt)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[onSoLoadComplete], ret:");
    ((StringBuilder)localObject).append(paramInt);
    QLog.i("cmgame_process.CmGameLauncher", 1, ((StringBuilder)localObject).toString());
    ApolloSoLoaderImpl.removeLoadCallback(CmGameLauncher.f(this.a));
    localObject = this.a.f();
    if (localObject == null) {
      return;
    }
    if (paramInt == 0)
    {
      if (!CmGameLauncher.g(this.a))
      {
        CmGameLauncher.a(this.a, true);
        CmGameLauncher.h(this.a);
      }
    }
    else {
      ((Activity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.5
 * JD-Core Version:    0.7.0.1
 */