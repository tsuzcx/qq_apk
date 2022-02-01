package com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.open.downloadnew.DownloadInfo;
import java.util.Iterator;
import java.util.List;
import ogc;
import org.json.JSONException;
import org.json.JSONObject;
import sxt;

public class WebFastAdapter$5
  implements Runnable
{
  public WebFastAdapter$5(sxt paramsxt, DownloadInfo paramDownloadInfo) {}
  
  public void run()
  {
    Iterator localIterator = this.this$0.a().iterator();
    int i = 0;
    label277:
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
            localObject1 = localJSONObject.optString("kd_ug_download_url");
            if ((TextUtils.isEmpty((CharSequence)localObject1)) || (!((String)localObject1).equals(this.a.d))) {
              continue;
            }
            j = i;
            try
            {
              if (localJSONObject.opt("id_recommend_category_txt") == null) {
                break label277;
              }
              int k = 1;
              i = 1;
              j = i;
              localObject1 = localJSONObject.getJSONObject("id_recommend_category_txt");
              j = i;
              ((JSONObject)localObject1).put("text", "安装快报阅读");
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
              ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject1, "20"));
              j = i;
              ogc.a(ogc.a("https://qbdsp.html5.qq.com/ug/stat?st=CgBOEgABiDILFgcxMDY5Mjc2IiAAAAA2JTkuMTQ2LjE0NC42MV8xNTgzMTMzNDQ0Njk1XzExNTYyNzY1MTNCXlyzBFkMgAOdAAAbDBABJgY0MTk3NjI2CTY2NjY2NjY2NkYAUAFsqAw%3D&itemid=ARTICLE_ID&qq=USER_QQ&acttype=ACTION_TYPE", (String)localObject1, "11"));
              i = k;
            }
            catch (JSONException localJSONException2)
            {
              String str;
              localJSONException2.printStackTrace();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.adapter.WebFastAdapter.5
 * JD-Core Version:    0.7.0.1
 */