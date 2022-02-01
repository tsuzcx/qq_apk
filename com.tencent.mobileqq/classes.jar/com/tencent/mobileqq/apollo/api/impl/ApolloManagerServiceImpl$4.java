package com.tencent.mobileqq.apollo.api.impl;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.api.res.IApolloResDownloader;
import com.tencent.mobileqq.apollo.api.uitls.impl.ApolloUtilImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloManagerServiceImpl$4
  implements Runnable
{
  ApolloManagerServiceImpl$4(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  public void run()
  {
    Object localObject1 = null;
    long l1 = System.currentTimeMillis();
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_sp", 0);
    Object localObject2 = localSharedPreferences.getString("inner_res_md5", null);
    boolean bool;
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      QLog.i("ApolloManager", 1, "need to unzip def.zip");
      bool = true;
    }
    for (;;)
    {
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "check default res cost: " + (l2 - l1) + " ms, unzip: " + bool);
      }
      if ((bool) && (ApolloManagerServiceImpl.access$700(this.this$0)))
      {
        localObject2 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject2 = ApolloUtilImpl.calcMd5FromAccess("apollo_def_rsc");
        }
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          localSharedPreferences.edit().putString("inner_res_md5", (String)localObject2).commit();
        }
      }
      ApolloManagerServiceImpl.access$800().set(false);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "check default ready scene file cost: " + (System.currentTimeMillis() - l2));
      }
      return;
      localObject1 = ApolloUtilImpl.calcMd5FromAccess("apollo_def_rsc");
      if (!((String)localObject2).equals(localObject1))
      {
        QLog.d("ApolloManager", 2, "local md5: " + (String)localObject2 + ", newMd5: " + (String)localObject1);
        bool = true;
      }
      else if (!ApolloUtilImpl.checkRoleRes(0))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ApolloManager", 2, "role res is invalid");
        }
        bool = true;
      }
      else
      {
        localObject2 = ((IApolloResDownloader)QRoute.api(IApolloResDownloader.class)).readRoleDefaultDressIds(0);
        if ((localObject2 == null) || (localObject2.length == 0))
        {
          StringBuilder localStringBuilder;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder().append("dresses is invalid size:");
            if (localObject2 != null) {
              break label369;
            }
          }
          label369:
          for (i = 0;; i = localObject2.length)
          {
            QLog.d("ApolloManager", 2, i);
            bool = true;
            break;
          }
        }
        int j = localObject2.length;
        int i = 0;
        for (;;)
        {
          if (i >= j) {
            break label443;
          }
          int k = localObject2[i];
          if (!ApolloUtilImpl.checkDressRes(k))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ApolloManager", 2, "dress is invalid id: " + k);
            }
            bool = true;
            break;
          }
          i += 1;
        }
        label443:
        bool = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.4
 * JD-Core Version:    0.7.0.1
 */