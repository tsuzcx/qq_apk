package com.tencent.mobileqq.activity.aio;

import android.text.TextUtils;
import com.tencent.mobileqq.data.AppGuideTipsConfig;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Map;

class AppGuideTipsManager$1
  implements Runnable
{
  AppGuideTipsManager$1(AppGuideTipsManager paramAppGuideTipsManager) {}
  
  public void run()
  {
    AppGuideTipsManager.a(this.this$0);
    this.this$0.c();
    AppGuideTipsManager.b(this.this$0).clear();
    Object localObject1 = (ArrayList)AppGuideTipsManager.c(this.this$0).query(AppGuideTipsConfig.class, AppGuideTipsConfig.class.getSimpleName(), false, null, null, null, null, null, null);
    int i;
    if (localObject1 != null)
    {
      if (((ArrayList)localObject1).size() <= 0) {
        return;
      }
      i = 0;
    }
    for (;;)
    {
      Object localObject2;
      String[] arrayOfString;
      int j;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (AppGuideTipsConfig)((ArrayList)localObject1).get(i);
        if ((localObject2 != null) && (!TextUtils.isEmpty(((AppGuideTipsConfig)localObject2).tipsType))) {
          if (!TextUtils.isEmpty(((AppGuideTipsConfig)localObject2).msgTypeStr))
          {
            arrayOfString = ((AppGuideTipsConfig)localObject2).msgTypeStr.split("\\|");
            if (arrayOfString != null)
            {
              j = 0;
              label137:
              if (j >= arrayOfString.length) {}
            }
          }
        }
      }
      try
      {
        int k = Integer.valueOf(arrayOfString[j]).intValue();
        ((AppGuideTipsConfig)localObject2).msgTypeMap.put(Integer.valueOf(k), Boolean.valueOf(true));
        label174:
        j += 1;
        break label137;
        AppGuideTipsManager.b(this.this$0).put(((AppGuideTipsConfig)localObject2).tipsType, localObject2);
        i += 1;
        continue;
        AppGuideTipsManager.a(this.this$0, true);
        this.this$0.b();
        if (QLog.isColorLevel())
        {
          localObject1 = AppGuideTipsManager.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("loadConfig, mTipsMap size=");
          ((StringBuilder)localObject2).append(AppGuideTipsManager.b(this.this$0).size());
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        return;
      }
      catch (Exception localException)
      {
        break label174;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.AppGuideTipsManager.1
 * JD-Core Version:    0.7.0.1
 */