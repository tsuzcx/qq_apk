package com.tencent.mobileqq.apollo.process.chanel;

import aing;
import aioe;
import aiws;
import aiys;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(aioe paramaioe, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + aiys.af + ", ApolloConstant.sGameAVSoMd5=" + aiys.ag);
    aiws.a().a(this.this$0.a);
    aiws.a().a(0, aiys.af, aiys.ag);
    aiws.a().a(BaseApplicationImpl.getContext(), aing.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */