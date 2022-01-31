package com.tencent.biz.pubaccount.readinjoy.weaknet;

import bbmy;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import obz;
import ocg;
import org.json.JSONException;
import rns;
import rnt;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(rnt paramrnt, long paramLong) {}
  
  public void run()
  {
    rnt.a(this.this$0, null);
    if (rns.a())
    {
      bbmy.a(BaseApplicationImpl.sApplication, 1, 2131652796, 1).a();
      try
      {
        rns.a("0X8009D08", obz.a().a("loading_time", String.valueOf(this.a)).a());
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