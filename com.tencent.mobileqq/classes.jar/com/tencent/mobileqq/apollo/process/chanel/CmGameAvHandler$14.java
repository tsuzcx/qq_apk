package com.tencent.mobileqq.apollo.process.chanel;

import akwd;
import akxb;
import algt;
import aliu;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;

public class CmGameAvHandler$14
  implements Runnable
{
  public CmGameAvHandler$14(akxb paramakxb, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    QLog.e("CmGameAvHandler", 1, "initAudioRoom ApolloConstant.sGameAVSoUrl=" + aliu.af + ", ApolloConstant.sGameAVSoMd5=" + aliu.ag);
    algt.a().a(this.this$0.a);
    algt.a().a(0, aliu.af, aliu.ag);
    algt.a().a(BaseApplicationImpl.getContext(), akwd.a().getCurrentAccountUin(), "" + this.a, "" + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.CmGameAvHandler.14
 * JD-Core Version:    0.7.0.1
 */