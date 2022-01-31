package com.tencent.mobileqq.apollo.process.chanel;

import ajac;
import ajba;
import ajks;
import ajms;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(ajba paramajba, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + ajms.af + ", ApolloConstant.sGameAVSoMd5=" + ajms.ag);
    ajks.a().a(this.this$0.a);
    ajks.a().a(0, ajms.af, ajms.ag);
    ajks.a().a(BaseApplicationImpl.getContext(), ajac.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */