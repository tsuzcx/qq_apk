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
    ApolloSoLoaderImpl.removeLoadCallback(CmGameLauncher.a(this.a));
    localObject = this.a.a();
    if (paramInt == 0)
    {
      if ((localObject != null) && (!CmGameLauncher.c(this.a)))
      {
        CmGameLauncher.a(this.a, true);
        CmGameLauncher.c(this.a);
      }
    }
    else if (localObject != null) {
      ((Activity)localObject).finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameLauncher.5
 * JD-Core Version:    0.7.0.1
 */