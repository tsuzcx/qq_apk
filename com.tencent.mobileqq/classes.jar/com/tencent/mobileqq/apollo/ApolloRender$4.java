package com.tencent.mobileqq.apollo;

import babp;
import bajr;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ApolloRender$4
  implements Runnable
{
  ApolloRender$4(ApolloRender paramApolloRender, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public void run()
  {
    try
    {
      Object localObject2 = babp.i();
      String str = babp.e();
      int i = babp.b();
      long l1 = babp.a();
      long l2 = Math.ceil(babp.d() / 1073741824.0D);
      long l3 = babp.k();
      long l4 = babp.l();
      float f = babp.a();
      Object localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("mo", localObject2);
      ((JSONObject)localObject1).put("os", str);
      ((JSONObject)localObject1).put("cc", String.valueOf(i));
      ((JSONObject)localObject1).put("cf", String.valueOf(l1));
      ((JSONObject)localObject1).put("mm", String.valueOf(l2));
      ((JSONObject)localObject1).put("w", String.valueOf(l3));
      ((JSONObject)localObject1).put("h", String.valueOf(l4));
      ((JSONObject)localObject1).put("d", String.valueOf(f));
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("vd", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("vs", this.b);
      ((JSONObject)localObject2).put("rd", this.c);
      localObject1 = ((JSONObject)localObject1).toString();
      localObject2 = ((JSONObject)localObject2).toString();
      bajr.a(null, "cmshow", "Apollo", "device_info", 0, 0, new String[] { String.valueOf(this.jdField_a_of_type_Int), localObject1, localObject2 });
      QLog.i("sava_ApolloRender", 1, " onSurfaceCreated report 644 data: " + (String)localObject1 + ";" + (String)localObject2);
      return;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("sava_ApolloRender", 2, " onSurfaceCreated report 644 data fail: " + localJSONException.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloRender.4
 * JD-Core Version:    0.7.0.1
 */