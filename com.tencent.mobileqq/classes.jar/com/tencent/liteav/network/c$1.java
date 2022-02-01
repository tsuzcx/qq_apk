package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import java.util.ArrayList;
import org.json.JSONObject;

class c$1
  extends Thread
{
  c$1(c paramc, String paramString1, String paramString2, int paramInt)
  {
    super(paramString1);
  }
  
  public void run()
  {
    if (this.c.a == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject2 = localArrayList;
    String str;
    if (i < 7)
    {
      if (i >= 5) {
        break label198;
      }
      str = "https://tcdns.myqcloud.com/queryip";
    }
    for (;;)
    {
      localObject2 = localArrayList;
      try
      {
        str = c.a(this.c, this.a, this.b, str);
        try
        {
          localObject2 = new JSONObject(str);
          if (((JSONObject)localObject2).has("use"))
          {
            int j = ((JSONObject)localObject2).getInt("use");
            if (j == 0) {
              localObject2 = localArrayList;
            }
          }
        }
        catch (Exception localException2)
        {
          localObject2 = localArrayList;
          TXCLog.e("TXCIntelligentRoute", "get value from json failed.", localException2);
          localObject2 = localArrayList;
          localArrayList = c.a(this.c, str);
          if (localArrayList != null)
          {
            localObject2 = localArrayList;
            if (localArrayList.size() > 0)
            {
              localObject2 = localArrayList;
              break label182;
            }
          }
          localObject2 = localArrayList;
          sleep(1000L, 0);
        }
        Object localObject1;
        i += 1;
      }
      catch (Exception localException1)
      {
        TXCLog.e("TXCIntelligentRoute", "get json string failed.", localException1);
        localObject1 = localObject2;
      }
      break;
      label182:
      this.c.a.onFetchDone(0, (ArrayList)localObject2);
      return;
      label198:
      str = "https://tcdnsipv6.myqcloud.com/queryip";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.liteav.network.c.1
 * JD-Core Version:    0.7.0.1
 */