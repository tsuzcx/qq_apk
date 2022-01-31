package com.tencent.mobileqq.apollo.process.ui;

import ajdq;
import ajdy;
import android.text.TextUtils;
import org.json.JSONObject;

public class CmGameDialog$1
  implements Runnable
{
  public CmGameDialog$1(ajdq paramajdq, String paramString1, String paramString2, ajdy paramajdy, JSONObject paramJSONObject) {}
  
  public void run()
  {
    if ((!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) && (!TextUtils.isEmpty(this.b)) && (this.jdField_a_of_type_Ajdy != null))
    {
      if (!"toast".equals(this.jdField_a_of_type_JavaLangString)) {
        break label106;
      }
      if (!"show".equals(this.b)) {
        break label82;
      }
      this.this$0.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_OrgJsonJSONObject.optInt("duration", -1), this.jdField_a_of_type_Ajdy);
    }
    label81:
    label82:
    label106:
    do
    {
      do
      {
        do
        {
          break label81;
          do
          {
            return;
          } while (!"hide".equals(this.b));
          this.this$0.b(this.jdField_a_of_type_Ajdy);
          return;
          if (!"alert".equals(this.jdField_a_of_type_JavaLangString)) {
            break;
          }
          if ("show".equals(this.b)) {
            this.this$0.b(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_OrgJsonJSONObject.optString("content"), this.jdField_a_of_type_Ajdy);
          }
        } while (!"hide".equals(this.b));
        this.this$0.b();
        return;
      } while (!"loading".equals(this.jdField_a_of_type_JavaLangString));
      if ("show".equals(this.b)) {
        this.this$0.a(this.jdField_a_of_type_OrgJsonJSONObject.optString("title"), this.jdField_a_of_type_Ajdy);
      }
    } while (!"hide".equals(this.b));
    this.this$0.a(this.jdField_a_of_type_Ajdy);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.CmGameDialog.1
 * JD-Core Version:    0.7.0.1
 */