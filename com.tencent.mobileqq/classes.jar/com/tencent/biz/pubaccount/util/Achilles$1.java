package com.tencent.biz.pubaccount.util;

import apwe;
import com.tencent.biz.pubaccount.readinjoy.config.beans.AchillesParams;
import com.tencent.mobileqq.data.RockDownloadInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import twl;

public final class Achilles$1
  implements Runnable
{
  public void run()
  {
    Object localObject2 = Achilles.a();
    if (!Achilles.a()) {
      QLog.i("Achilles", 1, "[run] wifi not connected, skip.");
    }
    for (;;)
    {
      return;
      Object localObject1 = new HashSet();
      localObject2 = ((Set)localObject2).iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (AchillesParams)((Iterator)localObject2).next();
        if (localObject3 == null)
        {
          QLog.e("Achilles", 1, "[run] param is null");
        }
        else
        {
          String str = ((AchillesParams)localObject3).getPackageName();
          QLog.i("Achilles", 1, "[run] checking " + str);
          if (!((AchillesParams)localObject3).isEnable()) {
            QLog.i("Achilles", 1, "[run] disabled, skip " + str);
          } else if (Achilles.a(str)) {
            QLog.i("Achilles", 1, "[run] installed, skip " + str);
          } else {
            ((Set)localObject1).add(localObject3);
          }
        }
      }
      if (!((Set)localObject1).isEmpty())
      {
        localObject1 = ((Set)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (AchillesParams)((Iterator)localObject1).next();
          localObject3 = Achilles.a((AchillesParams)localObject2);
          apwe.a((RockDownloadInfo)localObject3, new twl(this, (RockDownloadInfo)localObject3, (AchillesParams)localObject2));
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.Achilles.1
 * JD-Core Version:    0.7.0.1
 */