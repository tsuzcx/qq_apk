package com.tencent.mobileqq.apollo.process.chanel;

import alvx;
import alwt;
import amgo;
import amip;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(alwt paramalwt, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + amip.af + ", ApolloConstant.sGameAVSoMd5=" + amip.ag);
    amgo.a().a(this.this$0.a);
    amgo.a().a(0, amip.af, amip.ag);
    amgo.a().a(BaseApplicationImpl.getContext(), alvx.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */