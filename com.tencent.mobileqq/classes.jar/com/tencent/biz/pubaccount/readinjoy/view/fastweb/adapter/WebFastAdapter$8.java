package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tgb;
import tjl;

public class WebFastAdapter$8
  implements Runnable
{
  public WebFastAdapter$8(tgb paramtgb, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = (BaseData)localIterator.next();
      int j = i;
      JSONObject localJSONObject;
      if ((localObject instanceof ProteusItemData))
      {
        localJSONObject = ((ProteusItemData)localObject).c;
        j = i;
        if (localJSONObject != null)
        {
          j = i;
          if (localJSONObject.optString("kd_ug_rsp_info") != null)
          {
            localObject = new tjl(localJSONObject.optString("kd_ug_rsp_info"), tgb.a(localJSONObject));
            if ((TextUtils.isEmpty(((tjl)localObject).b)) || (!((tjl)localObject).b.equals(this.a.d))) {
              continue;
            }
            j = i;
          }
        }
      }
      for (;;)
      {
        try
        {
          if (localJSONObject.opt("id_recommend_category_txt") != null)
          {
            int k = 1;
            j = 1;
            i = k;
            localJSONObject = localJSONObject.getJSONObject("id_recommend_category_txt");
            i = k;
            localJSONObject.put("text", ((tjl)localObject).i);
            i = k;
            localJSONObject.put("label_ug_progress_progress", this.a.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.8
 * JD-Core Version:    0.7.0.1
 */