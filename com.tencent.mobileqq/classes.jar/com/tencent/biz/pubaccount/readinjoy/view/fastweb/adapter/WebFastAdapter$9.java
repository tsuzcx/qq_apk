package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import oqt;
import org.json.JSONException;
import org.json.JSONObject;
import tgb;
import tjl;

public class WebFastAdapter$9
  implements Runnable
{
  public WebFastAdapter$9(tgb paramtgb) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    label310:
    label312:
    for (;;)
    {
      int k;
      if (localIterator.hasNext())
      {
        Object localObject1 = (BaseData)localIterator.next();
        int j = i;
        if ((localObject1 instanceof ProteusItemData))
        {
          JSONObject localJSONObject = ((ProteusItemData)localObject1).c;
          k = i;
          if (localJSONObject != null)
          {
            j = i;
            k = i;
            try
            {
              if (localJSONObject.opt("id_recommend_category_txt") == null) {
                break label310;
              }
              j = i;
              k = i;
              if (localJSONObject.optString("kd_ug_rsp_info") == null) {
                break label310;
              }
              j = i;
              tjl localtjl = new tjl(localJSONObject.optString("kd_ug_rsp_info"));
              Object localObject3;
              if (i == 0)
              {
                str = "";
                j = i;
                localObject3 = localJSONObject.opt("card_info");
                localObject1 = str;
                if (localObject3 == null) {}
              }
              try
              {
                localObject3 = localJSONObject.getJSONObject("card_info");
                localObject1 = str;
                if (((JSONObject)localObject3).opt("rowKey") != null) {
                  localObject1 = ((JSONObject)localObject3).getString("rowKey");
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
              oqt.a(oqt.a(localtjl.a, (String)localObject1, "19"));
              j = i;
              oqt.a(oqt.a(localtjl.a, (String)localObject1, "106"));
              j = i;
              ThreadManager.getUIHandler().postDelayed(new WebFastAdapter.9.1(this), 200L);
              k = 1;
              i = 1;
              j = i;
              localObject1 = localJSONObject.getJSONObject("id_recommend_category_txt");
              j = i;
              ((JSONObject)localObject1).put("text", localtjl.g);
              j = i;
              ((JSONObject)localObject1).put("label_ug_progress_progress", 100);
            }
            catch (JSONException localJSONException2)
            {
              String str;
              localJSONException2.printStackTrace();
            }
          }
        }
        else
        {
          i = j;
          break label312;
        }
      }
      else
      {
        if (i != 0) {
          this.this$0.notifyDataSetChanged();
        }
        return;
      }
      i = k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.9
 * JD-Core Version:    0.7.0.1
 */