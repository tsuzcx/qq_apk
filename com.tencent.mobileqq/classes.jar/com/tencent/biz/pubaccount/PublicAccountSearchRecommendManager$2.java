package com.tencent.biz.pubaccount;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.app.MobileQQ;
import nom;
import nop;
import org.json.JSONArray;
import org.json.JSONObject;

public class PublicAccountSearchRecommendManager$2
  implements Runnable
{
  public PublicAccountSearchRecommendManager$2(nom paramnom, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    SharedPreferences localSharedPreferences = this.a.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + this.a.getCurrentAccountUin(), 0);
    if (localSharedPreferences != null) {
      try
      {
        localObject1 = new JSONArray();
        localObject2 = nom.b(this.this$0).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          nop localnop = (nop)((Iterator)localObject2).next();
          JSONObject localJSONObject = new JSONObject();
          localJSONObject.put("uin", localnop.jdField_a_of_type_JavaLangString);
          localJSONObject.put("name", localnop.b);
          localJSONObject.put("time", localnop.jdField_a_of_type_Long);
          localJSONObject.put("isPA", localnop.jdField_a_of_type_Boolean);
          ((JSONArray)localObject1).put(localJSONObject);
          continue;
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d(nom.b(this.this$0), 2, "saveHistoryListToLocal->error:" + localException);
        }
        localException.printStackTrace();
      }
    }
    Object localObject2 = new JSONObject();
    ((JSONObject)localObject2).put("search_history_list", localObject1);
    Object localObject1 = ((JSONObject)localObject2).toString();
    if (QLog.isColorLevel()) {
      QLog.d(nom.b(this.this$0), 2, "saveHistoryListToLocal->json:" + (String)localObject1);
    }
    SharedPreferences.Editor localEditor = localException.edit();
    localEditor.putString("public_account_search_history", (String)localObject1);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.2
 * JD-Core Version:    0.7.0.1
 */