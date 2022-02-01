package com.tencent.biz.pubaccount.readinjoy.pts.nativemodule;

import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.pts.nativemodule.PTSNativeModuleRegistry.IPTSMarkArticleRead;
import com.tencent.qphone.base.util.QLog;

public class PTSMarkArticleReadModule
  implements PTSNativeModuleRegistry.IPTSMarkArticleRead
{
  public void markArticleRead(long paramLong1, long paramLong2)
  {
    QLog.i("PTSMarkArticleReadModule", 1, "[markArticleRead], articleID = " + paramLong1 + ", channelID = " + paramLong2);
    try
    {
      ReadInJoyLogicEngine.a().a(paramLong1, System.currentTimeMillis());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PTSMarkArticleReadModule", 1, "[markArticleRead], e = " + localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.pts.nativemodule.PTSMarkArticleReadModule
 * JD-Core Version:    0.7.0.1
 */