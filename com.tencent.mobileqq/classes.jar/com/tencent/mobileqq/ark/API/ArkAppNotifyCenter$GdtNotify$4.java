package com.tencent.mobileqq.ark.API;

import alpv;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ArkDispatchTask;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;
import yxo;
import yyp;
import yyq;
import yyr;

public class ArkAppNotifyCenter$GdtNotify$4
  implements Runnable
{
  public ArkAppNotifyCenter$GdtNotify$4(alpv paramalpv, WeakReference paramWeakReference, String paramString1, String paramString2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaLangRefWeakReference == null) || (this.jdField_a_of_type_JavaLangRefWeakReference.get() == null) || (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", null);
    }
    Object localObject2;
    do
    {
      return;
      try
      {
        localObject1 = new JSONObject(this.jdField_a_of_type_JavaLangString).optJSONObject("params");
        if (localObject1 == null) {
          continue;
        }
        localObject1 = ((JSONObject)localObject1).optString("businessIdForAidTicketAndTaidTicket");
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          Object localObject1;
          yyq localyyq;
          QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", localJSONException);
          localObject2 = null;
        }
        localObject2 = yxo.a(localObject2.a);
      }
      localyyq = new yyq();
      localyyq.jdField_a_of_type_JavaLangString = ((String)localObject1);
      localObject1 = yyp.a((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), localyyq);
      if ((localObject1 == null) || (((yyr)localObject1).a == null))
      {
        QLog.e("ark.ArkAppNotifyCenter", 1, "ark get_device_info error", null);
        return;
      }
    } while ((localObject2 == null) || (!(localObject2 instanceof JSONObject)));
    ArkAppCenter.a().postToArkThread(new ArkAppNotifyCenter.GdtNotify.4.1(this, localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppNotifyCenter.GdtNotify.4
 * JD-Core Version:    0.7.0.1
 */