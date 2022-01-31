package com.tencent.mobileqq.apollo.process.chanel;

import akro;
import aksm;
import alce;
import alef;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(aksm paramaksm, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + alef.af + ", ApolloConstant.sGameAVSoMd5=" + alef.ag);
    alce.a().a(this.this$0.a);
    alce.a().a(0, alef.af, alef.ag);
    alce.a().a(BaseApplicationImpl.getContext(), akro.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */