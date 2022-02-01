package com.tencent.mobileqq.apollo.store.openbox;

import amip;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Map;

class ApolloCardWindow$3
  implements Runnable
{
  ApolloCardWindow$3(ApolloCardWindow paramApolloCardWindow) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        Object localObject1 = new File(amip.k);
        if (((File)localObject1).exists())
        {
          if (!((File)localObject1).isDirectory()) {
            return;
          }
          localObject1 = ((File)localObject1).listFiles();
          int j = localObject1.length;
          if (i < j)
          {
            Object localObject3 = localObject1[i];
            if ((localObject3 == null) || (!localObject3.getPath().endsWith(".cache"))) {
              break label143;
            }
            ??? = localObject3.getName();
            String str = ((String)???).substring(0, ((String)???).indexOf("."));
            synchronized (ApolloCardWindow.a)
            {
              ApolloCardWindow.a.put(str, this.this$0.a(localObject3.getPath()));
            }
          }
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.e("ApolloCardWindow", 1, "mPreloadRunnable error:", localException);
      }
      label143:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.openbox.ApolloCardWindow.3
 * JD-Core Version:    0.7.0.1
 */