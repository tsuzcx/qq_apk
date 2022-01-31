package com.tencent.mobileqq.apollo.process.data;

import ajcb;
import ajnc;
import android.app.Activity;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

public class CmGameCommonShare$3
  implements Runnable
{
  public CmGameCommonShare$3(ajcb paramajcb) {}
  
  public void run()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject(ajcb.a(this.this$0));
      localJSONObject.put("gameId", ajcb.a(this.this$0));
      localJSONObject.put("isSelectFriend", 1);
      ajnc.a(ajcb.a(this.this$0), localJSONObject.toString(), (Activity)ajcb.a(this.this$0).get());
      return;
    }
    catch (Exception localException)
    {
      QLog.e("apollo_cmGame_CmGameCommonShare", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameCommonShare.3
 * JD-Core Version:    0.7.0.1
 */