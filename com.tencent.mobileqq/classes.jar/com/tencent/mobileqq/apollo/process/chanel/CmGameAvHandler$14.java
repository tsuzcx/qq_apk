package com.tencent.mobileqq.apollo.process.chanel;

import ampj;
import amqf;
import anaa;
import ancb;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(amqf paramamqf, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + ancb.af + ", ApolloConstant.sGameAVSoMd5=" + ancb.ag);
    anaa.a().a(this.this$0.a);
    anaa.a().a(0, ancb.af, ancb.ag);
    anaa.a().a(BaseApplicationImpl.getContext(), ampj.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */