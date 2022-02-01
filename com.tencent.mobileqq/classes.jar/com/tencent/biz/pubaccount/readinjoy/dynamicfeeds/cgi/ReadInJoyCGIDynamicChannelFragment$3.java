package com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi;

import com.tencent.biz.pubaccount.readinjoy.struct.DynamicChannelDataModel;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import olh;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyCGIDynamicChannelFragment$3
  implements Runnable
{
  ReadInJoyCGIDynamicChannelFragment$3(ReadInJoyCGIDynamicChannelFragment paramReadInJoyCGIDynamicChannelFragment, ConcurrentHashMap paramConcurrentHashMap) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.size() > 0))
    {
      Iterator localIterator = this.a.values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject1 = ((DynamicChannelDataModel)localIterator.next()).mTemplateBean;
        JSONObject localJSONObject = new JSONObject();
        try
        {
          localJSONObject.put("channel_id", ReadInJoyCGIDynamicChannelFragment.g(this.this$0));
          if (localObject1 != null)
          {
            localObject1 = ((TemplateBean)localObject1).getDataAttribute(null);
            if (localObject1 != null)
            {
              localObject1 = ((Map)localObject1).entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
                String str = (String)((Map.Entry)localObject2).getKey();
                localObject2 = ((Map.Entry)localObject2).getValue();
                try
                {
                  localJSONObject.put(str, localObject2);
                }
                catch (JSONException localJSONException1)
                {
                  QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, "reportExposedData, e", localJSONException1);
                }
              }
            }
          }
        }
        catch (JSONException localJSONException2)
        {
          for (;;)
          {
            QLog.d("ReadInJoyDynamicChannelBaseFragment", 2, new Object[] { "put channelID failed, mChannelID = ", Integer.valueOf(ReadInJoyCGIDynamicChannelFragment.h(this.this$0)), ", e = ", localJSONException2 });
          }
          QLog.d("ReadInJoyDynamicChannelBaseFragment", 1, new Object[] { "actionName = ", ReadInJoyCGIDynamicChannelFragment.a(this.this$0), ", r5 = ", localJSONObject.toString() });
          olh.a(null, "", ReadInJoyCGIDynamicChannelFragment.b(this.this$0), ReadInJoyCGIDynamicChannelFragment.c(this.this$0), 0, 0, "", "", "", localJSONObject.toString(), false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.dynamicfeeds.cgi.ReadInJoyCGIDynamicChannelFragment.3
 * JD-Core Version:    0.7.0.1
 */