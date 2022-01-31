package com.tencent.biz.publicAccountImageCollection;

import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import rpg;
import rph;

class PublicAccountImageCollectionPreloadManager$5
  implements Runnable
{
  PublicAccountImageCollectionPreloadManager$5(PublicAccountImageCollectionPreloadManager paramPublicAccountImageCollectionPreloadManager, List paramList) {}
  
  public void run()
  {
    Iterator localIterator = this.a.iterator();
    for (;;)
    {
      if (localIterator.hasNext())
      {
        Object localObject1 = (String)localIterator.next();
        if (localObject1 != null)
        {
          if (QLog.isColorLevel()) {
            QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "preloadImage url= " + (String)localObject1);
          }
          try
          {
            localObject1 = new URL((String)localObject1);
            if (localObject1 != null)
            {
              rph localrph = new rph();
              localrph.a = ((URL)localObject1);
              rpg.a().a(localrph, null);
            }
          }
          catch (MalformedURLException localMalformedURLException)
          {
            for (;;)
            {
              if (QLog.isColorLevel()) {
                QLog.d(PublicAccountImageCollectionPreloadManager.a(), 2, "getURLPath ERROR e = " + localMalformedURLException.getMessage());
              }
              Object localObject2 = null;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionPreloadManager.5
 * JD-Core Version:    0.7.0.1
 */