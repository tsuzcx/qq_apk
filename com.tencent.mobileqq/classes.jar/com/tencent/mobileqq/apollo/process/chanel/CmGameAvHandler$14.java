package com.tencent.mobileqq.apollo.process.chanel;

import anbd;
import anbz;
import anlu;
import annv;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(anbz paramanbz, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + annv.af + ", ApolloConstant.sGameAVSoMd5=" + annv.ag);
    anlu.a().a(this.this$0.a);
    anlu.a().a(0, annv.af, annv.ag);
    anlu.a().a(BaseApplicationImpl.getContext(), anbd.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */