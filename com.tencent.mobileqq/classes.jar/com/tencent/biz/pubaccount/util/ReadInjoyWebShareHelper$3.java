package com.tencent.biz.pubaccount.util;

import android.app.Activity;
import begz;
import com.tencent.common.app.AppInterface;
import java.util.HashMap;
import ndd;
import org.json.JSONObject;
import szc;

public class ReadInjoyWebShareHelper$3
  implements Runnable
{
  public ReadInjoyWebShareHelper$3(szc paramszc, HashMap paramHashMap, String paramString1, String paramString2, JSONObject paramJSONObject, String paramString3, String paramString4, String paramString5) {}
  
  public void run()
  {
    Object localObject2 = ndd.a(this.jdField_a_of_type_JavaUtilHashMap);
    Object localObject1 = (String)((HashMap)localObject2).get("share_url");
    if (localObject1 == null) {
      localObject1 = this.jdField_a_of_type_JavaLangString;
    }
    for (;;)
    {
      String str = (String)((HashMap)localObject2).get("image_url");
      localObject2 = str;
      if (str == null) {
        localObject2 = this.b;
      }
      localObject1 = new ReadInjoyWebShareHelper.3.1(this, (String)localObject1, (String)localObject2);
      if (szc.a(this.this$0).getClass().getName().equalsIgnoreCase("com.tencent.qqreadinjoy.detailspage.ReadInJoyArticleDetailActivity"))
      {
        szc.a(this.this$0).runOnUiThread((Runnable)localObject1);
        return;
      }
      szc.a(this.this$0).a().runOnUiThread((Runnable)localObject1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ReadInjoyWebShareHelper.3
 * JD-Core Version:    0.7.0.1
 */