package com.tencent.biz.pubaccount.readinjoy.model;

import java.util.List;
import oat;
import org.json.JSONException;
import org.json.JSONObject;
import qni;

public class ArticleInfoModule$4
  implements Runnable
{
  public void run()
  {
    long l2 = -1L;
    long l1 = l2;
    try
    {
      if (this.jdField_a_of_type_Qni.b != null)
      {
        l1 = l2;
        if (this.jdField_a_of_type_Qni.b.size() > 0) {
          l1 = ((Long)this.jdField_a_of_type_Qni.b.get(0)).longValue();
        }
      }
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("hit_preload_red_pnt_push_cache", this.jdField_a_of_type_Int);
      localJSONObject.put("preload_red_pnt_push_articleID", l1);
      oat.a(null, "", "0X8009410", "0X8009410", 0, 0, localJSONObject.toString(), "", "", "", false);
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule.4
 * JD-Core Version:    0.7.0.1
 */