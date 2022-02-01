package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat;

import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import ocd;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyDynamicChannelFragment$4
  implements Runnable
{
  ReadInJoyDynamicChannelFragment$4(ReadInJoyDynamicChannelFragment paramReadInJoyDynamicChannelFragment, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (BaseArticleInfo)localIterator.next();
        Object localObject1 = ((BaseArticleInfo)localObject2).mProteusTemplateBean;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("channel_id", ReadInJoyDynamicChannelFragment.m(this.this$0));
          localJSONObject.put("article_id", ((BaseArticleInfo)localObject2).mArticleID);
          if (localObject1 != null)
          {
            localObject1 = ((TemplateBean)localObject1).getDataAttribute(null);
            if (localObject1 != null)
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject3 = (Map.Entry)((Iterator)localObject1).next();
                localObject2 = (String)((Map.Entry)localObject3).getKey();
                localObject3 = ((Map.Entry)localObject3).getValue();
                try
                {
                  localJSONObject.put((String)localObject2, localObject3);
                }
                catch (JSONException localJSONException1)
                {
                  QLog.d("ReadInJoyDynamicChannelFragment", 2, "reportExposedData, e: ", localJSONException1);
                }
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.d("ReadInJoyDynamicChannelFragment", 2, "reportExposedData, json exception, ", localJSONException2);
          }
          QLog.d("ReadInJoyDynamicChannelFragment", 1, new Object[] { "actionName = ", ReadInJoyDynamicChannelFragment.a(this.this$0), "\n", "r5 = ", localJSONObject });
          ocd.a(null, "", ReadInJoyDynamicChannelFragment.b(this.this$0), ReadInJoyDynamicChannelFragment.c(this.this$0), 0, 0, "", "", "", localJSONObject.toString(), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.compat.ReadInJoyDynamicChannelFragment.4
 * JD-Core Version:    0.7.0.1
 */