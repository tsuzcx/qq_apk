package com.tencent.biz.pubaccount.readinjoy.weaknet;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import ors;
import orz;
import srr;
import srs;

public class WeakNetManager$1
  implements Runnable
{
  public WeakNetManager$1(srs paramsrs, long paramLong) {}
  
  public void run()
  {
    srs.a(this.this$0, null);
    if (srr.a())
    {
      QQToast.a(BaseApplicationImpl.sApplication, 1, 2131719113, 1).a();
      try
      {
        srr.a("0X8009D08", ors.a().a("loading_time", String.valueOf(this.a)).a());
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