package com.tencent.mobileqq.activity.aio.photo;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import mqq.manager.Manager;

public class PhotoListConfigManager
  implements Manager
{
  int a;
  int b;
  Set<String> c = new HashSet();
  boolean d = false;
  
  public static int a(Context paramContext, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoListConfig");
    localStringBuilder.append(paramString);
    return paramContext.getSharedPreferences(localStringBuilder.toString(), 0).getInt("k_version", 0);
  }
  
  public static PhotoListConfigManager a(QQAppInterface paramQQAppInterface)
  {
    PhotoListConfigManager localPhotoListConfigManager = (PhotoListConfigManager)paramQQAppInterface.getManager(QQManagerFactory.PHOTOLIST_CONFIG_MANAGER);
    localPhotoListConfigManager.b(paramQQAppInterface);
    return localPhotoListConfigManager;
  }
  
  public static void a(Context paramContext, String paramString, int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoListConfig");
    localStringBuilder.append(paramString);
    paramContext.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("k_version", paramInt).apply();
  }
  
  @TargetApi(14)
  private void b(QQAppInterface paramQQAppInterface)
  {
    try
    {
      if (!this.d)
      {
        this.d = true;
        BaseApplication localBaseApplication = paramQQAppInterface.getApp();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("PhotoListConfig");
        localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
        paramQQAppInterface = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0);
        this.a = paramQQAppInterface.getInt("k_s", 0);
        this.b = paramQQAppInterface.getInt("k_w", 0);
        this.c = paramQQAppInterface.getStringSet("k_b_l", null);
        paramQQAppInterface = new StringBuilder("init ");
        paramQQAppInterface.append("size:");
        paramQQAppInterface.append(this.a);
        paramQQAppInterface.append(" width:");
        paramQQAppInterface.append(this.b);
        paramQQAppInterface.append(" black:");
        paramQQAppInterface.append(this.c);
        QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      }
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  @TargetApi(14)
  public void a(QQAppInterface paramQQAppInterface, int paramInt1, int paramInt2, Set<String> paramSet)
  {
    try
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramSet;
      BaseApplication localBaseApplication = paramQQAppInterface.getApp();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("PhotoListConfig");
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("k_s", paramInt1).putInt("k_w", paramInt2).putStringSet("k_b_l", paramSet).apply();
      paramQQAppInterface = new StringBuilder("updateConfig ");
      paramQQAppInterface.append("size:");
      paramQQAppInterface.append(this.a);
      paramQQAppInterface.append(" width:");
      paramQQAppInterface.append(this.b);
      paramQQAppInterface.append(" black:");
      paramQQAppInterface.append(paramSet);
      QLog.i("PhotoListConfig", 1, paramQQAppInterface.toString());
      return;
    }
    finally
    {
      paramQQAppInterface = finally;
      throw paramQQAppInterface;
    }
  }
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListConfigManager
 * JD-Core Version:    0.7.0.1
 */