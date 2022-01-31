package com.tencent.mobileqq.apollo.process.chanel;

import aimn;
import aipd;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class GeneralEventHandler$1
  implements Runnable
{
  public GeneralEventHandler$1(aipd paramaipd, String paramString) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(this.a);
      String str1 = localJSONObject.optString("friendUin");
      String str2 = localJSONObject.optString("nickName");
      int i = localJSONObject.optInt("src");
      aimn.a((QQAppInterface)aipd.a(this.this$0).get(), str1, str2, i);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollochannel_GeneralEventHandler", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.chanel.GeneralEventHandler.1
 * JD-Core Version:    0.7.0.1
 */