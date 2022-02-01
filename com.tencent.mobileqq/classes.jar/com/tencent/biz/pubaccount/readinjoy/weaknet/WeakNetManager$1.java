package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import pay;
import pbg;
import tpm;
import tpn;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(tpn paramtpn, long paramLong) {}
  
  public void run()
  {
    tpn.a(this.this$0, null);
    if (tpm.a())
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131717605, 1).a();
      try
      {
        tpm.a("0X8009D08", pay.a().a("loading_time", String.valueOf(this.a)).a());
        QLog.d("WeakNetManager", 1, "show weak net toast.");
        return;
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("WeakNetManager", 1, "show weak net data report exception, e = ", localJSONException);
        }
      }
    }
    QLog.d("WeakNetManager", 1, "no need to show toast.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */