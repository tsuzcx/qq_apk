package com.tencent.mobileqq.apollo.process.chanel;

import amwn;
import amxj;
import anhw;
import anka;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(amxj paramamxj, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + anka.s + ", ApolloConstant.sGameAVSoMd5=" + anka.t);
    anhw.a().a(this.this$0.a);
    anhw.a().a(0, anka.s, anka.t);
    anhw.a().a(BaseApplicationImpl.getContext(), amwn.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */