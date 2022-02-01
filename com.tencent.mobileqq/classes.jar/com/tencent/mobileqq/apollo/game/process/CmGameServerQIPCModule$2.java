package com.tencent.mobileqq.apollo.game.process;

import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import com.tencent.qphone.base.util.QLog;

class CmGameServerQIPCModule$2
  implements ApolloRspCallback
{
  CmGameServerQIPCModule$2(CmGameServerQIPCModule paramCmGameServerQIPCModule, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("openCMShowIfNeed setUserApolloModel ");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(": ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(", ");
    localStringBuilder.append(paramString);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 2, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.CmGameServerQIPCModule.2
 * JD-Core Version:    0.7.0.1
 */