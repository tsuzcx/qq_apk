package com.tencent.mobileqq.apollo.store;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import bcef;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class ApolloBaseActivity$1
  implements Runnable
{
  ApolloBaseActivity$1(ApolloBaseActivity paramApolloBaseActivity, String paramString, int paramInt) {}
  
  public void run()
  {
    bcef.b(null, "P_CliOper", "WebStatusReport", "", "", this.jdField_a_of_type_JavaLangString, 0, 1, this.this$0.jdField_a_of_type_Int, this.this$0.jdField_a_of_type_JavaLangString, Build.VERSION.RELEASE, String.valueOf(this.this$0.f - this.this$0.g), String.valueOf(System.currentTimeMillis() - this.this$0.g));
    Object localObject1 = ApolloBaseActivity.a(this.this$0).getAll();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.this$0.g + " mCurrentStepTime - mClickTime->" + (this.this$0.f - this.this$0.g) + " mCurrentStep->" + this.this$0.jdField_a_of_type_Int);
    }
    Object localObject2;
    if (this.jdField_a_of_type_Int != 1)
    {
      if (localObject1 != null)
      {
        localObject2 = String.valueOf(this.this$0.jdField_a_of_type_Long);
        if (((Map)localObject1).containsKey(localObject2)) {
          ApolloBaseActivity.a(this.this$0).edit().remove((String)localObject2).commit();
        }
      }
      return;
    }
    localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Map.Entry)((Iterator)localObject1).next();
      if ((((Map.Entry)localObject2).getValue() instanceof String))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloBaseActivity_report", 2, "current url:" + String.valueOf(((Map.Entry)localObject2).getValue()) + "\n current key:" + (String)((Map.Entry)localObject2).getKey());
        }
        if (!((String)((Map.Entry)localObject2).getKey()).equalsIgnoreCase(String.valueOf(this.this$0.jdField_a_of_type_Long)))
        {
          localObject2 = String.valueOf(((Map.Entry)localObject2).getValue());
          bcef.b(null, "P_CliOper", "WebStatusReport", "", "hard code unknown", this.jdField_a_of_type_JavaLangString, 0, 1, 100, (String)localObject2, Build.VERSION.RELEASE, "100", "200");
        }
      }
    }
    ApolloBaseActivity.a(this.this$0).edit().clear().commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */