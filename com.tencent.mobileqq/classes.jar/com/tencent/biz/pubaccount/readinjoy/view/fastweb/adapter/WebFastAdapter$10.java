package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebRecommendUGInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class WebFastAdapter$10
  implements Runnable
{
  WebFastAdapter$10(WebFastAdapter paramWebFastAdapter) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      int j = i;
      int k;
      if ((localObject instanceof ProteusItemData))
      {
        localObject = ((ProteusItemData)localObject).c;
        k = i;
        if (localObject != null)
        {
          k = i;
          j = i;
        }
      }
      for (;;)
      {
        try
        {
          if (((JSONObject)localObject).opt("id_recommend_category_txt") != null)
          {
            k = i;
            j = i;
            if (((JSONObject)localObject).optString("kd_ug_rsp_info") != null)
            {
              i = 1;
              k = 1;
              j = i;
              JSONObject localJSONObject = ((JSONObject)localObject).getJSONObject("id_recommend_category_txt");
              j = i;
              localJSONObject.put("text", new FastWebRecommendUGInfo(((JSONObject)localObject).optString("kd_ug_rsp_info")).f);
              j = i;
              localJSONObject.put("label_ug_progress_progress", 0);
            }
          }
          i = k;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
        }
        i = j;
      }
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.10
 * JD-Core Version:    0.7.0.1
 */