package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import pqf;
import pqg;
import udb;
import udc;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(udc paramudc, long paramLong) {}
  
  public void run()
  {
    udc.a(this.this$0, null);
    if (udb.a())
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131717972, 1).a();
      try
      {
        udb.a("0X8009D08", pqf.a().a("loading_time", String.valueOf(this.a)).a());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.weaknet.WeakNetManager.1
 * JD-Core Version:    0.7.0.1
 */