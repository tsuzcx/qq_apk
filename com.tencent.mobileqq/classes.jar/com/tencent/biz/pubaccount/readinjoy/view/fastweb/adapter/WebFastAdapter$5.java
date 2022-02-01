package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import oix;
import org.json.JSONException;
import org.json.JSONObject;
import ssq;
import swa;

public class WebFastAdapter$5
  implements Runnable
{
  public WebFastAdapter$5(ssq paramssq, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    label316:
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (BaseData)localIterator.next();
        int j = i;
        if ((localObject1 instanceof ProteusItemData))
        {
          JSONObject localJSONObject = ((ProteusItemData)localObject1).c;
          j = i;
          if (localJSONObject != null)
          {
            j = i;
            if (localJSONObject.optString("kd_ug_rsp_info") != null)
            {
              swa localswa = new swa(localJSONObject.optString("kd_ug_rsp_info"), ssq.a(localJSONObject));
              if ((TextUtils.isEmpty(localswa.b)) || (!localswa.b.equals(this.a.d))) {
                continue;
              }
              j = i;
              try
              {
                if (localJSONObject.opt("id_recommend_category_txt") == null) {
                  break label316;
                }
                int k = 1;
                i = 1;
                j = i;
                localObject1 = localJSONObject.getJSONObject("id_recommend_category_txt");
                j = i;
                ((JSONObject)localObject1).put("text", localswa.g);
                j = i;
                ((JSONObject)localObject1).put("label_ug_progress_progress", 100);
                str = "";
                j = i;
                Object localObject3 = localJSONObject.opt("card_info");
                localObject1 = str;
                if (localObject3 != null) {}
                try
                {
                  localJSONObject = localJSONObject.getJSONObject("card_info");
                  localObject1 = str;
                  if (localJSONObject.opt("rowKey") != null) {
                    localObject1 = localJSONObject.getString("rowKey");
                  }
                }
                catch (JSONException localJSONException1)
                {
                  for (;;)
                  {
                    j = i;
                    localJSONException1.printStackTrace();
                    Object localObject2 = str;
                  }
                }
                j = i;
                oix.a(oix.a(localswa.a, (String)localObject1, "20"));
                j = i;
                oix.a(oix.a(localswa.a, (String)localObject1, "11"));
                i = k;
              }
              catch (JSONException localJSONException2)
              {
                String str;
                localJSONException2.printStackTrace();
              }
            }
          }
        }
        i = j;
      }
      else
      {
        if (i != 0) {
          this.this$0.notifyDataSetChanged();
        }
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.5
 * JD-Core Version:    0.7.0.1
 */