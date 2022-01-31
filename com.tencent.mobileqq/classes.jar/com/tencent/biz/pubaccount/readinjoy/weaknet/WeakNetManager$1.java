package com.tencent.biz.pubaccount.readinjoy.weaknet;

import bcpw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import onk;
import onr;
import org.json.JSONException;
import saj;
import sak;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(sak paramsak, long paramLong) {}
  
  public void run()
  {
    sak.a(this.this$0, null);
    if (saj.a())
    {
      bcpw.a(BaseApplicationImpl.sApplication, 1, 2131718621, 1).a();
      try
      {
        saj.a("0X8009D08", onk.a().a("loading_time", String.valueOf(this.a)).a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */