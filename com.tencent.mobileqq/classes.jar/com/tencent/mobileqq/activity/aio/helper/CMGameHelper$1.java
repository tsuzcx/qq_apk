package com.tencent.mobileqq.activity.aio.helper;

import com.tencent.mobileqq.apollo.process.data.CmGameMainManager;
import com.tencent.mobileqq.apollo.view.ApolloGameWrapper.CheckGameListener;

class CMGameHelper$1
  implements ApolloGameWrapper.CheckGameListener
{
  CMGameHelper$1(CMGameHelper paramCMGameHelper) {}
  
  public void a(boolean paramBoolean, CmGameMainManager paramCmGameMainManager)
  {
    if ((paramBoolean) && (paramCmGameMainManager != null)) {
      paramCmGameMainManager.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.CMGameHelper.1
 * JD-Core Version:    0.7.0.1
 */