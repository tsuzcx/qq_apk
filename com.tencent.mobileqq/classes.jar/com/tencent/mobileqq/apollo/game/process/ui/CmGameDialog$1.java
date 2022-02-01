package com.tencent.mobileqq.apollo.game.process.ui;

import android.text.TextUtils;
import org.json.JSONObject;

class CmGameDialog$1
  implements Runnable
{
  CmGameDialog$1(CmGameDialog paramCmGameDialog, String paramString1, String paramString2, NativeUIManager paramNativeUIManager, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager != null)) {
      if ("toast".equals(this.jdField_a_of_type_JavaLangString))
      {
        if ("show".equals(this.b))
        {
          this.this$0.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_OrgJsonJSONObject.optInt("duration", -1), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager);
          return;
        }
        if ("hide".equals(this.b)) {
          this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager);
        }
      }
      else if ("alert".equals(this.jdField_a_of_type_JavaLangString))
      {
        if ("show".equals(this.b)) {
          this.this$0.b(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_OrgJsonJSONObject.optString("content"), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager);
        }
        if ("hide".equals(this.b)) {
          this.this$0.b();
        }
      }
      else if ("loading".equals(this.jdField_a_of_type_JavaLangString))
      {
        if ("show".equals(this.b)) {
          this.this$0.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager);
        }
        if ("hide".equals(this.b)) {
          this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqApolloGameProcessUiNativeUIManager);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.CmGameDialog.1
 * JD-Core Version:    0.7.0.1
 */