package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.api.res.IApolloSoLoader.OnCmSoLoadCompleteCallback;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

final class CmShowTest$1
  implements IApolloSoLoader.OnCmSoLoadCompleteCallback
{
  public void a(int paramInt)
  {
    ThreadManager.getUIHandler().post(new CmShowTest.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowTest.1
 * JD-Core Version:    0.7.0.1
 */