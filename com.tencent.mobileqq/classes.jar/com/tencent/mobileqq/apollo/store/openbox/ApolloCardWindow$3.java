package com.tencent.mobileqq.apollo.store.openbox;

import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class ApolloCardWindow$3
  implements Runnable
{
  ApolloCardWindow$3(ApolloCardWindow paramApolloCardWindow) {}
  
  public void run()
  {
    try
    {
      Object localObject1 = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/image_cache/");
      if (((File)localObject1).exists())
      {
        if (!((File)localObject1).isDirectory()) {
          return;
        }
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject3 = localObject1[i];
          if ((localObject3 != null) && (localObject3.getPath().endsWith(".cache")))
          {
            ??? = localObject3.getName();
            String str = ((String)???).substring(0, ((String)???).indexOf("."));
            synchronized (ApolloCardWindow.f)
            {
              ApolloCardWindow.f.put(str, this.this$0.a(localObject3.getPath()));
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloCardWindow", 1, "mPreloadRunnable error:", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.3
 * JD-Core Version:    0.7.0.1
 */