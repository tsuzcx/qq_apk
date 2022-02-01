package com.tencent.mobileqq.apollo.store;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.statistics.ReportController;
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
    ReportController.b(null, "P_CliOper", "WebStatusReport", "", "", this.jdField_a_of_type_JavaLangString, 0, 1, this.this$0.mCurrentStep, this.this$0.mCurrentUrl, Build.VERSION.RELEASE, String.valueOf(this.this$0.mCurrentStepTime - this.this$0.mClickTime), String.valueOf(System.currentTimeMillis() - this.this$0.mClickTime));
    Object localObject1 = ApolloBaseActivity.access$000(this.this$0).getAll();
    if (QLog.isColorLevel()) {
      QLog.d("ApolloBaseActivity", 2, "mClickTime->" + this.this$0.mClickTime + " mCurrentStepTime - mClickTime->" + (this.this$0.mCurrentStepTime - this.this$0.mClickTime) + " mCurrentStep->" + this.this$0.mCurrentStep);
    }
    Object localObject2;
    if (this.jdField_a_of_type_Int != 1)
    {
      if (localObject1 != null)
      {
        localObject2 = String.valueOf(this.this$0.mOnCreateMilliTimeStamp);
        if (((Map)localObject1).containsKey(localObject2)) {
          ApolloBaseActivity.access$000(this.this$0).edit().remove((String)localObject2).commit();
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
        if (!((String)((Map.Entry)localObject2).getKey()).equalsIgnoreCase(String.valueOf(this.this$0.mOnCreateMilliTimeStamp)))
        {
          localObject2 = String.valueOf(((Map.Entry)localObject2).getValue());
          ReportController.b(null, "P_CliOper", "WebStatusReport", "", "hard code unknown", this.jdField_a_of_type_JavaLangString, 0, 1, 100, (String)localObject2, Build.VERSION.RELEASE, "100", "200");
        }
      }
    }
    ApolloBaseActivity.access$000(this.this$0).edit().clear().commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloBaseActivity.1
 * JD-Core Version:    0.7.0.1
 */