package com.tencent.mobileqq.apollo.api.uitls.impl;

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

final class ApolloUtilImpl$6
  implements Runnable
{
  public void run()
  {
    label347:
    for (;;)
    {
      try
      {
        SharedPreferences localSharedPreferences = ApolloUtilImpl.getGameResSp();
        Object localObject = new File("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
        if (!((File)localObject).exists()) {
          break;
        }
        if (!((File)localObject).isDirectory()) {
          return;
        }
        if (FileUtils.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/") <= 104857600L) {
          break;
        }
        localObject = ((File)localObject).listFiles();
        if (localObject == null) {
          break;
        }
        localObject = Arrays.asList((Object[])localObject);
        Collections.sort((List)localObject, ApolloUtilImpl.mResPriorityComparator);
        Iterator localIterator = ((List)localObject).iterator();
        if (!localIterator.hasNext()) {
          break;
        }
        File localFile = (File)localIterator.next();
        int i = 0;
        if ((localFile == null) || (!localFile.exists())) {
          continue;
        }
        localObject = localFile.getName();
        if ((((String)localObject).endsWith(".patch")) || (((String)localObject).endsWith(".patched")))
        {
          localFile.delete();
          i = 1;
        }
        if (!((String)localObject).endsWith(".zip")) {
          break label347;
        }
        localObject = ((String)localObject).substring(0, ((String)localObject).indexOf("."));
        if (((ITroopAvatarUtilApi)QRoute.api(ITroopAvatarUtilApi.class)).isNumeric((String)localObject))
        {
          long l1 = localSharedPreferences.getLong((String)localObject, 0L);
          long l2 = NetConnInfoCenter.getServerTimeMillis();
          if ((l2 - l1 > 2592000000L) && (l2 - localFile.lastModified() > 2592000000L))
          {
            if (QLog.isColorLevel()) {
              QLog.i("ApolloUtil", 2, "time limit delete file:" + localFile.getName());
            }
            localFile.delete();
            i = 1;
            if (i == 0) {
              continue;
            }
            l1 = FileUtils.b("/sdcard/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/.apollo/game/");
            if (l1 >= 104857600L) {
              continue;
            }
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("ApolloUtil", 2, "delete finish,new size:" + l1);
            return;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("ApolloUtil", 1, "deleteGameResIfNeed error:", localException);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl.6
 * JD-Core Version:    0.7.0.1
 */