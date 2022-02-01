package com.tencent.mobileqq.apollo.utils.api.impl;

import android.content.SharedPreferences;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopAvatarUtilApi;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class ApolloUtilImpl$5
  implements Runnable
{
  public void run()
  {
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = ApolloUtilImpl.getGameResSp();
        Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
        if (((File)localObject).exists())
        {
          if (!((File)localObject).isDirectory()) {
            return;
          }
          if (FileUtils.getFileOrFolderSize("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/") > 104857600L)
          {
            localObject = ((File)localObject).listFiles();
            if (localObject == null) {
              return;
            }
            localObject = Arrays.asList((Object[])localObject);
            Collections.sort((List)localObject, ApolloUtilImpl.mResPriorityComparator);
            Iterator localIterator = ((List)localObject).iterator();
            if (localIterator.hasNext())
            {
              File localFile = (File)localIterator.next();
              if ((localFile == null) || (!localFile.exists())) {
                continue;
              }
              String str = localFile.getName();
              if (!str.endsWith(".patch")) {
                if (!str.endsWith(".patched")) {
                  break label380;
                }
              }
              localFile.delete();
              i = 1;
              localObject = str;
              if (str.endsWith(".zip")) {
                localObject = str.substring(0, str.indexOf("."));
              }
              int j = i;
              if (((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).isNumeric((String)localObject))
              {
                l1 = localSharedPreferences.getLong((String)localObject, 0L);
                long l2 = NetConnInfoCenter.getServerTimeMillis();
                j = i;
                if (l2 - l1 > 2592000000L)
                {
                  j = i;
                  if (l2 - localFile.lastModified() > 2592000000L)
                  {
                    if (QLog.isColorLevel())
                    {
                      localObject = new StringBuilder();
                      ((StringBuilder)localObject).append("time limit delete file:");
                      ((StringBuilder)localObject).append(localFile.getName());
                      QLog.i("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject).toString());
                    }
                    localFile.delete();
                    j = 1;
                  }
                }
              }
              if (j == 0) {
                continue;
              }
              long l1 = FileUtils.getFileOrFolderSize("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
              if (l1 >= 104857600L) {
                continue;
              }
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder();
                ((StringBuilder)localObject).append("delete finish,new size:");
                ((StringBuilder)localObject).append(l1);
                QLog.i("[cmshow]ApolloUtil", 2, ((StringBuilder)localObject).toString());
              }
            }
          }
        }
        else
        {
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.e("[cmshow]ApolloUtil", 1, "deleteGameResIfNeed error:", localException);
      }
      return;
      label380:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl.5
 * JD-Core Version:    0.7.0.1
 */