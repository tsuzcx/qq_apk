package com.tencent.biz.pubaccount.readinjoy.config.handlers;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.aladdin.config.handlers.SimpleConfigHandler;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;

public class DailyDynamicHeaderConfigHandler
  extends SimpleConfigHandler
{
  public boolean onReceiveConfig(int paramInt1, int paramInt2, String paramString)
  {
    boolean bool = super.onReceiveConfig(paramInt1, paramInt2, paramString);
    paramString = Aladdin.getConfig(paramInt1).getString("daily_header_proteus_bid", "0");
    ReadInJoyHelper.a("daily_header_proteus_bid", paramString);
    QLog.i("DailyDynamicHeaderConfig", 2, "update bid=" + paramString);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyDynamicHeaderConfigHandler
 * JD-Core Version:    0.7.0.1
 */