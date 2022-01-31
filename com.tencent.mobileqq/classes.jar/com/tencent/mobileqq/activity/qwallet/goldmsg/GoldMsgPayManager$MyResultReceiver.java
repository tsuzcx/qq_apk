package com.tencent.mobileqq.activity.qwallet.goldmsg;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.qphone.base.util.QLog;

public class GoldMsgPayManager$MyResultReceiver
  extends ResultReceiver
{
  private GoldMsgPayManager a;
  
  public GoldMsgPayManager$MyResultReceiver(Handler paramHandler, GoldMsgPayManager paramGoldMsgPayManager)
  {
    super(paramHandler);
    this.a = paramGoldMsgPayManager;
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    String str1;
    long l;
    String str2;
    if (this.a != null)
    {
      str1 = paramBundle.getString("_qwallet_payparams_sn");
      l = paramBundle.getLong("vacreport_key_seq", 0L);
      str2 = paramBundle.getString("retmsg");
      if (QLog.isColorLevel())
      {
        this.a.getClass();
        QLog.d("GoldMsg", 2, "onReceiveResult resultCode:" + paramInt + " msgseq:" + str1);
      }
      if (paramInt == 99999) {
        this.a.a(str1);
      }
    }
    else
    {
      return;
    }
    VACDReportUtil.endReport(l, "payEnd", null, paramInt, str2);
    this.a.a(str1, paramInt, paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.goldmsg.GoldMsgPayManager.MyResultReceiver
 * JD-Core Version:    0.7.0.1
 */