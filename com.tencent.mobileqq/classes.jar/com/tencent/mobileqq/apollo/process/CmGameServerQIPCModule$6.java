package com.tencent.mobileqq.apollo.process;

import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.ApolloLoadResTask;
import com.tencent.mobileqq.apollo.api.res.impl.ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.List;

class CmGameServerQIPCModule$6
  implements ApolloResDownloaderImpl.OnApolloDownLoadListenerForTaskList
{
  CmGameServerQIPCModule$6(CmGameServerQIPCModule paramCmGameServerQIPCModule, int paramInt) {}
  
  public void a(boolean paramBoolean, String paramString, int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    if (paramBoolean) {}
    for (paramInt1 = 0;; paramInt1 = -1)
    {
      paramString = EIPCResult.createResult(paramInt1, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, List<ApolloResDownloaderImpl.ApolloLoadResTask> paramList)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = -1)
    {
      paramString = EIPCResult.createResult(i, null);
      this.jdField_a_of_type_ComTencentMobileqqApolloProcessCmGameServerQIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      QLog.i("cmgame_process.CmGameServerQIPCModule", 2, "onDownLoadFinish onDownLoadFinish sucess:" + paramBoolean);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.6
 * JD-Core Version:    0.7.0.1
 */