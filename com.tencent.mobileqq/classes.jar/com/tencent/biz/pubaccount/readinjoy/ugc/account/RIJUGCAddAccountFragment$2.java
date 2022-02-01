package com.tencent.biz.pubaccount.readinjoy.ugc.account;

import com.tencent.qphone.base.util.QLog;
import oat;
import org.json.JSONException;
import pha;
import phi;

final class RIJUGCAddAccountFragment$2
  implements Runnable
{
  public void run()
  {
    try
    {
      oat.a(null, "CliOper", "", "", "0X800AF12", "0X800AF12", 0, 0, "", "", "", pha.a().a("uin", pha.a()).a(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(RIJUGCAddAccountFragment.b(), 1, "[deliverTipsExposureReport] error, e = " + localJSONException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment.2
 * JD-Core Version:    0.7.0.1
 */