package com.tencent.mobileqq.apollo.process.chanel;

import ajae;
import ajbc;
import ajku;
import ajmu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(ajbc paramajbc, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + ajmu.af + ", ApolloConstant.sGameAVSoMd5=" + ajmu.ag);
    ajku.a().a(this.this$0.a);
    ajku.a().a(0, ajmu.af, ajmu.ag);
    ajku.a().a(BaseApplicationImpl.getContext(), ajae.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */