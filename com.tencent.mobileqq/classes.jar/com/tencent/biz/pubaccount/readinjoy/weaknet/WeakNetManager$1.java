package com.tencent.biz.pubaccount.readinjoy.weaknet;

import bcql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import onh;
import ono;
import org.json.JSONException;
import sag;
import sah;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(sah paramsah, long paramLong) {}
  
  public void run()
  {
    sah.a(this.this$0, null);
    if (sag.a())
    {
      bcql.a(BaseApplicationImpl.sApplication, 1, 2131718632, 1).a();
      try
      {
        sag.a("0X8009D08", onh.a().a("loading_time", String.valueOf(this.a)).a());
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