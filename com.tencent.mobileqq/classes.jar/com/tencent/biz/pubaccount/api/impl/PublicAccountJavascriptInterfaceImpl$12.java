package com.tencent.biz.pubaccount.api.impl;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

class PublicAccountJavascriptInterfaceImpl$12
  extends Thread
{
  PublicAccountJavascriptInterfaceImpl$12(PublicAccountJavascriptInterfaceImpl paramPublicAccountJavascriptInterfaceImpl, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    try
    {
      localObject3 = new JSONObject(this.jdField_a_of_type_JavaLangString);
      localObject2 = ((JSONObject)localObject3).optString("callid");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject2);
      localObject1 = localObject2;
      if (!bool) {
        localObject1 = ((String)localObject2).replace("\\", "\\\\").replace("'", "\\'");
      }
      this.jdField_a_of_type_OrgJsonJSONObject.put("callid", localObject1);
      localObject1 = ((JSONObject)localObject3).optString("url");
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject2 = this.this$0;
        localObject3 = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("{ret:1, response:");
        localStringBuilder.append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
        localStringBuilder.append("}");
        ((PublicAccountJavascriptInterfaceImpl)localObject2).callJs((String)localObject3, new String[] { localStringBuilder.toString() });
        localObject1 = PublicAccountJavascriptInterfaceImpl.access$500((String)localObject1);
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).replace("\\", "\\\\").replace("'", "\\'");
          this.jdField_a_of_type_OrgJsonJSONObject.put("data", localObject1);
          localObject1 = this.this$0;
          localObject2 = this.b;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("{ret:0, response:");
          ((StringBuilder)localObject3).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
          ((StringBuilder)localObject3).append("}");
          ((PublicAccountJavascriptInterfaceImpl)localObject1).callJs((String)localObject2, new String[] { ((StringBuilder)localObject3).toString() });
          return;
        }
        localObject1 = this.this$0;
        localObject2 = this.b;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("{ret:-10, response:");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
        ((StringBuilder)localObject3).append("}");
        ((PublicAccountJavascriptInterfaceImpl)localObject1).callJs((String)localObject2, new String[] { ((StringBuilder)localObject3).toString() });
        return;
      }
      localObject1 = this.this$0;
      localObject2 = this.b;
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("{ret:-4, response:");
      ((StringBuilder)localObject3).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
      ((StringBuilder)localObject3).append("}");
      ((PublicAccountJavascriptInterfaceImpl)localObject1).callJs((String)localObject2, new String[] { ((StringBuilder)localObject3).toString() });
      return;
    }
    catch (JSONException localJSONException)
    {
      Object localObject3;
      Object localObject2;
      Object localObject1;
      label375:
      break label375;
    }
    localObject1 = this.this$0;
    localObject2 = this.b;
    localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append("{ret:-2, response:");
    ((StringBuilder)localObject3).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
    ((StringBuilder)localObject3).append("}");
    ((PublicAccountJavascriptInterfaceImpl)localObject1).callJs((String)localObject2, new String[] { ((StringBuilder)localObject3).toString() });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.impl.PublicAccountJavascriptInterfaceImpl.12
 * JD-Core Version:    0.7.0.1
 */