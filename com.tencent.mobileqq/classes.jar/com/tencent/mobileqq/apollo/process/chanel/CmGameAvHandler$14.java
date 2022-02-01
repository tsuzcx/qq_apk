package com.tencent.mobileqq.apollo.process.chanel;

import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper;
import com.tencent.qphone.base.util.QLog;

class CmGameAvHandler$14
  implements Runnable
{
  CmGameAvHandler$14(CmGameAvHandler paramCmGameAvHandler, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + ApolloConstant.s + ", ApolloConstant.sGameAVSoMd5=" + ApolloConstant.t);
    AVEngineWalper.a().a(this.this$0.a);
    AVEngineWalper.a().a(0, ApolloConstant.s, ApolloConstant.t);
    AVEngineWalper.a().a(BaseApplicationImpl.getContext(), CmGameUtil.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */