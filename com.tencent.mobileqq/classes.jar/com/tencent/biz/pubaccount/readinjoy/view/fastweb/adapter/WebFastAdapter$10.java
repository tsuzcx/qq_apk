package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import rzv;

public class WebFastAdapter$10
  implements Runnable
{
  public WebFastAdapter$10(rzv paramrzv) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      int j = i;
      if ((localObject instanceof ProteusItemData))
      {
        localObject = ((ProteusItemData)localObject).c;
        j = i;
        if (localObject != null) {
          j = i;
        }
      }
      for (;;)
      {
        try
        {
          if (((JSONObject)localObject).opt("id_recommend_category_txt") != null)
          {
            int k = 1;
            j = 1;
            i = k;
            localObject = ((JSONObject)localObject).getJSONObject("id_recommend_category_txt");
            i = k;
            ((JSONObject)localObject).put("text", "下载快报阅读");
            i = k;
            ((JSONObject)localObject).put("label_ug_progress_progress", 0);
          }
          i = j;
        }
        catch (JSONException localJSONException)
        {
          localJSONException.printStackTrace();
          j = i;
        }
        i = j;
      }
    }
    if (i != 0) {
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.10
 * JD-Core Version:    0.7.0.1
 */