package com.tencent.mobileqq.apollo.process.data;

import aktn;
import alep;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameCommonShare$3
  implements Runnable
{
  public CmGameCommonShare$3(aktn paramaktn) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(aktn.a(this.this$0));
      localJSONObject.put("gameId", aktn.a(this.this$0));
      localJSONObject.put("isSelectFriend", 1);
      alep.a(aktn.a(this.this$0), localJSONObject.toString(), (Activity)aktn.a(this.this$0).get());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.3
 * JD-Core Version:    0.7.0.1
 */